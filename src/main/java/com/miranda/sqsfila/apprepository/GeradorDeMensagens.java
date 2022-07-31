package com.miranda.sqsfila.apprepository;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class GeradorDeMensagens {

    static {
        listaDeMensagens();
    }
    private static List<String> listaDeMensagens = new ArrayList<>();

    public static String gerarMensagemAleatoria(){
        Random random = new Random();
        int i = random.nextInt(listaDeMensagens.size());
        return listaDeMensagens.get(i);
    }

    private static void listaDeMensagens (){
        listaDeMensagens.add("Bom dia! Que seu dia seja igual a vontade de Deus: bom, perfeito e agradável.");
        listaDeMensagens.add("Não importa a cor do céu. Quem faz o dia bonito é você. Bom dia!");
        listaDeMensagens.add("Que o dia seja leve, que a tristeza seja breve e que o dia seja feliz. Bom dia!");
        listaDeMensagens.add("Que o amor seja a melhor forma de começar e terminar o dia.");
        listaDeMensagens.add("Bom dia para você que acordou acreditando que tudo vai dar certo!");
        listaDeMensagens.add("Pra hoje: sorrisos bobos, uma mente tranquila e um coração cheio de paz.");
        listaDeMensagens.add("A cada nova manhã, nasce junto uma nova chance. Bom dia!");
        listaDeMensagens.add("Bom dia! Comece o dia sorrindo. Afinal, coisa boa atrai coisa boa.");
        listaDeMensagens.add("Viva cada momento, ria todos os dias, ame além das palavras... Tenha um bom dia!.");
    }





}
