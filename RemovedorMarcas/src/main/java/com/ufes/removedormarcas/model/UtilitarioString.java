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
class UtilitarioString {
     private static UtilitarioString instance;

    private UtilitarioString() {
    }

    public static UtilitarioString getInstance() {
        if (instance == null) {
            instance = new UtilitarioString();
        }
        return instance;
    }
    
    public String substitui(String texto, String palavra, CharSequence simbolo) {
        return texto.replaceAll(palavra, new String(new char[palavra.length()]).replace("\0", simbolo));
    }
}
