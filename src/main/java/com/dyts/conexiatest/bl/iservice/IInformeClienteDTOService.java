/**
 * Development and Technologies Solutions S.A.S
 * conexiatest
 * IInformeCamareroDTOService.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.bl.iservice;

import java.util.List;

/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 18/05/2019 2:04 PM
 */
public interface IInformeClienteDTOService<T> {
    List<T> getInformeTotalFacturacion(Float valor);
}
