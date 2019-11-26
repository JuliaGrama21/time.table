package timetable.util;

import org.hibernate.Session;

public class SessionTest {

    public static void main(String[] args) {


   Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
       session.close();
    }
}
