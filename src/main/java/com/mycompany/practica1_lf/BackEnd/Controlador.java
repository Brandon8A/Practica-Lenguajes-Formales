/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lf.BackEnd;

import com.mycompany.practica1_lf.Exceptions.ExceptionsAnalizadorLexico;
import com.mycompany.practica1_lf.FrontEnd.FrameAnalizadorLexico;
import com.mycompany.practica1_lf.FrontEnd.Pixel;
import com.mycompany.practica1_lf.PalabrasReservadas;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author brandon
 */
public class Controlador {

    private FrameAnalizadorLexico frameAnalizadorLexico;
    private Pixel[][] imagen;

    public Controlador(FrameAnalizadorLexico frameAnalizadorLexico) {
        this.frameAnalizadorLexico = frameAnalizadorLexico;
    }

    public void imprimirBotonesImagen() {
        frameAnalizadorLexico.getPanelImagen().removeAll();
        frameAnalizadorLexico.getPanelImagen().setLayout(new GridLayout(frameAnalizadorLexico.getTamañoFilas(), frameAnalizadorLexico.getTamañoColumnas()));
        imagen = new Pixel[frameAnalizadorLexico.getTamañoFilas()][frameAnalizadorLexico.getTamañoColumnas()];
        for (int i = 0; i < frameAnalizadorLexico.getTamañoFilas(); i++) {
            for (int j = 0; j < frameAnalizadorLexico.getTamañoColumnas(); j++) {
                imagen[i][j] = new Pixel();
                frameAnalizadorLexico.getPanelImagen().add(imagen[i][j]);
            }
        }
    }

    public void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", ".txt");
        int resultado = fileChooser.showOpenDialog(frameAnalizadorLexico);
        File archivoSeleccionado = fileChooser.getSelectedFile();
        obtenerContenidoArchvivo(archivoSeleccionado.getAbsolutePath());
    }

    private void obtenerContenidoArchvivo(String rutaArchivo) {
        try {
            FileReader archivoALeer = new FileReader(rutaArchivo);
            BufferedReader bufferedReader = new BufferedReader(archivoALeer);
            StringBuilder contenido = new StringBuilder();//Variable de tipo StringBuilder que nos ayudara a construir el contenido del archivo
            StringBuilder numeroLineaS = new StringBuilder();
            String linea;
            int numeroLineaI = 0;
            while ((linea = bufferedReader.readLine()) != null) {
                numeroLineaI++;
                numeroLineaS.append(numeroLineaI).append("\n");
                contenido.append(linea).append("\n");
            }
            frameAnalizadorLexico.getAreaTextoCodigo().setText(contenido.toString());
            frameAnalizadorLexico.getAreaTextoNumeroLinea().setText(numeroLineaS.toString());
        } catch (IOException e) {
            e.printStackTrace();
            frameAnalizadorLexico.getAreaTextoCodigo().setText("Error al abrir el archivo");
        }
        frameAnalizadorLexico.getAreaTextoCodigo().validate();
        frameAnalizadorLexico.getAreaTextoCodigo().repaint();
    }

    public void generarImagen() throws ExceptionsAnalizadorLexico {
        if (frameAnalizadorLexico.getAreaTextoCodigo() == null || frameAnalizadorLexico.getAreaTextoCodigo().getText().isBlank()) {
            throw new ExceptionsAnalizadorLexico("Ingrese codigo para poder analizarlo");
        }
//        System.out.print(frameAnalizadorLexico.getAreaTextoCodigo().getText());
        obtenerPalabras();
    }

    public void obtenerPalabras() {
        String texto = frameAnalizadorLexico.getAreaTextoCodigo().getText();
        String palabras[] = texto.split("\\s+");
        int i = 1;
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                for (PalabrasReservadas palabraReservada : PalabrasReservadas.values()) {
                    if (palabraReservada.name().equals(palabra)) {
                        System.out.println("La palabra " + palabra + " es una palabra reservada.");
                        
                    } else {
                        if (i == PalabrasReservadas.values().length) {
                            System.out.println("La palabra " + palabra + " NO esta reservada");
                        }
                    }
                    i++;
                }
            }
        }
    }
}
