/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufes.removedormarcas.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Valquíria Anacleto
 */
public class ProcessadorTexto {
      private final ArrayList<Tratador> tratadores = new ArrayList<>();

    public void addTratador(Tratador tratador) throws Exception {
        if (tratador != null) {
            tratadores.add(tratador);
        } else {
             JOptionPane.showMessageDialog(null, "Informe um tratador válido:");
        }
    }
     public void RemoveTratador(Tratador tratador) throws Exception {
        if (tratador != null) {
            tratadores.remove(tratador);
        } else {
            JOptionPane.showMessageDialog(null, "Erro!:");
        }
    }

    public String processaTexto(String texto) throws Exception {
        for (Tratador tratador : tratadores) {
            if (tratador.aceita(texto)) {
                texto = tratador.handler(texto);
            }
        }
       return texto;

    }
}
