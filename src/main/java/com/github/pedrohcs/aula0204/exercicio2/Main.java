package com.github.pedrohcs.aula0204.exercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long tempoInicial, tempoFinal, tempoTotal;
        String nome = "src/main/resources/numeros.txt";

        int repeticao = 0, maiorRepeticao = 0;
        String numero = "";

        try{
            tempoInicial = System.currentTimeMillis();

            BufferedReader leitor = new BufferedReader(new FileReader(nome));

            String linha;
            ArrayList<String> numeros = new ArrayList<String>();

            numeros.add(leitor.readLine());
            while ((linha = leitor.readLine()) != null){
                for (String num : numeros){
                    if(linha.equals(num)){
                        repeticao ++;
                    }
                }
                if(repeticao > maiorRepeticao){
                    maiorRepeticao = repeticao;
                    numero = linha;
                }
                repeticao = 0;
                numeros.add(linha);
            }

            tempoFinal = System.currentTimeMillis();
            tempoTotal = tempoFinal - tempoInicial;

            System.out.println("Números que repetiram: " + numero );
            System.out.println("Tempo inicial: " + tempoInicial);
            System.out.println("Tempo final: " + tempoFinal);
            System.out.println("Tempo total: " + tempoTotal);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
