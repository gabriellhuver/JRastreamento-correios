/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastreamentocorreios.jrastreamentocorreios.core;

import com.rastreamentocorreios.jrastreamentocorreios.models.Rastreamento;
import com.rastreamentocorreios.jrastreamentocorreios.models.Status;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Gabriell Huver
 */
public class RastreamentoAPI {

    private static final String BASE_URL = "https://www.linkcorreios.com.br/";

    public Rastreamento Rastrear(String codigo) throws Exception {
        Document doc = Jsoup.connect(BASE_URL + codigo).get();
        Elements elementsByTag = doc.getElementsByTag("td");
        List<Status> statusList = new ArrayList<>();
        for (int i = 0; i < elementsByTag.size(); i++) {
            String el = elementsByTag.get(i).text();
            if (isDateValid(el)) {
                Status newStatus = new Status();
                newStatus.setData(el);
                newStatus.setStatus(elementsByTag.get(i + 1).text());
                try {
                    if (elementsByTag.get(i + 2).text().contains("Local:")) {
                        newStatus.setLocal(elementsByTag.get(i + 2).text());
                    }
                } catch (Exception e) {
                }
                try {
                    if (elementsByTag.get(i + 2).text().contains("Origem:")) {
                        newStatus.setOrigem(elementsByTag.get(i + 2).text());
                    }
                } catch (Exception e) {
                }

                try {
                    if (elementsByTag.get(i + 3).text().contains("Destino:")) {
                        newStatus.setDestino(elementsByTag.get(i + 3).text());
                    }
                } catch (Exception e) {
                }
                statusList.add(newStatus);
            }

        }
        return new Rastreamento(reverseArrayList(statusList));
    }

    public static boolean isDateValid(String strDate) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false);
            Date data = format.parse(strDate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public List<Status> reverseArrayList(List<Status> alist) {
        for (int i = 0; i < alist.size() / 2; i++) {
            Status temp = alist.get(i);
            alist.set(i, alist.get(alist.size() - i - 1));
            alist.set(alist.size() - i - 1, temp);
        }
        return alist;
    }
}
