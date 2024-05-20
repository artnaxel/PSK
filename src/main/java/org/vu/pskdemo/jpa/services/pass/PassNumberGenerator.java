package org.vu.pskdemo.jpa.services.pass;

import jakarta.transaction.Transactional;

public interface PassNumberGenerator {
    @Transactional
    Integer generatePassNumber();
}
