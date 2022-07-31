package com.miranda.sqsfila.tarefas;


import com.miranda.sqsfila.apprepository.GeradorDeMensagens;
import com.miranda.sqsfila.aws.sns.AmazonSnsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Tarefa001 {
    //TODO CRIAR TAREFA PARA LER DATAS DE ANIVERSARIO CADASTRADA NA BASE
    private static final Logger LOG = LoggerFactory.getLogger(Tarefa001.class);
    @Autowired
    AmazonSnsService amazonSnsService;

    @Scheduled(cron = "0 0 8 * * ?")
    public void enviarMensagemDeBomDia(){
       LOG.info("Iniciando tarefa de envio de mensagem de bom dia na data :"+gerarData());

       String mensagemAleatoria = GeradorDeMensagens.gerarMensagemAleatoria();
       mensagemAleatoria.concat(" -  "+ gerarData());

       LOG.info("Mensagem gerada : "+mensagemAleatoria);
       amazonSnsService.publishMessageToTopic(mensagemAleatoria);
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void enviarMensagemDoMeioDia(){
        LOG.info("Iniciando tarefa de envio de mensagem do meio dia ");
        String msg = "Esta tarefa foi disparada ao meio-dia. Hora do almoço!" ;
        amazonSnsService.publishMessageToTopic(msg);
    }

    @Scheduled(cron = "0 0 * ? * *")
    public void enviarMensagemACadaHora(){
        LOG.info("Iniciando disparo de hora em hora. " + gerarData());
        String msg = "Disparo de hora em hora executado. Essa mensagem foi enviada as  "+gerarData() ;
        amazonSnsService.publishMessageToTopic(msg);
    }

    @Scheduled(cron = "0 */2 * ? * *")
    public void cadaDoisMinutos(){
        LOG.info("NovoLog : "+gerarData());
    }

    private String gerarData(){
        Date date = new Date();
        long time = date.getTime();
        return  String.valueOf(time);
    }
}
