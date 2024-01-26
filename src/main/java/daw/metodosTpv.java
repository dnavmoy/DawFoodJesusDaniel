/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
//-- menu encenderTpv-> crear clase encenderTpv con ArrayProductos-carrito-contraseña administrador
//menu desplegable-> seleccionar encenderTpv
//->  usuario, administrador,
//usuario-> comida,bebida,postre
//		--> tres subcategorias
//	opcion-> pedir, consultar precio
//todo momento atras-inicio-añadir producto con cantidad.
//--- ticket numero de ticket--> cambia al contador constructor******
//
//administrador-> contraseña************* -> menu cambios->cambio mismo id***************
//administrador-> mostrar lista ventas de forma visible
//pasarela de pago******* falta cvv y fecha 
//
//clases
//
//array clientes-> con tarjetas guardadas
//array productos->comida,bebida,postres->subclases
//
//arraylist pedidos
//arraylist- lista pedidos
//clase carrito!
//clase encenderTpv
//clase ticket
//
//tpv- constraseñasadministrador 
public class metodosTpv {

    public static void encenderTpv(TPV tpv) {

        boolean salir = true;
        boolean atras = true;

        //inicializar productos
        ArrayProductos lista = tpv.getProductosTpv();

//       
        //estructura menu
        do {
            String[] menuTpv = {"SALIR", "TPV"};
            int respTpv = respuestaBoton(menuTpv);
            switch (respTpv) {
                case 1:
                    ListaVentas listaTickets = tpv.getListaV();
                    do {
                        String[] menu = {"SALIR", "USUARIO", "ADMINISTRADOR"};
                        int respuesta = respuestaBoton(menu);

                        switch (respuesta) {

                            case 1:
                                Usuario.Usuario(lista, listaTickets,tpv.getCesta());
                                break;
                            //menu administrador
                            case 2:
                                Administrador.administrador(lista, listaTickets);
//                                
                                break;
                            //Opcion para salir
                            case 0:
                                salir = false;
                        }

                    } while (salir);
                case 0:
                    salir = false;
                    break;
            }
            while (salir);

        } while (salir);

    }

    public static int respuestaJopt(String texto) {
        int respuesta = 0;
        boolean incorrecto = true;
        do {
            try {
                respuesta = Integer.parseInt(JOptionPane.showInputDialog(texto));
                incorrecto = false;
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(null, "introduce valor valido");

            }
        }while (incorrecto);
            return respuesta;
        }
    

    public static int respuestaBoton(String[] menu) {

        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione opcion",
                "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                menu,
                "usuario");

        return seleccion;
    }

    public static String respuestaTexto(String menu) {
        String respuesta = JOptionPane.showInputDialog(menu);
        return respuesta;
    }

    public static double respuestaDouble(String menu) {
        double respuesta = 0;
        boolean incorrecto = true;
        do {
            try {
                respuesta = Double.parseDouble(JOptionPane.showInputDialog(menu));
                incorrecto = false;
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(null, "introduce valor valido");

            }
        }while (incorrecto);
            return respuesta;
        }

    }
