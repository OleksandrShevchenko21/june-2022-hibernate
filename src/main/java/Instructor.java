import lombok.*;

//    annotate the class as an entity and map to db table
//    define the fields
//    annotate the fields with db columns names
//** set up mapping to InstructorDetail entity
//    create constructors
//    generate getter/setters methods
//    generate to String() methods

import javax.persistence.*;

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
//    @Column(name="id")
//    private int id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id", referencedColumnName = "id")
    private InstructorDetail instructorDetail;

}
