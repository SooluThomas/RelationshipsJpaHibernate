package com.SooluThomas.jpa.hibernate.demo.entity;

import javax.persistence.*;

@Entity
public class Passport {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    //mappedBy uses the object of the passport class in the owning side
    //and is used in the non-owning side of the relationship
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
