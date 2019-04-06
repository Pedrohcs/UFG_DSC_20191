package com.github.pedrohcs.aula0204.exercicio4;

public class Main {
    public static void main(String[] args){
        java.lang.Thread[] thread = new java.lang.Thread[10];
        int contador = 0;

        for (java.lang.Thread t : thread){
            t = new java.lang.Thread(new Thread(contador));
            t.start();
            contador ++;
        }
    }
}
