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
public class PlatoBean implements Serializable {
    private Integer idPlato;
    private String nombre;
    private Float importe;

    public PlatoBean(Integer idPlato, String nombre, Float importe) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.importe = importe;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }
    
    
}
