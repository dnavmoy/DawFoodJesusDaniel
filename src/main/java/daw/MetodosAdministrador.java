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
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class MetodosAdministrador {

    public static boolean pasarelaPago(Carrito carrito) {

        boolean repetir = true;
        boolean correcto = false;

        do {
            String[] menuPago = {"SALIR", "PAGAR"};
            int respuesta = MenuTpv.respuestaBoton(menuPago);
            switch (respuesta) {
                case 0 ->
                    repetir = false;

                case 1 -> {

                    ArrayList<Tarjeta> lista = InicializadorClases.tarjetas();
                    if (carrito.getCesta().size() <= 0) {
                        JOptionPane.showMessageDialog(null, "Carrito esta vacio");
                    } else {
                        Collections.sort(lista, (k1, k2) -> Integer.compare(k1.getNumTarjeta(), k2.getNumTarjeta()));

                        Tarjeta x = new Tarjeta(MenuTpv.respuestaJopt("introduce numero tarjeta"), 001, LocalDate.now(), 0);
                        int cvvProbar;
                        LocalDate fechaCadProbar;
                        int posicion = Collections.binarySearch(lista,
                                x,
                                ((k1, k2) -> Integer.compare(k1.getNumTarjeta(), k2.getNumTarjeta())));

                        if (posicion >= 0) {
                            boolean cvvFecha = true;

                            do {
                                cvvProbar = MenuTpv.respuestaJopt("introduce Cvv");
                                fechaCadProbar = fechaValida();

                                if (cvvProbar < 0 || cvvProbar > 999) {
                                    JOptionPane.showMessageDialog(null, "cvv debe ser de tres cifras");

                                } else {
                                    cvvFecha = false;
                                }

                            } while (cvvFecha);

                            if (lista.get(posicion).getCvv() == cvvProbar && lista.get(posicion).getFechaVencimiento().equals(fechaCadProbar)) {

                                if (lista.get(posicion).getSaldo() >= MetodosUsuario.sacarTotal(carrito)) {
                                    lista.get(posicion).setSaldo(lista.get(posicion).getSaldo() - MetodosUsuario.sacarTotal(carrito));
                                    repetir = false;
                                    JOptionPane.showMessageDialog(null, "Pago Correcto");
                                    correcto = true;
                                } else {
                                    JOptionPane.showMessageDialog(null, "saldo insuficiente");
                                }

                            } else {

                                JOptionPane.showMessageDialog(null, "error en cvv o  fecha");
                            }

                        } else {
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
        char[] arrayChar = {'#', '$', '%', '&', '(', ')', '*', '+', ',', '-', '.', ':', ';', '<', '=', '>', '@'};
        Random r = new Random();
        char[] chars = new char[6];
        chars[0] = (char) r.nextInt(97, 123);
        chars[1] = (char) r.nextInt(65, 91);
        chars[2] = (char) r.nextInt(48, 58);
        chars[3] = arrayChar[r.nextInt(arrayChar.length)];
        chars[4] = (char) r.nextInt(33, 123);
        chars[5] = (char) r.nextInt(33, 123);
        char extra;
        for (int i = 0; i < chars.length; i++) {
            int posicion1 = r.nextInt(chars.length);
            int posicion2 = r.nextInt(chars.length);
            extra = chars[posicion1];
            chars[posicion1] = chars[posicion2];
            chars[posicion2] = extra;
        }
        String password = String.valueOf(chars);

        return password;
    }

    public static String listaTickets(ListaVentas ventas) {
        String carritoTexto = "";

        Iterator<Integer> it = ventas.getId().iterator();
        Iterator<Carrito> it2 = ventas.getVentas().iterator();

        while (it.hasNext()) {
            int id = it.next();
            carritoTexto = carritoTexto.concat("\n Nº pedido " + id + "\n");
            carritoTexto = carritoTexto.concat(MetodosUsuario.consultarProductos(it2.next()));
        }

        return carritoTexto;
    }

    public static void añadirProductos(ArrayProductos lista) {
        boolean atras = true;
        do {
            String[] menuUsuario = {"ATRAS", "COMIDA", "BEBIDA", "POSTRE"};
            int usuario = respuestaBoton(menuUsuario);

            switch (usuario) {
                case 1:

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

}
