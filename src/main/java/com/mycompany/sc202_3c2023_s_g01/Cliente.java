package com.mycompany.sc202_3c2023_s_g01;
public class Cliente {
    private String nameCliente;
    private String numTelCliente;
    private String correoCliente;

    public Cliente(String nameCliente, String numTelCliente, String correoCliente) {
        this.nameCliente = nameCliente;
        this.numTelCliente = numTelCliente;
        this.correoCliente = correoCliente;
    }

    // Getters y Setters
    public String getNameCliente() {
        return nameCliente;
    }

    public void setNameCliente(String nameCliente) {
        this.nameCliente = nameCliente;
    }

    public String getNumTelCliente() {
        return numTelCliente;
    }

    public void setNumTelCliente(String numTelCliente) {
        this.numTelCliente = numTelCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
}