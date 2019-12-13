/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastreamentocorreios.jrastreamentocorreios.models;

import java.util.Date;

/**
 *
 * @author Gabriell Huver
 */
public class Status {

    private String data;
    private String status;
    private String local;
    private String origem;
    private String destino;

    public Status(String data, String status, String local, String origem, String destino) {
        this.data = data;
        this.status = status;
        this.origem = origem;
        this.destino = destino;
        this.local = local;
    }

    public Status() {
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Status{" + "data=" + data + ", status=" + status + ", local=" + local + ", origem=" + origem + ", destino=" + destino + '}';
    }

   

}
