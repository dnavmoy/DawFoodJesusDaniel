/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author daniel
 */
public class Pruebas {

    public static void main(String[] args) {

        ArrayList<Productos> carrito = new ArrayList<>();

        Productos producto = new Productos(0, "cosa", 1, 1, 1, Bebidas.CON_GAS);
        carrito.add(producto);
        carrito.add(new Productos(2, "cosa2", 10, 1, 5, Comidas.ENTRANTES));

    }

    public void añadirProducto(Productos producto,ArrayList<Productos> carrito,int cantidad) {
       for(int i=0;i<cantidad;i++){
        carrito.add(producto);
       }
    }
    
    public void consultarProductos(ArrayList<Productos> carrito){
        String carritoTexto="";
        Iterator<Productos> it= carrito.iterator();
        while(it.hasNext()){
           carritoTexto.concat(it.next().toString());
       }
        
    }
    
            

}
