package timetable.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import timetable.model.Lesson;
import timetable.util.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class HibernateLessonDao implements ILessonDao {

    public boolean addLesson(Lesson lesson) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(lesson);
        tx1.commit();
        session.close();
        return true;
    }

    public boolean updateLesson(Lesson lesson) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(lesson);
        tx1.commit();
        session.close();
        return true;
    }

    public boolean deleteLesson(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Lesson lesson = session.get(Lesson.class, id);
        session.delete(lesson);
        tx1.commit();
        session.close();
        return true;
    }

    public Lesson findLessonById(Long id) {
        Lesson lesson = new Lesson();
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Lesson> query = builder.createQuery(Lesson.class);
            Root<Lesson> root = query.from(Lesson.class);
            query.select(root).where(builder.equal(root.get("id"), id));
            Query<Lesson> q = session.createQuery(query);
            lesson = q.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lesson;
    }

    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Lesson> query = builder.createQuery(Lesson.class);
            Root<Lesson> root = query.from(Lesson.class);
            query.select(root);
            Query<Lesson> q = session.createQuery(query);
            lessons = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return lessons;
    }
}
