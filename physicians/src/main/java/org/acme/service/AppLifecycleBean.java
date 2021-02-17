package org.acme.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.jboss.logging.Logger;

@ApplicationScoped
public class AppLifecycleBean {

    private static final Logger LOGGER = Logger.getLogger("lifecyle");

    void onStart(@Observes StartupEvent ev) {               
        LOGGER.infov("Quarkus lifecyle: ----> The application is starting <-----");
    }

    void onStop(@Observes ShutdownEvent ev) {               
        LOGGER.info("Quarkus lifecyle: ----> The application is stopping <-----");
    }

}