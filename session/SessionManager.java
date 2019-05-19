/**
 * Carlos Alberto Maturana Mulett
 * conexiatest
 * SessionManager.java
 * <p>
 * Derechos de Autor 2019 D&TS ©
 * Todos los Derechos Reservados.
 */
package com.dyts.conexiatest.persistence.session;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 * @author: CarlosMatt
 * @version: 1.0.1
 * @created: 11/05/2019 1:42 AM
 */
public class SessionManager {

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        synchronized (SessionManager.class) {
            if (sessionFactory == null) {
                try {
                    // Create registry
                    registry = new StandardServiceRegistryBuilder().configure().build();

                    // Create MetadataSources
                    MetadataSources sources = new MetadataSources(registry);

                    // Create Metadata
                    Metadata metadata = sources.getMetadataBuilder().build();

                    // Create SessionFactory
                    sessionFactory = metadata.getSessionFactoryBuilder().build();

                } catch (Exception e) {
                    Logger.getLogger(SessionManager.class.getName()).log(Level.SEVERE, String.format("Error al obtener session de base de datos %s", e));
                    if (registry != null) {
                        StandardServiceRegistryBuilder.destroy(registry);
                    }
                }
            }
        }
        return sessionFactory;
    }
    
    public static EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("ConexiatestPU").createEntityManager();
    }
}