package com.terehov.soap.service;

import com.terehov.soap.model.*;
import com.terehov.soap.util.HibernateUtil;
import com.terehov.soap.Constants;

// для соединения по soap класса и его методов
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.terehov.soap.service.TeamService")
public class TeamServiceImpl implements TeamService {

    private static final Logger logger = LogManager.getLogger(TeamService.class);

    @Override
    @WebMethod
    public StudentsEntity insertUser(StudentsEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            entity = (StudentsEntity) session.merge(entity);
            transaction.commit();
            logger.info(entity.getClass().getSimpleName() + Constants.ADDED);
            return entity;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    @WebMethod
    public StudentsEntity getUserById(Integer id) {
        Transaction transaction = null;
        StudentsEntity users;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            users = session.get(StudentsEntity.class, id);
            transaction.commit();
            logger.info(StudentsEntity.class.getSimpleName() + Constants.FOUND);

            return users;

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public GroupsEntity getGroupById(Integer id) {
        Transaction transaction = null;
        GroupsEntity users;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            users = session.get(GroupsEntity.class, id);
            transaction.commit();
            logger.info(StudentsEntity.class.getSimpleName() + Constants.FOUND);

            return users;

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public List<StudentsEntity> getListUsersByListOfId(List<Integer> listOfId) {
        Transaction transaction = null;
        StudentsEntity users;
        List<StudentsEntity> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();

            for(Integer id : listOfId) {
                users = session.get(StudentsEntity.class, id);
                list.add(users);
            }

            transaction.commit();
            logger.info(StudentsEntity.class.getSimpleName() + Constants.FOUND);

            return list;

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @WebMethod
    @Override
    public List<StudentsEntity> selectAllUsers() {
        Transaction transaction;
        List<StudentsEntity> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("from StudentsEntity ", StudentsEntity.class).list();
            transaction.commit();
            logger.info("Records were selected");
            return list;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            return list;
        }
    }

    @WebMethod
    @Override
    public boolean updateUser(StudentsEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            logger.info(entity.getClass().getSimpleName() + Constants.UPDATED);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @WebMethod
    @Override
    public boolean deleteUser(int id) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.delete(new StudentsEntity());
            transaction.commit();
            logger.info(StudentsEntity.class.getSimpleName() + id + Constants.DELETED);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    Session getSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
}
