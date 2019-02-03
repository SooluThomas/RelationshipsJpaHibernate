package com.SooluThomas.jpa.hibernate.demo;

import com.SooluThomas.jpa.hibernate.demo.entity.Course;
import com.SooluThomas.jpa.hibernate.demo.entity.Passport;
import com.SooluThomas.jpa.hibernate.demo.entity.Review;
import com.SooluThomas.jpa.hibernate.demo.repository.CourseRepository;
import com.SooluThomas.jpa.hibernate.demo.repository.PassportRepository;
import com.SooluThomas.jpa.hibernate.demo.repository.ReviewRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository repository;

	@Autowired
	private PassportRepository passportRepository;

	@Autowired
	private ReviewRepository reviewRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Inserting -> {}", repository.save(new Course("Introduction to Spring Boot")));
		logger.info("Inserting -> {}", repository.save(new Course("Introduction to Java")));
		logger.info("Inserting -> {}", repository.save(new Course("Introduction to Bootstrap")));

		logger.info("Inserting -> {}", passportRepository.save(new Passport("F3003333")));
		logger.info("Inserting -> {}", passportRepository.save(new Passport("A4204567")));
		logger.info("Inserting -> {}", passportRepository.save(new Passport("V0099332")));

		logger.info("Inserting -> {}", reviewRepository.insert(new Review("5", "Super!")));
		logger.info("Inserting -> {}", reviewRepository.insert(new Review("3", "Good Try")));
		logger.info("Inserting -> {}", reviewRepository.insert(new Review("1", "I won't recommend")));


//		Course course= repository.findById(1);
//		logger.info("{}", course);

//		repository.deleteById(1);
//		logger.info("Deleting id 1");

	}
}

