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
public class MesaBean implements Serializable {
    private Integer idMesa;
    private Integer numMaxComensales;
    private Integer ubicacion;

    public MesaBean(Integer idMesa, Integer numMaxComensales, Integer ubicacion) {
        this.idMesa = idMesa;
        this.numMaxComensales = numMaxComensales;
        this.ubicacion = ubicacion;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getNumMaxComensales() {
        return numMaxComensales;
    }

    public void setNumMaxComensales(Integer numMaxComensales) {
        this.numMaxComensales = numMaxComensales;
    }

    public Integer getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Integer ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}
