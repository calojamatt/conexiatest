/**
 * Development and Technologies Solutions S.A.S
 * conexiatest
 * InformeCamareroController.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.controller;

import com.dyts.conexiatest.bl.iservice.IInformeCamareroDTOService;
import com.dyts.conexiatest.persistence.dto.InformeCamareroDTO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 18/05/2019 2:54 PM
 */
@ViewScoped
@Named(value = "infcamareromb")
public class InformeCamareroController implements Serializable {

    List<InformeCamareroDTO> camareroDTOList;

    @Autowired
    IInformeCamareroDTOService informeCamareroDTOService;

    public List<InformeCamareroDTO> getCamareroDTOList() {
        return camareroDTOList;
    }

    public void setCamareroDTOList(List<InformeCamareroDTO> camareroDTOList) {
        this.camareroDTOList = camareroDTOList;
    }

    @PostConstruct
    public void postConstruct() {
        camareroDTOList = informeCamareroDTOService.findAll();
    }

}
