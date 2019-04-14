package com.github.pedrohcs.aula0804.exercicio2;

public class Main {

    private static final int QUANTPOSICOES = 20;

    public static void main(String[] args){

        int[] a = new int[QUANTPOSICOES];
        int num, posicao = 0;
        int numPesquisado = 15;
        int quantasThreads = 3;

        for(num = 1; num <= QUANTPOSICOES; num++){
            a[posicao] = num;
            posicao ++;
        }

        parallelSearch(numPesquisado, a, quantasThreads);

    }

    public static void parallelSearch(int x, int[]a, int numThreads){
        Thread[] thread = new Thread[QUANTPOSICOES];
        int divisao = QUANTPOSICOES / numThreads;
        int posiRelativaInicial;
        int posiRelativaFinal;
        int tamanhoRelativo = 0;

        for (int cont1 = 0; cont1 < numThreads; cont1++){
            if (cont1 == (numThreads - 1)){
                posiRelativaInicial = divisao * (numThreads - 1);
                tamanhoRelativo = QUANTPOSICOES - posiRelativaInicial;
                int[] vetorRelativo = new int[tamanhoRelativo];

                for (int cont2 = 0; cont2 < tamanhoRelativo; cont2++){
                    vetorRelativo[cont2] = a[posiRelativaInicial];
                    posiRelativaInicial++;
                }

                thread[cont1] = new Thread(new SearchNum(vetorRelativo, x, cont1, divisao));
                thread[cont1].start();

            } else{
                posiRelativaInicial = (divisao * cont1);
                tamanhoRelativo = divisao;
                int[] vetorRelativo = new int[tamanhoRelativo];

                for (int cont3 = 0; cont3 < tamanhoRelativo; cont3++){
                    vetorRelativo[cont3] = a[posiRelativaInicial];
                    posiRelativaInicial ++;
                }

                thread[cont1] = new Thread(new SearchNum(vetorRelativo, x, cont1, divisao));
                thread[cont1].start();
            }
        }
    }

}
