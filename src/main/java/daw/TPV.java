/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author daniel
 */
public class TPV {

    private final UUID id;
    private ListaVentas listaV;
    private ArrayProductos productosTpv;
    private String direccion;
    private LocalDateTime hora;
    private String password;

    public TPV() {
        this.id = new UUID(0, 0);
        this.listaV = new ListaVentas();
        this.productosTpv = new ArrayProductos();
        this.productosTpv = InicializadorClases.incializadorProductos();
        this.direccion = "";
        this.hora = LocalDateTime.now();
        this.password=Funciones.password();

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.listaV);
        hash = 47 * hash + Objects.hashCode(this.productosTpv);
        hash = 47 * hash + Objects.hashCode(this.direccion);
        hash = 47 * hash + Objects.hashCode(this.hora);
        hash = 47 * hash + Objects.hashCode(this.password);
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
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.listaV, other.listaV)) {
            return false;
        }
        if (!Objects.equals(this.productosTpv, other.productosTpv)) {
            return false;
        }
        return Objects.equals(this.hora, other.hora);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TPV{");
        sb.append("id=").append(id);
        sb.append(", listaV=").append(listaV);
        sb.append(", productosTpv=").append(productosTpv);
        sb.append(", direccion=").append(direccion);
        sb.append(", hora=").append(hora);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }

    
    

   
    

    

    public String getDireccion() {
        return direccion;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public UUID getId() {
        return id;
    }

    public ListaVentas getListaV() {
        return listaV;
    }

    public ArrayProductos getProductosTpv() {
        return productosTpv;
    }

    public void setListaV(ListaVentas listaV) {
        this.listaV = listaV;
    }

    public void setProductosTpv(ArrayProductos productosTpv) {
        this.productosTpv = productosTpv;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
