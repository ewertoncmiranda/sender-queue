package com.miranda.sqsfila.aws.sqs;

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

    public void sendMessageToQueue(String message) {
        queueMessagingTemplate.send(endpoint, MessageBuilder.withPayload(message).build());
    }

}
