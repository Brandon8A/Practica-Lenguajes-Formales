/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1_lf.FrontEnd;

import com.mycompany.practica1_lf.BackEnd.Controlador;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author brandon
 */
public class FrameAnalizadorLexico extends javax.swing.JFrame {

   private Controlador controlador;
   private int tamañoFilas;
   private int tamañoColumnas;
    /**
     * Creates new form FrameAnalizadorLexico
     */
    public FrameAnalizadorLexico() {
        initComponents();
        this.controlador = new Controlador(this);
        areaTextoNumeroLinea.setEditable(false);
        this.setTitle("Analizador Lexico");
        SolicitarFilasColumnas solicitarFilasColumnas = new SolicitarFilasColumnas(this, true, controlador);
        solicitarFilasColumnas.setLocationRelativeTo(null);
        solicitarFilasColumnas.setVisible(true);
    }

    public Controlador getControlador() {
        return controlador;
    }

    public int getTamañoFilas() {
        return tamañoFilas;
    }

    public void setTamañoFilas(int tamañoFilas) {
        this.tamañoFilas = tamañoFilas;
    }

    public int getTamañoColumnas() {
        return tamañoColumnas;
    }

    public void setTamañoColumnas(int tamañoColumnas) {
        this.tamañoColumnas = tamañoColumnas;
    }

    public JPanel getPanelImagen(){
        return panelImagen;
    }
    
    public JTextArea getAreaTextoCodigo(){
        return areaTextoCodigo;
    }
    
    public JTextArea getAreaTextoNumeroLinea(){
        return areaTextoNumeroLinea;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAnalizadorLexico = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoNumeroLinea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaTextoCodigo = new javax.swing.JTextArea();
        botonAnalizadorLexico = new javax.swing.JButton();
        botonCargarArchivo = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        panelImagen = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTextoNumeroLinea.setColumns(20);
        areaTextoNumeroLinea.setRows(5);
        jScrollPane1.setViewportView(areaTextoNumeroLinea);

        areaTextoCodigo.setColumns(20);
        areaTextoCodigo.setRows(5);
        jScrollPane3.setViewportView(areaTextoCodigo);

        botonAnalizadorLexico.setText("Generar Imagen");

        botonCargarArchivo.setText("Cargar Archivo");
        botonCargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargarArchivoActionPerformed(evt);
            }
        });

        botonLimpiar.setText("Limpiar");

        javax.swing.GroupLayout panelImagenLayout = new javax.swing.GroupLayout(panelImagen);
        panelImagen.setLayout(panelImagenLayout);
        panelImagenLayout.setHorizontalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelImagenLayout.setVerticalGroup(
            panelImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelAnalizadorLexicoLayout = new javax.swing.GroupLayout(panelAnalizadorLexico);
        panelAnalizadorLexico.setLayout(panelAnalizadorLexicoLayout);
        panelAnalizadorLexicoLayout.setHorizontalGroup(
            panelAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAnalizadorLexicoLayout.createSequentialGroup()
                .addGroup(panelAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelAnalizadorLexicoLayout.createSequentialGroup()
                        .addComponent(botonCargarArchivo)
                        .addGap(410, 410, 410)
                        .addComponent(botonAnalizadorLexico))
                    .addGroup(panelAnalizadorLexicoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAnalizadorLexicoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelAnalizadorLexicoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(botonLimpiar)
                        .addGap(56, 56, 56))))
        );
        panelAnalizadorLexicoLayout.setVerticalGroup(
            panelAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAnalizadorLexicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(12, 12, 12)
                .addGroup(panelAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAnalizadorLexico)
                    .addComponent(botonLimpiar)
                    .addComponent(botonCargarArchivo))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAnalizadorLexico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelAnalizadorLexico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargarArchivoActionPerformed
        // TODO add your handling code here:
        controlador.abrirArchivo();
    }//GEN-LAST:event_botonCargarArchivoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTextoCodigo;
    private javax.swing.JTextArea areaTextoNumeroLinea;
    private javax.swing.JButton botonAnalizadorLexico;
    private javax.swing.JButton botonCargarArchivo;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelAnalizadorLexico;
    private javax.swing.JPanel panelImagen;
    // End of variables declaration//GEN-END:variables
}
