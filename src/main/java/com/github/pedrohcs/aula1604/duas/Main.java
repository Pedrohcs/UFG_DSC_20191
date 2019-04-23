package com.github.pedrohcs.aula1604.duas;

import com.github.pedrohcs.aula0804.exercicio1.ThreadA;
import com.github.pedrohcs.aula0804.exercicio1.ThreadB;

public class Main {

    public static void main(String[] args){
        long tempoTotal, tempoInicial, tempoFinal;

        Thread threadA = new Thread();
        Thread threadB = new Thread();

        threadA = new Thread(new ThreadA());
        threadB = new Thread(new ThreadB());

        tempoInicial = System.currentTimeMillis();
        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tempoFinal = System.currentTimeMillis();

        tempoTotal = tempoFinal - tempoInicial;
        System.out.println(String.format("Tempo total gasto: %d", tempoTotal));

    }
}
