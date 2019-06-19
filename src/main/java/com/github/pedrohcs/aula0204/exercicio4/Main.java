package com.github.pedrohcs.aula0204.exercicio4;

import java.lang.Thread;

public class Main {
    public static void main(String[] args){
        Thread[] thread = new Thread[10];
        int contador = 0;

        for (Thread t : thread){
            t = new Thread(new ContadorThread(contador));
            t.start();
            contador ++;
        }
    }
}
