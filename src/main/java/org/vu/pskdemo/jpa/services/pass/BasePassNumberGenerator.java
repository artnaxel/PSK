package org.vu.pskdemo.jpa.services.pass;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;

@ApplicationScoped
public class BasePassNumberGenerator implements PassNumberGenerator {

    @Override
    public Integer generatePassNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Random().nextInt(1000000);
    }
}
