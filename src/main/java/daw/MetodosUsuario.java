/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import Clases.Carrito;
import Clases.ListaVentas;
import Clases.Productos;
import static daw.MenuTpv.respuestaJopt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class MetodosUsuario {

    public static boolean pedir(ArrayProductos lista, Carrito carrito, Productos tipo) {
        //devuelve atras para volver en el menu anterior si es correcto
        boolean atras = false;
        //muestra los productos segun el producto ejemplo 
        int pedido = MenuTpv.respuestaBoton(objetoMenu(crearListaArray(lista.getListaProductos(), tipo)), listaPrecios(crearListaArray(lista.getListaProductos(), tipo)));
        //si persiona 0 (boton atras) volvemos en el menu  si es distinto de 0 pregunta y añade la cantidad de productos segun el metodo
        if (pedido != 0) {
            int cantidad = respuestaJopt("cuanto añades");
            MetodosUsuario.addProducto(lista, carrito, cantidad, crearListaArray(lista.getListaProductos(), tipo).get(pedido - 1));
            atras = true;

        }
        return atras;
    }

    public static void addProducto(ArrayProductos lista, Carrito carrito, int cantidad, Productos producto) {
        //lista de productos no usada*****************
        //si la cantidad es superior a 0 añade el producto en el carrito y la cantidad (si hay stock suficiente) y reduce el stock
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "introduce valor mayor que 0");
        } else {
            if (cantidad > producto.getStock()) {
                JOptionPane.showMessageDialog(null, "cantidad superior al stock, ingrese cantidad inferior al stock actual : " + producto.getStock());

            } else {
                int id = producto.getID();
                lista.getListaProductos().get(id).setStock(lista.getListaProductos().get(id).getStock()-cantidad);
                                                
                if (carrito.getCarrito().containsKey(id)) {

                    carrito.getCarrito().replace(id, cantidad + carrito.getCarrito().get(id));
                } else {
                    carrito.getCarrito().put(id, cantidad);
                }
            }
        }
    }

    public static void devProductoStock(ArrayProductos lista, Carrito carrito) {
        //recorrer el carrito y volver a añadir al stock la lista de productos

        
        Map<Integer, Integer> valores = carrito.getCarrito();
        for (Map.Entry<Integer, Integer> valor : valores.entrySet()) {
            
            int nuevoStock=(lista.getListaProductos().get(valor.getKey()).getStock() + valor.getValue());
           
            
            lista.getListaProductos().get(valor.getKey()).setStock(nuevoStock);
            
            
        }
    }

    public static String consultarProductos(ArrayProductos lista, Carrito carrito) {

        //muestra los productos del carrito iterando segun las cantidades y productos
        //he intentado hacer con tablas pero no parece facil y no me da ya tiempo
        String carritoTexto = """
                             "Id       cantidad       precio     precio c/iva     total linea      descripcion \n
                             """;

        Map<Integer, Integer> valores = carrito.getCarrito();
        for (Map.Entry<Integer, Integer> valor : valores.entrySet()) {
            carritoTexto = carritoTexto.concat("""
                       %s                 %s                     %.2f             %.2f          %.2f          %s          
                       """.formatted(valor.getKey(), valor.getValue(), lista.getListaProductos().get(valor.getKey()).getPrecio(),
                    lista.getListaProductos().get(valor.getKey()).getPrecio() * (1 + lista.getListaProductos().get(valor.getKey()).getIva()),
                    lista.getListaProductos().get(valor.getKey()).getPrecio() * (1 + lista.getListaProductos().get(valor.getKey()).getIva()) * valor.getValue(),
                    lista.getListaProductos().get(valor.getKey()).getDescripcion()));
        }

        //carritoTexto = carritoTexto.concat("total pedido: " + total + "\n total con iva " + totalIva);
        return carritoTexto;
    }

    public static ArrayList<Productos> crearListaArray(ArrayList<Productos> lista, Productos producto) {
        //creo una lista de los productos  segunt el producto ejemplo
        ArrayList<Productos> devuelto = new ArrayList();
        //mostrar los productos que tengan el mismo enum-> comprobar comida,bebida y postre
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
        //devolver una lista ya filtrada
        return devuelto;
    }

    public static String[] objetoMenu(ArrayList<Productos> filtrado) {

        //crea lista de objetos para el joption de botones
        String[] devolver = new String[filtrado.size() + 1];
        //añade las opciones en un Array de String 
        devolver[0] = "ATRAS";
        for (int i = 1; i < filtrado.size() + 1; i++) {
            devolver[i] = filtrado.get(i - 1).getDescripcion();
        }
        return devolver;
    }

    public static String listaPrecios(ArrayList<Productos> filtrado) {
        //mostrar los precios de los productos en la descricion del joption 
        String devolver = "";

        for (int i = 0; i < filtrado.size(); i++) {
            devolver = devolver.concat("\n" + filtrado.get(i).getDescripcion() + " Precio:  " + filtrado.get(i).getPrecio());
        }
        return devolver;
    }

    public static int ultimoId(ArrayProductos lista) {
        int ultimaPosicion = 0;
        Collections.sort(lista.getListaProductos(), (k1, k2) -> Integer.compare(k1.getID(), k2.getID()));
        ultimaPosicion = lista.getListaProductos().size();
        int devolver = lista.getListaProductos().get(ultimaPosicion - 1).getID();

        return devolver;
    }

    public static int ultimoTicket(ListaVentas lista) {
        //buscamos el ultimo ticket 
        int ultimaPosicion = 0;
        int devolver = 0;
        //ordenar lista
        Collections.sort(lista.getId(), (k1, k2) -> Integer.compare(k1, k2));
        ultimaPosicion = lista.getId().size();
        //buscar ultima posicion y ver que numero de pedido tiene y añadimos uno

        //asi comprobamos que el numero será superior aunque se borren tickets
        if (ultimaPosicion != 0) {
            devolver = lista.getId().get(ultimaPosicion - 1);
        }

        return devolver;

    }

}
