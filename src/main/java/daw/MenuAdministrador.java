/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import Clases.Bebidas;
import Clases.ListaVentas;
import Clases.Productos;
import static daw.MenuTpv.respuestaBoton;
import static daw.MenuTpv.respuestaJopt;
import static daw.MenuTpv.respuestaTexto;
import static daw.MenuTpv.respuestaDouble;
import javax.swing.JOptionPane;


/**
 *
 * @author daniel
 */
public class MenuAdministrador {

    public static void administrador(ArrayProductos lista,ListaVentas tpv1){
        boolean atras=true;
       
        do {
        String[] menuAdministrador = {"ATRAS", "CAMBIAR PRODUCTO", "ALTA PRODUCTO", "BORRAR PRODUCTO", "CONSULTA PRODUCTO", "VER VENTAS"};
        int administrador = respuestaBoton(menuAdministrador);

        switch (administrador) {
            case 1:
                int idProducto=respuestaJopt("que producto vas a cambiar?");
                MetodosUsuario.cambiarProducto(lista, idProducto);
                break;
            case 2:
                
                MetodosAdministrador.añadirProductos(lista);
                break;
            case 3:
                int idProd=respuestaJopt("que producto vas a borrar?");
                MetodosUsuario.borrarProducto(lista, idProd);
                break;
            case 4:
                MetodosUsuario.consultarProductos(lista);
                break;
            case 5:
                String mostrar= MetodosAdministrador.listaTickets(tpv1);
                JOptionPane.showMessageDialog(null, mostrar);
                
                break;
            case 0:
                atras = false;
                break;
        }
    }
    while (atras);
}                                
    
}
