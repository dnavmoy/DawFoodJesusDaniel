/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.DawFoodJesusDaniel.respuestaBoton;
import static daw.DawFoodJesusDaniel.respuestaJopt;
import static daw.DawFoodJesusDaniel.respuestaTexto;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Administrador {

    public static void administrador(ArrayProductos lista,ListaVentas tpv1){
        boolean atras=true;
    
        do {
                                    String[] menuAdministrador = {"ATRAS", "CAMBIAR PRODUCTO", "ALTA PRODUCTO", "BORRAR PRODUCTO", "CONSULTA PRODUCTO", "VER VENTAS"};
        int administrador = respuestaBoton(menuAdministrador);

        switch (administrador) {
            case 1:

                break;
            case 2:
                lista.getListaProductos().add(new Productos(lista.getListaProductos().size() + 1, respuestaTexto("introduce descripcion"), respuestaJopt("introduce precio"), respuestaJopt("introduce iva"), respuestaJopt("introduce stock"), Bebidas.CON_GAS));
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.out.println(tpv1);
                break;
            case 0:
                atras = false;
                break;
        }
    }
    while (atras);
}                                
    
}
