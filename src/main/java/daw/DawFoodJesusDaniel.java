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
        boolean repetir = true;
        boolean atras = true;
        do {
            int menu = Integer.parseInt(JOptionPane.showInputDialog("usuario1-"
                    + " administrador 2. 3 para salir"));

            switch (menu) {
                case 1 :
                    do {
                        int usuario = Integer.parseInt(JOptionPane.showInputDialog("1 comida-"
                                + " 2bebida 3 postre 4 atras 5 salir"));
                        switch (usuario) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "comida");
                                do{
                                    int comida = Integer.parseInt(JOptionPane.showInputDialog("sub1-"
                                + " sub2 sub3 4 atras "));
                                    switch(comida){
                                        case 1: 
                                            JOptionPane.showMessageDialog(null, "sub1");
                                            break;
                                        case 4:
                                            atras=false;
                                    }
                                }while(atras);
                                atras=true;
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "bebida");
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "postre");
                                break;
                            case 4:
                                atras=false;
                        }

                    } while (atras);
                    break;
                
                case 2:
                    JOptionPane.showMessageDialog(null, "opcion 2");
                case 3:
                    repetir = false;
            }
            
        } while (repetir);

    }
}
