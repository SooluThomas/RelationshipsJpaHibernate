package com.SooluThomas.jpa.hibernate.demo.repository;

import com.SooluThomas.jpa.hibernate.demo.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class CourseRepository {
    @Autowired
    EntityManager entityManager;

    public Course findById(long id){
        return entityManager.find(Course.class, id);
    }

    public Course save(Course course){
        Course add = entityManager.merge(course);
        return add;
    }

    public void deleteById(long id){
        Course del = findById(id);
        entityManager.remove(del);
    }
}
