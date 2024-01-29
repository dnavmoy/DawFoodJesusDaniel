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
        
        ArrayList<TPV> listaTpvs = new ArrayList<>();
        listaTpvs.add(new TPV());
        MenuTpv.encenderTpv(listaTpvs.get(0));
        
        
    }
    
}
