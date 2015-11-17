/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.dominio;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jordan
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByCodVenta", query = "SELECT v FROM Venta v WHERE v.codVenta = :codVenta"),
    @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Venta.findByCantProd", query = "SELECT v FROM Venta v WHERE v.cantProd = :cantProd"),
    @NamedQuery(name = "Venta.findByValorNetoTotal", query = "SELECT v FROM Venta v WHERE v.valorNetoTotal = :valorNetoTotal")})
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_venta")
    private Integer codVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_prod")
    private int cantProd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_neto_total")
    private int valorNetoTotal;
    @JoinColumn(name = "rut_cliente", referencedColumnName = "rut_cliente")
    @ManyToOne(optional = false)
    private Cliente rutCliente;
    @JoinColumn(name = "rut_vendedor", referencedColumnName = "rut_vendedor")
    @ManyToOne(optional = false)
    private Vendedor rutVendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codVenta")
    private Collection<DetalleVenta> detalleVentaCollection;

    public Venta() {
    }

    public Venta(Integer codVenta) {
        this.codVenta = codVenta;
    }

    public Venta(Integer codVenta, Date fecha, int cantProd, int valorNetoTotal) {
        this.codVenta = codVenta;
        this.fecha = fecha;
        this.cantProd = cantProd;
        this.valorNetoTotal = valorNetoTotal;
    }

    public Integer getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(Integer codVenta) {
        this.codVenta = codVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }

    public int getValorNetoTotal() {
        return valorNetoTotal;
    }

    public void setValorNetoTotal(int valorNetoTotal) {
        this.valorNetoTotal = valorNetoTotal;
    }

    public Cliente getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(Cliente rutCliente) {
        this.rutCliente = rutCliente;
    }

    public Vendedor getRutVendedor() {
        return rutVendedor;
    }

    public void setRutVendedor(Vendedor rutVendedor) {
        this.rutVendedor = rutVendedor;
    }

    @XmlTransient
    public Collection<DetalleVenta> getDetalleVentaCollection() {
        return detalleVentaCollection;
    }

    public void setDetalleVentaCollection(Collection<DetalleVenta> detalleVentaCollection) {
        this.detalleVentaCollection = detalleVentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codVenta != null ? codVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.codVenta == null && other.codVenta != null) || (this.codVenta != null && !this.codVenta.equals(other.codVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.dominio.Venta[ codVenta=" + codVenta + " ]";
    }
    
}
