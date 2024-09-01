/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lf.BackEnd;

import com.mycompany.practica1_lf.FrontEnd.FrameAnalizadorLexico;
import java.awt.GridLayout;
import javax.swing.JButton;

/**
 *
 * @author brandon
 */
public class Controlador {
    
    private FrameAnalizadorLexico frameAnalizadorLexico;

    public Controlador(FrameAnalizadorLexico frameAnalizadorLexico) {
        this.frameAnalizadorLexico = frameAnalizadorLexico;
    }
    
    public void imprimirBotonesImagen(){
        frameAnalizadorLexico.getPanelImagen().removeAll();
        frameAnalizadorLexico.getPanelImagen().setLayout(new GridLayout(frameAnalizadorLexico.getTamañoFilas(), frameAnalizadorLexico.getTamañoColumnas()));
        for (int i = 0; i < frameAnalizadorLexico.getTamañoFilas(); i++) {
            for (int j = 0; j < frameAnalizadorLexico.getTamañoColumnas(); j++) {
                frameAnalizadorLexico.getPanelImagen().add(new JButton());
            }
        }
    }
}
