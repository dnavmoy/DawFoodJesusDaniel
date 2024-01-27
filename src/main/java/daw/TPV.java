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
public class TPV {
    
    private int id=0;
    private ListaVentas listaV;
    
    private ArrayProductos productosTpv;

    public TPV() {
        this.id = id;
        this.listaV = new ListaVentas();
        this.productosTpv= new ArrayProductos();
        this.productosTpv= InicializadorClases.incializadorProductos();
        
                
                
    }



    public int getId() {
        return id;
    }

    public ListaVentas getListaV() {
        return listaV;
    }

 

    public ArrayProductos getProductosTpv() {
        return productosTpv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListaV(ListaVentas listaV) {
        this.listaV = listaV;
    }

    

    public void setProductosTpv(ArrayProductos productosTpv) {
        this.productosTpv = productosTpv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.listaV);
      
        hash = 59 * hash + Objects.hashCode(this.productosTpv);
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
        final TPV other = (TPV) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.listaV, other.listaV)) {
            return false;
        }
       
        return Objects.equals(this.productosTpv, other.productosTpv);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TPV{");
        sb.append("id=").append(id);
        sb.append(", listaV=").append(listaV);
       
        sb.append(", productosTpv=").append(productosTpv);
        sb.append('}');
        return sb.toString();
    }

    
    
    
}