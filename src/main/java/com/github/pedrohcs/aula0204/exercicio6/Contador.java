package com.github.pedrohcs.aula0204.exercicio6;

public class Contador implements Runnable {

    @Override
    public void run() {
        int contador;
        for (contador = 0; contador <= 1000; contador++){
            System.out.println(String.format("Número: %d", contador));
        }
    }
}
