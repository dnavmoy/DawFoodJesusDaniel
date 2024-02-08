/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import Clases.Bebidas;
import Clases.Carrito;
import Clases.Comidas;
import Clases.ListaVentas;
import Clases.Postre;
import Clases.Productos;
import Clases.Tarjeta;
import static daw.MenuTpv.respuestaBoton;
import static daw.MenuTpv.respuestaDouble;
import static daw.MenuTpv.respuestaJopt;
import static daw.MenuTpv.respuestaTexto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class MetodosAdministrador {

    public static boolean pasarelaPago(ArrayProductos listaProductos,Carrito carrito) {

        boolean repetir = true;
        boolean correcto = false;
        //menu para hacer el pago- ahora no es necesario pero se puede añadir tarjetas en un futuro
        do {
            String[] menuPago = {"SALIR", "PAGAR"};
            int respuesta = MenuTpv.respuestaBoton(menuPago);
            switch (respuesta) {
                case 0 ->
                    repetir = false;

                case 1 -> {
                    //al iniciar el pago añadimos la lista de tarjetas para poder comprobarlas
                    ArrayList<Tarjeta> lista = InicializadorClases.tarjetas();
                    //si el carrito esta vacio no llegamos a intentar el pago
                    if (carrito.getCarrito().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Carrito esta vacio");
                    } else {
                        //ordenar las tarjetas para poder buscarlas
                        Collections.sort(lista, (k1, k2) -> Integer.compare(k1.getNumTarjeta(), k2.getNumTarjeta()));
                        //tarjeta ejemplo para buscar 
                        Tarjeta x = new Tarjeta(MenuTpv.respuestaJopt("introduce numero tarjeta"), 001, LocalDate.now(), 0);
                        int cvvProbar;
                        LocalDate fechaCadProbar;
                        int posicion = Collections.binarySearch(lista,
                                x,
                                ((k1, k2) -> Integer.compare(k1.getNumTarjeta(), k2.getNumTarjeta())));
                        //si encuentra numero de tarjeta 
                        if (posicion >= 0) {
                            boolean cvvFecha = true;
                            //si la encuentra pregunta cvv y fecha vencimiento
                            do {
                                cvvProbar = MenuTpv.respuestaJopt("introduce Cvv");
                                fechaCadProbar = fechaValida();

                                //si es disitno a tres digitos da error
                                if (cvvProbar < 0 || cvvProbar > 999) {
                                    JOptionPane.showMessageDialog(null, "cvv debe ser de tres cifras");

                                } else {
                                    cvvFecha = false;
                                }
                                //repite mientras no tenga formato correcto
                            } while (cvvFecha);
                            //luego probamos si el cvv y la fecha es igual a la de la tarjeta
                            if (lista.get(posicion).getCvv() == cvvProbar && lista.get(posicion).getFechaVencimiento().equals(fechaCadProbar)) {
                                //comprobamos el saldo de la tarjeta si es suficiente segun el carrito mandado
                                if (lista.get(posicion).getSaldo() >= sacarTotal(listaProductos,carrito)) {
                                    lista.get(posicion).setSaldo(lista.get(posicion).getSaldo() - sacarTotal(listaProductos,carrito));
                                    repetir = false;
                                    JOptionPane.showMessageDialog(null, "Pago Correcto");
                                    correcto = true;
                                    //cambiamos correcto a true para que el pago haya sido correcto
                                } else {
                                    JOptionPane.showMessageDialog(null, "saldo insuficiente");
                                }

                            } else {

                                JOptionPane.showMessageDialog(null, "error en cvv o  fecha");
                            }

                        } else {
                            //si no encuentra tarjeta muestra mensaje error
                            JOptionPane.showMessageDialog(null, "no existe la tarjeta");
                        }
                    }

                }

            }

        } while (repetir);

        return correcto;
    }

    public static LocalDate fechaValida() {
        LocalDate fechaValida = LocalDate.of(1, 1, 1);
        boolean error = true;
        do
        try {
            fechaValida = LocalDate.of(MenuTpv.respuestaJopt("introduce año"), MenuTpv.respuestaJopt("introduce mes"), 30);
            error = false;
        } catch (java.time.DateTimeException jtd) {
            JOptionPane.showMessageDialog(null, "fecha no valida");
        } while (error);
        return fechaValida;
    }

    //CREAR METODO CONTRASEÑA
    public static String password() {
        //creo array para las letras especiales
        char[] arrayChar = {'#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', ':', ';', '<', '=', '>', '@'};
        Random r = new Random();
        //creo un array de char para ir guardando cada una de las reglas
        char[] chars = new char[6];
        //una minuscula al azar
        chars[0] = (char) r.nextInt(97, 123);
        //una mayuscula al azar
        chars[1] = (char) r.nextInt(65, 91);
        //un numero
        chars[2] = (char) r.nextInt(48, 58);
        //un caracter especial de los elegidos
        chars[3] = arrayChar[r.nextInt(arrayChar.length)];
        //y luego dos caracteres cualquiera de todos los anteriores
        chars[4] = (char) r.nextInt(33, 123);
        chars[5] = (char) r.nextInt(33, 123);
        char extra;
        //y mediante un for voy desordenandolos
        for (int i = 0; i < chars.length; i++) {
            int posicion1 = r.nextInt(chars.length);
            int posicion2 = r.nextInt(chars.length);
            extra = chars[posicion1];
            chars[posicion1] = chars[posicion2];
            chars[posicion2] = extra;
        }
        //luego lo convierto en un string
        String password = String.valueOf(chars);

        return password;
    }

    public static String listaTickets(ArrayProductos lista,ListaVentas ventas) {
        //creo el texto a mostrar vacio
        String carritoTexto = "";

        Iterator<Integer> it = ventas.getId().iterator();
        Iterator<Carrito> it2 = ventas.getVentas().iterator();
        //mediante iteradores voy añadiendo el numero de pedido y luego la compra realizada
        while (it.hasNext()) {
            int id = it.next();
            carritoTexto = carritoTexto.concat("\n Nº pedido " + id + "\n");
            carritoTexto = carritoTexto.concat(MetodosUsuario.consultarProductos(lista,it2.next()));
        }
        //devuelvo el listado para mostrarlo
        return carritoTexto;
    }

    public static void añadirProductos(ArrayProductos lista) {
        boolean atras = true;
        do {
            String[] menuUsuario = {"ATRAS", "COMIDA", "BEBIDA", "POSTRE"};
            int usuario = respuestaBoton(menuUsuario);

            switch (usuario) {
                case 1:
                    //he copiado el menu de usuario para este metodo, voy buscando el tipo de producto a añadir y luego pido los datos 
                    //el id los busco segun el metodo, en el que busco el id del ulitmo producto y le sumo uno
                    String[] menuComida = {"ATRAS", "ENTRANTES", "PRIMEROS", "SEGUNDOS"};
                    int comida = respuestaBoton(menuComida);
                    switch (comida) {
                        case 1:
                            lista.getListaProductos().add(new Productos(MetodosUsuario.ultimoId(lista) + 1,
                                    respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"),
                                    respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Comidas.ENTRANTES));
                            break;

                        case 2:
                            lista.getListaProductos().add(new Productos(MetodosUsuario.ultimoId(lista) + 1,
                                    respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"),
                                    respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Comidas.PRIMEROS));

                            break;
                        case 3:
                            lista.getListaProductos().add(new Productos(MetodosUsuario.ultimoId(lista) + 1,
                                    respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"),
                                    respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Comidas.SEGUNDOS));

                            break;

                        case 0:
                            atras = false;

                    }

                    break;
                case 2:

                    String[] bebidaarray = {"ATRAS", "ALCOHOLICA", "Con Gas", "Sin Gas"};
                    int bebida = respuestaBoton(bebidaarray);

                    switch (bebida) {
                        case 1:
                            lista.getListaProductos().add(new Productos(MetodosUsuario.ultimoId(lista) + 1,
                                    respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"),
                                    respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Bebidas.ALCOHOLICA));

                            atras = true;
                            break;
                        case 2:

                            lista.getListaProductos().add(new Productos(MetodosUsuario.ultimoId(lista) + 1,
                                    respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"),
                                    respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Bebidas.CON_GAS));

                            break;
                        case 3:
                            lista.getListaProductos().add(new Productos(MetodosUsuario.ultimoId(lista) + 1,
                                    respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"),
                                    respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Bebidas.SIN_GAS));

                            break;
                        case 0:
                            atras = false;

                    }

                    break;
                case 3:

                    String[] menuPostre = {"ATRAS", "CALIENTE", "FRIO", "FRUTA"};
                    int postre = respuestaBoton(menuPostre);

                    switch (postre) {
                        case 1:
                            lista.getListaProductos().add(new Productos(MetodosUsuario.ultimoId(lista) + 1,
                                    respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"),
                                    respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Postre.CALIENTE));
                            break;
                        case 2:
                            lista.getListaProductos().add(new Productos(MetodosUsuario.ultimoId(lista) + 1,
                                    respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"),
                                    respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Postre.FRIO));
                            atras = true;
                            break;
                        case 3:
                            lista.getListaProductos().add(new Productos(MetodosUsuario.ultimoId(lista) + 1,
                                    respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"),
                                    respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Postre.FRUTA));

                            break;
                        case 0:
                            atras = false;

                    }

                    break;
                case 0:
                    atras = false;
                    break;
            }
        } while (atras);
    }

 
    public static void cambiarProducto(ArrayProductos lista, int id) {
        //borrar producto segun id->
        Productos producto = lista.getListaProductos().get(id-1);
        borrarProducto(lista, id);
        //añadir prodcutos segun
        if(producto.getComida()==null){
            if(producto.getBebida()==null){
                lista.getListaProductos().add(new Productos(id, respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"), respuestaDouble("introduce Iva"), respuestaJopt("introduce stock"), producto.getPostre()));
             }else{
                lista.getListaProductos().add(new Productos(producto.getID(), respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"), respuestaDouble("introduce iva"), respuestaJopt("introduce stock"),producto.getBebida()));
            }
        }else{
             lista.getListaProductos().add(new Productos(producto.getID(), respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"), respuestaDouble("introduce iva"), respuestaJopt("introduce stock"),producto.getComida()));
        }
        
    }

    public static void borrarProducto(ArrayProductos lista, int id) {
        Collections.sort(lista.getListaProductos(), (k1, k2) -> Integer.compare(k1.getID(), k2.getID()));
        Productos x = new Productos(id, "", 0, 0, 0, Bebidas.CON_GAS);
        int posicion = Collections.binarySearch(lista.getListaProductos(), x, (k1, k2) -> k1.getID() - k2.getID());
        lista.getListaProductos().remove(posicion);
    }

    public static void consultarProductos(ArrayProductos lista) {
        //crear un String  de todos los productos
        String listaTexto = "Id --- descripcion--- precio--- precio c/iva \n";
        Iterator<Productos> it = lista.getListaProductos().iterator();
        while (it.hasNext()) {
            Productos nuevo = it.next();
            listaTexto = listaTexto.concat(nuevo.getID() + "--" + nuevo.getDescripcion() + "--" + nuevo.getPrecio() + "--" + (1 + nuevo.getIva()) * nuevo.getPrecio() + "\n");
        }
        JOptionPane.showMessageDialog(null, listaTexto);
    }

    public static double sacarTotal(ArrayProductos lista,Carrito carrito) {
        
        //metodo para ver el total a pagar, comprueba el carrito y suma cada
        //producto con el iva
        
        
        double total=0;
        
        
       Map<Integer,Integer> valores= carrito.getCarrito();

        for (Map.Entry<Integer, Integer> valor : valores.entrySet()) {
            total+= (lista.getListaProductos().get(valor.getKey()).getPrecio()+(1+lista.getListaProductos().get(valor.getKey()).getIva()))*valor.getValue();
        }

        return total;
    }

}
