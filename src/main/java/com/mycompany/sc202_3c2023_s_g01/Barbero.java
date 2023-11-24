
package com.mycompany.proyectofinal;

import javax.swing.JOptionPane;
public class Barbero {
    
    datosBarberos barberos[] = new datosBarberos[3];
    
    public void InsertarBarberos(){
        for (int i = 0; i < barberos.length; i++) {
            datosBarberos barb = new datosBarberos();
            
            barb.nombre = JOptionPane.showInputDialog("Digite el nombre del barbero:");
            
            for (int j = 0; j < 7; j++) {
                String dia = "";
                switch (j) {
                    case 0:
                        dia = "Lunes";
                        break;
                    case 1:
                        dia = "Martes";
                        break;
                    case 2:
                        dia = "Miércoles";
                        break;
                    case 3:
                        dia = "Jueves";
                        break;
                    case 4:
                        dia = "Viernes";
                        break;
                    case 5:
                        dia = "Sábado";
                        break;
                    case 6:
                        dia = "Domingo";
                        break;
                }
                int trabajadia = Integer.parseInt(JOptionPane.showInputDialog("¿Trabaja el barbero " + barb.nombre + " el día " + dia + "? \n1.Si \n2.No"));
                if (trabajadia ==1) {
                    int horaInicio = Integer.parseInt(JOptionPane.showInputDialog("¿A qué hora comienza a trabajar el barbero " + barb.nombre + " el día " + dia + "? \nIngrese solo el numero de la hora, la hora debe ser despues de las 7 y antes de las 20."));
                    if (horaInicio<7){
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra a las 7.");
                        horaInicio = 7;
                    }
                    
                    if (horaInicio>=20){
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra a las 19 horas.");
                        horaInicio = 19;
                    }
                    int horaFinal = Integer.parseInt(JOptionPane.showInputDialog("¿A qué hora termina de trabajar el barbero " + barb.nombre + " el día " + dia + "? \nIngrese solo el numero de la hora, maximo puede terminar a las 20 horas"));
                    
                    if (horaFinal<horaInicio){
                        JOptionPane.showMessageDialog(null, "La hora final es inferior a la hora de inicio, se pondra por defecto 1 hora despues del inicio.");
                        horaFinal = horaInicio+1;
                    }
                    
                    if (horaFinal>20){
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra a las 20 horas.");
                        horaFinal = 20;
                    }
                    barb.horario[j][0] = horaInicio;
                    barb.horario[j][1] = horaFinal;
                    
                    barb.horaAlmuerzo = Integer.parseInt(JOptionPane.showInputDialog("Digite la hora de almuerzo: \nDebe estar entre las horas: " +horaInicio+ ":00, "+horaFinal+":00"));
                    
                } else {
                    barb.horario[j][0] = -1;
                    barb.horario[j][1] = -1;
                    barb.horaAlmuerzo = -1;
                }
                
            }
            barberos[i] =  barb;
        }
    }
}
    

