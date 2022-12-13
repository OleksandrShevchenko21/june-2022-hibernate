import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
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
                        .addAnnotatedClass(Review.class) /*!!!!!!! register class*/
                        .addAnnotatedClass(Student.class) /*!!!!!!! register class*/
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();


        //work space

        session.beginTransaction();

        Student student1 = new Student("Vlad");
        Student student2 = new Student("Oleg");
        Student student3 = new Student("Masha");
        Student student4 = new Student("Vika");

        Review review1 = new Review("Good");
        Review review2 = new Review("not Good");
        Review review3 = new Review("Bad");
        Review review4 = new Review("not Bad");
        Review review5 = new Review("very nice course");
        Review review6 = new Review("very bad course");
        Review review7 = new Review("I like it");
        Review review8 = new Review("need more");
        Review review9 = new Review("wow");
        Review review10 = new Review("super");

        Course Stretching = new Course(
                "Stretching",
                Arrays.asList(review1, review2),
                Arrays.asList(student1, student2));
        Course Tennis = new Course(
                "Tennis",
                Arrays.asList(review3,review4),
                Arrays.asList(student3, student2));
        Course Jumping = new Course(
                "Jumping",
                Arrays.asList(review5,review6),
                Arrays.asList(student1, student4));
        Course Crossfit = new Course(
                "Crossfit",
                (Arrays.asList(review7,review8)),
                Arrays.asList(student4, student3));
        Course Gym = new Course(
                "Gym",
                (Arrays.asList(review9,review10)),
                Arrays.asList(student4, student2));

        Instructor instructor1 = new Instructor("Ivan","Ivanenko",
                new InstructorDetail("junior","@strongMax"),
                (Arrays.asList (Stretching,Crossfit)));


        Instructor instructor2 = new Instructor("Petro","Petrenyk",
                new InstructorDetail("middle","@strongPetro"),
        (Arrays.asList (Tennis,Jumping)));


        Instructor instructor3 = new Instructor("Vasyl","Vasulunyk",
                new InstructorDetail("senior","@strongVasyl"),
                (Arrays.asList (Gym)));


        session.save(instructor1);
        session.save(instructor2);
        session.save(instructor3);


        session.getTransaction().commit();



        session.close();
        sessionFactory.close();

    }

}