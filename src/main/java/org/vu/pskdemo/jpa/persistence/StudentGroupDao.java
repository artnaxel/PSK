package org.vu.pskdemo.jpa.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    public List<StudentGroup> findGroupsByNames(List<String> groupNames) {
        TypedQuery<StudentGroup> query = em.createQuery("SELECT g FROM StudentGroup g WHERE g.title IN :groupNames", StudentGroup.class);
        query.setParameter("groupNames", groupNames);
        return query.getResultList();
    }

    public StudentGroup findByName(String name) {
        TypedQuery<StudentGroup> query = em.createQuery("SELECT g FROM StudentGroup g WHERE g.title = :name", StudentGroup.class);
        query.setParameter("name", name);
        List<StudentGroup> groups = query.getResultList();
        return groups.isEmpty() ? null : groups.get(0);
    }
}
