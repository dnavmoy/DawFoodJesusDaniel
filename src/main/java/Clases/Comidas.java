/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Clases;

/**
 *
 * @author daniel
 */
public enum Comidas {
    
    ENTRANTES("Entrante",0.21),PRIMEROS("Primeros",0.21),SEGUNDOS("Segundo",0.21);
    
    private String nombre;
    private double iva;
    
    private Comidas (String nombre,double iva){
        this.nombre=nombre;
        this.iva=iva;
    }
}
