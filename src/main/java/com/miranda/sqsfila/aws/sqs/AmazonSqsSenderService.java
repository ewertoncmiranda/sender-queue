package com.miranda.sqsfila.aws.sqs;

import com.miranda.sqsfila.aws.sns.AmazonSnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class AmazonSqsSenderService {
    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate ;
    @Value("${cloud.aws.end-point-sqs.uri}")
    private String endpoint;

    @Autowired
    private AmazonSnsService snsClient;

    public void sendMessageToQueue(String message) {

        snsClient.publishMessageToTopic("Mensagem vinda da FILA : "+message);
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
    }

}
