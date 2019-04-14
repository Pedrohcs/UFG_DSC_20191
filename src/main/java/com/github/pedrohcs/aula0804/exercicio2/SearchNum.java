package com.github.pedrohcs.aula0804.exercicio2;

import java.util.ArrayList;

public class SearchNum implements Runnable {
    private ArrayList<Integer> array = new ArrayList();
    private String numProcurado;
    private String nome;
    private int multiplicador;

    public SearchNum(int[] array, int numProcurado, int nome, int multiplicador){
        for (int cont = 0; cont < array.length; cont++){
            this.array.add(array[cont]);
        }
        this.numProcurado = Integer.toString(numProcurado);
        this.nome = Integer.toString(nome);
        this.multiplicador = multiplicador;
    }
    @Override
    public void run() {
        for (int posicao = 0; posicao < this.array.size(); posicao++){
            if (this.array.get(posicao).toString().equals(this.numProcurado)){
                posicao = (this.multiplicador * Integer.parseInt(nome)) + posicao;
                System.out.println(String.format("Número %s encontrado na posição %d"
                        , this.numProcurado, posicao, this.nome));
            }
        }
    }
}
