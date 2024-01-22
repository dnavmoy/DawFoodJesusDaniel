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
public class ListaVentas {
    
    private ArrayList ventas;

    public ListaVentas() {
        this.ventas = new ArrayList();
    }

    public ArrayList getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.ventas);
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
        final ListaVentas other = (ListaVentas) obj;
        return Objects.equals(this.ventas, other.ventas);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListaVentas{");
        sb.append("ventas=").append(ventas);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
}
