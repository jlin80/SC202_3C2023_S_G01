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
    
    private Cita citaAsociada;
    private double totalFactura;

    public Factura( Cita citaAsociada, double totalFactura) {
        this.citaAsociada = citaAsociada;
        this.totalFactura = totalFactura;
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

