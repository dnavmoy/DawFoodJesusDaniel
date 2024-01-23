/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author daniel
 */
public class InicializadorClases {
    
 public static void incializadorProductos(){
     ArrayProductos lista=new ArrayProductos();
        
        Productos ensalada = new Productos(1, "ensalada", 1, 0.21, 10, Comidas.ENTRANTES);
        Productos gazpacho = new Productos(2, "gazpacho", 15, 0.21, 10, Comidas.ENTRANTES);
        Productos agua = new Productos(3, "agua", 1.5, 0.21, 10, Bebidas.SIN_GAS);
        Productos carne = new Productos(4, "filete", 20, 0.21, 10, Comidas.PRIMEROS);
        Productos cerveza = new Productos(5, "Cerveza", 3.2, 0.21, 10, Bebidas.ALCOHOLICA);
        Productos manzana = new Productos(6, "Manzana", 0.75, 0.21, 7, Postre.FRUTA);
        //ArrayList<Productos> lista = new ArrayList();

        lista.getListaProductos().add(ensalada);
        lista.getListaProductos().add(gazpacho);
        lista.getListaProductos().add(agua);
        lista.getListaProductos().add(carne);
        lista.getListaProductos().add(cerveza);
        lista.getListaProductos().add(manzana);
     
 }   
    
}
