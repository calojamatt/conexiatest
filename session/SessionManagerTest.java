package com.dyts.conexiatest.session;

import com.dyts.conexiatest.persistence.session.SessionManager;
import javax.persistence.EntityManager;
import org.hibernate.SessionFactory;
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
public class SessionManagerTest {
    
    public SessionManagerTest() {
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
     * Test of getSessionFactory method, of class SessionManager.
     */
    @Test
    public void testGetSessionFactory() {
        System.out.println("Message getSessionFactory");
        SessionFactory expResult = null;
        SessionFactory result = SessionManager.getSessionFactory();
        //EntityManager result = SessionManager.getEntityManager();
        assertNotEquals(expResult, result);
    }
    
}
