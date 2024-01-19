/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class Pruebas {

   
    public static void addProducto(Productos producto,ArrayList<Productos> carrito,int cantidad) {
       for(int i=0;i<cantidad;i++){
        carrito.add(producto);
       }
    }
    
    public static void consultarProductos(ArrayList<Productos> carrito){
        String carritoTexto="";
        Iterator<Productos> it= carrito.iterator();
        while(it.hasNext()){
           carritoTexto.concat("algo");
       }
        JOptionPane.showMessageDialog(null,carritoTexto);
        
    }
    
            

}
