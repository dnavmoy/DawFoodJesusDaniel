/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.DawFoodJesusDaniel.respuestaBoton;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class Usuario {

    public static boolean Usuario(ArrayProductos lista, ListaVentas ticketVenta) {
        boolean atras = true;

        Carrito carrito = new Carrito();

        do {
            String[] menuUsuario = {"ATRAS", "COMIDA", "BEBIDA", "POSTRE", "VER CARRITO", "PAGAR"};
            int usuario = respuestaBoton(menuUsuario);
            switch (usuario) {
                case 1:

                    do {
                        String[] menuComida = {"ATRAS", "ENTRANTES", "PRIMEROS", "SEGUNDOS"};
                        int comida = respuestaBoton(menuComida);
                        switch (comida) {
                            case 1:

                                do {

                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Comidas.ENTRANTES);
                                    atras = Pruebas.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;

                            case 2:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Comidas.PRIMEROS);
                                    atras = Pruebas.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 3:
                                Productos objeto = new Productos(-1, "", 0, 0, 0, Comidas.SEGUNDOS);
                                atras = Pruebas.pedir(lista.getListaProductos(), carrito, objeto);

                                break;

                            case 0:
                                atras = false;

                        }

                    } while (atras);
                    atras = true;
                    break;
                case 2:

                    do {
                        String[] bebidaarray = {"ATRAS", "ALCOHOLICA", "Con Gas", "Sin Gas"};
                        int bebida = respuestaBoton(bebidaarray);

                        switch (bebida) {
                            case 1:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Bebidas.ALCOHOLICA);
                                    atras = Pruebas.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 2:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Bebidas.CON_GAS);
                                    atras = Pruebas.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 3:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Bebidas.SIN_GAS);
                                    atras = Pruebas.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 0:
                                atras = false;

                        }

                    } while (atras);
                    atras = true;
                    break;
                case 3:
                    do {
                        String[] menuPostre = {"ATRAS", "CALIENTE", "FRIO", "FRUTA"};
                        int postre = respuestaBoton(menuPostre);

                        switch (postre) {
                            case 1:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Postre.CALIENTE);
                                    atras = Pruebas.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 2:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Postre.FRIO);
                                    atras = Pruebas.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 3:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Postre.FRUTA);
                                    atras = Pruebas.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 0:
                                atras = false;

                        }

                    } while (atras);
                    atras = true;
                    break;
                case 4:
                    String carritoTexto = Pruebas.consultarProductos(carrito);
                    JOptionPane.showMessageDialog(null, carritoTexto);

                    break;
                case 5:
                    boolean pagado = Funciones.pasarelaPago(carrito);

                    if (!pagado) {

                        ticketVenta.getVentas().add(carrito);
                        ticketVenta.getFecha().add(Date.from(Instant.now()));
                        ticketVenta.getId().add(Pruebas.ultimoTicket(ticketVenta)+1);
                        String Ticket = Pruebas.consultarProductos(carrito);
                        String mostrarTicket= "NUMERO DE PEDIDO : "+ Pruebas.ultimoTicket(ticketVenta)+"\n";
                        mostrarTicket=mostrarTicket.concat(Ticket);
                        JOptionPane.showMessageDialog(null, mostrarTicket);
                        

                    }
                    atras = false;
                    break;

                case 0:
                    atras = false;
            }
        } while (atras);
        atras=true;
        return atras;
    }

}
