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
public class ArrayProductos {
    
    private ArrayList ListaProductos;

    public ArrayProductos() {
        this.ListaProductos = new ArrayList();
    }

    public ArrayList getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(ArrayList ListaProductos) {
        this.ListaProductos = ListaProductos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.ListaProductos);
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
        final ArrayProductos other = (ArrayProductos) obj;
        return Objects.equals(this.ListaProductos, other.ListaProductos);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayProductos{");
        sb.append("ListaProductos=").append(ListaProductos);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
}
