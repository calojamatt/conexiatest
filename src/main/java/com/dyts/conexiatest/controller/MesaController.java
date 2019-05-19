/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * MesaController.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.controller;

import com.dyts.conexiatest.bl.serviceimpl.MesaService;
import com.dyts.conexiatest.persistence.entities.Mesa;
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
 * @created: 12/05/2019 5:32:10 p.m.
 */
@RequestScoped
@Named(value = "mesamb")
public class MesaController implements Serializable {
    private Integer idMesa;
    private Short numMaxComensales;
    private String ubicacion;
    
    private Mesa mesa;
    private List<Mesa> mesaList;
    @Autowired
    private MesaService mesaService;

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Short getNumMaxComensales() {
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

    public List<Mesa> getMesaList() {
        return mesaList;
    }

    public void setMesaList(List<Mesa> mesaList) {
        this.mesaList = mesaList;
    }

    public MesaService getMesaService() {
        return mesaService;
    }

    public void setMesaService(MesaService mesaService) {
        this.mesaService = mesaService;
    }
    
    @PostConstruct
    public void postConstruct() {
        try {
            mesaList = mesaService.findAll();
        } catch (Exception ex) {
            Logger.getLogger(MesaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String createMesa() {
        try {
            this.mesa = new Mesa();
            this.mesa.setIdMesa(this.idMesa);
            this.mesa.setNumMaxComensales(this.numMaxComensales);
            this.mesa.setUbicacion(this.ubicacion);
            mesaService.create(this.mesa);
            reset();
            return "/pages/nueva_mesa.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(CocinerosController.class.getName()).log(Level.SEVERE, null, ex);
            return "/pages/mesas.xhtml?faces-redirect=true";
        }
    }

    private void reset() {
        try {
            idMesa = null;
            numMaxComensales= null;
            ubicacion = "";
            mesa = new Mesa();
            mesaList = mesaService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
