/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1_lf.BackEnd;

import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author brandon
 */
public class Operadores {

    private final String COLOR_HEXADECIMAL_SUMA = "#FF33FF";
    private final String COLOR_HEXADECIMAL_RESTA = "#C19A6B";
    private final String COLOR_HEXADECIMAL_EXPONENTE = "#FCD0B4";
    private final String COLOR_HEXADECIMAL_DIVISION = "#B4D941";
    private final String COLOR_HEXADECIMAL_MODULO = "#D9AB41";
    private final String COLOR_HEXADECIMAL_MULTIPLICACION = "#D80073";
    private final String COLOR_HEXADECIMAL_IGUAL_DOBLE = "#6A00FF";
    private final String COLOR_HEXADECIMAL_DIFERENTE = "#3F2212";
    private final String COLOR_HEXADECIMAL_MAYOR_QUE = "#D9D441";
    private final String COLOR_HEXADECIMAL_MENOR_QUE = "#D94A41";
    private final String COLOR_HEXADECIMAL_MAYOR_O_IGUAL_QUE = "#E3C800";
    private final String COLOR_HEXADECIMAL_MENOR_O_IGUAL_QUE = "#F0A30A";
    private final String COLOR_HEXADECIMAL_IGUAL_SIMPLE = "#41D9D4";
    private final String COLOR_HEXADECIMAL_ASIGNACION_COMPUESTA = "#FFFFFF";
    private final String COLOR_HEXADECIMAL_ENTERO = "#1BA1E2";
    private final String COLOR_HEXADECIMAL_DECIMAL = "#FFFF88";
    private final String COLOR_HEXADECIMAL_CADENA = "#E51400";
    private final String COLOR_HEXADECIMAL_BOOLEANO = "#FA6800";
    private final String COLOR_HEXADECIMAL_CARACTER = "#0050EF";

    private Controlador controlador;

    public Operadores(Controlador controlador) {
        this.controlador = controlador;
    }

    //Metodo que permite identificar cada uno de los operadores aritmeticos
    public void identificadorOperadorAritmetico(String texto) {
        Pattern pattern = Pattern.compile("[+\\-*/^]");//estableciendo que caracteres deben identificar como artimeticos
        Matcher matcher = pattern.matcher(texto);
        while (matcher.find()) {
            System.out.println("Operador: " + matcher.group());
            establecerColorIdentificadorAritmetico(matcher.group());
            controlador.setControladorColumnas(controlador.getControladorColumnas() + 1);
            if (controlador.getControladorColumnas() == controlador.getFrameAnalizadorLexico().getTamañoColumnas()) {
                controlador.setControladorColumnas(0);
                controlador.setControladorFilas(controlador.getControladorFilas() + 1);
            }
        }

    }

    private void establecerColorIdentificadorAritmetico(String operadorAritmetico) {
        Color color = null;
        if (operadorAritmetico.equals("+")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAritmetico, "Operador Aritmetico");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_SUMA), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorAritmetico.equals("-")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAritmetico, "Operador Aritmetico");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_SUMA), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorAritmetico.equals("^")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAritmetico, "Operador Aritmetico");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_SUMA), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorAritmetico.equals("/")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAritmetico, "Operador Aritmetico");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_SUMA), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorAritmetico.equals("Mod")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAritmetico, "Operador Aritmetico");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_SUMA), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorAritmetico.equals("*")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAritmetico, "Operador Aritmetico");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_SUMA), token);
            controlador.setPalabraIdentificada(true);
        }
    }

    public void identificadorOperadorRelacionalComparacion(String texto) {
        Pattern pattern = Pattern.compile("==|!=|<|>|<=|>=");
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Operadores relacionales encontrados:");
        while (matcher.find()) {
            System.out.println("Operador: " + matcher.group());
            establecerColorIdentificadorRelacionalComparacion(matcher.group());
            controlador.setControladorColumnas(controlador.getControladorColumnas() + 1);
            if (controlador.getControladorColumnas() == controlador.getFrameAnalizadorLexico().getTamañoColumnas()) {
                controlador.setControladorColumnas(0);
                controlador.setControladorFilas(controlador.getControladorFilas() + 1);
            }
        }
    }

    private void establecerColorIdentificadorRelacionalComparacion(String operadorRelacionalComparacion) {
        Color color = null;
        if (operadorRelacionalComparacion.equals("==")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorRelacionalComparacion, "Operador Relacional");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_DOBLE), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorRelacionalComparacion.equals("<>")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorRelacionalComparacion, "Operador Relacional");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_DOBLE), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorRelacionalComparacion.equals(">")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorRelacionalComparacion, "Operador Relacional");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_DOBLE), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorRelacionalComparacion.equals("<")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorRelacionalComparacion, "Operador Relacional");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_DOBLE), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorRelacionalComparacion.equals(">=")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorRelacionalComparacion, "Operador Relacional");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_DOBLE), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorRelacionalComparacion.equals("<=")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorRelacionalComparacion, "Operador Relacional");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_DOBLE), token);
            controlador.setPalabraIdentificada(true);
        }
    }

    public void identificadorOperadoresAsignacion(String texto) {
        // Expresión regular para encontrar operadores de asignación
        Pattern pattern = Pattern.compile("\\+=|-=|\\*=|/=|%=|=");
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Operadores de asignación encontrados:");
        while (matcher.find()) {
            System.out.println("Operador: " + matcher.group());
            establecerColorIdentificadorAsignacion(matcher.group());
            controlador.setControladorColumnas(controlador.getControladorColumnas() + 1);
            if (controlador.getControladorColumnas() == controlador.getFrameAnalizadorLexico().getTamañoColumnas()) {
                controlador.setControladorColumnas(0);
                controlador.setControladorFilas(controlador.getControladorFilas() + 1);
            }
        }
    }

    private void establecerColorIdentificadorAsignacion(String operadorAsignacion) {
        Color color = null;
        if (operadorAsignacion.equals("=")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAsignacion, "Operador Asignacion");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_SIMPLE), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorAsignacion.equals("+=")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAsignacion, "Operador Asignacion");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_SIMPLE), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorAsignacion.equals("-=")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAsignacion, "Operador Asignacion");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_SIMPLE), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorAsignacion.equals("*=")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAsignacion, "Operador Asignacion");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_SIMPLE), token);
            controlador.setPalabraIdentificada(true);
        } else if (operadorAsignacion.equals("/=")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(),
                    operadorAsignacion, "Operador Asignacion");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_IGUAL_SIMPLE), token);
            controlador.setPalabraIdentificada(true);
        }
    }

    public void identificadorPalabrasReservadas(String palabra) {
        int i = 0;
        for (PalabrasReservadas palabraReservada : PalabrasReservadas.values()) {
            if (palabraReservada.name().equals(palabra)) {
                System.out.println("La palabra " + palabra + " es una palabra reservada.");
                String colorHexadecimal = "#60A917";
                Color color = null;
                Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(), palabra, "Palabra Reservada");
                controlador.pintarImagen(color = color.decode(colorHexadecimal),token);
                controlador.setControladorColumnas(controlador.getControladorColumnas() + 1);
                controlador.setPalabraIdentificada(true);
                if (controlador.getControladorColumnas() == controlador.getFrameAnalizadorLexico().getTamañoColumnas()) {
                    controlador.setControladorColumnas(0);
                    controlador.setControladorFilas(controlador.getControladorFilas() + 1);
                }
//                        controladorColumnas++;
            } else {
                if (i == PalabrasReservadas.values().length) {
                    System.out.println("La palabra " + palabra + " NO esta reservada");
                }
            }
            i++;
        }

    }

    public void identificadorTiposDatos(String palabra) {
        // Verificar si es un número entero
        try {
            Integer.parseInt(palabra.trim());
            establecerColorTiposDatos("int");
            return;
        } catch (NumberFormatException e) {
            // No es un número entero
            System.out.println("No es entero");
        }

        // Verificar si es un número decimal
        try {
            Double.parseDouble(palabra.trim());
            establecerColorTiposDatos("Double");
            return;
        } catch (NumberFormatException e) {
            // No es un número decimal
            System.out.println("No es decimal");
        }
        if (palabra.length() == 1) {
            establecerColorTiposDatos("char");
            return;
        }
        if (palabra.equals("True") || palabra.equals("False")) {
            establecerColorTiposDatos("boolean");
            return;
        }
        establecerColorTiposDatos("String");
    }

    public void establecerColorTiposDatos(String tipoDato) {
        Color color = null;
        if (tipoDato.equals("int")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(), tipoDato, "Tipo de Dato");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_ENTERO), token);
            controlador.setControladorColumnas(controlador.getControladorColumnas() + 1);
            if (controlador.getControladorColumnas() == controlador.getFrameAnalizadorLexico().getTamañoColumnas()) {
                controlador.setControladorColumnas(0);
                controlador.setControladorFilas(controlador.getControladorFilas() + 1);
            }
        } else if (tipoDato.equals("Double")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(), tipoDato, "Tipo de Dato");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_DECIMAL), token);
            controlador.setControladorColumnas(controlador.getControladorColumnas() + 1);
            if (controlador.getControladorColumnas() == controlador.getFrameAnalizadorLexico().getTamañoColumnas()) {
                controlador.setControladorColumnas(0);
                controlador.setControladorFilas(controlador.getControladorFilas() + 1);
            }
        } else if (tipoDato.equals("char")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(), tipoDato, "Tipo de Dato");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_DECIMAL), token);
            controlador.setControladorColumnas(controlador.getControladorColumnas() + 1);
            if (controlador.getControladorColumnas() == controlador.getFrameAnalizadorLexico().getTamañoColumnas()) {
                controlador.setControladorColumnas(0);
                controlador.setControladorFilas(controlador.getControladorFilas() + 1);
            }
        } else if (tipoDato.equals("boolean")) {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(), tipoDato, "Tipo de Dato");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_DECIMAL), token);
            controlador.setControladorColumnas(controlador.getControladorColumnas() + 1);
            if (controlador.getControladorColumnas() == controlador.getFrameAnalizadorLexico().getTamañoColumnas()) {
                controlador.setControladorColumnas(0);
                controlador.setControladorFilas(controlador.getControladorFilas() + 1);
            }
        } else {
            Token token = new Token(controlador.getControladorFilas(), controlador.getControladorColumnas(), tipoDato, "Tipo de Dato");
            controlador.pintarImagen(color = color.decode(COLOR_HEXADECIMAL_DECIMAL), token);
            controlador.setControladorColumnas(controlador.getControladorColumnas() + 1);
            if (controlador.getControladorColumnas() == controlador.getFrameAnalizadorLexico().getTamañoColumnas()) {
                controlador.setControladorColumnas(0);
                controlador.setControladorFilas(controlador.getControladorFilas() + 1);
            }
        }
    }

}
//-*/%^+
