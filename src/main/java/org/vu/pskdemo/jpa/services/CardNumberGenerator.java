package org.vu.pskdemo.jpa.services;

import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class CardNumberGenerator implements Serializable {

    public Integer generateCardNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        Integer generatedCardNumber = new Random().nextInt(1000000);
        return generatedCardNumber;
    }
}