package com.github.pedrohcs.aula0805.exercicio5;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    final static String ALFANUMERICO = "abcdefghijklmnopqrstuvxwyz1234567890";
    final static String SENHA1 = "17a0a00212dde12b063af7dc22fdf02b";
    final static String SENHA2 = "75abfe3020804dd73a2a6040da9df96c";
    final static String SENHA3 = "c77aeec24015ad7e6e0b1db9d9deed68";

    final static int NUMTHREADS = 10;

    public static void main(String[] args){
        String tentativa, resultado;
        char[] caracter = ALFANUMERICO.toCharArray();

        ArrayList<String> senhas = new ArrayList<>();
        senhas.add(SENHA1);
        senhas.add(SENHA2);
        senhas.add(SENHA3);

        long tempoInicialSequencial, tempoFinalSequencial;
        tempoInicialSequencial = System.currentTimeMillis();

        for (String senha : senhas) {
            BreakPassword.busca(senha, caracter);
        }

        tempoFinalSequencial = System.currentTimeMillis();
        System.out.println("Tempo gasto para encontrar as senhas de forma sequencial: " +
                ((tempoFinalSequencial - tempoInicialSequencial) / 1000) + "s");
        System.out.println("--------------------------------------------------------------------------");

        ArrayList<Thread> threadBreakPasses = new ArrayList<>();

        long tempoInicialParalelo, tempoFinalParalelo;
        tempoInicialParalelo = System.currentTimeMillis();

        int quociente = caracter.length / NUMTHREADS;

        Checker checker = new Checker();

        ThreadGroup grupoThread = new ThreadGroup("Senhas");

        for (int i = 0; i < NUMTHREADS; i++) {
            char[] charArray;
            if (i == NUMTHREADS - 1) {
                charArray = Arrays.copyOfRange(caracter, i * quociente, ALFANUMERICO.length());

            } else {
                charArray = Arrays.copyOfRange(caracter, i * quociente, (i + 1) * quociente);
            }

            threadBreakPasses.add(new Thread(grupoThread, new ThreadBreakPass(charArray, senhas, caracter, checker)));
        }

        for (Thread qs : threadBreakPasses) {
            qs.start();
        }

        for (Thread thread : threadBreakPasses) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        tempoFinalParalelo = System.currentTimeMillis();

        System.out.println("Tempo gasto para encontrar as senhas de forma paralela com " + NUMTHREADS + " Threads: " +
                ((tempoFinalParalelo - tempoInicialParalelo) / 1000) + "s");
    }
}
