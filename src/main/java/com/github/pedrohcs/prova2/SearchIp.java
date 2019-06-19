package com.github.pedrohcs.prova2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class SearchIp implements Runnable{

    private int begin;
    private int end;
    private int[] ip;
    private ArrayList<String> validIps = new ArrayList();

    public SearchIp (int begin, int end, int[] ip){
        this.begin = begin;
        this.end = end;
        this.ip = ip;
    }

    private void calculateIpBegin(){
        int cont = 1;
        while(cont <= this.begin){
            addIp();
            cont++;
        }
    }

    private void addIp() {
        if(this.ip[3] == 255){
            this.ip[3] = 0;
            if(this.ip[2] == 255){
                this.ip[2] = 0;
                if(this.ip[1] == 255){
                    this.ip[1] = 0;
                    this.ip[0] += 1;
                } else {
                    this.ip[1] += 1;
                }
            } else {
                this.ip[2] += 1;
            }
        } else{
            this.ip[3] += 1;
        }
    }

    private long estaAcessivel(String hostAddress) {
        InetAddress inetAddress = null;
        Date start, stop;
        try {
            inetAddress = InetAddress.getByName(hostAddress);
        } catch (UnknownHostException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        try {
            start = new Date();
            if (inetAddress.isReachable(5000)) {
                stop = new Date();
                return (stop.getTime() - start.getTime());
            }
        } catch (IOException e1) {
            System.out.println("Erro: " + e1.getMessage());
        } catch (IllegalArgumentException e1) {
            System.out.println("Timeout inválido:" + e1.getMessage());
        }
        return -1; // para indicar erro
    }

    private ArrayList<String> getValidIps(){
        Collections.sort(this.validIps);
        return this.validIps;
    }

    @Override
    public void run() {
        this.calculateIpBegin();
        int cont = 1;
        while(cont <= this.end){
            addIp();
            String ip = Integer.toString(this.ip[0]) + "." + Integer.toString(this.ip[1]) +
                    "." + Integer.toString(this.ip[2]) + "." + Integer.toString(this.ip[3]);
            if(this.estaAcessivel(ip) != -1){
                this.validIps.add(ip);
            }
            cont++;
        }
    }
}
