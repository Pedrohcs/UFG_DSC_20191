package com.github.pedrohcs.aula0204.exercicio6;

public class TesteContador {
    private static int NUMEROTHREADS = 6;

    public static void main(String[] args) {
        Thread[] thread = new Thread[NUMEROTHREADS];
        int contador;

        for (contador = 0; contador < NUMEROTHREADS; contador++) {
            thread[contador] = new Thread(new Contador());
            thread[contador].start();
        }
    }
}
