/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * ClienteService.java
 *
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest.bl.serviceimpl;

import com.dyts.conexiatest.bl.iservice.IClienteService;
import com.dyts.conexiatest.persistence.dao.GenericDao;
import com.dyts.conexiatest.persistence.dto.InformeCamareroDTO;
import com.dyts.conexiatest.persistence.dto.InformeClienteDTO;
import com.dyts.conexiatest.persistence.entities.Cliente;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 4:08:18 a.m.
 */
@Service
public class ClienteService implements IClienteService<Cliente> {

    GenericDao<Cliente> genericDao;
    private EntityManager entityManager;

    public GenericDao getGenericDao() {
        return genericDao;
    }

    public void setGenericDao(GenericDao genericDao) {
        this.genericDao = genericDao;
        entityManager = genericDao.getSessionFactory().createEntityManager();
    }

    @Override
    public Cliente create(Cliente cliente) throws Exception {
        return (Cliente) genericDao.create(cliente);
    }

    @Override
    public void delete(Cliente id) throws Exception {

    }

    @Override
    public Cliente find(Cliente id) throws Exception {
        return (Cliente) genericDao.find(id);
    }

    @Override
    public Cliente update(Cliente cliente) throws Exception {
        return (Cliente) genericDao.update(cliente);
    }

    @Override
    public Cliente findOneByNamedQuery(String namedQuery, String parameterName, Object value) throws Exception {
        return (Cliente) genericDao.findOneByNamedQuery(namedQuery, parameterName, value);
    }

    @Override
    public List<Cliente> findAll() throws Exception {
        return genericDao.findAll(new Cliente());
    }

    @Override
    public List<Cliente> findAllWithParameter(String parameterName, Object parameterValue) throws Exception {
        return null;
    }

    @Override
    public List<Cliente> findByNamedQuery(String namedQuery, String[] parameters, Object[] values) throws Exception {
        return null;
    }

    @Override
    public List<Cliente> findByNativeQuery(String nativeQuery) throws Exception {
        return null;
    }
}
