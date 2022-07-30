package com.miranda.sqsfila.http;

import com.miranda.sqsfila.aws.sqs.AmazonSqsSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sqs")
public class FilaSqsController {
    @Autowired
    AmazonSqsSenderService service;

    @PostMapping("/send")
    public void sendMessageToQueue(@RequestBody String message) {
        service.sendMessageToQueue( message);
    }


}
