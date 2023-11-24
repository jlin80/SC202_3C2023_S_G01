package com.mycompany.sc202_3c2023_s_g01;
import javax.swing.JOptionPane;

public class Factura {
    
    public int precio = 2500;
    public int precioFin = 3000;
    public double totalEntre = 0;
    public double totalFinde =0;
    public String fecha="";
    
    
    
    public void muestraFactura (int dia,int duracion,String nombreCliente, String numTelCliente){
    
    if (dia <=5) {
        fecha = JOptionPane.showInputDialog(null,"indigue la fecha de la factura");
        totalEntre =((precio * duracion)*0.13); 
        JOptionPane.showMessageDialog(null, "***FACTURA***\n FECHA: "+fecha+ "\nNOMBRE DE CLIENTE  : "+ nombreCliente +"\n tTELÉFONO :"+numTelCliente+"DÍA :"+dia
        + "TIPO DE TRABAJO :(hay que hacer una lista de por lo menos 5 tipos de trabajos que despues de le da equivalencia a duración para colocar esta parte) "+
                "TOTAL CON IVA INCLUIDO: " + totalEntre );
  } else 
    {
       totalFinde = ((precioFin * duracion)*0.13);
       fecha = JOptionPane.showInputDialog(null,"indigue la fecha de la factura");
       
      JOptionPane.showMessageDialog(null, "***FACTURA***\n FECHA: "+fecha+ "\nNOMBRE DE CLIENTE  : "+ nombreCliente +"\n tTELÉFONO :"+numTelCliente+"DÍA :"+ dia
              +"TIPO DE TRABAJO :(hay que hacer una lista de por lo menos 5 tipos de trabajos que despues de le da equivalencia a duración para colocar esta parte)"
                + "TOTAL CON IVA INCLUIDO: " + totalFinde );
        }
    }
}