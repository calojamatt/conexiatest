/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * Test.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.cbeans;

import java.io.Serializable;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 9:46:08 p.m.
 */
public class ClientesBean implements Serializable {
    private Integer idCliente;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String observaciones;

    public ClientesBean(Integer idCliente, String nombres, String apellido1, String apellido2, String observaciones) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.observaciones = observaciones;
    }

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
   
    
}
