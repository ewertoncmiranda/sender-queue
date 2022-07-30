package com.miranda.sqsfila.http;

import com.miranda.sqsfila.aws.sns.AmazonSnsService;
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
    @PostMapping("/assinar/email")
    public String assinarEmail(@RequestBody String email) {
        return snsClient.novaAssinaturaEmail(email) ;
    }

    /* *
     * * TODO CRIAR VALIDAÇÕES DE EMAIL E CELULAR
     * */
    @PostMapping("/assinar/celular")
    public String assinarCelular(@RequestBody String celular) {
        return snsClient.novaAssinaturaCelular(celular) ;
    }

    @PostMapping("/enviar")
    public String enviar(@RequestBody String messagem) {
        return snsClient.publishMessageToTopic(messagem) ;
    }

    @GetMapping("find/{id}")
    public ResponseEntity findMensagemPorID(@PathVariable long id) {
    return ResponseEntity.ok(snsClient.resgatarMensagemPorId(id));
    }


}
