package com.mycompany.sc202_3c2023_s_g01;
import javax.swing.JOptionPane;

public class SC202_3C2023_S_G01 {
    
    public static void main(String[] args) {

 // Crear objetos necesarios
        Barbero barbero = new Barbero();
        Cita cita = new Cita();
        Factura factura = new Factura();

        while (true) {
            // Mostrar menú de opciones
            String opcion = JOptionPane.showInputDialog(
                    "1. Factura\n" +
                    "2. Cita\n" +
                    "3. Barbero\n" +
                    "4. Datos del Barbero\n" +
                    "5. Salir"
            );

            // Procesar la opción seleccionada
            switch (opcion) {
                case "1":
              
                    factura.muestraFactura(0, 0, opcion, opcion);
                    break;
                case "2":

                    cita.bienvenida();
                    cita.Cita(opcion, opcion, 0, 0, barbero);
                    cita.eliminarCita(opcion, 0);
                    break;
                case "3":
            
                    barbero.InsertarBarberos();
                    break;
                case "4":
           
                    barbero.mostrarDatosBarberos();
                    break;
                case "5":
               
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    return;
                default:
           
                    JOptionPane.showMessageDialog(null, "Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}
