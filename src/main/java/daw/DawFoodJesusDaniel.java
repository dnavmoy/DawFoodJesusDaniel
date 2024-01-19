/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package daw;

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
//
//tpv- constraseñasadministrador 
public class DawFoodJesusDaniel {

    public static void main(String[] args) {

        boolean salir = true;
        boolean atras = true;

        //inicializar productos
        int[] arrayTarjeta = new int[4];

        arrayTarjeta[0] = 1233;
        arrayTarjeta[1] = 1234;
        arrayTarjeta[2] = 1235;
        arrayTarjeta[3] = 1236;

        Productos ensalada = new Productos(0, "ensalada", 1, 0.21, 10, Comidas.ENTRANTES);
        Productos gazpacho = new Productos(1, "gazpacho", 15, 0.21, 10, Comidas.ENTRANTES);
        Productos agua = new Productos(2, "agua", 1.5, 0.21, 10, Bebidas.SIN_GAS);
        Productos carne = new Productos(3, "filete", 20, 0.21, 10, Comidas.PRIMEROS);

        //estructura menu
        do {
            int respuesta = respuestaJopt("1 usuario, 2 adminstrador,3 salir");

            switch (respuesta) {

                case 1:
                    ArrayList<Productos> carrito = new ArrayList<>();
                    do {
                        int usuario = respuestaJopt("1 comida, 2 bebida, 3 postre, 4 atras");
                        switch (usuario) {
                            case 1:

                                do {
                                    int comida = respuestaJopt("1 sub 1 2 sub 2 3 sub 3 4 atras");
                                    switch (comida) {
                                        case 1:
                                            System.out.println("Entrantes");
                                            do {
                                                int entrantes = respuestaJopt("ensalada 1 - gazpacho 2 - atras 4");
                                                switch (entrantes) {
                                                    case 1:
                                                        int cantidad = respuestaJopt("cuanto añades");
                                                        Pruebas.addProducto(ensalada, carrito, cantidad);
                                                        break;
                                                    case 2:
                                                        System.out.println("sub 2");
                                                        break;
                                                    case 3:
                                                        System.out.println("sub 3");
                                                        break;
                                                    case 4:
                                                        Pruebas.consultarProductos(carrito);
                                                        atras = false;

                                                }

                                            } while (atras);
                                            atras = true;
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
