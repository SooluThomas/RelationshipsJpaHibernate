package com.SooluThomas.jpa.hibernate.demo.entity;

import javax.persistence.*;

@Entity
public class Passport {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY) //mappedBy = "Student.class")
    private Student student;

    public Passport(){}

    public Passport(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void getId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
