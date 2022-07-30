package com.miranda.sqsfila.aws.sqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class AmazonSqsLIstenerService {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate ;
    @Value("${cloud.aws.end-point-sqs.uri}")
    private String endpoint;

    @SqsListener("fila001")
    public void loadMessageFromSQS(String message) {

        System.out.println(" Mensagem recebida: " +message);
    }



}
