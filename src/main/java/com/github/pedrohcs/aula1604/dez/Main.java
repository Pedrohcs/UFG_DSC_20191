package com.github.pedrohcs.aula1604.dez;

import java.lang.Thread;

public class Main {

    private static final int QUANTIDADETHREADS = 5;

    public static void main(String[] args){
        int inicio1 = 1_000_000, fim1 = 30_000_000;
        int inicio2 = 90_000_000, fim2 = 120_000_000;
        int intervalo1, intervalo2, num;
        long tempoTotal, tempoInicial, tempoFinal;

        tempoInicial = System.currentTimeMillis();

        intervalo1 = (fim1 - inicio1) / QUANTIDADETHREADS;
        intervalo2 = (fim2 - inicio2) / QUANTIDADETHREADS;

        Thread[] threadPrimo1 = new Thread[QUANTIDADETHREADS];
        Thread[] threadPrimo2 = new Thread[QUANTIDADETHREADS];

        num = inicio1;
        for (int cont = 0; cont < QUANTIDADETHREADS; cont++){
            threadPrimo1[cont] = new Thread(new ThreadPrimo(num, (num+intervalo1)));
            threadPrimo1[cont].start();
            num = num + intervalo1;
        }

        for (Thread t : threadPrimo1){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        num = inicio2;
        for (int cont = 0; cont < QUANTIDADETHREADS; cont++){
            threadPrimo2[cont] = new Thread(new ThreadPrimo(num, (num+intervalo2)));
            threadPrimo2[cont].start();
            num = num + intervalo2;
        }

        for (Thread t : threadPrimo2){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        tempoFinal = System.currentTimeMillis();

        tempoTotal = tempoFinal - tempoInicial;
        System.out.println(String.format("Tempo total gasto: %d", tempoTotal));
    }
}
