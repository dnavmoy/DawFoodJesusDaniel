/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.DawFoodJesusDaniel.respuestaJopt;
import static daw.DawFoodJesusDaniel.respuestaTexto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class Pruebas {

    public static void addProducto(ArrayList<Productos> lista, Carrito carrito, int cantidad, Productos producto) {

        if (cantidad > producto.getStock()) {
            JOptionPane.showMessageDialog(null, "cantidad superior al stock, ingrese cantidad inferior al stock actual : " + producto.getStock());
        } else {
            producto.setStock(producto.getStock() - cantidad);
            for (int i = 0; i < cantidad; i++) {
                carrito.getCesta().add(producto);
                //carrito.add(producto);

            }
        }
    }

    public static String consultarProductos(Carrito carrito) {
        String carritoTexto = "Id --- descripcion--- precio--- precio c/iva \n";
        double total = 0;
        double totalIva=0;
        String texto = "";
        Iterator<Productos> it = carrito.getCesta().iterator();
        while (it.hasNext()) {
            Productos nuevo = it.next();
            carritoTexto = carritoTexto.concat(nuevo.getID() + "--" + nuevo.getDescripcion() + "--" + nuevo.getPrecio() + "--" + (1 + nuevo.getIva()) * nuevo.getPrecio() + "\n");
            total += nuevo.getPrecio();
            totalIva += (1 + nuevo.getIva()) * nuevo.getPrecio();
        }
        carritoTexto = carritoTexto.concat("total pedido: " + total + "\n total con iva " + totalIva);
        //JOptionPane.showMessageDialog(null, carritoTexto);
        return carritoTexto;
    }

    public static double consultarProductos(ArrayProductos lista) {
        String listaTexto = "Id --- descripcion--- precio--- precio c/iva \n";
        double total = 0;
        double totalIva = 0;
        Iterator<Productos> it = lista.getListaProductos().iterator();
        while (it.hasNext()) {
            Productos nuevo = it.next();
            listaTexto = listaTexto.concat(nuevo.getID() + "--" + nuevo.getDescripcion() + "--" + nuevo.getPrecio() + "--" + (1 + nuevo.getIva()) * nuevo.getPrecio() + "\n");
            total += nuevo.getPrecio();
            totalIva += (1 + nuevo.getIva()) * nuevo.getPrecio();
        }

        JOptionPane.showMessageDialog(null, listaTexto);
        return totalIva;
    }

    public static double sacarTotal(Carrito carrito) {
        double total = 0;
        double totalIva = 0;
        Iterator<Productos> it = carrito.getCesta().iterator();
        while (it.hasNext()) {
            Productos nuevo = it.next();
            totalIva += (1 + nuevo.getIva()) * nuevo.getPrecio();
        }
        return totalIva;
    }

    public static ArrayList<Productos> crearListaArray(ArrayList<Productos> lista, Productos producto) {

        ArrayList<Productos> devuelto = new ArrayList();
        Iterator<Productos> it = lista.iterator();
        while (it.hasNext()) {
            Productos nuevo = it.next();
            if (nuevo.getComida() != null) {
                try {
                    if (nuevo.getComida().compareTo(producto.getComida()) == 0) {
                        devuelto.add(nuevo);
                    }
                } catch (NullPointerException npe) {

                }
            }
            if (nuevo.getBebida() != null) {
                try {
                    if (nuevo.getBebida().compareTo(producto.getBebida()) == 0) {
                        devuelto.add(nuevo);
                    }
                } catch (NullPointerException npe) {

                }
            }
            if (nuevo.getPostre() != null) {
                try {
                    if (nuevo.getPostre().compareTo(producto.getPostre()) == 0) {
                        devuelto.add(nuevo);
                    }
                } catch (NullPointerException npe) {

                }

            }

        }

        return devuelto;
    }

    public static String[] objetoMenu(ArrayList<Productos> filtrado) {

        String[] devolver = new String[filtrado.size() + 1];

        devolver[0] = "ATRAS";
        for (int i = 1; i < filtrado.size() + 1; i++) {
            devolver[i] = filtrado.get(i - 1).getDescripcion();
        }
        return devolver;
    }

    public static boolean pedir(ArrayList<Productos> lista, Carrito carrito, Productos tipo) {
        boolean atras = true;

        int pedido = DawFoodJesusDaniel.respuestaBoton(objetoMenu(crearListaArray(lista, tipo)));

        if (pedido != 0) {
            int cantidad = respuestaJopt("cuanto añades");
            Pruebas.addProducto(lista, carrito, cantidad, crearListaArray(lista, tipo).get(pedido - 1));
        } else {
            Pruebas.consultarProductos(carrito);
            atras = false;

        }
        return atras;
    }

    public static void cambiarProducto(ArrayProductos lista, int id) {
//        Collections.sort(lista.getListaProductos(), (k1, k2) -> Integer.compare(k1.getID(), k2.getID()));
//
//        Productos x = new Productos(id, "", 0, 0, 0, Bebidas.CON_GAS);
//
//        int posicion = Collections.binarySearch(lista.getListaProductos(),
//                x,
//                ((k1, k2) -> k1.getID() - k2.getID()));
//
//        lista.getListaProductos().remove(posicion);
        borrarProducto(lista, id);
        lista.getListaProductos().add(new Productos(id, respuestaTexto("introduce descripcion"), respuestaJopt("introduce precio"), respuestaJopt("introduce iva"), respuestaJopt("introduce stock"), Bebidas.CON_GAS));

    }

    
    public static void borrarProducto(ArrayProductos lista, int id){
        Collections.sort(lista.getListaProductos(), (k1, k2) -> Integer.compare(k1.getID(), k2.getID()));

        Productos x = new Productos(id, "", 0, 0, 0, Bebidas.CON_GAS);

        int posicion = Collections.binarySearch(lista.getListaProductos(),
                x,
                ((k1, k2) -> k1.getID() - k2.getID()));

        lista.getListaProductos().remove(posicion);
        
    }
    
    public static int ultimoId(ArrayProductos lista){
        int ultimaPosicion=0;
        Collections.sort(lista.getListaProductos(), (k1, k2) -> Integer.compare(k1.getID(), k2.getID()));
        ultimaPosicion=lista.getListaProductos().size();
        int devolver=lista.getListaProductos().get(ultimaPosicion-1).getID();
        
        return devolver;
    }
    
    
}
