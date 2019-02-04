package com.SooluThomas.jpa.hibernate.demo.repository;

import com.SooluThomas.jpa.hibernate.demo.entity.Course;
import com.SooluThomas.jpa.hibernate.demo.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Repository
@Transactional
public class ReviewRepository {
    @Autowired
    EntityManager em;

    public Review findById(Long id){ return em.find(Review.class, id);}

    public Review insert(Review review) {
        Review add = em.merge(review);
        return add;
    }

    @Transactional
    public void playWithEntityManager(){
        Course course1 = new Course("JPA in 50 Steps - Updated");
        em.persist(course1);
        Review review1 = new Review("5", "Super!", course1);
        em.persist(review1);

        Course course2 = new Course("Web Service in 100 Steps");
        em.persist(course2);
        Review review2 = new Review("3", "Good Try", course2);
        em.persist(review2);

        Course course3 = new Course("Introduction to Java");
        em.persist(course3);
        Review review3 = new Review("1", "I won't recommend", course3);
        em.persist(review3);
    }

}
