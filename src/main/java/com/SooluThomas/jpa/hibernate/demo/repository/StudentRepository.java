package com.SooluThomas.jpa.hibernate.demo.repository;

import com.SooluThomas.jpa.hibernate.demo.entity.Passport;
import com.SooluThomas.jpa.hibernate.demo.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Student findAllById(Long id){
        return entityManager.find(Student.class, id);
    }

    public Student insert(Student student){
        Student add = entityManager.merge(student);
        return add;
    }

    public void deleteById(Long id){
        Student toRemove = findAllById(id);
        entityManager.remove(toRemove);
    }

    //Updated this because Student table was mapped to Passport table and to enter passport details as well
    public void insertInitialValues(){
        Passport passport1 = new Passport("A4204567");
        entityManager.persist(passport1);

        Student student1 = new Student("Ammu");
        student1.setPassport(passport1);
        entityManager.persist(student1);

        Passport passport2 = new Passport("F3003333");
        entityManager.persist(passport2);

        Student student2 = new Student("Vava");
        student2.setPassport(passport2);
        entityManager.persist(student2);

        Passport passport3 = new Passport("V0099332");
        entityManager.persist(passport3);

        Student student3 = new Student("Unni");
        student3.setPassport(passport3);
        entityManager.persist(student3);
    }

    public void saveStudentWithPassport(){
        Passport passport = new Passport("T3456678");
        entityManager.persist(passport);

        Student student = new Student("Milli");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    //This function can retrieve Passport details of a student thru StudentRepository or Service Layer
    //@Transactional is added to extend the servive for this entire method rather than each line.
    //if @Transactional is not added then the student.getPassport will get an Exception
    //I can also change the name of Student
    //the program myt end up getting error if there is no student with id= 13. It depends which hibernate sequence is updated.
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = entityManager.find(Student.class, 13L);
        logger.info("student 11 -> {}", student);
        logger.info("passport -> {}", student.getPassport());
        Passport passport = student.getPassport();
        student.setName("Soonu Thomas");
    }

    public void retrievePassportAndAssociatedStudent(){
        Passport passport = entityManager.find(Passport.class, 12L);
        logger.info("Passport 12l -> {}", passport);
        logger.info("Passport -> {}", passport.getStudent());

    }
}
