package com.SooluThomas.jpa.hibernate.demo.repository;

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

    public void playWithEntityManager(){
        insert(new Review("5", "Super!"));
        insert(new Review("3", "Good Try"));
        insert(new Review("1", "I won't recommend"));
    }

}
