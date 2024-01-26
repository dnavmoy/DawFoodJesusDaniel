/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author daniel
 */
public class Carrito {
 
    
    private ArrayList<Productos> cesta;

    public Carrito() {
        this.cesta = new ArrayList<Productos>();
    }
    

    public ArrayList<Productos> getCesta() {
        return cesta;
    }

    public void setCesta(ArrayList<Productos> cesta) {
        this.cesta = cesta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.cesta);
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
        return Objects.equals(this.cesta, other.cesta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrito{");
        sb.append("cesta=").append(cesta);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}