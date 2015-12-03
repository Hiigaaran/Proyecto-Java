/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dominio;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Jordan
 */
public class Estadistica implements Serializable{
    private int cod_estadistica;
    private Timestamp fecha_estadistica;
    private int total_semanal;
    private int total_mensual;
    private int total_anual;

    public Estadistica() {
    }

    public Estadistica(int cod_estadistica, Timestamp fecha_estadistica, int total_semanal, int total_mensual, int total_anual) {
        this.cod_estadistica = cod_estadistica;
        this.fecha_estadistica = fecha_estadistica;
        this.total_semanal = total_semanal;
        this.total_mensual = total_mensual;
        this.total_anual = total_anual;
    }

    public int getCod_estadistica() {
        return cod_estadistica;
    }

    public void setCod_estadistica(int cod_estadistica) {
        this.cod_estadistica = cod_estadistica;
    }

    public Timestamp getFecha_estadistica() {
        return fecha_estadistica;
    }

    public void setFecha_estadistica(Timestamp fecha_estadistica) {
        this.fecha_estadistica = fecha_estadistica;
    }

    public int getTotal_semanal() {
        return total_semanal;
    }

    public void setTotal_semanal(int total_semanal) {
        this.total_semanal = total_semanal;
    }

    public int getTotal_mensual() {
        return total_mensual;
    }

    public void setTotal_mensual(int total_mensual) {
        this.total_mensual = total_mensual;
    }

    public int getTotal_anual() {
        return total_anual;
    }

    public void setTotal_anual(int total_anual) {
        this.total_anual = total_anual;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.cod_estadistica;
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
        final Estadistica other = (Estadistica) obj;
        if (this.cod_estadistica != other.cod_estadistica) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
