package com.SooluThomas.jpa.hibernate.demo.repository;

import com.SooluThomas.jpa.hibernate.demo.entity.Course;
import com.SooluThomas.jpa.hibernate.demo.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@Repository
public class CourseRepository {
    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private LocalDateTime time = LocalDateTime.now();

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

    public void addHardCodedReviewsForCourse(){
        //getting course
        Course course = findById(2001L);
        logger.info("course.getReviews() -> {}", course.getReview());

        //adding reviews
        Review review1 = new Review(1001L, "3", "Good Teaching");
        Review review2 = new Review(1002L,"4", "Really satisfied");

        //setting the relationship
        course.addReviews(review1);
        review1.setCourse(course);

        course.addReviews(review2);
        review2.setCourse(course);

        //adding to database
        entityManager.persist(review1);
        entityManager.persist(review2);
    }

    public void addReviewsForCourses(Long id, List<Review> reviews){
        Course course = findById(id);
        //logger.info("Course.getReviews() -> {}", course.getReview());

        for (Review review : reviews){
            course.addReviews(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }

}
