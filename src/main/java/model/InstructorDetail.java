package model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "instructor_detail")
@ToString
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "quality_level")
    private String level;
    @Column(name = "network")
    private String instagram;

    public InstructorDetail(String level, String instagram) {

        this.level = level;
        this.instagram = instagram;
    }
}