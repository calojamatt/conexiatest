/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * IGenericDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.persistence.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 * @param <T>
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 1:55 AM
 */
public interface IGenericDao<T extends Serializable> {
    T create(T t) throws Exception;
    void delete(T id) throws Exception;
    T find(T id) throws Exception;
    T update(T t) throws Exception;
    T findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception;
    List<T> findAll(T t) throws Exception;
    List<T> findAllWithParameter(T t, String parameterName, Object parameterValue) throws Exception;
    List<T> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception;
    List<T> findByNativeQuery(String nativeQuery) throws Exception;
    SessionFactory getSessionFactory();
}
