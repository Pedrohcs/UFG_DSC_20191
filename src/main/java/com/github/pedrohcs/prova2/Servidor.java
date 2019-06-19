package com.github.pedrohcs.prova2;

import java.util.ArrayList;
import java.util.Collections;

public class Servidor {
    private static String begin = "1.1.1.1";
    private static String end = "1.1.2.1";
    private static int numsBegin[] = new int[4];
    private static int numsEnd[] = new int[4];
    private static long quantityIps;

    public static void main(String[] args){
        convertIps(begin, end);
        quantityIps();
        System.out.println(quantityIps);
    }

    private static void convertIps(String inicio, String fim){
        String [] inicioSplit = inicio.split("\\.");
        String [] fimSplit = fim.split("\\.");
        int cont = 0;
        while (cont < 4){
            numsBegin[cont] = Integer.parseInt(inicioSplit[cont]);
            numsEnd[cont] = Integer.parseInt(fimSplit[cont]);
            cont++;
        }
    }

    private static void quantityIps(){
        long quantityIpBegin = numsBegin[0] * (long) Math.pow(256, 3) +
                            numsBegin[1] * (long) Math.pow(256, 2) +
                            numsBegin[2] * 256 +
                            numsBegin[3];

        long quantityIpEnd = numsEnd[0] * (long) Math.pow(256, 3) +
                    numsEnd[1] * (long) Math.pow(256, 2) +
                    numsEnd[2] * 256 +
                    numsEnd[3];

        quantityIps = quantityIpEnd - quantityIpBegin;
    }


}
