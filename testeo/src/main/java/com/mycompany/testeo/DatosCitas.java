
package com.mycompany.testeo;

//Clase datos citas, que contiene todos los objetos que se almacenaran en el arreglo
//de citas
public class DatosCitas {
    //Se crea un cliente del tipo DatosCliente, que es otra clase
    private DatosCliente cliente;
    private int diaCita;
    
    //Se crea ademas el tipo servicio, que pertenece a un enum en la clase TipoServicio
    private TipoServicio.EleccionServicio tipoServicio;
    private int valorHora;
    private int horaInicio;

    //Constructor de la clase
    public DatosCitas() {

    }


    //Se ponen los setters y getters, ya que los datos de los clientes son privados
    public DatosCliente getCliente() {
        return cliente;
    }

    public void setCliente(DatosCliente cliente) {
        this.cliente = cliente;
    }

    public int getDiaCita() {
        return diaCita;
    }

    public void setDiaCita(int diaCita) {
        this.diaCita = diaCita;
    }

    public TipoServicio.EleccionServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio.EleccionServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getValorHora() {
        return valorHora;
    }

    public void setValorHora(int valorHora) {
        this.valorHora = valorHora;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }
}
