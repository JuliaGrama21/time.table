package timetable.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import timetable.model.*;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.sfg.xml");
                configuration.addAnnotatedClass(Teacher.class);
                configuration.addAnnotatedClass(Group.class);
                configuration.addAnnotatedClass(Room.class);
                configuration.addAnnotatedClass(Subject.class);
                configuration.addAnnotatedClass(Lesson.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Wrong!" + e);
            }
        }
        return sessionFactory;
    }
}
