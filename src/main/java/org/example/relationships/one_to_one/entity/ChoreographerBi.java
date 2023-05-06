package org.example.relationships.one_to_one.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="choreographer")
public class ChoreographerBi{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="details_id")
    private ChoreographerDetailsBi choreographerDetailsBi;

    public ChoreographerBi() {

    }

    public ChoreographerBi(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ChoreographerDetailsBi getChoreographerDetails() {
        return choreographerDetailsBi;
    }

    public void setChoreographerDetailsBi(ChoreographerDetailsBi choreographerDetailsBi) {
        this.choreographerDetailsBi = choreographerDetailsBi;
    }

    @Override
    public String toString() {
        return "Choreographer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ChoreographerDetails=" + choreographerDetailsBi +
                '}';
    }
}
