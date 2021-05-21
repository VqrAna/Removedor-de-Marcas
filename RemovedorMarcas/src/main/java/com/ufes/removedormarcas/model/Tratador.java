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
public abstract class Tratador {

    protected final String marca;

    public Tratador(String stringTratada) {
        this.marca = stringTratada;
    }
    

    public abstract boolean aceita(String texto);
      public abstract String handler(String texto);

  
}
