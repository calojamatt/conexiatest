/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyts.conexiatest.dao;

import com.dyts.conexiatest.entities.Cliente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CarlosMatt
 */
public class GenericDaoTest {
    
    Cliente t;
    
    public GenericDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        t = new Cliente();
        //t.setIdCliente(Integer.SIZE);
        t.setNombre("Carlos Alberto");
        t.setApellido1("Maturana");
        t.setApellido2("Mulett");
        t.setObservaciones("prueba de dao y service");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class GenericDao.
     * @throws java.lang.Exception
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        GenericDao instance = new GenericDaoImpl();
        Object expResult = null;
        Object result = instance.create(t);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of delete method, of class GenericDao.
     * @throws java.lang.Exception
     */
    //@Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Object id = null;
        GenericDao instance = new GenericDaoImpl();
        instance.delete(t);
    }

    /**
     * Test of find method, of class GenericDao.
     * @throws java.lang.Exception
     */
    //@Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        GenericDao instance = new GenericDaoImpl();
        Object expResult = null;
        Object result = instance.find(t.getIdCliente());
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class GenericDao.
     * @throws java.lang.Exception
     */
    //@Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Object t = null;
        GenericDao instance = new GenericDaoImpl();
        Object expResult = null;
        Object result = instance.update(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findOneByNamedQuery method, of class GenericDao.
     * @throws java.lang.Exception
     */
    //@Test
    public void testFindOneByNamedQuery() throws Exception {
        System.out.println("findOneByNamedQuery");
        String namedQuery = "";
        String parameterName = "";
        Object value = null;
        GenericDao instance = new GenericDaoImpl();
        Object expResult = null;
        Object result = instance.findOneByNamedQuery(namedQuery, parameterName, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class GenericDao.
     * @throws java.lang.Exception
     */
    //@Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        GenericDao instance = new GenericDaoImpl();
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByNamedQuery method, of class GenericDao.
     * @throws java.lang.Exception
     */
    //@Test
    public void testFindByNamedQuery() throws Exception {
        System.out.println("findByNamedQuery");
        String namedQuery = "";
        String[] parameters = null;
        Object[] values = null;
        GenericDao instance = new GenericDaoImpl();
        List expResult = null;
        List result = instance.findByNamedQuery(namedQuery, parameters, values);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByNativeQuery method, of class GenericDao.
     * @throws java.lang.Exception
     */
    //@Test
    public void testFindByNativeQuery() throws Exception {
        System.out.println("findByNativeQuery");
        String nativeQuery = "";
        GenericDao instance = new GenericDaoImpl();
        List expResult = null;
        List result = instance.findByNativeQuery(nativeQuery);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllWithParameter method, of class GenericDao.
     * @throws java.lang.Exception
     */
    //@Test
    public void testFindAllWithParameter() throws Exception {
        System.out.println("findAllWithParameter");
        String parameterName = "";
        Object parameterValue = null;
        GenericDao instance = new GenericDaoImpl();
        List expResult = null;
        List result = instance.findAllWithParameter(parameterName, parameterValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GenericDaoImpl extends GenericDao<Cliente> {
    }
    
}
