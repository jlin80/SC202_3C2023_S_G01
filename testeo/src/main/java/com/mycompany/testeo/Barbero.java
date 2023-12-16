
package com.mycompany.testeo;

import javax.swing.JOptionPane;
public class Barbero {
    
    //Aqui se crea el arreglo barberos de la clase datosBarberos, clase que tiene todos los objetos necesarios los cuales son:
    //Nombre, hora de almuerzo, y el horario que es un arreglo de dos dimensiones
    datosBarberos barberos[] = new datosBarberos[2];
    
    //Metodo para realizar el ingreso de los barberos al sistema, enviando los objetos a una posicion del arreglo barberos
    public void InsertarBarberos(){
        
        //Ciclo for cuya funcion es recorrer todas las posiciones del arreglo barberos para ingresar los datos
        for (int i = 0; i < barberos.length; i++) {
            
            //Metodo constructor para instanciar la clase datosBarberos. De esta manera, podemos usarlos e 
            //insertarlos. Esta dentro de la funcion para que siempre guarde un barbero distinto
            datosBarberos barb = new datosBarberos();
            
            //Le damos un valor a barb.nombre, que al ser de tipo barb por consecuencia estamos llenando
            // un dato de DatosBarberos. Con uso del input, le pedimos al usuario que ingrese el valor
            //del mismo
            barb.nombre = JOptionPane.showInputDialog("Digite el nombre del barbero:");
            
            //Ciclo for con limite de 7 para poder cambiar visualmente el horario del dia de la semana que 
            //se le solicita al cliente. 
            for (int j = 0; j < 7; j++) {
                
                //Se instancia un string dia con espacio en blanco para evitar posibles errores.
                String dia = "";
                
                //Se inicia el switch, dependiendo del valor de j le instancia el nombre del dia
                //a la variable dia. De esta manera, podemos poner el nombre del dia utilizando
                //numeros para identificarlos
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
                
                //Se utiliza un Input para solicitar si el barbero trabaja el dia dado por el switch case
                int trabajadia = Integer.parseInt(JOptionPane.showInputDialog("¿Trabaja el barbero " + barb.nombre + " el día " + dia + "? \n1.Si \n2.No"));
                
                //Este if sirve para verificar si el barbero trabaja ese dia. De ser la opcion 1 si trabaja, por
                //lo que entra en esta opcion del if
                if (trabajadia ==1) {
                    
                    //Creamos una variable entera para poder instanciar la hora de inicio, o hora en la que comienza
                    // a trabajar el barbero. Ponemos tambien el nombre del barbero antes insertado, y el dia.
                    //ademas, se le solicita al usuario que sea una hora entre las 7 y 20
                    int horaInicio = Integer.parseInt(JOptionPane.showInputDialog("¿A qué hora comienza a trabajar el barbero " + barb.nombre + " el día " + dia + "? \nIngrese solo el numero de la hora, la hora debe ser despues de las 7 y antes de las 20."));
                    
                    //If de validacion que la hora insertada haya sido correcta
                    if (horaInicio<7){
                        
                        //En caso de que la hora sea menor que 7, se pone por defecto
                        //en 7
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra a las 7.");
                        horaInicio = 7;
                    }
                    
                    //if de validacion al igual que el anterior
                    if (horaInicio>=20){
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra a las 19 horas.");
                        horaInicio = 19;
                    }
                    
                    //Variable para instanciar la hora final o hora en la que termina ese dia.
                    int horaFinal = Integer.parseInt(JOptionPane.showInputDialog("¿A qué hora termina de trabajar el barbero " + barb.nombre + " el día " + dia + "? \nIngrese solo el numero de la hora, maximo puede terminar a las 20 horas"));
                    
                    //If de validacion por si la hora final es menor a la hora de inicio
                    if (horaFinal<horaInicio){
                        
                        //se pone por defecto que la hora final es hora de inicio mas una hora
                        JOptionPane.showMessageDialog(null, "La hora final es inferior a la hora de inicio, se pondra por defecto 1 hora despues del inicio.");
                        horaFinal = horaInicio+1;
                    }
                    
                    //if de validacion para que la hora final no sea mayor a 20 horas
                    if (horaFinal>20){
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra a las 20 horas.");
                        horaFinal = 20;
                    }
                    
                    //Una variable entera para almacenar la hora de almuerzo. Debe ser entre la 
                    //hora inicio y hora final
                    int horaAlmuerzo = Integer.parseInt(JOptionPane.showInputDialog("Digite la hora de almuerzo: \nDebe estar entre las horas: " +horaInicio+ ":00, "+horaFinal+":00"));
                    
                    //If de validacion para que la hora almuerzo este entre hora inicio y final
                    if (horaAlmuerzo > horaFinal || horaAlmuerzo < horaInicio) {
                        JOptionPane.showMessageDialog(null, "La hora es incorrecta, por defecto se pondra 1 hora antes de la hora de salida.");
                        horaAlmuerzo = horaFinal-1;
                    }
                    
                    //Aqui damos los valores insertados por el usuario a los respectivos
                    //objetos de datosBarberos. De esta manera, la posicion 0 de la fila
                    //equivale a la hora de inicio, y la posicion 1 a la hora final.
                    //Ademas, a hora de almuerzo se le inserta tambien su respectivo valor.
                    barb.horario[j][0] = horaInicio;
                    barb.horario[j][1] = horaFinal;
                    barb.horaAlmuerzo = horaAlmuerzo;

                //Este else pertenece al if inicial de trabaja dia, osea de cuando se elije
                //si trabaja o no
                } else {
                    //Al ser else, significa que no es uno y por ende no trabaja ese dia,
                    //por lo que a las posiciones de horas se les da -1. Esto significa que
                    //no trabaja ese dia
                    barb.horario[j][0] = -1;
                    barb.horario[j][1] = -1;
                    
                }
                
            //Este cierre de llave pertenece al for de dias significando que ya se termino
            //de solicitar el horario completo del barbero ingresado
            }
            
            //Una vez terminado todo el proceso de insercion, se le da a la posicion i del arreglo
            //barberos todos los objetos de barb, osea datosBarberos
            barberos[i] =  barb;
        }
    }
    
    //Metodo para mostrar los datos antes insertados de los barberos, llamando los objetos ya guardados
    //en el arreglo del mismo nombre
    public void mostrarDatosBarberos() {
        
    //Objeto de tipo string llamado mensaje. Este se inicializa con un mensaje por defecto, que tiene
    //dos saltos de linea para dar un mejor orden. Mientras mas datos hayan, mas se le ira agregando a
    //este mensaje
    String mensaje = "Datos de los barberos:\n\n";
    
    //Ciclo for para recorrer todo el arreglo de barberos. De esta manera, podemos ir uno por uno
    //agregando datos al objeto mensaje
    for (int i = 0; i < barberos.length; i++) {
        
        //Aqui se crea un constructor para el arreglo de barberos. Asi se podran obtener los datos
        //de manera mas ordenada y facil
        datosBarberos barb = barberos[i];
        
        //Este if verifica si los datos guardados son nulos, esto porque si el usuario decide llamar
        //primero en el menu a mostrar datos, si no hubiesen entonces daria un error
        if (barb == null){
            
            //Mensaje mostrando el error y ademas llama al metodo insertar barberos, para que pueda insertarlos
            JOptionPane.showMessageDialog(null, "No hay datos para mostrar");
            InsertarBarberos();
        }
        
        //De no ser nulo, al objeto mensaje se le añade mas texto con el numero del barbero
        //y su nombre, que esta guardado en barb. Recordar que en este caso cuando decimos
        //barb se refiere al arreglo
        mensaje += "Barbero " + (i + 1) + ":\n";
        mensaje += "Nombre: " + barb.nombre + "\n";
        
        //For para poder mostrar en texto el dia equivalente a un numero
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
            
            //Se le agrega al objeto mensaje el dia
            mensaje += "Día " + dia + ": ";
            
            //If para verificar que la hora inicial o final del horario no son -1
            //Recordar que -1 significa que no trabaja
            if (barb.horario[j][0] != -1 && barb.horario[j][1] != -1) {
                
                //Se le agrega al objeto mensaje la posicion de la columna 0 y 1, que equivalen
                //a la hora inicial y final de ese dia del barberuo, ademas de la hora de almuerzo
                mensaje += "Trabaja de " + barb.horario[j][0] + ":00 a " + barb.horario[j][1] + ":00";
                mensaje += ", Hora de almuerzo: " + barb.horaAlmuerzo + ":00\n";
                
            //Este else es por si encontro un -1
            } else {
                //Si encontro -1, entonces a mensaje se le añadira nada mas que no se trabaja
                mensaje += "No trabaja ese día\n";
            }
        }
        
        //Juego, cuando termine el for del dia, se agregara un salto de linea para mostrarlo de manera
        //mas ordenada
        mensaje += "\n";
    }
    
    //Finalmente, se imprimira el objeto mensaje, que tiene todos los datos necesarios para este punto
    JOptionPane.showMessageDialog(null, mensaje);
    }
}

    

