/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author daniel
 */
public class ListaVentas {

    private ArrayList<Integer> id;
    private ArrayList<Carrito> ventas;
    private ArrayList<Date> fecha;

    public ListaVentas() {
        this.id = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.fecha = new ArrayList<>();
    }

    public ArrayList<Carrito> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Carrito> ventas) {
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
            sb.append(", fecha=").append(fecha);
       
        sb.append('}');
        return sb.toString();
    }

    public ArrayList<Date> getFecha() {
        return fecha;
    }

    public void setFecha(ArrayList<Date> fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Integer> getId() {
        return id;
    }

    public void setId(ArrayList<Integer> id) {
        this.id = id;
    }

  

}
