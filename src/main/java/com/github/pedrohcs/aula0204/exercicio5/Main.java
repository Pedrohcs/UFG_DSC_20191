package com.github.pedrohcs.aula0204.exercicio5;

public class Main {
    private static int NUMEROMAXIMO = 5;

    public static void main(String[] args){
        Thread[] thread = new Thread[NUMEROMAXIMO];
        int contador = 0;

        for (Thread t : thread){
            t = new Thread(new T1(contador));
            t.start();
            contador ++;
        }
    }
}
