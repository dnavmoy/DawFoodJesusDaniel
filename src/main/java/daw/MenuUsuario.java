/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import Clases.Carrito;
import Clases.Bebidas;
import Clases.Comidas;
import Clases.ListaVentas;
import Clases.Postre;
import Clases.Productos;
import static daw.MenuTpv.respuestaBoton;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class MenuUsuario {

    public static boolean Usuario(ArrayProductos lista, ListaVentas ticketVenta) {
        boolean atras = true;
        //creo un carrito cada vez que un usuario entre, al entrar otro usuario sustituye el carrito
        Carrito carrito = new Carrito();

        //permanece en menu usuario hasta que atras sea true 
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
                                    //creo producto ejemplo para filtrar la lista de productos solo por ese tipo-> en este caso los entrantes
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Comidas.ENTRANTES);
                                    //muestra solo esos productos y deja pedirlos
                                    atras = MetodosUsuario.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;

                            case 2:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Comidas.PRIMEROS);
                                    atras = MetodosUsuario.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 3:
                                Productos objeto = new Productos(-1, "", 0, 0, 0, Comidas.SEGUNDOS);
                                atras = MetodosUsuario.pedir(lista.getListaProductos(), carrito, objeto);

                                break;

                            case 0:
                                //boton atras hace que se salga del bucle de comida y lo vuelvo aponer en true para que permanezca en menu usuario
                                atras = false;

                        }

                    } while (atras);
                    atras = true;
                    break;
                case 2:
                    //idem con comidas
                    do {
                        String[] bebidaarray = {"ATRAS", "ALCOHOLICA", "Con Gas", "Sin Gas"};
                        int bebida = respuestaBoton(bebidaarray);

                        switch (bebida) {
                            case 1:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Bebidas.ALCOHOLICA);
                                    atras = MetodosUsuario.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 2:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Bebidas.CON_GAS);
                                    atras = MetodosUsuario.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 3:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Bebidas.SIN_GAS);
                                    atras = MetodosUsuario.pedir(lista.getListaProductos(), carrito, objeto);

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
                                    atras = MetodosUsuario.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 2:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Postre.FRIO);
                                    atras = MetodosUsuario.pedir(lista.getListaProductos(), carrito, objeto);

                                } while (atras);
                                atras = true;
                                break;
                            case 3:
                                do {
                                    Productos objeto = new Productos(-1, "", 0, 0, 0, Postre.FRUTA);
                                    atras = MetodosUsuario.pedir(lista.getListaProductos(), carrito, objeto);

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
                    //llama a metodo consultar productos para enseñar el carrito
                    String carritoTexto = MetodosUsuario.consultarProductos(lista,carrito);
                    JOptionPane.showMessageDialog(null, carritoTexto);
                    break;
                case 5:
                    //llama a metodo pasarelaPago para hacer el pago, devuelve true si es correcto el pago
                    
                    boolean pagado = MetodosAdministrador.pasarelaPago(lista,carrito);

                    if (pagado) {
                        //si el pago es correcto añadimos los datos del carrito a la lista de ventas
                        ticketVenta.getVentas().add(carrito);
                        ticketVenta.getFecha().add(Date.from(Instant.now()));
                        //metodo para calcular cual ha sido el ultimo ticket 
                        ticketVenta.getId().add(MetodosUsuario.ultimoTicket(ticketVenta) + 1);
                        //y mostramos el ticket-> un carrito con numero de pedido
                        String Ticket = MetodosUsuario.consultarProductos(lista,carrito);
                        String mostrarTicket = "NUMERO DE PEDIDO : " + MetodosUsuario.ultimoTicket(ticketVenta) + "\n";
                        mostrarTicket = mostrarTicket.concat(Ticket);
                        JOptionPane.showMessageDialog(null, mostrarTicket);

                    }
                    atras = false;
                    break;

                case 0:
                    atras = false;
                    
                    //si salimos del usuario sin pagar hay que devolver los productos al stock si no se eliminarar erroneamente
                    MetodosUsuario.devProductoStock(lista, carrito);
                    break;
            }
        } while (atras);
        atras = true;
        return atras;
    }

}
