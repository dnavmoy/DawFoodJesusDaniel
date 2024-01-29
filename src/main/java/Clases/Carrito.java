/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Clases.Productos;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author daniel
 */
public class Carrito {
 
    
    private ArrayList<Productos> cesta;
    private ArrayList<Integer> cantidad;

    public Carrito() {
        this.cesta = new ArrayList<Productos>();
        this.cantidad = new ArrayList<Integer>();
    }
    
    public Carrito(ArrayList<Productos> productos, ArrayList<Integer> cantidades) {
        this.cesta = productos;
        this.cantidad = cantidades;
    }
  
    
    public Carrito(Carrito copia){
        this.cesta= copia.cesta;
        this.cantidad=copia.cantidad;
    }

    public ArrayList<Productos> getCesta() {
        return cesta;
    }

  

    public void setCesta(ArrayList<Productos> cesta) {
        this.cesta = cesta;
    }

    public ArrayList<Integer> getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList<Integer> cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cesta);
        hash = 97 * hash + Objects.hashCode(this.cantidad);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carrito other = (Carrito) obj;
        if (!Objects.equals(this.cesta, other.cesta)) {
            return false;
        }
        return Objects.equals(this.cantidad, other.cantidad);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrito{");
        sb.append("cesta=").append(cesta);
        sb.append(", cantidad=").append(cantidad);
        sb.append('}');
        return sb.toString();
    }

    

    
}