package com.SooluThomas.jpa.hibernate.demo.repository;

import com.SooluThomas.jpa.hibernate.demo.entity.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
@Repository
public class PassportRepository {
    @Autowired
    EntityManager entityManager;

    public Passport findById(long id){
        return entityManager.find(Passport.class, id);
    }

    public Passport save(Passport course){
        Passport add = entityManager.merge(course);
        return add;
    }

    public void deleteById(long id){
        Passport del = findById(id);
        entityManager.remove(del);
    }

    public void playWithEntityManager(){
        save(new Passport("F3003333"));
        save(new Passport("A4204567"));
        save(new Passport("V0099332"));
    }
}
