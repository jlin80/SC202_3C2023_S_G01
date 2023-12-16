

package com.mycompany.testeo;

import javax.swing.JOptionPane;

public class Testeo {

    public static void main(String[] args) {
        Barbero barbs = new Barbero();
        Cita cit = new Cita(barbs);
        
        int opcion=1;
        
        while(opcion>0 || opcion<=7){
            opcion = Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO\n"
                + "1.Ingresar barberos\n"+
                "2.Reportar los barberos\n"+
                "3.Ingresar citas\n"+
                "4.Reportar las citas\n"+
                "5.Eliminar citas\n"+
                "6.Revisar agenda\n"+
                "Otro.Salir"));
            switch (opcion) {
                case 0:
                    
                    break;
                case 1:
                    barbs.InsertarBarberos();
                    break;
                case 2:
                    barbs.mostrarDatosBarberos();
                    break;
                case 3:
                    cit.InsertarCita();
                    break;
                case 4:
                    cit.mostrarDatosCitas();
                    break;
                case 5:
                    cit.eliminarCita();
                    break;
                case 6:
                    
                    break;
            }
        }
        
        
        
    }
}
