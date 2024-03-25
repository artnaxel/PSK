package org.vu.pskdemo.jpa.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.SynchronizationType;

@ApplicationScoped
public class Resources {
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Produces
    // identifies producer method that creates an object that can be injected elsewhere
    @Default
    // produced EntityManager is the default one to be injected
    @RequestScoped
    // EntityManager instance will be created for each HTTP request
    private EntityManager createJTAEntityManager() {
        // EntityManager will automatically join the JTA transaction.
        return emf.createEntityManager(SynchronizationType.SYNCHRONIZED);
    }

    private void closeJTAEntityManager(@Disposes @Default EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}
