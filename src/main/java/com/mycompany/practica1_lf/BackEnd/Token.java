/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lf.BackEnd;

/**
 *
 * @author brandon
 */
public class Token {
    
    private int fila;
    private int columna;
    private String lexema;
    private String tipo;

    public Token(int fila, int columna, String lexema, String tipo) {
        this.fila = fila;
        this.columna = columna;
        this.lexema = lexema;
        this.tipo = tipo;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public String getLexema() {
        return lexema;
    }

    public String getTipo() {
        return tipo;
    }
    
    
    
}
