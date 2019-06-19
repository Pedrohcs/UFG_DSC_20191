package com.github.pedrohcs.prova.exercicio7;

import java.util.Random;

public class Tartaruga implements Runnable{

    final static int DISTANCIA_CORRIDA = 200;

    private int quantidadePassos = 0;
    private int distanciaPercorrida = 0;
    private String nome;
    private int colocacao;

    public Tartaruga(String nome){
        this.nome = nome;
    }

    public void getColocacao(){
        System.out.println(String.format("O tartaruga %s terminou a corrida com %d passos e na sua colocação foi %sº " +
                "lugar", this.nome, this.quantidadePassos, this.colocacao));
    }

    @Override
    public void run() {
        Random gerador = new Random();
        int descanso;
        int pulo;

        while (this.distanciaPercorrida < DISTANCIA_CORRIDA){
            if ((this.quantidadePassos % 10) == 0){
                System.out.println(String.format("A tartaruga %s andou %d", this.nome, this.distanciaPercorrida));
                descanso = gerador.nextInt(4);
                try {
                    Thread.sleep(descanso);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            pulo = gerador.nextInt(6);
            this.distanciaPercorrida += pulo;
            this.quantidadePassos ++;

        }

        this.colocacao = Main.colocacao ++;
    }
}
