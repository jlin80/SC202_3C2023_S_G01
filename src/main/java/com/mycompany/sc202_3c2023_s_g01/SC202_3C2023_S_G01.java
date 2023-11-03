package com.mycompany.sc202_3c2023_s_g01;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

public class SC202_3C2023_S_G01 {
    
    public static void main(String[] args) {

//funciones de la barberia.
        String NombreCompleto;
        String citas;
        String opcion;


        int salario =  2500;
        int salario2 =  3000;
        int MontoTotal =  salario * 13;

citas = NombreCompleto;

while (true) {
    opcion = JOptionPane.showInputDialog("Digite el tipo de servicio que desea:\n"
        + "1. Tinte\n" 
            + "2. Corte con barba\n" 
                + "3. Servicio completo\n" 
                    + "4. Precio de servicio\n"
                        + "5. Salir\n");

                          
// Aquí puedes agregar la lógica para gestionar la cita según la opción seleccionada

switch (opcion) {
    case "1":
        JOptionPane.showMessageDialog(null, "Bienvenido a nuestro menú de citas.");
            NombreCompleto = JOptionPane.showInputDialog("Digite su nombre para guarda la cita:");    
            citas JOptionPane.showMessageDialog(null, "Usted fue guardado con Éxito" );

            break;
    
    case "2":
        // Lógica para el servicio de corte con barba
            break;
                            
    case "3":
        // Lógica para el servicio completo
            break;

    case "4":
        // Lógica para consultar el precio del servicio
        JOptionPane.showMessageDialog(null,"Su Monto total es el siguiente :" + "\n" + MontoTotal);
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
