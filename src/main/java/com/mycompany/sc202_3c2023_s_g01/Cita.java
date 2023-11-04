package com.mycompany.sc202_3c2023_s_g01;
public class Cita {
    private String nombreCliente;
    private String numTelCliente;
    private String dia;
    private int horaInicio;
    private int horaFin;
    private double precioPorHora;

    public Cita(String nombreCliente, String numTelCliente, String dia, int horaInicio, int horaFin, double precioPorHora) {
        this.nombreCliente = nombreCliente;
        this.numTelCliente = numTelCliente;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precioPorHora = precioPorHora;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumTelCliente() {
        return numTelCliente;
    }

    public void setNumTelCliente(String numTelCliente) {
        this.numTelCliente = numTelCliente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int HoraInicio) {
        this.horaInicio = HoraInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int HoraFin) {
        this.horaFin = HoraFin;
    }
    public double getPrecioPorHora() {
        return precioPorHora;
    }

    public void setPrecioPorHora(double precioPorHora) {
        this.precioPorHora = precioPorHora;
    }
}
