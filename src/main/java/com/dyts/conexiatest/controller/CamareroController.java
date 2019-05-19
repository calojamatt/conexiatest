/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * CamareroController.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.controller;

import com.dyts.conexiatest.bl.serviceimpl.CamareroService;
import com.dyts.conexiatest.persistence.entities.Camarero;
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
 * @created: 12/05/2019 5:27:03 p.m.
 */
@RequestScoped
@Named(value = "camareromb")
public class CamareroController implements Serializable {
    private Integer idCamarero;
    private String nombres;
    private String apellido1;
    private String apellido2;
    
    private Camarero camarero;
    private List<Camarero> camareroList;

    @Autowired
    private CamareroService camareroService;

    public Integer getIdCamarero() {
        return idCamarero;
    }

    public void setIdCamarero(Integer idCamarero) {
        this.idCamarero = idCamarero;
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

    public List<Camarero> getCamareroList() {
        return camareroList;
    }

    public void setCamareroList(List<Camarero> camareroList) {
        this.camareroList = camareroList;
    }
    
    @PostConstruct
    public void postConstruct() {
        try {
            camareroList = camareroService.findAll();
        } catch (Exception ex) {
            Logger.getLogger(CocinerosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String createCamarero() {
        try {
            camarero = new Camarero();
            camarero.setIdCamarero(this.idCamarero);
            camarero.setNombre(this.nombres);
            camarero.setApellido1(this.apellido1);
            camarero.setApellido2(this.apellido2);
            camareroService.create(camarero);
            reset();
            return "/pages/nuevo_camarero.xhtml?faces-redirect=true";
        }catch (Exception ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            return "/pages/camareros.xhtml?faces-redirect=true";
        }
    }

    private void reset() {
        try {
            idCamarero = null;
            nombres = "";
            apellido1 = "";
            apellido2 = "";
            camarero = new Camarero();
            camareroList = camareroService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
