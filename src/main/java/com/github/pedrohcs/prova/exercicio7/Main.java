package com.github.pedrohcs.prova.exercicio7;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    final static int QUANTIDADE_TARTARUGAS = 7;
    final static String[] NOMES_TARTARUGAS = {
            "Renan", "Julinho", "Rocha", "Emilia", "Rogerinho", "Palmirinha", "Cuca"
    };

    public static int colocacao = 1;

    public static void main(String[] args){
        Collections.shuffle(Arrays.asList(NOMES_TARTARUGAS));
        Thread corredores[] = new Thread[QUANTIDADE_TARTARUGAS];
        Thread[] thread = new Thread[QUANTIDADE_TARTARUGAS];
        Tartaruga[] tartarugas = new Tartaruga[QUANTIDADE_TARTARUGAS];

        for (int contador = 0; contador < QUANTIDADE_TARTARUGAS; contador++){
            Tartaruga threadTartaruga = new Tartaruga(NOMES_TARTARUGAS[contador]);
            tartarugas[contador] = threadTartaruga;
            thread[contador] = new Thread(threadTartaruga);
            thread[contador].start();
        }

        for (Thread t : thread){
            try{
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for(Tartaruga tartaruga : tartarugas){
            tartaruga.getColocacao();
        }
    }
}
