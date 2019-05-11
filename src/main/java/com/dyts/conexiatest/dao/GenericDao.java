/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * GenericDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.dao;

import com.dyts.conexiatest.session.SessionManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @param <T>
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 1:57 AM
 */

/*
* @param <T>
*/
public abstract class GenericDao<T> implements IGenericDao<T> {

    EntityManager entityManager;
    private final Class<T> classType;

    public GenericDao() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType) type;
        classType = (Class) pType.getActualTypeArguments()[0];
        entityManager = SessionManager.getSessionFactory().createEntityManager();
    }

    /**
     *
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    @Transactional
    public T create(T t) throws Exception {
        try {
            this.entityManager.persist(t);
            return t;
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    @Transactional
    public void delete(T id) throws Exception {
        try {
            this.entityManager.remove(this.entityManager.getReference(classType, id));
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public T find(T id) throws Exception {
        try {
            return this.entityManager.find(classType, id);
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    @Transactional
    public T update(T t) throws Exception {
        try {
            return this.entityManager.merge(t);
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public T findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception {
        try {
            final Query query = this.entityManager.createNamedQuery(namedQuery);
            query.setParameter(parameterName, value);
            return (T) query.getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public List<T> findAll() throws Exception {
        try {
            final StringBuffer queryString = new StringBuffer("SELECT o from ");
            queryString.append(classType.getSimpleName()).append(" o ");
            final Query query = this.entityManager.createQuery(queryString.toString());
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public List<T> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception {
        try {
            final Query query = this.entityManager.createNamedQuery(namedQuery);
            int a = 0;
            for(String key: parameters) {
                query.setParameter(key, values[a]);
                a++;
            }
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public List<T> findByNativeQuery(String nativeQuery) throws Exception {
        try {
            final Query query = this.entityManager.createNativeQuery(nativeQuery);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public List<T> findAllWithParameter(String parameterName, Object parameterValue) throws Exception {
        try {
            final StringBuffer queryString = new StringBuffer("SELECT o from ");
            queryString.append(classType.getSimpleName()).append(" o ");
            queryString.append("where o.").append(parameterName).append(" = :").append(parameterName);
            final Query query = this.entityManager.createQuery(queryString.toString());
            query.setParameter(parameterName, parameterValue);
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }
}
