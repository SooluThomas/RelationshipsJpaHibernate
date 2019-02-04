package com.SooluThomas.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
    @Id
    //@GeneratedValue
    private Long id;

    private String reviewRate;
    private String description;

    @ManyToOne
    private Course course;

    protected Review() {
    }

//    public Review(String reviewRate, String description) {
//        this.reviewRate = reviewRate;
//        this.description = description;
//    }

    public Review(Long id, String reviewRate, String description) {
        this.id = id;
        this.reviewRate = reviewRate;
        this.description = description;
    }

    public Review(Long id, String reviewRate, String description, Course course) {
        this.id = id;
        this.reviewRate = reviewRate;
        this.description = description;
        this.course = course;
    }

    public String getRating() {
        return reviewRate;
    }

    public void setRating(String rating){
        this.reviewRate = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewRate='" + reviewRate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
