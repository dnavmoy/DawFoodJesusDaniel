/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import Clases.ListaVentas;
import static daw.MenuTpv.respuestaBoton;
import static daw.MenuTpv.respuestaJopt;
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
        //creo menu administrador con las opciones, que manod al metodo para crear los botones
        int administrador = respuestaBoton(menuAdministrador);

        switch (administrador) {
            case 1:
                int idProducto=respuestaJopt("que producto vas a cambiar?");
                MetodosAdministrador.cambiarProducto(lista, idProducto);
                break;
            case 2:
                
                MetodosAdministrador.añadirProductos(lista);
                break;
            case 3:
                int idProd=respuestaJopt("que producto vas a borrar?");
                MetodosAdministrador.borrarProducto(lista, idProd);
                break;
            case 4:
                MetodosAdministrador.consultarProductos(lista);
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
