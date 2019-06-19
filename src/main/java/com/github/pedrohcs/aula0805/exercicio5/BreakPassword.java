package com.github.pedrohcs.aula0805.exercicio5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class BreakPassword {

    public static String md5(String senha){
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    public static boolean busca(String senha, char[] caracter){
        for (char letra1 : caracter) {
            for (char letra2 : caracter) {
                for (char letra3 : caracter) {
                    for (char letra4 : caracter) {
                        for (char letra5 : caracter) {
                            String tentativa = String.valueOf(letra1) + String.valueOf(letra2) + String.valueOf(letra3) +
                                    String.valueOf(letra4) + String.valueOf(letra5);
                            if (md5(tentativa).equals(senha)) {
                                System.out.println("Senha encontrada!");
                                System.out.println("Hash: " + senha);
                                System.out.println("Senha: " + tentativa);
                                return true;
                            }
                        }
                    }

                }
            }
        }

        return false;
    }
}
