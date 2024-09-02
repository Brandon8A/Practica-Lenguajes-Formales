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
    private boolean palabraIdentificada = false;

    /**
     * Metodo constructor
     * @param frameAnalizadorLexico tener control sobre la parte grafica de la aplicacion
     */
    public Controlador(FrameAnalizadorLexico frameAnalizadorLexico) {
        this.frameAnalizadorLexico = frameAnalizadorLexico;
    }

    /**
     * Este metodo permite imprimir botones en el campo 3 de nuestra ventana
     */
    public void imprimirBotonesImagen() {
        frameAnalizadorLexico.getPanelImagen().removeAll();
        frameAnalizadorLexico.getPanelImagen().setLayout(new GridLayout(frameAnalizadorLexico.getTamañoFilas(), frameAnalizadorLexico.getTamañoColumnas()));
        imagen = new Pixel[frameAnalizadorLexico.getTamañoFilas()][frameAnalizadorLexico.getTamañoColumnas()];//estabelciendo dimensiones a la imagen
        for (int i = 0; i < frameAnalizadorLexico.getTamañoFilas(); i++) {
            for (int j = 0; j < frameAnalizadorLexico.getTamañoColumnas(); j++) {
                imagen[i][j] = new Pixel();
                frameAnalizadorLexico.getPanelImagen().add(imagen[i][j]);
            }
        }
    }

    /**
     * Metodo que permite establecer el color blanco a cada uno de los pixeles
     */
    private void reseteandoImagen() {
        for (int i = 0; i < frameAnalizadorLexico.getTamañoFilas(); i++) {
            for (int j = 0; j < frameAnalizadorLexico.getTamañoColumnas(); j++) {
                imagen[i][j].setBackground(Color.WHITE);
            }
        }
        frameAnalizadorLexico.getPanelImagen().validate();
        frameAnalizadorLexico.getPanelImagen().repaint();
    }

    /**
     * Metodo que permite abrir un archivo de texto
     */
    public void abrirArchivo() {
        JFileChooser fileChooser = new JFileChooser();//herramienta grafica 
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);//seleccionando unicamente archivos

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", ".txt");
        int resultado = fileChooser.showOpenDialog(frameAnalizadorLexico);
        File archivoSeleccionado = fileChooser.getSelectedFile();//alamcenando archivo en la variable 
        obtenerContenidoArchvivo(archivoSeleccionado.getAbsolutePath());//obteniendo el path del archivo
    }

    /**
     * Este metodo permitira obtener el contenido que este escrito en el archivo
     * @param rutaArchivo recibe el path del archivo a extraer la informacion
     */
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

    /**
     * Metodo que permite pintar cada pixel
     * @throws ExceptionsAnalizadorLexico 
     */
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
        String texto = frameAnalizadorLexico.getAreaTextoCodigo().getText();//obteniendo el texto del area de texto
        String palabras[] = texto.split("\\s+");
        Operadores identificarOperadores = new Operadores(this);
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                if (!palabraIdentificada) {
                    identificarOperadores.identificadorOperadorRelacionalComparacion(palabra);
                }
                if (!palabraIdentificada) {
                    identificarOperadores.identificadorOperadoresAsignacion(palabra);
                }
                if (!palabraIdentificada) {
                    identificarOperadores.identificadorOperadorAritmetico(palabra);
                }
                if (!palabraIdentificada) {
                    identificarOperadores.identificadorPalabrasReservadas(palabra);
                }
                if (!palabraIdentificada) {
                    identificarOperadores.identificadorTiposDatos(palabra);
                }
            }
            palabraIdentificada = false;
        }
    }

    /**
     * Metodo que permite establecer color a cada pixel y establecer un token a cada pixel
     * @param color el color del cual se va a pintar la imagen
     * @param token el tipo de dato que va a tener cada pixel
     */
    public void pintarImagen(Color color, Token token) {
        imagen[controladorFilas][controladorColumnas].setBackground(color);
        imagen[controladorFilas][controladorColumnas].setToken(token);
    }

    //METODOS GETTERS Y SETTERS
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

    public Pixel[][] getImagen() {
        return imagen;
    }

    public void setImagen(Pixel[][] imagen) {
        this.imagen = imagen;
    }

    public boolean isPalabraIdentificada() {
        return palabraIdentificada;
    }

    public void setPalabraIdentificada(boolean palabraIdentificada) {
        this.palabraIdentificada = palabraIdentificada;
    }
    
    

}
