/**
 * Development and Technologies Solutions S.A.S
 * conexiatest
 * InformeCamareroDTO.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.persistence.dto;

import java.io.Serializable;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 18/05/2019 2:00 PM
 */
public class InformeClienteDTO implements Serializable {
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Float totalFacturado;

    public InformeClienteDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Float getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(Float totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
}
