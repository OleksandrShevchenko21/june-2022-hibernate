import model.Course;
import model.Instructor;
import model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")
                        .build();

        Metadata metadata =
                new MetadataSources(serviceRegistry)
                        .addAnnotatedClass(Instructor.class) /*!!!!!!! register class*/
                        .addAnnotatedClass(InstructorDetail.class) /*!!!!!!! register class*/
                        .addAnnotatedClass(Course.class) /*!!!!!!! register class*/
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();


        //work space

        session.beginTransaction();

        Course Stretching = new Course("Stretching");
        Course Tennis = new Course("Tennis");
        Course Jumping = new Course("Jumping");
        Course Crossfit = new Course("Crossfit");
        Course Gym = new Course("Gym");

        Instructor instructor1 = new Instructor("Ivan","Ivanenko",
                new InstructorDetail("junior","@strongMax"),
                (Arrays.asList (Stretching,Crossfit)));


        Instructor instructor2 = new Instructor("Petro","Petrenyk",
                new InstructorDetail("middle","@strongPetro"),
        (Arrays.asList (Tennis,Jumping)));


        Instructor instructor3 = new Instructor("Vasyl","Vasulunyk",
                new InstructorDetail("senior","@strongVasyl"),
                (Arrays.asList (Gym,Crossfit)));


        session.save(instructor1);
        session.save(instructor2);
        session.save(instructor3);


        session.getTransaction().commit();


        /*end dont forget*/
        session.close();
        sessionFactory.close();

    }

}