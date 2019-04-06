package com.github.pedrohcs.aula0204.exercicio8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class GeradorDeNoticia implements Runnable {

    private static int NUMNOTICIAS = 20;
    private String arquivoNoticias = "src/main/resources/noticias.txt";
    private boolean condicional = true;

    private String[] noticias = new String[NUMNOTICIAS];

    public GeradorDeNoticia(){
        try {
            BufferedReader leitor = new BufferedReader(new FileReader(this.arquivoNoticias));

            String linha;
            this.noticias[0] = leitor.readLine();
            int contador = 1;
            while ((linha = leitor.readLine()) != null){
                this.noticias[contador] = linha;
                contador++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (this.condicional){
            Random gerador = new Random();
            System.out.println(String.format("Plantão: %s", this.noticias[gerador.nextInt(20)]));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
