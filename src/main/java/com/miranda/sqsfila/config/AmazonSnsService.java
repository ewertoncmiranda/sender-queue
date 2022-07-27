package com.miranda.sqsfila.config;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2")
public class AmazonSnsService {

    @Autowired
    private AmazonSNSClient snsClient;

    @Value("${cloud.aws.end-point-sns.uri}")
    private String topico_endereco ;

    @GetMapping ("/addSubscription/{email}")
    public String addSubscription(@PathVariable String email) {
        SubscribeRequest request = new SubscribeRequest(topico_endereco, "email", email);
        snsClient.subscribe(request);
        return "Subscription request is pending. To confirm the subscription, check your email : " + email;
    }

    @GetMapping("/sendNotification")
    public String publishMessageToTopic(@RequestBody String mensagem){
        PublishRequest publishRequest=new PublishRequest(topico_endereco,mensagem,"Notificação");
        snsClient.publish(publishRequest);
        return "Notification send successfully !!";
    }


}
