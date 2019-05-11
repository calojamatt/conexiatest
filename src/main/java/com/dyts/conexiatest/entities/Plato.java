/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyts.conexiatest.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CarlosMatt
 */
@Entity
@Table(name = "plato", catalog = "conexiatest", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p"),
    @NamedQuery(name = "Plato.findByIdPlato", query = "SELECT p FROM Plato p WHERE p.idPlato = :idPlato"),
    @NamedQuery(name = "Plato.findByNombre", query = "SELECT p FROM Plato p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Plato.findByImporte", query = "SELECT p FROM Plato p WHERE p.importe = :importe")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlato")
    private Integer idPlato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private float importe;

    public Plato() {
    }

    public Plato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Plato(Integer idPlato, String nombre, float importe) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.importe = importe;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlato != null ? idPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.idPlato == null && other.idPlato != null) || (this.idPlato != null && !this.idPlato.equals(other.idPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dyts.conexiatest.entities.Plato[ idPlato=" + idPlato + " ]";
    }
    
}
