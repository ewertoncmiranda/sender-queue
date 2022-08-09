package com.miranda.sqsfila.http;

import com.miranda.sqsfila.aws.sqs.AmazonSqsSenderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sqs")
public class FilaSqsController {
    @Autowired
    AmazonSqsSenderService service;

    @ApiOperation(value = "[SQS] - Envia uma nova mensagem na fila. ")
    @PostMapping("/send")
    public void sendMessageToQueue(@RequestBody String message) {
        service.sendMessageToQueue( message);
    }


}
