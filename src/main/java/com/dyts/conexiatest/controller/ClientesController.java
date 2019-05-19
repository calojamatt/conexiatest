/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * ClientesController.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.controller;

import com.dyts.conexiatest.bl.iservice.IClienteService;
import com.dyts.conexiatest.persistence.entities.Cliente;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 10:05:59 p.m.
 */
@ViewScoped
@Named(value = "clientesmb")
public class ClientesController implements Serializable {

    private Integer idCliente;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String observaciones;
    private Cliente cliente;
    private List<Cliente> clientList;

    @Autowired
    private IClienteService clienteService;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<Cliente> getClientList() {
        return clientList;
    }

    public void setClientList(List<Cliente> clientList) {
        this.clientList = clientList;
    }

    @PostConstruct
    public void postConstruct() {
        try {
            clientList = clienteService.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String createClient() {
        try {
            this.cliente = new Cliente();
            this.cliente.setIdCliente(this.idCliente);
            this.cliente.setNombre(this.nombres);
            this.cliente.setApellido1(this.apellido1);
            this.cliente.setApellido2(this.apellido2);
            this.cliente.setObservaciones(this.observaciones);
            this.clienteService.create(cliente);
            // Add View Faces Message
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Cliente registrado.");
            FacesContext.getCurrentInstance().addMessage( null, message);
            reset();
            return "/pages/nuevo_cliente.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(ClientesController.class.getName()).log(Level.SEVERE, null, ex);
            return "clientes";
        }
    }

    private void reset() {
        try {
            idCliente = null;
            nombres = "";
            apellido1 = "";
            apellido2 = "";
            observaciones = "";
            cliente = new Cliente();
            clientList = clienteService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
