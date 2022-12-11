import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
                        .getMetadataBuilder()
                        .build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();


        //work space

        session.beginTransaction();
//
//        session.save(new Instructor("Max","Maximenko",new InstructorDetail("junior","@strongMax")));
//
//
//
//        session.getTransaction().commit();


        /*end dont forget*/
        session.close();
        sessionFactory.close();

    }

}
