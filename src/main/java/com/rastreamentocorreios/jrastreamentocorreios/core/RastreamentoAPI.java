/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastreamentocorreios.jrastreamentocorreios.core;

import com.rastreamentocorreios.jrastreamentocorreios.models.Rastreamento;
import com.rastreamentocorreios.jrastreamentocorreios.models.Status;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriell Huver
 */
public class RastreamentoAPI {

    private static final String BASE_URL = "https://www.linkcorreios.com.br/";
    private static final DateFormat formatter = new SimpleDateFormat("MM/dd/yy-HH:mm");

    public Rastreamento Rastrear(String codigo) throws Exception {
        Document doc = Jsoup.connect(BASE_URL + codigo).get();
        Elements elementsByTag = doc.getElementsByClass("singlepost");
        Elements statusElements = elementsByTag.get(0).getElementsByTag("ul");
        List<Status> statusList = new ArrayList<>();
        for (Element statusElement: statusElements ) {
            Status status =  new Status();
            status.setStatus(statusElement.getElementsByTag("li").get(0).text());
            status.setData(statusElement.getElementsByTag("li").get(1).text());
            if(statusElement.getElementsByTag("li").get(2).text().contains("Local")){
                status.setLocal(statusElement.getElementsByTag("li").get(2).text());
            } else if(statusElement.getElementsByTag("li").get(2).text().contains("Origem") && statusElement.getElementsByTag("li").get(3).text().contains("Destino")) {
                status.setOrigem(statusElement.getElementsByTag("li").get(2).text());
                status.setDestino(statusElement.getElementsByTag("li").get(3).text());
            }
            statusList.add(status);
        }

        return Rastreamento.builder().statusList(statusList).build();
    }


}
