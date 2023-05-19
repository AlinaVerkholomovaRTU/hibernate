package main.java.org.example.inheritance.table_per_class;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="legal_entity")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="amount", column=@Column(name="amount"))
})
public class LegalEntity extends Customer {

    @Column(name="register_number")
    private int registerNumber;

    public int getRegisterNumber() {
        return registerNumber;
    }

    public LegalEntity() {
    }

    public void setRegisterNumber(int registerNumber) {
        this.registerNumber = registerNumber;
    }

}
