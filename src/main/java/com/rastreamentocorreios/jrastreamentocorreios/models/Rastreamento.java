/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastreamentocorreios.jrastreamentocorreios.models;

import java.util.List;

/**
 *
 * @author Gabriell Huver
 */
public class Rastreamento {

    private List<Status> statusList;

    public Rastreamento(List<Status> statusList) {
        this.statusList = statusList;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

  
 
}
