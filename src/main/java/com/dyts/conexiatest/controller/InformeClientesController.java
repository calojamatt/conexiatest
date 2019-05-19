/**
 * Development and Technologies Solutions S.A.S
 * conexiatest
 * InformeClientesController.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.controller;

import com.dyts.conexiatest.bl.iservice.IClienteService;
import com.dyts.conexiatest.bl.iservice.IInformeClienteDTOService;
import com.dyts.conexiatest.persistence.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 18/05/2019 3:56 PM
 */
@ViewScoped
@Named(value = "infclientemb")
public class InformeClientesController implements Serializable {

    private Float valorFacturado = 0.0F;
    private List<Cliente> clienteList;

    @Autowired
    IInformeClienteDTOService iInformeClienteDTOService;

    public Float getValorFacturado() {
        return valorFacturado;
    }

    public void setValorFacturado(Float valorFacturado) {
        this.valorFacturado = valorFacturado;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @PostConstruct
    public void postConstruct() {
        try {
            valorFacturado = 100000.0F;
            clienteList = iInformeClienteDTOService.getInformeTotalFacturacion(valorFacturado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void filterClients() {
        try {
            clienteList = iInformeClienteDTOService.getInformeTotalFacturacion(valorFacturado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
