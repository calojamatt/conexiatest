/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * CocinerosController.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.controller;

import com.dyts.conexiatest.bl.serviceimpl.CocineroService;
import com.dyts.conexiatest.persistence.entities.Cocinero;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 12/05/2019 5:20:14 p.m.
 */
@ViewScoped
@Named(value = "cocineromb")
public class CocinerosController implements Serializable {
    private Integer idCocinero;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private Cocinero cocinero;
    private List<Cocinero> cocineroList;

    @Autowired
    private CocineroService cocineroService;

    public Integer getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(Integer idCocinero) {
        this.idCocinero = idCocinero;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public List<Cocinero> getCocineroList() {
        return cocineroList;
    }

    public void setCocineroList(List<Cocinero> cocineroList) {
        this.cocineroList = cocineroList;
    }

    @PostConstruct
    public void postConstruct() {
        try {
            cocineroList = cocineroService.findAll();
        } catch (Exception ex) {
            Logger.getLogger(CocinerosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String createCocinero() {
        try {
            this.cocinero = new Cocinero();
            this.cocinero.setIdCocinero(this.idCocinero);
            this.cocinero.setNombre(this.nombres);
            this.cocinero.setApellido1(this.apellido1);
            this.cocinero.setApellido2(this.apellido2);
            cocineroService.create(this.cocinero);
            reset();
            return "/pages/nuevo_cocinero.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(CocinerosController.class.getName()).log(Level.SEVERE, null, ex);
            return "/pages/cocineros.xhtml?faces-redirect=true";
        }
    }

    private void reset() {
        try {
            idCocinero = null;
            nombres = "";
            apellido1 = "";
            apellido2 = "";
            cocinero = new Cocinero();
            cocineroList = cocineroService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
