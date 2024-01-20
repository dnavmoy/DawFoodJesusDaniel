/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.DawFoodJesusDaniel.respuestaJopt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class Pruebas {

    public static void addProducto(ArrayList<Productos> lista, ArrayList<Productos> carrito, int cantidad, int id) {
        
            if (cantidad > lista.get(id).getStock()) {
                JOptionPane.showMessageDialog(null, "cantidad superior al stock, ingrese cantidad inferior al stock actual : " + lista.get(id).getStock());
            } else {
                lista.get(id).setStock(lista.get(id).getStock()-cantidad);
                for (int i = 0; i < cantidad; i++) {
                carrito.add(lista.get(id));
                

            }
        }
    }

    public static void consultarProductos(ArrayList<Productos> carrito) {
        String carritoTexto = "Id --- descripcion--- precio--- precio c/iva \n";
        double total = 0;
        double totalIva = 0;
        Iterator<Productos> it = carrito.iterator();
        while (it.hasNext()) {
            Productos nuevo = it.next();
            carritoTexto = carritoTexto.concat(nuevo.getID() + "--" + nuevo.getDescripcion() + "--" + nuevo.getPrecio() + "--" + (1 + nuevo.getIva()) * nuevo.getPrecio() + "\n");
            total += nuevo.getPrecio();
            totalIva += (1 + nuevo.getIva()) * nuevo.getPrecio();
        }
        carritoTexto = carritoTexto.concat("total pedido: " + total + "\n total con iva " + totalIva);
        JOptionPane.showMessageDialog(null, carritoTexto);

    }

    public static String crearLista(ArrayList<Productos> lista, Productos producto) {
        String listaTexto = "";
        ArrayList<Productos> devuelto = new ArrayList();
        Iterator<Productos> it = lista.iterator();
        while (it.hasNext()) {
            Productos nuevo = it.next();
            if (nuevo.getComida() != null) {
                try {
                    if (nuevo.getComida().compareTo(producto.getComida()) == 0) {
                        listaTexto = listaTexto.concat(nuevo.getID() + "-" + nuevo.getDescripcion() + "-"+nuevo.getPrecio()*(1+nuevo.getIva())+ "\n");
                    }
                } catch (NullPointerException npe) {

                }
            }
            if (nuevo.getBebida() != null) {
                try {
                    if (nuevo.getBebida().compareTo(producto.getBebida()) == 0) {
                        listaTexto = listaTexto.concat(nuevo.getID() + " " + nuevo.getDescripcion() + "-");
                    }
                } catch (NullPointerException npe) {

                }
            }
            if (nuevo.getPostre() != null) {
                try {
                    if (nuevo.getPostre().compareTo(producto.getPostre()) == 0) {
                        listaTexto = listaTexto.concat(nuevo.getID() + " " + nuevo.getDescripcion() + "-");
                    }
                } catch (NullPointerException npe) {

                }

            }

        }
        return listaTexto;
    }

    public static boolean pedir(ArrayList<Productos> lista, ArrayList<Productos> carrito, Productos tipo) {
        boolean atras = true;
        int pedido = respuestaJopt(Pruebas.crearLista(lista, tipo) + "0-atras");
        if (pedido != 0) {
            int cantidad = respuestaJopt("cuanto añades");
            Pruebas.addProducto(lista, carrito, cantidad, pedido);
        } else {
            Pruebas.consultarProductos(carrito);
            atras = false;

        }
        return atras;
    }

}
