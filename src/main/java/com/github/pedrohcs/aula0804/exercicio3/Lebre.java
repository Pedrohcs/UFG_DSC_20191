package com.github.pedrohcs.aula0804.exercicio3;

import java.util.Random;

public class Lebre extends Thread {

    private int distancia = 0;
    private int distanciaFinal = 20;
    private int quantPulos = 0;
    private String nome;

    public Lebre(String nome){
        this.nome = nome;
    }

    @Override
    public void run() {
        Random gerador = new Random();
        int pulo;
        while (this.distancia < this.distanciaFinal){
            pulo = gerador.nextInt(3) + 1;
            this.distancia = this.distancia + pulo;
            this.quantPulos ++;
            this.yield();
        }

        System.out.println(String.format("A lebre %s terminou a corrida com %d pulos", this.nome, this.quantPulos));
    }
}
