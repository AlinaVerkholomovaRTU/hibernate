package main.java.org.example.inheritance.table_per_subclass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="individual")
@PrimaryKeyJoinColumn(name="ID")
public class Individual extends Customer {

    @Column(name="name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
