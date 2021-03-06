/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyts.conexiatest.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CarlosMatt
 */
@Entity
@Table(name = "mesa", catalog = "conexiatest", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesa.findAll", query = "SELECT m FROM Mesa m"),
    @NamedQuery(name = "Mesa.findByIdMesa", query = "SELECT m FROM Mesa m WHERE m.idMesa = :idMesa"),
    @NamedQuery(name = "Mesa.findByNumMaxComensales", query = "SELECT m FROM Mesa m WHERE m.numMaxComensales = :numMaxComensales"),
    @NamedQuery(name = "Mesa.findByUbicacion", query = "SELECT m FROM Mesa m WHERE m.ubicacion = :ubicacion")})
public class Mesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMesa")
    private Integer idMesa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumMaxComensales")
    private short numMaxComensales;
    @Size(max = 100)
    @Column(name = "Ubicacion")
    private String ubicacion;
    @OneToMany(mappedBy = "idMesa")
    private List<Factura> facturaCollection;


    public Mesa() {
    }

    public Mesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Mesa(Integer idMesa, short numMaxComensales) {
        this.idMesa = idMesa;
        this.numMaxComensales = numMaxComensales;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMesa != null ? idMesa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesa)) {
            return false;
        }
        Mesa other = (Mesa) object;
        if ((this.idMesa == null && other.idMesa != null) || (this.idMesa != null && !this.idMesa.equals(other.idMesa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dyts.conexiatest.entities.Mesa[ idMesa=" + idMesa + " ]";
    }

    @XmlTransient
    public List<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(List<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public short getNumMaxComensales() {
        return numMaxComensales;
    }

    public void setNumMaxComensales(Short numMaxComensales) {
        this.numMaxComensales = numMaxComensales;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}
