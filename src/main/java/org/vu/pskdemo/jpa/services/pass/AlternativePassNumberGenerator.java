package org.vu.pskdemo.jpa.services.pass;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;

@ApplicationScoped
@Alternative
public class AlternativePassNumberGenerator implements PassNumberGenerator {
    private int lastGenerated = 0;

    @Override
    public Integer generatePassNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lastGenerated += 1;
        return lastGenerated;
    }
}
