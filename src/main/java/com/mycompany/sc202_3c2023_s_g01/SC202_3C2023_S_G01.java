//Integrantes:
//Lesly_Otavalo
//Erick_Benavides
//Hernán_Lu
//Jin_Lin

package com.mycompany.sc202_3c2023_s_g01;
import javax.swing.JOptionPane;

public class SC202_3C2023_S_G01 {
    
    public static void main(String[] args) {

//Nombre de los barberos.
        String Barbero1, Barbero2, Barbero3, Barbero4, Barbero5;
        int BarberoSalario1 , BarberoSalario2, BarberoSalario3, BarberoSalario4, BarberoSalario5;

//funciones de la barberia.
        String NombreCompleto;
        String citas;
        String opcion;
 


// Menu principal
while (true) {
opcion = JOptionPane.showInputDialog("Digite una opción:\n"
        + "1. Agregar cita\n"
            + "2. Información de citas\n"
                 + "3. Salir\n");

switch (opcion) {

case "1":
    // Aquí puedes agregar la lógica para buscar un barbero
    break;
    
case "2":
    // Aquí puedes agregar la lógica para buscar información de cita
     break;
                            
case "3":System.exit(0); // Termina el programa directamente
break;
               
default:JOptionPane.showMessageDialog(null, "Opción inválida");
break;    
     
                        }
// Menú de tipos de servicio por resulver 

while (true) {
    citas = JOptionPane.showInputDialog("Digite el tipo de servicio que desea:\n"
        + "1. Tinte\n" 
            + "2. Corte con barba\n" 
                + "3. Servicio completo\n" 
                    + "4. Precio de servicio\n"
                        + "5. Salir\n");

citas = JOptionPane.showInputDialog("Digite su nombre para guarda la cita:");    

                          
// Aquí puedes agregar la lógica para gestionar la cita según la opción seleccionada

switch (citas) {
    case "1":
        break;
    
    case "2":
        // Lógica para el servicio de corte con barba
            break;
                            
    case "3":
        // Lógica para el servicio completo
            break;

    case "4":
        // Lógica para consultar el precio del servicio
            break;

    case "5":
        JOptionPane.showMessageDialog(null, "Saliendo del sistema");
            System.exit(0);
                           
    default:
        JOptionPane.showMessageDialog(null, "Opción inválida. Digite una opción válida.");
    break;

   
                }   
            }
        }
    }
}
