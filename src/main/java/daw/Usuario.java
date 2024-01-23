/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.DawFoodJesusDaniel.respuestaBoton;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author daniel
 */
public class Usuario {
    
    public static boolean Usuario(ArrayProductos lista,ListaVentas tpv1){
        boolean atras=true;
        
        
        
                                Carrito carrito= new Carrito();
                                
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
                                            Pruebas.consultarProductos(carrito);
                                            
                                            break;
                                        case 5:
                                            boolean pagado=Funciones.pasarelaPago(carrito);

                                            if (pagado){
                        tpv1.getVentas().add(carrito);
                                                System.out.println("ha funcionado");
                                            }
                                            break;
                                        case 0:
                                            atras = false;
                                    }
                                } while (atras);
                                
        
        return atras;
    }
    
}
