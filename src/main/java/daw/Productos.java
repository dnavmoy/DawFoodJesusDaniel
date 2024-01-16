/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Objects;

/**
 *
 * @author daniel
 */
public class Productos{
    
    private final int ID;
    private String descripcion;
    private double precio;
    private double Iva;
    private int stock;
    private Comidas comida;
    private Bebidas bebida;
    private Postre postre;

    public Productos(int ID, String descripcion, double precio, double Iva, int stock, Comidas comida) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.precio = precio;
        this.Iva = Iva;
        this.stock = stock;
        this.comida = comida;
        this.bebida = bebida;
        this.postre = postre;
    }
    public Productos(int ID, String descripcion, double precio, double Iva, int stock,Bebidas bebida) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.precio = precio;
        this.Iva = Iva;
        this.stock = stock;
        this.comida = comida;
        this.bebida = bebida;
        this.postre = postre;
    }
    
    public Productos(int ID, String descripcion, double precio, double Iva, int stock,Postre postre) {
        this.ID = ID;
        this.descripcion = descripcion;
        this.precio = precio;
        this.Iva = Iva;
        this.stock = stock;
        this.comida = comida;
        this.bebida = bebida;
        this.postre = postre;
    }

    public int getID() {
        return ID;
    }

    public double getPrecio() {
        return precio;
    }

    public double getIva() {
        return Iva;
    }

    public int getStock() {
        return stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Comidas getComida() {
        return comida;
    }

    public Bebidas getBebida() {
        return bebida;
    }

    public Postre getPostre() {
        return postre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setIva(double Iva) {
        this.Iva = Iva;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setComida(Comidas comida) {
        this.comida = comida;
    }

    public void setBebida(Bebidas bebida) {
        this.bebida = bebida;
    }

    public void setPostre(Postre postre) {
        this.postre = postre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.ID;
        hash = 67 * hash + Objects.hashCode(this.descripcion);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.Iva) ^ (Double.doubleToLongBits(this.Iva) >>> 32));
        hash = 67 * hash + this.stock;
        hash = 67 * hash + Objects.hashCode(this.comida);
        hash = 67 * hash + Objects.hashCode(this.bebida);
        hash = 67 * hash + Objects.hashCode(this.postre);
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
        final Productos other = (Productos) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (Double.doubleToLongBits(this.Iva) != Double.doubleToLongBits(other.Iva)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (this.comida != other.comida) {
            return false;
        }
        if (this.bebida != other.bebida) {
            return false;
        }
        return this.postre == other.postre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Productos{");
        sb.append("ID=").append(ID);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", precio=").append(precio);
        sb.append(", Iva=").append(Iva);
        sb.append(", stock=").append(stock);
        sb.append(", comida=").append(comida);
        sb.append(", bebida=").append(bebida);
        sb.append(", postre=").append(postre);
        sb.append('}');
        return sb.toString();
    }

  
    
    
    
    
}
