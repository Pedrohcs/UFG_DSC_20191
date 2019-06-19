package com.github.pedrohcs.aula2304;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class PistaCorridaSapo {

    final static int QUANTIDADE_SAPOS = 5;
    final static int DISTANCIA_CORRIDA = 2000;
    final static String[] NOMES_SAPOS = {
            "Alfredo", "Geremias", "Antonieta", "Marcinhho", "Rogerinho", "Claudinho"
    };

    public static int colocacao = 1;

    public static void main(String[] args){
        Collections.shuffle(Arrays.asList(NOMES_SAPOS));
        Thread corredores[] = new Thread[QUANTIDADE_SAPOS];

        for (int contador = 0; contador < QUANTIDADE_SAPOS; contador++){
            corredores[contador] = new Thread(new Sapo(NOMES_SAPOS[contador], DISTANCIA_CORRIDA));
            corredores[contador].start();
        }
    }
}
