package main.java.org.example.inheritance.table_per_subclass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="legal_entity")
@PrimaryKeyJoinColumn(name="ID")
public class LegalEntity extends Customer {

    @Column(name="register_number")
    private int registerNumber;

    public int getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }
}
