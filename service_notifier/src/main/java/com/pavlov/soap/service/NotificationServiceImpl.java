package com.pavlov.soap.service;

import com.pavlov.soap.Constants;
import com.pavlov.soap.model.ServiceNotifierEntity;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import com.pavlov.soap.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.jws.WebMethod;
import javax.jws.WebService;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.pavlov.soap.service.NotificationService")
public class NotificationServiceImpl implements NotificationService {

    private static final Logger logger = LogManager.getLogger(NotificationServiceImpl.class);

    //Create
    @Override
    @WebMethod
    public Boolean addUser(Integer userId) {
        Transaction transaction;
        ServiceNotifierEntity entity = new ServiceNotifierEntity(0, userId);
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    //Read
    @Override
    public ServiceNotifierEntity getEntityById(Integer id) {
        Transaction transaction = null;
        ServiceNotifierEntity serviceNotifierEntity;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            serviceNotifierEntity = session.get(ServiceNotifierEntity.class, id);
            transaction.commit();
            logger.info(ServiceNotifierEntity.class.getSimpleName() + Constants.ADDED);
            return serviceNotifierEntity;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }
    @Override
    public List<ServiceNotifierEntity> getEntityByMiss() {
        List<ServiceNotifierEntity> students;
        Transaction transaction = null;
        ServiceNotifierEntity serviceNotifierEntity;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM ServiceNotifierEntity WHERE countOfMiss <= 2");
            students = query.list();
            transaction.commit();
            logger.info(ServiceNotifierEntity.class.getSimpleName() + Constants.ADDED);
            return students;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }
    @Override
    public List<ServiceNotifierEntity> getEntityByMissThreeDays() {
        List<ServiceNotifierEntity> students;
        Transaction transaction = null;
        ServiceNotifierEntity serviceNotifierEntity;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM ServiceNotifierEntity WHERE countOfMiss = 3");
            students = query.list();
            transaction.commit();
            logger.info(ServiceNotifierEntity.class.getSimpleName() + Constants.ADDED);
            return students;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }
    @Override
    public List<ServiceNotifierEntity> getAll() {
        Transaction transaction;
        List<ServiceNotifierEntity> studentList = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            studentList = session.createQuery("from ServiceNotifierEntity ", ServiceNotifierEntity.class).list();
            transaction.commit();
            return studentList;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return studentList;
        }

    }

    //Update
    @Override
    @WebMethod
    public Boolean trackingOn(Integer userId) {
        Transaction transaction;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update ServiceNotifierEntity set countOfMiss = 0 WHERE studentId = :userId");
            query.setParameter("userId", userId);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }
    @Override
    public Boolean trackingOff() {
        Transaction transaction;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.createQuery("update ServiceNotifierEntity set countOfMiss = countOfMiss + 1").executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    //Delete
    @WebMethod
    @Override
    public Boolean deleteUser(Integer userId){
        Transaction transaction;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE ServiceNotifierEntity WHERE studentId = :studentId");
            query.setParameter("studentId", userId);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return false;
        }
    }

    Session getSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
}
