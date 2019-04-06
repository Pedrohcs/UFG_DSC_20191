package com.github.pedrohcs.aula0204.exercicio8;

public class Main {

    public static void main(String[] args){
        Thread threadNoticia = new Thread();
        Thread threadHora = new Thread();
        threadNoticia = new Thread(new GeradorDeNoticia());
        threadHora = new Thread((new GeradorDeHora()));

        threadNoticia.start();
        threadHora.start();
    }
}
