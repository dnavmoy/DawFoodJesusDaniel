/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.metodosTpv.respuestaJopt;
import static daw.metodosTpv.respuestaTexto;
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
            carrito.getCesta().add(producto);
            carrito.getCantidad().add(cantidad);
        }
    }

    public static void devProductoStock(ArrayProductos lista, Carrito carrito) {
        Iterator<Productos> itProductos = carrito.getCesta().iterator();
        Iterator<Integer> itCantidad = carrito.getCantidad().iterator();
        while (itProductos.hasNext()) {

            Productos nuevo = itProductos.next();
            int cantidad = itCantidad.next();
            nuevo.setStock(nuevo.getStock() + cantidad);

        }
    }

    public static String consultarProductos(Carrito carrito) {
        String carritoTexto = "Id --- descripcion-- cantidad-- precio--- precio c/iva ---total linea\n";
        double total = 0;
        double totalIva = 0;
        String texto = "";
        Iterator<Productos> it = carrito.getCesta().iterator();
        Iterator<Integer> it2 = carrito.getCantidad().iterator();

        while (it.hasNext()) {
            Productos nuevo = it.next();
            int cantidad = it2.next();
            double precioConIva = nuevo.getPrecio() * (1 + nuevo.getIva());
            carritoTexto = carritoTexto.concat(nuevo.getID() + "--" + nuevo.getDescripcion() + "-- " + cantidad + "--" + nuevo.getPrecio() + "--" + precioConIva + " = " + precioConIva * cantidad + "\n");
            total += nuevo.getPrecio() * cantidad;
            totalIva += precioConIva * cantidad;
        }
        carritoTexto = carritoTexto.concat("total pedido: " + total + "\n total con iva " + totalIva);

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
        Iterator<Integer> it2 = carrito.getCantidad().iterator();
        while (it.hasNext()) {
            Productos nuevo = it.next();
            int cantidad = it2.next();
            totalIva += ((1 + nuevo.getIva()) * nuevo.getPrecio() * cantidad);
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

    public static String listaPrecios(ArrayList<Productos> filtrado) {

        String devolver = "";

        for (int i = 0; i < filtrado.size(); i++) {
            devolver = devolver.concat("\n" + filtrado.get(i).getDescripcion() + " Precio:  " + filtrado.get(i).getPrecio());
        }
        return devolver;
    }

    public static boolean pedir(ArrayList<Productos> lista, Carrito carrito, Productos tipo) {
        boolean atras = true;

        int pedido = metodosTpv.respuestaBoton(objetoMenu(crearListaArray(lista, tipo)), listaPrecios(crearListaArray(lista, tipo)));

        if (pedido != 0) {
            int cantidad = respuestaJopt("cuanto añades");
            Pruebas.addProducto(lista, carrito, cantidad, crearListaArray(lista, tipo).get(pedido - 1));
        } else {
            Pruebas.consultarProductos(carrito);
            atras = false;

        }
        return atras;
    }

    // metodos administrador
    public static void cambiarProducto(ArrayProductos lista, int id) {

        borrarProducto(lista, id);
        lista.getListaProductos().add(new Productos(id, respuestaTexto("introduce descripcion"), respuestaJopt("introduce precio"), respuestaJopt("introduce iva"), respuestaJopt("introduce stock"), Bebidas.CON_GAS));

    }

    public static void borrarProducto(ArrayProductos lista, int id) {
        Collections.sort(lista.getListaProductos(), (k1, k2) -> Integer.compare(k1.getID(), k2.getID()));

        Productos x = new Productos(id, "", 0, 0, 0, Bebidas.CON_GAS);

        int posicion = Collections.binarySearch(lista.getListaProductos(),
                x,
                ((k1, k2) -> k1.getID() - k2.getID()));

        lista.getListaProductos().remove(posicion);

    }

    public static int ultimoId(ArrayProductos lista) {
        int ultimaPosicion = 0;
        Collections.sort(lista.getListaProductos(), (k1, k2) -> Integer.compare(k1.getID(), k2.getID()));
        ultimaPosicion = lista.getListaProductos().size();
        int devolver = lista.getListaProductos().get(ultimaPosicion - 1).getID();

        return devolver;
    }

    public static int ultimoTicket(ListaVentas lista) {
        int ultimaPosicion = 0;
        int devolver = 0;
        Collections.sort(lista.getId(), (k1, k2) -> Integer.compare(k1, k2));
        ultimaPosicion = lista.getId().size();
        if (ultimaPosicion != 0) {
            devolver = lista.getId().get(ultimaPosicion - 1);
        }

        return devolver;

    }

}
