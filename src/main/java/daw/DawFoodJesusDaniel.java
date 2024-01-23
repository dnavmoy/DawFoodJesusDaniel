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
//
//menu desplegable-> seleccionar tpv
//->  usuario, administrador,
//usuario-> comida,bebida,postre
//		--> tres subcategorias
//	opcion-> pedir, consultar precio
//todo momento atras-inicio-añadir producto con cantidad.
//
//
//administrador-> contraseña -> menu cambios
//
//pasarela de pago
//
//clases
//
//array clientes-> con tarjetas guardadas
//array productos->comida,bebida,postres->subclases
//
//arraylist pedidos
//arraylist- lista pedidos
//clase carrito!
//clase tpv
//clase ticket
//
//tpv- constraseñasadministrador 
public class DawFoodJesusDaniel {

    public static void main(String[] args) {

        boolean salir = true;
        boolean atras = true;

        //inicializar productos
        
                
        ArrayProductos lista=InicializadorClases.incializadorProductos();
        
//       
        //estructura menu
        do {
            String[] menuTpv = {"SALIR", "TPV"};
            int respTpv = respuestaBoton(menuTpv);
            switch (respTpv) {
                case 1:
                    ListaVentas tpv1 = new ListaVentas();
                    do {
                        String[] menu = {"SALIR", "USUARIO", "ADMINISTRADOR"};
                        int respuesta = respuestaBoton(menu);
                       

                        switch (respuesta) {

                            case 1:
                                Usuario.Usuario(lista,tpv1);
                                break;
                            //menu administrador
                            case 2:
                              Administrador.administrador(lista, tpv1);
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

        int respuesta = Integer.parseInt(JOptionPane.showInputDialog(texto));
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

}
