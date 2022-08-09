package com.miranda.sqsfila.http;

import com.miranda.sqsfila.aws.sns.AmazonSnsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sns")
public class TopicoSnsController {

    @Autowired
    private AmazonSnsService snsClient;

    /* *
     * * TODO CRIAR VALIDAÇÕES DE EMAIL E CELULAR
     * */
    @ApiOperation(value = "[SNS] - Cadastra um novo email ao tópico. ")
    @PostMapping("/assinar/email")
    public String assinarEmail(@RequestBody String email) {
        return snsClient.novaAssinaturaEmail(email) ;
    }

    /* *
     * * TODO CRIAR VALIDAÇÕES DE EMAIL E CELULAR
     * */
    @ApiOperation(value = "[SNS] - Cadastra um novo celuar ao tópico. ")
    @PostMapping("/assinar/celular")
    public String assinarCelular(@RequestBody String celular) {
        return snsClient.novaAssinaturaCelular(celular) ;
    }

    @ApiOperation(value = "[SNS] - Publica uma nova mensagem no tópico. ")
    @PostMapping("/enviar")
    public String enviar(@RequestBody String messagem) {
        return snsClient.publishMessageToTopic(messagem) ;
    }

    @ApiOperation(value = "[SNS] - Busca uma mensagem publicada , na base. ")
    @GetMapping("find/{id}")
    public ResponseEntity findMensagemPorID(@PathVariable long id) {
    return ResponseEntity.ok(snsClient.resgatarMensagemPorId(id));
    }


}
