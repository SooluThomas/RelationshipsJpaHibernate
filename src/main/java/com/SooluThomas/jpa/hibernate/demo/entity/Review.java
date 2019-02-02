package com.SooluThomas.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    private String reviewRate;
    private String description;

    protected Review() {
    }

    public Review(String rating, String description) {
        this.reviewRate = rating;
        this.description = description;
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

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewRate='" + reviewRate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
