/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Main {
 
    public static void main(String[] args) {
        
        //creo la lista de tpvs para poder añadir otros en un futuro
        //el constructor por defecto tiene ya una lista de productos que añado
        //al tpv para que cada uno tenga distintos stocks. en un futuro se podría
        //crear otro tpv con otros productos
        ArrayList<TPV> listaTpvs = new ArrayList<>();
        listaTpvs.add(new TPV());
        MenuTpv.encenderTpv(listaTpvs.get(0));
        
        
    }
    
}
