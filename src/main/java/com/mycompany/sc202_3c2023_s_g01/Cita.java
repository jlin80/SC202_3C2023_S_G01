package com.mycompany.sc202_3c2023_s_g01;
import javax.swing.JOptionPane;

public class Cita {
    public String nombreCliente;
    public String numTelCliente;
    public int dia;
    public int duracion;
    public Barbero barbero; //clase barbero
    public enum entreSemana{
        Lunes, Martes, Miercoles, Jueves, Viernes
    }
    
    public enum finDeSemana{
        Sabado, Domingo
    }
    
    Cita citas[] = new Cita[1]; //arreglo de citas
    
    public void Cita(String nombreCliente, String numTelCliente, int dia, int duracion, Barbero barbero) {
        this.nombreCliente = nombreCliente;
        this.numTelCliente = numTelCliente;
        this.dia = dia;
        this.duracion = duracion;
        this.barbero = barbero;
    }
    
    public void bienvenida() { //solicitar datos al cliente para añadir cita
        nombreCliente = JOptionPane.showInputDialog("Ingrese su nombre: ");
        numTelCliente = JOptionPane.showInputDialog("Ingrese su número teléfono: ");
        dia = Integer.parseInt(JOptionPane.showInputDialog("\n1.Lunes \n2.Martes \n3.Miércoles \n4.Jueves \n5.Viernes \nIngrese el día de la cita: "));
        Factura factura = new Factura();
        if (dia <= 5) {
            JOptionPane.showMessageDialog(null, "Ha elegido un día entre semana, el cobro del servicio es de: "+factura.precio);
        } else {
            JOptionPane.showMessageDialog(null, "Ha elegido un día del fin de semana, el cobro del servicio es de: "+factura.precioFin);
        }          
        duracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duración de la cita en horas: "));
        Barbero barberoDisponible = null;
        for (int i = 0; i < barberos.length; i++) { // recorre el arreglo de barberos
            if (duracion != barbero.horaAlmuerzo) { // si no lo contiene, lo llena
                Barbero barbero = barberos[i];
                barberoDisponible = barbero;
                JOptionPane.showMessageDialog(null, "La cita fue agendada con éxito.\nBarbero: "+barberoDisponible.nombre);
                break;
            }
        }
    }
    
    public void eliminarCita(String nombreCliente, int dia){
        for (int i = 0; i < citas.length; i++) {
            if (citas[i] != null) { // el if verifica si la posicion actual no esta nulo
                Cita citaEliminar = citas[i]; 
                boolean foundNombre = citaEliminar.nombreCliente.equals(nombreCliente); // verificar si el nombre coincide con el del cliente
                boolean foundDia = citaEliminar.dia == dia; // verificar si el dia coincide
                if (foundNombre && foundDia) { // si se cumple esta condicion se modifica el valor a nulo para liberar el espacio
                citas[i] = null; // se elimina moditicando el valor a nulo
                JOptionPane.showMessageDialog(null, "La cita fue eliminada con éxito.");
                return; // sale del metodo despues de eliminar la cita
                } else {
                JOptionPane.showMessageDialog(null, "No se encontró la cita para eliminar.");
                }
            }
        }
    }
}