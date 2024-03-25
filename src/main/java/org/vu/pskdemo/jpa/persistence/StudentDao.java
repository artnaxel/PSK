package org.vu.pskdemo.jpa.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.vu.pskdemo.jpa.entities.Student;

@ApplicationScoped
public class StudentDao {

    @Inject
    private EntityManager em;

    public void persist(Student student){
        this.em.persist(student);
    }

    public Student findOne(Long id){
        return em.find(Student.class, id);
    }

    public Student update(Student student) {
        return em.merge(student);
    }
}