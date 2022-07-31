package com.miranda.sqsfila.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WelcomeController {

    @GetMapping("/welcome")
    public String bemVindo(){
      return  "Seja bem vindo!";
    }

}
