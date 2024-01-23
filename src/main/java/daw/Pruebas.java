/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.DawFoodJesusDaniel.respuestaJopt;
import java.util.ArrayList;
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

    public static double consultarProductos(Carrito carrito) {
        String carritoTexto = "Id --- descripcion--- precio--- precio c/iva \n";
        double total = 0;
        double totalIva = 0;
        Iterator<Productos> it = carrito.getCesta().iterator();
        while (it.hasNext()) {
            Productos nuevo = it.next();
            carritoTexto = carritoTexto.concat(nuevo.getID() + "--" + nuevo.getDescripcion() + "--" + nuevo.getPrecio() + "--" + (1 + nuevo.getIva()) * nuevo.getPrecio() + "\n");
            total += nuevo.getPrecio();
            totalIva += (1 + nuevo.getIva()) * nuevo.getPrecio();
        }
        carritoTexto = carritoTexto.concat("total pedido: " + total + "\n total con iva " + totalIva);
        JOptionPane.showMessageDialog(null, carritoTexto);
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

}
