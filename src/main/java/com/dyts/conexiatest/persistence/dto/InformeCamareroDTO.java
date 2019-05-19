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
public class InformeCamareroDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String mes;
    private Float totalFacturado;

    public InformeCamareroDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Float getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(Float totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
}
