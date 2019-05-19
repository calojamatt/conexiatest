/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * PlatoController.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.controller;

import com.dyts.conexiatest.bl.serviceimpl.PlatoService;
import com.dyts.conexiatest.persistence.entities.Cocinero;
import com.dyts.conexiatest.persistence.entities.Plato;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 12/05/2019 5:38:22 p.m.
 */
@RequestScoped
@Named(value = "platomb")
public class PlatoController implements Serializable {
    private Integer idPlato;
    private String nombre;
    private Float importe;
    private String nombreCocinero;
    private Plato plato;
    private List<Plato> platoList;
    private Cocinero cocinero;
    @Autowired
    private PlatoService platoService;

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

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public String getNombreCocinero() {
        return nombreCocinero;
    }

    public void setNombreCocinero(String nombreCocinero) {
        this.nombreCocinero = nombreCocinero;
    }

    public List<Plato> getPlatoList() {
        return platoList;
    }

    public void setPlatoList(List<Plato> platoList) {
        this.platoList = platoList;
    }

    public Cocinero getCocinero() {
        return cocinero;
    }

    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }

    @PostConstruct
    public void postConstruct() {
        try {
            platoList = platoService.findAll();
        } catch (Exception ex) {
            Logger.getLogger(PlatoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String createPlato() {
        try {
            this.plato = new Plato();
            this.plato.setNombre(this.nombre);
            this.plato.setImporte(this.importe);
            this.plato.setIdCocinero(this.cocinero);
            platoService.create(this.plato);
            reset();
            return "/pages/nuevo_plato.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(CocinerosController.class.getName()).log(Level.SEVERE, null, ex);
            return "/pages/platos.xhtml?faces-redirect=true";
        }
    }

    private void reset() {
        try {
            nombre = "";
            importe = 0.0F;
            plato = new Plato();
            cocinero = new Cocinero();
            platoList = platoService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectCocinero(Cocinero cocinero) {
        this.setCocinero(cocinero);
        String aux = cocinero.getNombre().concat(" ").concat(cocinero.getApellido1()).concat(" ").concat(cocinero.getApellido2());
        this.setNombreCocinero(aux);
    }
}
