package com.github.pedrohcs.aula2304;

import java.util.Random;

public class Sapo implements Runnable {

    private int distanciaPercorrida = 0;
    private int distanciaCorrida;
    private int distanciaPulo;
    private int quantidadePulos = 0;
    private int colocacao;
    private String nome;

    public Sapo(String nome, int distanciaCorrida){
        this.nome = nome;
        this.distanciaCorrida = distanciaCorrida;
    }

    @Override
    public void run() {
        Random gerador = new Random();
        int descanso;
        while (this.distanciaPercorrida < (this.distanciaCorrida/2)){
            Pular(gerador);
        }

        descanso = gerador.nextInt(1000) + 2500;
        try {
            Thread.sleep(descanso);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (this.distanciaPercorrida < this.distanciaCorrida){
            Pular(gerador);
        }

        this.colocacao = PistaCorridaSapo.colocacao ++;
        System.out.println(String.format("O sapo %s terminou a corrida com %d pulos e na sua colocação foi %sº " +
                "lugar", this.nome, this.quantidadePulos, this.colocacao));
    }

    private void Pular(Random gerador) {
        int descanso;
        this.distanciaPulo = gerador.nextInt(60) + 40;
        this.distanciaPercorrida += this.distanciaPulo;
        this.quantidadePulos ++;
        descanso =  gerador.nextInt(1000) + 500;
        try {
            Thread.sleep(descanso);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
