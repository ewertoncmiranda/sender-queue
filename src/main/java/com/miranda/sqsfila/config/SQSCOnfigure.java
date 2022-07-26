package com.miranda.sqsfila.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSCOnfigure {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate ;

    @Value("${cloud.aws.end-point-sqs.uri}")
    private String endpoint;

    @GetMapping("/send/{message}")
    public void sendMessageToQueue(@PathVariable String message) {
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
    }

    @SqsListener("fila001")
    public void loadMessageFromSQS(String message) {
        System.out.println("message from SQS Queue  -> "+message);
    }


}
