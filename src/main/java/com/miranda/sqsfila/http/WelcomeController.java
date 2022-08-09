package com.miranda.sqsfila.http;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WelcomeController {

    @GetMapping("/welcome")
    @ApiOperation(value = "[WELCOME] - Seja bem vindos! ")
    public String bemVindo(){
      return  "Seja bem vindos!";
    }

}
