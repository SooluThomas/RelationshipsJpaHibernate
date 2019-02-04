package com.SooluThomas.jpa.hibernate.demo;


import com.SooluThomas.jpa.hibernate.demo.entity.Review;
import com.SooluThomas.jpa.hibernate.demo.repository.CourseRepository;
import com.SooluThomas.jpa.hibernate.demo.repository.PassportRepository;
import com.SooluThomas.jpa.hibernate.demo.repository.ReviewRepository;
import com.SooluThomas.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private PassportRepository passportRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private StudentRepository studentRepository;



	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private LocalDateTime time = LocalDateTime.now();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//courseRepository.playWithEntityManager();
		reviewRepository.playWithEntityManager();

		//courseRepository.addHardCodedReviewsForCourse();

		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review(1004L,"3", "Good Teaching"));
		reviews.add(new Review(1005L,"4", "Really satisfied"));
		courseRepository.addReviewsForCourses(2002L, reviews);




		studentRepository.insertInitialValues();
		studentRepository.saveStudentWithPassport();

		//studentRepository.retrieveStudentAndPassportDetails();


//		Course course= repository.findById(1);
//		logger.info("{}", course);

//		repository.deleteById(1);
//		logger.info("Deleting id 1");

	}
}

