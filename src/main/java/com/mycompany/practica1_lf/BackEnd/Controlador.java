/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lf.BackEnd;

import com.mycompany.practica1_lf.Exceptions.ExceptionsAnalizadorLexico;
import com.mycompany.practica1_lf.FrontEnd.FrameAnalizadorLexico;
import com.mycompany.practica1_lf.FrontEnd.Pixel;
import java.awt.Color;
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
    private int controladorFilas = 0;
    private int controladorColumnas = 0;

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

    private void reseteandoImagen() {
        for (int i = 0; i < frameAnalizadorLexico.getTamañoFilas(); i++) {
            for (int j = 0; j < frameAnalizadorLexico.getTamañoColumnas(); j++) {
                imagen[i][j].setBackground(Color.WHITE);
            }
        }
        frameAnalizadorLexico.getPanelImagen().validate();
        frameAnalizadorLexico.getPanelImagen().repaint();
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
        controladorColumnas = 0;
        controladorFilas = 0;
        reseteandoImagen();
        obtenerPalabras();
    }

    /**
     * Metodo que obtiene cada palabra del texto de la JTextArea y las almacena en un arreglo
     */
    public void obtenerPalabras() {
        String texto = frameAnalizadorLexico.getAreaTextoCodigo().getText();
        String palabras[] = texto.split("\\s+");
        Operadores identificarOperadores = new Operadores(this);
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                identificarOperadores.identificadorOperadorAritmetico(palabra);
                identificarOperadores.identificadorOperadorRelacionalComparacion(palabra);
                identificarOperadores.identificadorOperadoresAsignacion(palabra);
                identificarOperadores.identificadorPalabrasReservadas(palabra);
            }
        }
    }

    public void pintarImagen(Color color) {
        imagen[controladorFilas][controladorColumnas].setBackground(color);
    }

    public int getControladorFilas() {
        return controladorFilas;
    }

    public void setControladorFilas(int controladorFilas) {
        this.controladorFilas = controladorFilas;
    }

    public int getControladorColumnas() {
        return controladorColumnas;
    }

    public void setControladorColumnas(int controladorColumnas) {
        this.controladorColumnas = controladorColumnas;
    }

    public FrameAnalizadorLexico getFrameAnalizadorLexico() {
        return frameAnalizadorLexico;
    }

}
