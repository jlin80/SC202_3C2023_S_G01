
package com.mycompany.proyectofinal;

import javax.swing.JOptionPane;
public class Barbero {
    
    //Primero, se crea un arreglo con 3 barberos disponibles.
    datosBarberos barberos[] = new datosBarberos[3];

    //En este metodo, se podran insertar los 3 barberos.
    public void InsertarBarberos(){
        
        //Este ciclo for sirve para recorrer el arreglo de barberos, y en cada posicion llenar con objetos del barbero
        for (int i = 0; i < barberos.length; i++) {
            
            //Constructor para utilizar los datos del barbero, en la clase datosBarberos.
            datosBarberos barb = new datosBarberos();
            
            //Como el constructor se definio como barb, utilizamos la variable nombre de tipo barb
            barb.nombre = JOptionPane.showInputDialog("Digite el nombre del barbero:");
            
            //Este ciclo for es meramente para conseguir el nombre de los dias y reportarlos de
            //una manera mas visual
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
                
                //La variable trabajadia sirve para indicar si un barbero trabaja en un dia n
                int trabajadia = Integer.parseInt(JOptionPane.showInputDialog("¿Trabaja el barbero " + barb.nombre + " el día " + dia + "? \n1.Si \n2.No"));
                
                //Si trabaja ese dia, se ejecutara este codigo
                if (trabajadia ==1) {
                    
                    //Se define una hora inicio para el comienzo del trabajo del dia del barbero
                    int horaInicio = Integer.parseInt(JOptionPane.showInputDialog("¿A qué hora comienza a trabajar el barbero " + barb.nombre + " el día " + dia + "? \nIngrese solo el numero de la hora, la hora debe ser despues de las 7 y antes de las 20."));
                    
                    //Si la hora de inicio es menor a 7 estaria mal, por lo que se ejecuta este codigo
                    if (horaInicio<7){
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra a las 7.");
                        
                        //Al estar mal, se pone por defecto 7 como hora de inicip
                        horaInicio = 7;
                    }
                    
                    //Caso contrario en caso de que la hora sea mayor a lo esperado
                    if (horaInicio>=20){
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra a las 19 horas.");
                        horaInicio = 19;
                    }
                    
                    //Aqui se define hora final, que es donde termina la jornada del barbero ese dia
                    int horaFinal = Integer.parseInt(JOptionPane.showInputDialog("¿A qué hora termina de trabajar el barbero " + barb.nombre + " el día " + dia + "? \nIngrese solo el numero de la hora, maximo puede terminar a las 20 horas"));
                       
                    //Nuevamente hay ifs para atajar horas no esperadas
                    if (horaFinal<horaInicio){
                        JOptionPane.showMessageDialog(null, "La hora final es inferior a la hora de inicio, se pondra por defecto 1 hora despues del inicio.");
                        horaFinal = horaInicio+1;
                    }
                    
                    if (horaFinal>20){
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra a las 20 horas.");
                        horaFinal = 20;
                    }
                    
                    //Aqui, en el arreglo de dos dimensiones horario de tipo barb,
                    //se le asigna en la posicion columna 0 la hora inicial y la 1 la hora final.
                    //la j significa que ira recorriendo el arreglo horario
                    barb.horario[j][0] = horaInicio;
                    barb.horario[j][1] = horaFinal;
                    
                    //Se instancia la hora de almuerzo. Solo puede ser en el horario del dia establecido
                    barb.horaAlmuerzo = Integer.parseInt(JOptionPane.showInputDialog("Digite la hora de almuerzo: \nDebe estar entre las horas: " +horaInicio+ ":00, "+horaFinal+":00"));
                    
                    //If para evitar horas no esperadas
                    if (barb.horaAlmuerzo>horaFinal||barb.horaAlmuerzo<horaInicio){
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra en la hora final.");
                        barb.horaAlmuerzo = horaFinal-1;
                    }
                 
                // este else es del if original, si se trabajaba ese dia.
                } else {
                    //En caso de que no se trabaje, se pone -1 en todos los valores,
                    //que mas tarde servira para que se vea que no se trabaja ese dia
                    barb.horario[j][0] = -1;
                    barb.horario[j][1] = -1;
                    barb.horaAlmuerzo = -1;
                }
                
            }
            
            //Aqui finalmente agregamos todos los objetos al barbero
            barberos[i] =  barb;
        }
    }
    
    //Este metodo es para mostrar los datos del barbero
    public void mostrarDatosBarberos() {
        
        //Este string es para el mensaje
    String mensaje = "Datos de los barberos:\n\n";

    
    //Este ciclo for es para recorrer el arreglo de barberos
    for (int i = 0; i < barberos.length; i++) {
        
        //constructor
        datosBarberos barb = barberos[i];
        
        //aqui utilizamos el mensaje original para no estar escribiendo lo mismo,
        //y se le suma el nombre del barbero en la posicion correspondiente
        mensaje += "Barbero " + (i + 1) + ":\n";
        mensaje += "Nombre: " + barb.nombre + "\n";

        
        //ciclo for para los dias
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

            //Aqui es el mismo mensaje pero para los dias y las horas
            mensaje += "Día " + dia + ": ";
            if (barb.horario[j][0] != -1 && barb.horario[j][1] != -1) {
                mensaje += "Trabaja de " + barb.horario[j][0] + ":00 a " + barb.horario[j][1] + ":00";
                mensaje += ", Hora de almuerzo: " + barb.horaAlmuerzo + ":00\n";
            } else {
                mensaje += "No trabaja ese día\n";
            }
        }

        mensaje += "\n";
    }

    JOptionPane.showMessageDialog(null, mensaje, "Datos de los barberos", JOptionPane.INFORMATION_MESSAGE);
    }
}

    

