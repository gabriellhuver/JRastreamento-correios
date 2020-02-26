/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastreamentocorreios.jrastreamentocorreios.tests;

import com.rastreamentocorreios.jrastreamentocorreios.core.RastreamentoAPI;
import com.rastreamentocorreios.jrastreamentocorreios.models.Rastreamento;
import com.rastreamentocorreios.jrastreamentocorreios.models.Status;
import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriell Huver
 */
public class RastreamentoAPITest {
    @Test
    public void TestRequestOk() {
        RastreamentoAPI rastreamento =  new RastreamentoAPI();
        try {
            Rastreamento rastreio = rastreamento.Rastrear("testRequest");
            System.out.println(rastreio.getStatusCode());
            for (Status status : rastreio.getStatusList()) {
                System.out.println(status.toString());
            }
            Assert.assertEquals((Integer)rastreio.getStatusCode(),(Integer)200);
        } catch (Exception ex) {
            Logger.getLogger(RastreamentoAPITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

 
}
