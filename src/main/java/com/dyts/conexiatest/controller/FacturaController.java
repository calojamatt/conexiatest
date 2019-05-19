/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * FacturaController.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.controller;

import com.dyts.conexiatest.bl.serviceimpl.FacturaService;
import com.dyts.conexiatest.persistence.entities.Camarero;
import com.dyts.conexiatest.persistence.entities.Cliente;
import com.dyts.conexiatest.persistence.entities.Detallefactura;
import com.dyts.conexiatest.persistence.entities.Factura;
import com.dyts.conexiatest.persistence.entities.Mesa;
import com.dyts.conexiatest.persistence.entities.Plato;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 12/05/2019 6:00:18 p.m.
 */
@ViewScoped
@Named(value = "facturasmb")
public class FacturaController implements Serializable {
    private Integer idFactura;
    private Float importe;
    private Date fechaFactura;
    private Factura factura;
    private Cliente cliente;
    private Mesa mesa;
    private Camarero camarero;
    private String nombreCompletoCliente;
    private String nombreCompletoCamarero;
    private List<Factura> facturaList;
    private List<Detallefactura> detfacList;

    @Autowired
    private FacturaService facturaService;
    
    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }

    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }

    public String getNombreCompletoCamarero() {
        return nombreCompletoCamarero;
    }

    public void setNombreCompletoCamarero(String nombreCompletoCamarero) {
        this.nombreCompletoCamarero = nombreCompletoCamarero;
    }
    
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public List<Detallefactura> getDetfacList() {
        return detfacList;
    }

    public void setDetfacList(List<Detallefactura> detfacList) {
        this.detfacList = detfacList;
    }
        
    @PostConstruct
    public void postConstruct() {
        try {
            this.factura = new Factura();
            this.mesa = new Mesa();
            this.camarero = new Camarero();
            this.cliente = new Cliente();
            this.fechaFactura = new Date();
            this.importe = 0.0F;
            this.nombreCompletoCamarero = "";
            this.nombreCompletoCliente = "";
            detfacList = new ArrayList<>();
            this.facturaList = this.facturaService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Float sumInvoiceImporte(List<Detallefactura> ldf) {
        this.importe = 0.0F;
        ldf.forEach(d -> this.importe += d.getImporte() > 0.0F ? d.getImporte():0.0F);
        return this.importe;
    }

    public String createInvoice() {
        try {
            //this.factura.setIdFactura(this.idFactura);
            this.factura.setFechaFactura(this.fechaFactura);
            this.factura.setIdMesa(this.mesa);
            this.factura.setIdCliente(this.cliente);
            this.factura.setIdCamarero(this.camarero);
            this.factura.setDetallefacturaCollection(this.detfacList);
            this.facturaService.create(this.factura);
            this.facturaList = this.facturaService.findAll();
            postConstruct();
            return "/pages/nueva_factura.xhtml?faces-redirect=true";
        } catch (Exception ex) {
            Logger.getLogger(FacturaController.class.getName()).log(Level.SEVERE, null, ex);
            return "/pages/facturas.xhtml?faces-redirect=true";
        }
    }

    public void selectClient(Cliente cliente) {
        this.setCliente(cliente);
        String aux = cliente.getNombre().concat(" ").concat(cliente.getApellido1()).concat(" ").concat(cliente.getApellido2());
        this.setNombreCompletoCliente(aux);
    }
    
    public String selectCamarero(Camarero camarero) {
        this.setCamarero(camarero);
        String aux = camarero.getNombre().concat(" ").concat(camarero.getApellido1()).concat(" ").concat(camarero.getApellido2());
        this.setNombreCompletoCamarero(aux);
        return aux;
    }
    
    public void selectMesa(Mesa mesa) {
        this.setMesa(mesa);
    }
    
    public void selectPlato(Plato plato) {
        Detallefactura df = new Detallefactura();
        df.setIdPlato(plato);
        df.setIdCocinero(plato.getIdCocinero());
        df.setImporte(plato.getImporte());
        df.setIdFactura(this.factura);
        detfacList.add(df);
    }
    
    public void deletePlato(Detallefactura df) {
        detfacList.removeIf(d -> d.getIdPlato().getIdPlato().equals(df.getIdPlato().getIdPlato()));
    }

    public void updateDataTable() {
        try {
            this.facturaList = this.facturaService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
