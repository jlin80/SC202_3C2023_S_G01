
package com.mycompany.testeo;


import javax.swing.JOptionPane;

//Clase cita, para poder insertar citas
public class Cita {
    
    //Se crea una instancia privada de la clase Barbero, ya que para instanciar una 
    //cita, esta debe tener los datos de Barbero, sino se considerarian datos nulos
    //al "no existir" en esta clase
     private Barbero barbs; 

     //Despues, se crea una clase cita con valor de barbero de tipo de la clase Barbero
    public Cita(Barbero barbero) {
        this.barbs = barbero;
    }
    
    //Se crea un arreglo citas de tipo DatosCitas, que tiene: cliente de tipo datosCliente, dia cita,
    //tipo servicio, el valor monetario de una hora, y la hora de inicio de la cita
    DatosCitas[] citas = new DatosCitas[3];
     
    //Metodo para poder ingresar una cita, obteniendo los datos antes mencionados
    public void InsertarCita(){
        
        //Se instancian constructores de las clases necesarias, que son los datos
        DatosCliente client = new DatosCliente();
        TipoServicio servicio = new TipoServicio();
        TipoServicio.EleccionServicio tipo;
        DatosCitas datosCita = new DatosCitas();
        
        //Se instancia una variable string de nombre
        String nombre = JOptionPane.showInputDialog("Cual es su nombre?");
        
        //A ese string, se utiliza el setNombre de cliente para poder agregar el nombre
        //insertado por el usuario en datosCliente
        client.setNombre(nombre);
        
        //Se pide una variable entera para el telefono del usuario
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Cual es su numero de telefono?"));
        client.setTelefono(telefono);
        
        //Se instancia una variable entera de dia, en el que el usuario puede elegir un numero entre el rango
        //de 1 a 7, cada uno equivale a un dia. Ademas, con getNombre podemos mostrar el nombre del usuario
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Bien "+client.getNombre()+
                "! \nQue dia quiere reservar su cita?\n1.Lunes \n2.Martes \n3.Miercoles \n4.Jueves \n5.Viernes \n6.Sabado \n7.Domingo"));
        
        //Se instancia valor hora en 0 por errores inesperados
        int valorHora=0;
        
        //If que verifica si el dia esta en el rango de 1 a 5, osea de lunes a viernes
        if (dia <= 1 || dia <= 5) {
            JOptionPane.showMessageDialog(null, "Debido a que solicito entre semana, sera a precio normal");
            
            //Si es entre semana, valor hora es equivalente a 2500 
            valorHora = 2500;
            
        //Este else if es para verificar si es 6 o 7, osea fin de semana
        } else if (dia == 6 || dia ==7) {
            JOptionPane.showMessageDialog(null, "Debido a que solicito en fin de semana, sera mas caro por hora (pasa de 2500 a 3000)");
            
            //Si lo es el valor por hora cambia, ahora siendo de 3000
            valorHora = 3000;
            
        //Else en caso de que las anteriores dos no hayan sido efectivas
        } else {
            
            //Se llama nuevamente a InsertarCita para que el usuario pueda insertar de nuevo  el dia
            JOptionPane.showMessageDialog(null, "Opción de día inválida. Por favor, introduzca un día válido.");
            InsertarCita();
         
        }
        
        //Variable para seleccion, en el que el usuario elegira el tipo de servicio que quiere
        int seleccion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo de servicio. \n1.Corte \n2.Tinte \n3.Servicio completo"));
        
        //Si seleccion equivale a uno, entonces el servicio es de corte
        if (seleccion ==1){
            
            //tipo ahora es igual al enum de TipoServicio y la opcion corte
            tipo = TipoServicio.EleccionServicio.CORTE;
            
            //Ademas, si la opcion es 1 osea corte entonces la horas horas necesarias
            //es solo una
            servicio.horasServicio=1;
        }
        
        //Else if para el 2
        else if (seleccion ==2){
            //Si es 2 es tinte, y las horas del servicio equivalen a 2
            tipo = TipoServicio.EleccionServicio.TINTE;
            servicio.horasServicio=2;
        }
        
        //Else if para el 3
        else if (seleccion ==3){
            //Si es 3 es Servicio completo, y las horas necesarias son 3
            tipo = TipoServicio.EleccionServicio.SERVICIO_COMPLETO;
            servicio.horasServicio=3;
        }
        
        //Else por si cualquiera de las anteriores no ocurre, por lo que se pone por 
        //defecto en corte
        else{
            tipo = TipoServicio.EleccionServicio.CORTE;
        }
        
        //Se instancia una variable precio bruto, que es igual a valor hora por
        //las horas necesarias. Esto dara un precio total bruto, osea sin IVA
        int pbruto = valorHora * servicio.horasServicio;
        
        //Mensaje para mostrar al usuario los datos pertinentes
        JOptionPane.showMessageDialog(null, "Ha elegido "+tipo+", el precio bruto es de: " +pbruto);
        
        //Se pide al usuario una hora de inicio, y que sea entre las 7 y 19
        int horaInicio = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la hora de inicio (A partir de las 7):"));
        
        //Si las horas no estan en el rango, se pone por defecto en 7
        if (horaInicio < 7 || horaInicio > 19) {
            JOptionPane.showMessageDialog(null, "La hora de inicio debe estar entre 7 y 20, se pondra automaticamente en 7.");
            horaInicio =7;
            
        }
        
        //Se llama al metodo buscarBarberoDisponible, que tiene como valores dia, hora de inicio y las horas servicio
        //para comparar
        datosBarberos barberoDisponible = buscarBarberoDisponible(dia, horaInicio, servicio.horasServicio);
        
        //If para verificar si hay datos. Si barbero es distinto a nulo, entonces prosigue
        if (barberoDisponible != null) {
            //Mensaje para notificar que se encontro un barbero
            JOptionPane.showMessageDialog(null, "Barbero disponible, Se procederá con la reserva.");

            
            //Se utilizan los sets para que los valores dados por el usuario se pongan en la clase
            //datosCita, de esta manera haciendo la correcta insercion de datos
            datosCita.setCliente(client);
            datosCita.setDiaCita(dia);
            datosCita.setTipoServicio(tipo);
            datosCita.setValorHora(valorHora);
            datosCita.setHoraInicio(horaInicio);
            
            //Ciclo for para verificar si hay una cita en esa posicion
            for (int i = 0; i < citas.length; i++) {
                if (citas[i] == null) {
                    //Si no la hay, osea es nulo, a esa posicion del arreglo se le
                    //dan los datos de cita
                    citas[i] = datosCita;
                    break;
                }
            }
        //Else del if para encontrar barberos. de ser nulo, se le notifica al usuario que no hay
        //barberos ese dia
        } else {
            JOptionPane.showMessageDialog(null, "Lo sentimos, no hay barbero disponible para la hora de inicio seleccionada.");
            InsertarCita();
        }
    }
    
    //Metodo para buscar algun barbero que encaje con las especificaciones del usuario,
    //teniendo como parametros dia, hora de inicio y duracion
    private datosBarberos buscarBarberoDisponible(int dia, int horaInicio, int duracion) {
        
        //Ciclo for para recorrer el arreglo barberos
        for (int i = 0; i < barbs.barberos.length; i++) {
            
            //Constructor para instanciar el arreglo barberos como barb
            datosBarberos barb = barbs.barberos[i];
            
            //Si las horas inicio o final son diferentes de -1, osea que trabajan entonces
            //se creara un booleano de true, osea si hay un barbero con coincidencia
            if (barb.horario[dia - 1][0] != -1 && barb.horario[dia - 1][1] != -1) {
                boolean barberoDisponible = true;
                
                //Ciclo for en la que hora es la hora de inicio dada por el usuario.
                //y se compara con los demas datos necesarios
                for (int hora = horaInicio; hora < horaInicio + duracion; hora++) {

                    
                    //Si la hora es igual a la hora de almuerzo, es menor a la hora de inicio
                    //o es mayor a la hora final del barbero se le considera como false
                    if (hora == barb.horaAlmuerzo || hora < barb.horario[dia - 1][0] || hora >= barb.horario[dia - 1][1]) {
                        barberoDisponible = false;
                        break;
                    }
                }
                //If para verificar que barbero si se encontro, y mostrara el nombre del barbero
                if (barberoDisponible==true) {
                    System.out.println("Barbero disponible encontrado: " + barb.nombre);
                    
                    //ademas, retorna barb o el barbero encontrado
                    return barb;
                }
            }
        }
        //Si se termina el ciclo for si coincidencias, el retorno es nulo
        return null;
    }
    
    //Metodo para mostrar las citas al usuario
    public void mostrarDatosCitas() {
        
        //Se inicia un objeto mensaje con un mensaje predeterminado
        String mensaje = "Datos de las citas:\n\n";
        
        //Ciclo for para recorrer el arreglo citas
        for (int i = 0; i < citas.length; i++) {
            
            //Constructor para el arreglo citas de tipo DatosCitas como datosCita
            DatosCitas datosCita = citas[i];
            
            //Si el arreglo es nulo, entonces se muestra un mensaje de error y manda al usuario a 
            //insertar una cita
            if (citas == null){
                JOptionPane.showMessageDialog(null, "No hay datos para mostrar");
                InsertarCita();
            }
            
            //Si datos cita es diferente a nulo entonces se podra proseguir
            if (datosCita != null) {
                
                //Al objeto mensaje se le agrega en texto los datos correspondientes
                mensaje += "Cita " + (i + 1) + ":\n";
                
                //Ademas, se obtiene el nombre de DatosCliente que a su vez pertenece a datosCitas]
                mensaje += "Cliente: " + datosCita.getCliente().getNombre() + "\n";
                
                //Ciclo for para los dias
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
                    //If para verificar que el dia se encontro. En este caso, se compara
                    //getDiaCita osea el dia de la cita insertada de tipo datos cita con
                    //j -1, que es parte del ciclo y se le resta uno para tener equivalencia
                    // con el dia deseado
                    if (datosCita.getDiaCita()==j-1){
                        
                        //Se le agregan los datos pertinentes en el mensaje
                        mensaje += "Día: " + dia + "\n";
                        mensaje += "Tipo de Servicio: " + datosCita.getTipoServicio() + "\n";
                        mensaje += "Valor por Hora: " + datosCita.getValorHora() + "\n";
                        mensaje += "Hora de Inicio: " + datosCita.getHoraInicio() + ":00\n\n";
                    }
                    else{
                        //Si no hay coincidencias en el dia, entonces mensaje se queda igual
                        mensaje=mensaje;
                    }
                }
            }
        }
        //Por ultimo, se muestra todo lo que almaceno mensaje
        JOptionPane.showMessageDialog(null, mensaje);
    }   
    
    //Metodo para eliminar una cita especificada por el usuario
    public void eliminarCita() {
        
        //Se instancia una variable para saber cual es el nombre del cliente con las citas a eliminar
        String nombreClienteEliminar = JOptionPane.showInputDialog("Ingrese el nombre del cliente cuya cita desea eliminar:");
        
        //Se instancia un contador citas en 0 en caso de que el cliente tenga mas de una cita
        int contadorCitas = 0;
        
        //Ciclo for para recorrer todo el arreglo citas
        for (int i = 0; i < citas.length; i++) {
            //Constructor para instanciar el arreglo citas como datosCita
            DatosCitas datosCita = citas[i];
            
            //If para verificar que los datos de la cita no sean nulos y que el nombre
            //que pertenece a cliente que a su vez pertenece a datos cita es igual o
            //Coincide con el nombre del cliente que desea eliminar una de sus citas
            if (datosCita != null && datosCita.getCliente().getNombre().equals(nombreClienteEliminar)) {
                
                //El contador de citas se suma, para obtener todas las citas que tiene ese cliente
                contadorCitas++;
                
                //Se imprime un mensaje un mensaje para mostrar las citas del usuario con sus datos
                JOptionPane.showMessageDialog(null, "Cita " + contadorCitas + ":\n"
                        + "Día: " + obtenerNombreDia(datosCita.getDiaCita()) + "\n"
                        + "Tipo de Servicio: " + datosCita.getTipoServicio() + "\n"
                        + "Hora de Inicio: " + datosCita.getHoraInicio() + ":00");
            }
        }
        
        //Si el contador de citas es mayor a 0 entra en este if
        if (contadorCitas > 0) {
            
            //Se instancia un numeroCita a eliminar, esto en caso de que un solo cliente tenga varias citas
            //Entonces, el usuario escoje cual de las citas desea eliminar
            int numeroCitaEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de cita que desea eliminar:"));
            
            //Este if verifica que el numero de cita a eliminar sea entre el rango de 1 al contador de citas
            if (numeroCitaEliminar >= 1 && numeroCitaEliminar <= contadorCitas) {
                
                //Se instancia una variable de citas eliminadas
                int citasEliminadas = 0;
                
                //Ciclo for para recorrer el arreglo citas
                for (int i = 0; i < citas.length; i++) {
                    
                    //Constructor para instanciar el arreglo citas como datosCita
                    DatosCitas datosCita = citas[i];
                    
                    //Nuevamente si los datos no son nulos y equivalen entonces entra en el if
                    if (datosCita != null && datosCita.getCliente().getNombre().equals(nombreClienteEliminar)) {
                            //Se instancia la cita en null, osea que la borra por completo, y la cantidad de 
                            //citas eliminadas se suma
                            citas[i] = null;
                            citasEliminadas++;
                            
                        //Si citas eliminadas es igual al numeroCitaEliminar, entonces enviara un mensaje de que
                        //se logro la operacion con exito
                        if (citasEliminadas == numeroCitaEliminar) {
                            JOptionPane.showMessageDialog(null, "Cita eliminada con éxito.");
                            return;
                        }
                    }
                }
                //Si el numero de cita a eliminar no coincide con los mostrados, entonces se cancelara la operacion
            } else {
                JOptionPane.showMessageDialog(null, "Número de cita no válido. No se eliminó ninguna cita.");
            }
            //Este else pertenece al if para encontrar las citas asociadas a un nombre. De no haberlas,
            //se le notificara al usuario que no hay
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron citas asociadas al cliente: " + nombreClienteEliminar);
        }
    }

    private String obtenerNombreDia(int numeroDia) {
        switch (numeroDia) {
            case 0:
                return "Lunes";
            case 1:
                return "Martes";
            case 2:
                return "Miércoles";
            case 3:
                return "Jueves";
            case 4:
                return "Viernes";
            case 5:
                return "Sábado";
            case 6:
                return "Domingo";
            default:
                return "Desconocido";
        }
    }
}
