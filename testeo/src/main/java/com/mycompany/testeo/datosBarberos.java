
package com.mycompany.testeo;

//Clase datos barberos. En esta clase se almacenan los datos que el arreglo barberos debe tener
public class datosBarberos {
    
    //se instancian en publico ya que la info del barbero debe ser publica, y tiene el
    //nombre, hora de almuerzo y horario
    public String nombre;
    public int horaAlmuerzo;
    
    //El horario es una matriz, donde las 7 posiciones equivalen a dias y las 2 posiciones
    //que equivalen a hora inicio y hora final de ese dia
    public int[][] horario = new int[7][2];
    
}
