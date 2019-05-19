/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dyts.conexiatest.service;

import com.dyts.conexiatest.bl.serviceimpl.ClienteService;
import com.dyts.conexiatest.persistence.entities.Cliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 *
 * @author CarlosMatt
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:WEB-INF/spring-config.xml"})
public class ClienteServiceTest {
    
    Cliente t;
    @Autowired
    private ClienteService service;
    
    public ClienteServiceTest() {
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
        t.setNombre("Carlos Alberto");
        t.setApellido1("Maturana");
        t.setApellido2("Mulett");
        t.setObservaciones("prueba de dao y serviceimpl");
    }
    
    @After
    public void tearDown() {
    }
    
    //@Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Object expResult = null;
        Object result = service.create(t);
        assertNotEquals(expResult, result);
    }
    
}
