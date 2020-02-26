/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastreamentocorreios.jrastreamentocorreios.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author Gabriell Huver
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
public class Status {

    private String data;
    private String status;
    private String local;
    private String origem;
    private String destino;

}
