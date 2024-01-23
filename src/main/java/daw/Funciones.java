/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jesus
 */
public class Funciones {
    

    public static boolean pasarelaPago(Carrito carrito){

        boolean correcto=false;

        int numTarjeta=DawFoodJesusDaniel.respuestaJopt("Intoduce tarjeta");
        
      
        for(int i=0;i<tarjetas().size();i++){
            
            if(numTarjeta==tarjetas().get(i).getNumTarjeta()
                    && tarjetas().get(i).getSaldo()>= Pruebas.consultarProductos(carrito))
            {
                tarjetas().get(i).setSaldo(tarjetas().get(i).getSaldo()-Pruebas.consultarProductos(carrito));
                
                correcto=true;
            }
            
        }

        return correcto;
    }
    
    
    public static ArrayList<Tarjeta> tarjetas () {
    
    Tarjeta t1=new Tarjeta(1234,123, new Date(2025,12,30),1000);
    Tarjeta t2=new Tarjeta(4321,321, new Date(2024,12,30),200);
    Tarjeta t3=new Tarjeta(1357,135, new Date(2026,12,30),12000);
    
     ArrayList<Tarjeta> listaTarjeta = new ArrayList();
     
        listaTarjeta.add (t1);
        listaTarjeta.add(t2);
        listaTarjeta.add(t3);
        
        return listaTarjeta;
    
}
    
}
