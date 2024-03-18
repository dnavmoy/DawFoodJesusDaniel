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
        //lista.remove(0);//Eliminamos la primera porque no tiene el formato
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
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Comidas.ENTRANTES);
            listaDevolver.getListaProductos().add(temporal);
            System.out.println(temporal);
            

        }

        return listaDevolver;
    }
    public static ArrayProductos extraerProductos() {
        //Creouna lista que devolvere
        //ArrayList<Productos> listaDevolver = new ArrayList();
        ArrayProductos listaDevolver= new ArrayProductos();
        
        List<String>lista=leerFichero("entrantes.csv");
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Comidas.ENTRANTES);
            listaDevolver.getListaProductos().add(temporal);
           
        }
        lista=leerFichero("primeros.csv");
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Comidas.PRIMEROS);
            listaDevolver.getListaProductos().add(temporal);
            
        }
        lista=leerFichero("segundos.csv");
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Comidas.SEGUNDOS);
            listaDevolver.getListaProductos().add(temporal);
            
        }
        lista=leerFichero("alcoholicas.csv");
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Bebidas.ALCOHOLICA);
            listaDevolver.getListaProductos().add(temporal);
            
        }
        lista=leerFichero("gas.csv");
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Bebidas.CON_GAS);
            listaDevolver.getListaProductos().add(temporal);
            
        }
        lista=leerFichero("singas.csv");
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Bebidas.SIN_GAS);
            listaDevolver.getListaProductos().add(temporal);
            
        }
        
        lista=leerFichero("calientes.csv");
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Postre.CALIENTE);
            listaDevolver.getListaProductos().add(temporal);
            
        }
        
        lista=leerFichero("frios.csv");
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Postre.FRIO);
            listaDevolver.getListaProductos().add(temporal);
            
        }
        
        lista=leerFichero("fruta.csv");
        for (int i = 0; i < lista.size(); i++) {
            //Separamos por , para obtener los datos de cada vehiculo
            String[] array = lista.get(i).split(",");//Corta por cada coma
            //Creamos un objeto producto y metemos los datos en cada campo
            Productos temporal = new Productos(Integer.parseInt(array[0]),array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), Postre.FRUTA);
            listaDevolver.getListaProductos().add(temporal);
            
        }
        
        

        return listaDevolver;
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
