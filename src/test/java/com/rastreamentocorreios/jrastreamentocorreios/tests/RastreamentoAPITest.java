/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastreamentocorreios.jrastreamentocorreios.tests;

import com.rastreamentocorreios.jrastreamentocorreios.core.RastreamentoAPI;
import com.rastreamentocorreios.jrastreamentocorreios.models.Rastreamento;
import com.rastreamentocorreios.jrastreamentocorreios.models.Status;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author Gabriell Huver
 */
public class RastreamentoAPITest {
    @Test
    public void test() {
        RastreamentoAPI rastreamento =  new RastreamentoAPI();
        try {
            Rastreamento Rastrear = rastreamento.Rastrear("LO297764110CN");
            for (Status status : Rastrear.getStatusList()) {
                System.out.println(status.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(RastreamentoAPITest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

 
}
