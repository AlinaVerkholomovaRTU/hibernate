package org.example.relationships.many_to_one.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="school")
public class SchoolBi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="school_id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="city")
    private String city;

    @OneToMany(mappedBy = "school",
               cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<TeacherBi> teachers;

    public SchoolBi() {
    }

    public SchoolBi(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<TeacherBi> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherBi> students) {
        this.teachers = students;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
