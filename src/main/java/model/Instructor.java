package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name= "Instructor")
@ToString
public class Instructor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id", referencedColumnName = "id")
    private InstructorDetail instructorDetail;

    @OneToMany(
            cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "instuctor_course",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course>courses;



    public Instructor(String name, String surname, InstructorDetail instructorDetail) {
        this.name = name;
        this.surname = surname;
        this.instructorDetail = instructorDetail;
    }
    public Instructor(String name, String surname, InstructorDetail instructorDetail, List<Course> courses) {
        this.name = name;
        this.surname = surname;
        this.instructorDetail = instructorDetail;
        this.courses = courses;
    }


}