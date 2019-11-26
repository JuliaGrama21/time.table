package timetable.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import timetable.model.Subject;
import timetable.util.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class HibernateSubjectDao implements ISubjectDao {

    public boolean addSubject(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(subject);
        tx1.commit();
        session.close();
        return true;
    }

    public boolean updateSubject(Subject subject) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(subject);
        tx1.commit();
        session.close();
        return true;
    }

    public boolean deleteSubject(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Subject subject = session.get(Subject.class, id);
        session.delete(subject);
        tx1.commit();
        session.close();
        return true;
    }

    public Subject findSubjectById(Long id) {
        Subject subject = new Subject();
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Subject> query = builder.createQuery(Subject.class);
            Root<Subject> root = query.from(Subject.class);
            query.select(root).where(builder.equal(root.get("id"), id));
            Query<Subject> q = session.createQuery(query);
            subject = q.getSingleResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return subject;
    }

    public List<Subject> getAllSubjects() {
        List<Subject> subjects = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Subject> query = builder.createQuery(Subject.class);
            Root<Subject> root = query.from(Subject.class);
            query.select(root);
            Query<Subject> q = session.createQuery(query);
            subjects = q.getResultList();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return subjects;
    }
}
