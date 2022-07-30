package com.miranda.sqsfila.aws.sns;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.miranda.sqsfila.database.TopicMessageEntity;
import com.miranda.sqsfila.database.TopicMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class AmazonSnsService {

    @Autowired
    private AmazonSNSClient snsClient;

    @Autowired
    private TopicMessageRepository repository;

    @Value("${cloud.aws.end-point-sns.uri}")
    private String topico_endereco ;


    public String novaAssinaturaEmail( String email) {
        SubscribeRequest request = new SubscribeRequest(topico_endereco, "email", email);
        snsClient.subscribe(request);
        return "Inscrição Pendente!. Verifique seu email : " + email;
    }

    public String novaAssinaturaCelular( String celular) {
        SubscribeRequest request = new SubscribeRequest(topico_endereco, "sms", celular);
        snsClient.subscribe(request);
        return "Inscrição Pendente!. Verifique seu celular : " + celular;
    }

    @Transactional
    public String publishMessageToTopic( String mensagem){
        var topic = new TopicMessageEntity();
        topic.setMensagem(mensagem);
        TopicMessageEntity save = repository.save(topic);
        if (Objects.isNull(save)) throw new NullPointerException("ENTIDADE DE TOPICO NULA!");


        PublishRequest publishRequest=new PublishRequest(topico_endereco,mensagem,"Notificação");
        snsClient.publish(publishRequest);
        return "Notification send successfully !!";
    }
    public TopicMessageEntity resgatarMensagemPorId( Long id){

        Optional<TopicMessageEntity> opt = repository.findById(id);
        if (opt.isEmpty())  throw new NullPointerException("MENSAGEM NAO ENCONTRADA POR ID :"+id);
        return opt.get();
    }

}
