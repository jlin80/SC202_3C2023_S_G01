package com.mycompany.sc202_3c2023_s_g01;
import javax.swing.JOptionPane;

public class Factura {
    
    public int precio = 2500;
    public int precioFin = 3000;
    public double totalEntre = 0;
    public double totalFinde =0;
    public String fecha="";
    

    public void muestraFactura (int dia,int duracion,String nombreCliente, String numTelCliente, TipoServicio tipoServicio){
    
    if (dia <=5) {
        fecha = JOptionPane.showInputDialog(null,"indigue la fecha de la factura");
        totalEntre =((precio * duracion)*0.13); 
        JOptionPane.showMessageDialog(null, "***FACTURA***\n FECHA: "+fecha+ "\nNOMBRE DE CLIENTE  : "+ nombreCliente +"\n tTELÉFONO :"+numTelCliente+"DÍA :"+dia
        + "TIPO DE TRABAJO : "+tipoServicio
               + "TOTAL CON IVA INCLUIDO: " + totalEntre );
  } else 
    {
       totalFinde = ((precioFin * duracion)*0.13);
       fecha = JOptionPane.showInputDialog(null,"indigue la fecha de la factura");
       
      JOptionPane.showMessageDialog(null, "***FACTURA***\n FECHA: "+fecha+ "\nNOMBRE DE CLIENTE  : "+ nombreCliente +"\n tTELÉFONO :"+numTelCliente+"DÍA :"+ dia
              +"TIPO DE TRABAJO : "+tipoServicio
                + "TOTAL CON IVA INCLUIDO: " + totalFinde );
        }
    }
}
