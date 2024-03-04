package org.vu.pskdemo.jpa.usecases;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.vu.pskdemo.jpa.persistence.StudentDao;

@ApplicationScoped
public class StudentService {
    @Inject
    private StudentDao studentDao;
}
