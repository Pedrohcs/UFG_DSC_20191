package com.github.pedrohcs.aula0804.exercicio3;

public class Main {

    private static final int QUANTIDADE = 5;

    public static void main (String[] args){
        Lebre[] lebres = new Lebre[QUANTIDADE];

        lebres[0] = new Lebre("Lebre 1");
        lebres[1] = new Lebre("Lebre 2");
        lebres[2] = new Lebre("Lebre 3");
        lebres[3] = new Lebre("Lebre 4");
        lebres[4] = new Lebre("Lebre 5");

        for (Thread lebre : lebres){
            lebre.start();
        }
    }
}
