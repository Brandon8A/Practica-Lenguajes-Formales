/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lf.FrontEnd;

import com.mycompany.practica1_lf.BackEnd.Token;
import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author brandon
 */
public class Pixel extends JButton{
    
    private int numeroPixel;
    private Token token = null;

    public Pixel() {
        this.setBackground(Color.WHITE);
    }

    
    
    public int getNumeroPixel() {
        return numeroPixel;
    }

    public void setNumeroPixel(int numeroPixel) {
        this.numeroPixel = numeroPixel;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
    
    
}
