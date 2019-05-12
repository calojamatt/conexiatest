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
public class CamareroBean implements Serializable {
    private Integer idCamarero;
    private String nombres;
    private String apellido1;
    private String apellido2;

    public CamareroBean(Integer idCamarero, String nombres, String apellido1, String apellido2) {
        this.idCamarero = idCamarero;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

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
    
}
