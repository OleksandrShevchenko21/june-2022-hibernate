
//    annotate the class as an entity and map to db table
//    define the fields
//    annotate the fields with db columns names
//    create constructors
//    generate getter/setters methods
//    generate to String() methods

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
