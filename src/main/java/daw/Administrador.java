/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.metodosTpv.respuestaBoton;
import static daw.metodosTpv.respuestaJopt;
import static daw.metodosTpv.respuestaTexto;
import static daw.metodosTpv.respuestaDouble;
import javax.swing.JOptionPane;


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
                int idProducto=respuestaJopt("que producto vas a cambiar?");
                Pruebas.cambiarProducto(lista, idProducto);
                break;
            case 2:
                
                lista.getListaProductos().add(new Productos(Pruebas.ultimoId(lista)+1,
                        respuestaTexto("introduce descripcion"), respuestaDouble("introduce precio"), 
                        respuestaDouble("introduce iva"), respuestaJopt("introduce stock"), Bebidas.CON_GAS));
                break;
            case 3:
                int idProd=respuestaJopt("que producto vas a borrar?");
                Pruebas.borrarProducto(lista, idProd);
                break;
            case 4:
                Pruebas.consultarProductos(lista);
                break;
            case 5:
                String mostrar= Funciones.listaTickets(tpv1);
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
