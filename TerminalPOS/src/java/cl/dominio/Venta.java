/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dominio;

import java.sql.Timestamp;

/**
 *
 * @author Simon
 */
public class Venta {
    public int codVenta;
    public Timestamp fecha;
    public int rutCliente;
    public int cantProducto;
    public int valorNetoTotal;

    public Venta() {
    }

    public int getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(int rutCliente) {
        this.rutCliente = rutCliente;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public int getValorNetoTotal() {
        return valorNetoTotal;
    }

    public void setValorNetoTotal(int valorNetoTotal) {
        this.valorNetoTotal = valorNetoTotal;
    }

    @Override
    public String toString() {
        return "Venta{" + "codVenta=" + codVenta + ", fecha=" + fecha + ", rutCliente=" + rutCliente + ", cantProducto=" + cantProducto + ", valorNetoTotal=" + valorNetoTotal + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.codVenta;
        hash = 71 * hash + this.rutCliente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venta other = (Venta) obj;
        if (this.codVenta != other.codVenta) {
            return false;
        }
        if (this.rutCliente != other.rutCliente) {
            return false;
        }
        return true;
    }
    
    
}
