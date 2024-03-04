package org.vu.pskdemo.jpa.persistence;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.vu.pskdemo.jpa.entities.StudentGroup;

public class StudentGroupDao {
    @Inject
    private EntityManager em;

    public void persist(StudentGroup studentGroup){
        this.em.persist(studentGroup);
    }

    public StudentGroup findOne(Long id){
        return em.find(StudentGroup.class, id);
    }

    public StudentGroup update(StudentGroup studentGroup) {
        return em.merge(studentGroup);
    }
}
