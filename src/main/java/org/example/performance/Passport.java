package org.example.performance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="passport_number")
    private String passport_number;

    @Column(name="passport_type")
    private String type;

    public Passport() {
    }

    public Passport(String number, String type) {
        this.passport_number = number;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return passport_number;
    }

    public void setNumber(String passport_number) {
        this.passport_number = passport_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + passport_number + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
