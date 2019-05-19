package com.dyts.conexiatest.controller;

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
public class ClientesControllerTest {
    
    public ClientesControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createCliente method, of class ClientesController.
     */
    //@Test
    public void testCreateCliente() {
        System.out.println("createCliente");
        ClientesController instance = new ClientesController();
        instance.setIdCliente(73204915);
        instance.setNombres("Carlos Alberto");
        instance.setApellido1("Maturana");
        instance.setApellido2("Mulett");
        instance.setObservaciones("Prueba almacenamiento");
        String expResult = "index.xhtml?faces-redirect=true";
        String result = instance.createClient();
        assertEquals(expResult, result);
    }
    
}
