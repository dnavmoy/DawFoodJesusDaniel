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

        Productos producto0 = new Productos(0, "cero", 0, 0, 0, Comidas.ENTRANTES);
        Productos ensalada = new Productos(1, "ensalada", 1, 0.21, 10, Comidas.ENTRANTES);
        Productos gazpacho = new Productos(2, "gazpacho", 15, 0.21, 10, Comidas.ENTRANTES);
        Productos agua = new Productos(3, "agua", 1.5, 0.21, 10, Bebidas.SIN_GAS);
        Productos carne = new Productos(4, "filete", 20, 0.21, 10, Comidas.PRIMEROS);
        Productos cerveza = new Productos(5, "Cerveza", 3.2, 0.21, 10, Bebidas.ALCOHOLICA);
        ArrayList<Productos> lista = new ArrayList();
        lista.add(producto0);
        lista.add(ensalada);
        lista.add(gazpacho);
        lista.add(agua);
        lista.add(carne);
        lista.add(cerveza);
        //estructura menu
        do {
            int respuesta = respuestaJopt("1 usuario, 2 adminstrador,0 salir");

            switch (respuesta) {

                case 1:
                    ArrayList<Productos> carrito = new ArrayList<>();
                    do {
                        int usuario = respuestaJopt("1 comida, 2 bebida, 3 postre,4 ver carrito,5 Pagar 0 atras");
                        switch (usuario) {
                            case 1:

                                do {
                                    int comida = respuestaJopt("1-Entrantes 2-Primeros 3-Segundos 0-atras");
                                    switch (comida) {
                                        case 1:

                                            do {

                                                Productos objeto = new Productos(-1, "", 0, 0, 0, Comidas.ENTRANTES);
                                                atras = Pruebas.pedir(lista, carrito, objeto);

                                            } while (atras);
                                            atras = true;
                                            break;

                                        case 2:
                                            do {
                                                Productos objeto = new Productos(-1, "", 0, 0, 0, Comidas.PRIMEROS);
                                                atras = Pruebas.pedir(lista, carrito, objeto);

                                            } while (atras);
                                            atras = true;
                                            break;
                                        case 3:
                                            Productos objeto = new Productos(-1, "", 0, 0, 0, Comidas.SEGUNDOS);
                                            atras = Pruebas.pedir(lista, carrito, objeto);

                                            break;

                                        case 0:
                                            atras = false;

                                    }

                                } while (atras);
                                atras = true;
                                break;
                            case 2:

                                do {
                                    int bebida = respuestaJopt("1-Alcoholica  2-Con Gas 3-Sin Gas 0 atras");
                                    switch (bebida) {
                                        case 1:
                                            do {
                                                Productos objeto = new Productos(-1, "", 0, 0, 0, Bebidas.ALCOHOLICA);
                                                atras = Pruebas.pedir(lista, carrito, objeto);

                                            } while (atras);
                                            atras = true;
                                            break;
                                        case 2:
                                            do {
                                                Productos objeto = new Productos(-1, "", 0, 0, 0, Bebidas.CON_GAS);
                                                atras = Pruebas.pedir(lista, carrito, objeto);

                                            } while (atras);
                                            atras = true;
                                            break;
                                        case 3:
                                            do {
                                                Productos objeto = new Productos(-1, "", 0, 0, 0, Bebidas.SIN_GAS);
                                                atras = Pruebas.pedir(lista, carrito, objeto);

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
                                    int postre = respuestaJopt("1-Caliente 2-Frio 3-Fruta 0-atras");
                                    switch (postre) {
                                        case 1:
                                            do {
                                                Productos objeto = new Productos(-1, "", 0, 0, 0, Postre.CALIENTE);
                                                atras = Pruebas.pedir(lista, carrito, objeto);

                                            } while (atras);
                                            atras = true;
                                            break;
                                        case 2:
                                            do {
                                                Productos objeto = new Productos(-1, "", 0, 0, 0, Postre.FRIO);
                                                atras = Pruebas.pedir(lista, carrito, objeto);

                                            } while (atras);
                                            atras = true;
                                            break;
                                        case 3:
                                            do {
                                                Productos objeto = new Productos(-1, "", 0, 0, 0, Postre.FRUTA);
                                                atras = Pruebas.pedir(lista, carrito, objeto);

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
                                Pruebas.consultarProductos(carrito);
                                break;
                            case 5:
                                //Funciones.pasarelaPago(tarjeta);
                                break;
                            case 0:
                                atras = false;
                        }
                    } while (atras);
                    break;
                //menu administrador
                case 2:
                    
                    do {
                        int administrador = respuestaJopt("1-cambiar producto 2-Alta 3-borrar 4- consultar 0 atras ");
                                
                        switch (administrador) {
                            case 1:
                                
                                break;
                            case 2:
                                lista.add(new Productos(6, "ejemplo añadir", respuestaJopt("introduce precio"), respuestaJopt("introduce iva"), respuestaJopt("introduce stock"), Bebidas.CON_GAS));
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 0:
                                atras = false;
                                break;
                        }
                    } while (atras);
                    break;

                case 0:
                    salir = false;
            }

        } while (salir);

    }

    public static int respuestaJopt(String texto) {

        int respuesta = Integer.parseInt(JOptionPane.showInputDialog(texto));
        return respuesta;

    }
}
