package com.mycompany.sc202_3c2023_s_g01;
public class Servicio {
    private String tipoServ;
    private double precioServ; 
    private int tiempoEstimado; // Ingresarlo en minutos

    public Servicio(String tipoServ, double precioServ, int tiempoEstimado) {
        this.tipoServ = tipoServ;
        this.precioServ = precioServ;
        this.tiempoEstimado = tiempoEstimado;
    }

    // Getters y Setters
    public String getTipoServ() {
        return tipoServ;
    }

    public void setTipoServ(String tipoServ) {
        this.tipoServ = tipoServ;
    }

    public double getPrecioServ() {
        return precioServ;
    }

    public void setPrecioServ(double precioServ) {
        this.precioServ = precioServ;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(int tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }
}