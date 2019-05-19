/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * GenericDao.java
 * <p>
 * Derechos de Autor 2015-2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.persistence.dao;

import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @param <T>
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 1:57 AM
 */

/*
* @param <T>
*/
@Transactional
@Repository
public class GenericDao<T extends Serializable> implements IGenericDao<T> {
    
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Get Hibernate Session Factory
     *
     * @return SessionFactory - Hibernate Session Factory
     */
    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Set Hibernate Session Factory
     *
     * @param sessionFactory SessionFactory - Hibernate Session Factory
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public GenericDao() {
    }

    /**
     *
     * @param t
     * @return
     * @throws Exception
     */
    @Override
    public T create(T t) throws Exception {
        try {
            this.sessionFactory.getCurrentSession().save(t);
            return t;
        } catch (HibernateException e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public void delete(T id) throws Exception {
        try {
            this.sessionFactory.getCurrentSession().delete(id);
        } catch (HibernateException e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public T find(T id) throws Exception {
        try {
            return this.sessionFactory.getCurrentSession().find((Class<T>) id.getClass(), id);
        } catch (HibernateException e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public T update(T t) throws Exception {
        try {
            return (T) this.sessionFactory.getCurrentSession().merge(t);
        } catch (HibernateException e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public T findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception {
        try {
            final Query query = this.sessionFactory.getCurrentSession().createNamedQuery(namedQuery);
            query.setParameter(parameterName, value);
            return (T) query.getSingleResult();
        } catch (HibernateException e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public List<T> findAll(T t) throws Exception {
        try {
            final StringBuffer queryString = new StringBuffer("SELECT o from ");
            queryString.append(t.getClass().getSimpleName()).append(" o ");
            final Query query = this.sessionFactory.getCurrentSession().createQuery(queryString.toString());
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public List<T> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception {
        try {
            final Query query = this.sessionFactory.getCurrentSession().createNamedQuery(namedQuery);
            int a = 0;
            for(String key: parameters) {
                query.setParameter(key, values[a]);
                a++;
            }
            return query.getResultList();
        } catch (HibernateException e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public List<T> findByNativeQuery(String nativeQuery) throws Exception {
        try {
            final Query query = this.sessionFactory.getCurrentSession().createNativeQuery(nativeQuery);
            return query.getResultList();
        } catch (HibernateException e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }

    @Override
    public List<T> findAllWithParameter(T t, String parameterName, Object parameterValue) throws Exception {
        try {
            final StringBuffer queryString = new StringBuffer("SELECT o from ");
            queryString.append(t.getClass().getSimpleName()).append(" o ");
            queryString.append("where o.").append(parameterName).append(" = :").append(parameterName);
            final Query query = this.sessionFactory.getCurrentSession().createQuery(queryString.toString());
            query.setParameter(parameterName, parameterValue);
            return query.getResultList();
        } catch (HibernateException e) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, String.format("Error on query execution %s", e));
            throw new Exception(String.format("Error on query execution %s", e));
        }
    }
}
