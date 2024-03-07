package org.vu.pskdemo.jpa.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.vu.pskdemo.jpa.entities.StudentGroup;

import java.util.List;

@ApplicationScoped
public class StudentGroupDao {
    @Inject
    private EntityManager em;

    public void persist(StudentGroup studentGroup){
        this.em.persist(studentGroup);
    }

    public List<StudentGroup> loadAll() {
        return em.createNamedQuery("StudentGroup.findAll", StudentGroup.class).getResultList();
    }

    public StudentGroup findOne(Long id){
        return em.find(StudentGroup.class, id);
    }

    public StudentGroup update(StudentGroup studentGroup) {
        return em.merge(studentGroup);
    }
}
