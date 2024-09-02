/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practica1_lf.FrontEnd;

import com.mycompany.practica1_lf.BackEnd.Controlador;
import com.mycompany.practica1_lf.Exceptions.ExceptionsAnalizadorLexico;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
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
    private int cantidadLineas = 1;
    private int cantidadTokens;

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

    public JPanel getPanelImagen() {
        return panelImagen;
    }

    public JTextArea getAreaTextoCodigo() {
        return areaTextoCodigo;
    }

    public JTextArea getAreaTextoNumeroLinea() {
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
        botonGenerarImagen = new javax.swing.JButton();
        botonCargarArchivo = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        panelImagen = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        subMenuReportes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTextoNumeroLinea.setColumns(20);
        areaTextoNumeroLinea.setRows(5);
        jScrollPane1.setViewportView(areaTextoNumeroLinea);

        areaTextoCodigo.setColumns(20);
        areaTextoCodigo.setRows(5);
        areaTextoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                areaTextoCodigoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(areaTextoCodigo);

        botonGenerarImagen.setText("Generar Imagen");
        botonGenerarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarImagenActionPerformed(evt);
            }
        });

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
                        .addComponent(botonGenerarImagen))
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(12, 12, 12)
                .addGroup(panelAnalizadorLexicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGenerarImagen)
                    .addComponent(botonLimpiar)
                    .addComponent(botonCargarArchivo))
                .addContainerGap())
        );

        jMenu1.setText("Reportes");

        subMenuReportes.setText("Ver Reporte");
        subMenuReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuReportesActionPerformed(evt);
            }
        });
        jMenu1.add(subMenuReportes);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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

    private void botonGenerarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarImagenActionPerformed
        try {
            // TODO add your handling code here:
            controlador.generarImagen();
        } catch (ExceptionsAnalizadorLexico ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonGenerarImagenActionPerformed

    private void areaTextoCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_areaTextoCodigoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            System.out.println("ENTER");
            cantidadLineas++;
            areaTextoNumeroLinea.setText(crearNumeroDeLineas().toString());
        }
    }//GEN-LAST:event_areaTextoCodigoKeyPressed

    private void subMenuReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuReportesActionPerformed
        // TODO add your handling code here:
        FrameReportes frameReportes = new FrameReportes(controlador.getImagen());
        frameReportes.setLocationRelativeTo(null);
        frameReportes.setVisible(true);
        frameReportes.mostrarDatosEnTabla();
    }//GEN-LAST:event_subMenuReportesActionPerformed

    private StringBuilder crearNumeroDeLineas() {
        StringBuilder numeroDeLineas = new StringBuilder();
        for (int i = 0; i < cantidadLineas; i++) {
            numeroDeLineas.append(i+1).append("\n");
        }
        return numeroDeLineas;
    }

    public int getCantidadTokens() {
        return cantidadTokens;
    }

    public void setCantidadTokens(int cantidadTokens) {
        this.cantidadTokens = cantidadTokens;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTextoCodigo;
    private javax.swing.JTextArea areaTextoNumeroLinea;
    private javax.swing.JButton botonCargarArchivo;
    private javax.swing.JButton botonGenerarImagen;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelAnalizadorLexico;
    private javax.swing.JPanel panelImagen;
    private javax.swing.JMenuItem subMenuReportes;
    // End of variables declaration//GEN-END:variables
}
