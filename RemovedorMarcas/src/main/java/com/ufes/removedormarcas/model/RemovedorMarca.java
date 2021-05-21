/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.removedormarcas.model;

/**
 *
 * @author Valquíria Anacleto
 */
public class RemovedorMarca extends Tratador {

    public RemovedorMarca(String stringTratada) {
        super(stringTratada);
    }

    @Override
    public boolean aceita(String texto) {
           return texto.contains(this.marca);
    }

    @Override
    public String handler(String texto) {
         return UtilitarioString.getInstance().substitui(texto, marca, "*");
    }
    
}
