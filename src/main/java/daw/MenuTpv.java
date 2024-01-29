/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

import Clases.ListaVentas;
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
//
//todo momento atras-inicio-añadir producto con cantidad.
//--- ticket numero de ticket--> cambia al contador constructor******
//
// -> menu cambios->cambio mismo id***************
//**** enum iva****
//****admin cambio productos-tipo productosno cambia*** o añadir producto*****
//**** termina que no añade bien los produtos al cambiarlo
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
public class MenuTpv {

    public static void encenderTpv(TPV tpv) {

        boolean salir = true;

        //inicializar productos-> una lista de ventas y una lista de productos
        ArrayProductos lista = tpv.getProductosTpv();
        ListaVentas listaVentas = tpv.getListaV();
//       
        //estructura menu
        do {
            //solo para poder consultarla en el ejemplo
            System.out.println("la contraseña de aministrador es: " + tpv.getPassword());

            String[] menuTpv = {"SALIR", "Encender Tpv"};
            int respTpv = respuestaBoton(menuTpv);

            switch (respTpv) {
                case 1:
                    //al "encender" tpv manda al menu inicial
                    do {
                        //seleccionar usuario, administrador o salir del tpv-> llama a metodos de cada uno
                        String[] menu = {"SALIR", "USUARIO", "ADMINISTRADOR"};
                        int respuesta = respuestaBoton(menu);

                        switch (respuesta) {

                            case 1:
                                MenuUsuario.Usuario(lista, listaVentas);

                                break;
                            //menu administrador
                            case 2:
                                String passwordIntroducida = respuestaTexto("introduce la contraseña");
                                if (passwordIntroducida == null) {
                                    JOptionPane.showMessageDialog(null, "introduce contraseña");
                                } else {
                                    if (passwordIntroducida.equals(tpv.getPassword())) {
                                        MenuAdministrador.administrador(lista, listaVentas);
                                    } else {
                                        JOptionPane.showMessageDialog(null, "contraseña erronea");
                                    }
                                }
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
        String respuestaTexto;
        do {
            respuestaTexto = JOptionPane.showInputDialog(texto);
            try {               
                if (respuestaTexto != null) {
                    respuesta = Integer.parseInt(respuestaTexto);
                    incorrecto = false;
                } 
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(null, "introduce valor valido");

            }
        } while (incorrecto);
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

    public static int respuestaBoton(String[] menu, String opciones) {

        int seleccion = JOptionPane.showOptionDialog(
                null,
                opciones,
                "Opciones",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                menu,
                "usuario");

        return seleccion;
    }

    public static String respuestaTexto(String menu) {
        boolean vacio=true;
        String respuesta="";
        do{
        respuesta = JOptionPane.showInputDialog(menu);
        if(respuesta!=null){
            vacio=false;
        }
        }while(vacio);
        return respuesta;
    }

    public static double respuestaDouble(String menu) {
        double respuesta = 0;
        boolean incorrecto = true;
        do {
            String respuestaTexto = JOptionPane.showInputDialog(menu);
            if (respuestaTexto != null) {
                try {
                    respuesta = Double.parseDouble(respuestaTexto);
                    incorrecto = false;
                } catch (NumberFormatException nf) {
                    JOptionPane.showMessageDialog(null, "introduce valor valido");

                }
            }
        } while (incorrecto);
        return respuesta;
    }

}
