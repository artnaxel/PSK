package org.vu.pskdemo.jpa.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.vu.pskdemo.jpa.entities.Course;

@ApplicationScoped
public class CourseDao {
    @Inject
    private EntityManager em;

    public void persist(Course course){
        this.em.persist(course);
    }

    public Course findOne(Long id){
        return em.find(Course.class, id);
    }

    public Course update(Course course) {
        return em.merge(course);
    }
}
