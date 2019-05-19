/**
 * Development and Technologies Solutions S.A.S
 * ApplicationContextUtils.java
 * 
 * Derechos de Autor 2015 D&TS © 
 * Todos los Derechos Reservados.
 */

package com.dyts.conexiatest;

import java.io.Serializable;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Carlos Maturana <cmaturana@dytssolutions.com>
 * @version 1.0
 * @created 27/10/2015 05:12:41 PM
 */
public class ApplicationContextUtils implements ApplicationContextAware, Serializable {
    
    private static ApplicationContext applicationContext;
    private static ApplicationContextUtils applicationContextUtils;

    public static ApplicationContextUtils getInstance() {
        if (applicationContextUtils == null) {
            synchronized (ApplicationContextUtils.class) {
                if (applicationContextUtils == null) {
                    applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
                    applicationContextUtils = new ApplicationContextUtils();
                }
            }
        }
        return applicationContextUtils;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    protected Object readResolve() {
        return getInstance();
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        ApplicationContextUtils.applicationContext = ac;
    }
}
