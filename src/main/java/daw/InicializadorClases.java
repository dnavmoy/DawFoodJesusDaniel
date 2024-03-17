/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import Clases.Bebidas;
import Clases.Comidas;
import Clases.Postre;
import Clases.Productos;
import Clases.Tarjeta;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 *
 * @author daniel
 */
public class InicializadorClases {
    
    public static List<String> leerFichero(String nombreFichero) {
        //Creamos una lista para almacenar la que nos devolvera ReadAllLines
        List<String> lista = new ArrayList<>();
        //Importante usar un try para controlar una posible excepcion
        try {
            lista = Files.readAllLines(Paths.get(nombreFichero));
        } catch (IOException ex) {
            System.out.println("Error accediendo a " + nombreFichero);
        }
        lista.remove(0);//Eliminamos la primera porque no tiene el formato
        return lista;
    
    }
    
    
    public static ArrayProductos extraerProductos(List<String> lista) {
        //Creouna lista que devolvere
        //ArrayList<Productos> listaDevolver = new ArrayList();
        ArrayProductos listaDevolver= new ArrayProductos();
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Bebidas.CON_GAS);
            listaDevolver.getListaProductos().add(temporal);
            System.out.println(temporal);
            

        }

        return listaDevolver;
    }
    
    
    
 public static ArrayProductos incializadorProductos(){
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
        
        return lista;
     
 }   

    public static ArrayList<Tarjeta> tarjetas() {
        Tarjeta t1 = new Tarjeta(1234, 123, LocalDate.of(2025, 12, 30), 1);
        Tarjeta t2 = new Tarjeta(4321, 321, LocalDate.of(2024, 12, 30), 200);
        Tarjeta t3 = new Tarjeta(1357, 135, LocalDate.of(2026, 12, 30), 12000);
        ArrayList<Tarjeta> listaTarjeta = new ArrayList();
        listaTarjeta.add(t1);
        listaTarjeta.add(t2);
        listaTarjeta.add(t3);
        return listaTarjeta;
    }
    
}
