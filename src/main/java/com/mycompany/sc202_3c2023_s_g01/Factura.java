/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sc202_3c2023_s_g01;

/**
 *
 * @author otava
 */
public class Factura {
    
    private Cliente cliente;
    private Cita citaAsociada;
    private double totalFactura;

    public Factura(Cliente cliente, Cita citaAsociada, double totalFactura) {
        this.cliente = cliente;
        this.citaAsociada = citaAsociada;
        this.totalFactura = totalFactura;
    }

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cita getCitaAsociada() {
        return citaAsociada;
    }

    public void setCitaAsociada(Cita citaAsociada) {
        this.citaAsociada = citaAsociada;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }
}

