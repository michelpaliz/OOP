package com.germangascon.tema08.ejercicio01;

import java.util.Calendar;

public class Coche {
    public enum TipoCoche {MINI, UTILITARIO, FAMILIAR, DEPORTIVO}
    public enum ModalidadSeguro {TERCEROS, TODORIESGO}
    private String modelo;
    private String color;
    private boolean metalizada;
    private String matricula;
    private TipoCoche tipo;
    private int anyo;
    private ModalidadSeguro seguro;
    public Coche() {
        this.modelo = "Unknown";
        this.color = "Blanco";
        this.metalizada = false;
        this.matricula = "Unknown";
        this.tipo = TipoCoche.UTILITARIO;
        this.anyo = Calendar.getInstance().get(Calendar.YEAR);
        this.seguro = ModalidadSeguro.TERCEROS;
    }

    public Coche(String modelo, String color, boolean metalizada, String matricula, TipoCoche tipo, int anyo, ModalidadSeguro seguro) {
        this.modelo = modelo;
        this.color = color;
        this.metalizada = metalizada;
        this.matricula = matricula;
        this.tipo = tipo;
        this.anyo = anyo;
        this.seguro = seguro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isMetalizada() {
        return metalizada;
    }

    public void setMetalizada(boolean metalizada) {
        this.metalizada = metalizada;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TipoCoche getTipo() {
        return tipo;
    }

    public void setTipo(TipoCoche tipo) {
        this.tipo = tipo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public ModalidadSeguro getSeguro() {
        return seguro;
    }

    public void setSeguro(ModalidadSeguro seguro) {
        this.seguro = seguro;
    }

    public void imprimirCoche() {
        System.out.println("Coche: " + modelo );
        System.out.println("Color: " + color);

    }
}
