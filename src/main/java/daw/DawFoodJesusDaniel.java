/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

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
//
//tpv- constraseñasadministrador 
public class DawFoodJesusDaniel {

    public static void main(String[] args) {

        boolean salir = true;
        boolean atras = true;

        //inicializar productos
<<<<<<< HEAD
        
        Clientes c1 =new Clientes();
=======
        Clientes c1 = new Clientes();
        
        
        
>>>>>>> origin/main
        
        //estructura menu
        do {
            int respuesta = respuestaJopt("1 usuario, 2 adminstrador,3 salir");

            switch (respuesta) {

                case 1:
                    do {
                        int usuario = respuestaJopt("1 comida, 2 bebida, 3 postre, 4 atras");
                        switch (usuario) {
                            case 1:

                                do {
                                    int comida = respuestaJopt("1 sub 1 2 sub 2 3 sub 3 4 atras");
                                    switch (comida) {
                                        case 1:
                                            System.out.println("sub 1");
                                            break;
                                        case 2:
                                            System.out.println("sub 2");
                                            break;
                                        case 3:
                                            System.out.println("sub 3");
                                            break;
                                        case 4:
                                            atras = false;

                                    }

                                } while (atras);
                                atras = true;
                                break;
                            case 2:

                                do {
                                    int bebida = respuestaJopt("1 sub 1 2 sub 2 3 sub 3 4 atras");
                                    switch (bebida) {
                                        case 1:
                                            System.out.println("sub 1");
                                            break;
                                        case 2:
                                            System.out.println("sub 2");
                                            break;
                                        case 3:
                                            System.out.println("sub 3");
                                            break;
                                        case 4:
                                            atras = false;

                                    }

                                } while (atras);
                                atras = true;
                                break;
                            case 3:
                                do {
                                    int postre = respuestaJopt("1 sub 1 2 sub 2 3 sub 3 4 atras");
                                    switch (postre) {
                                        case 1:
                                            System.out.println("sub 1");
                                            break;
                                        case 2:
                                            System.out.println("sub 2");
                                            break;
                                        case 3:
                                            System.out.println("sub 3");
                                            break;
                                        case 4:
                                            atras = false;

                                    }

                                } while (atras);
                                atras = true;
                                break;
                            case 4:
                                atras = false;
                        }
                    } while (atras);
                    break;
                //menu administrador
                case 2:
                    break;

                case 3:
                    salir = false;
            }

        } while (salir);

    }

    public static int respuestaJopt(String texto) {

        int respuesta = Integer.parseInt(JOptionPane.showInputDialog(texto));
        return respuesta;

    }
}
