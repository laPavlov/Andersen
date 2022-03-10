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
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.terehov.soap.service.TeamService")
public class TeamServiceImpl implements TeamService {

    private static final Logger logger = LogManager.getLogger(TeamService.class);

    @Override
    public Boolean createGroup(String color) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.merge(new GroupEntity(color));
            transaction.commit();
            logger.info(color.getClass().getSimpleName() + Constants.ADDED);
            return true;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public Boolean deleteGroup(Integer idGroup) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query1 = session.createQuery("DELETE UsersInGroupEntity where idGroupEntity =: idGroup");
            query1.setParameter("idGroup", new GroupEntity(idGroup));
            query1.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE GroupEntity where id =: idGroup");
            query.setParameter("idGroup", idGroup);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    @Override
    public Boolean choiceColorForGroup(Integer idGroup, String color) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE GroupEntity set color =: color where id =: idGroup");
            query.setParameter("color", color);
            query.setParameter("idGroup", idGroup);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public Boolean addUserToGroup(Integer idGroup, Integer idUser, String role) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.merge(new UsersInGroupEntity(idGroup, idUser, role));
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public Boolean choiceRoleUserToGroup(Integer idUser, String role) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE UsersInGroupEntity set role =: role where idUserEntity =: idUser");
            query.setParameter("idUser", new UserEntity(idUser));
            query.setParameter("role", role);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public Boolean removeUserFromGroup(Integer idUser) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE UsersInGroupEntity where idUserEntity =: idUser");
            query.setParameter("idUser", new UserEntity(idUser));
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    @WebMethod
    public UserEntity insertUser(UserEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            entity = (UserEntity) session.merge(entity);
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
    public UserEntity getUserById(Integer id) {
        Transaction transaction = null;
        UserEntity users;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            users = session.get(UserEntity.class, id);
            transaction.commit();
            logger.info(UserEntity.class.getSimpleName() + Constants.FOUND);

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
    public UsersInGroupEntity getUserGroup(Integer id) {
        Transaction transaction = null;
        UsersInGroupEntity usersInGroupEntity;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM UsersInGroupEntity where idUserEntity =: idUser");
            usersInGroupEntity = (UsersInGroupEntity) query.setParameter("idUser", new UserEntity(id)).list().get(0);
            transaction.commit();
            logger.info(UserEntity.class.getSimpleName() + Constants.FOUND);

            return usersInGroupEntity;

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public UsersInGroupEntity getAdminGroup(Integer idGroup) {
        Transaction transaction = null;
        UsersInGroupEntity usersInGroupEntity;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM UsersInGroupEntity where idGroupEntity =: idGroup and role = 'ADMIN'");
            usersInGroupEntity = (UsersInGroupEntity) query.setParameter("idGroup", new GroupEntity(idGroup)).list().get(0);
            transaction.commit();
            logger.info(UserEntity.class.getSimpleName() + Constants.FOUND);

            return usersInGroupEntity;

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public GroupEntity getGroupById(Integer id) {
        Transaction transaction = null;
        GroupEntity group;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            group = session.get(GroupEntity.class, id);
            transaction.commit();
            logger.info(GroupEntity.class.getSimpleName() + Constants.FOUND);

            return group;

        } catch (Exception e) {
            logger.info(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public List<UserEntity> getListUsersByListOfId(List<Integer> listOfId) {
        Transaction transaction = null;
        UserEntity users;
        List<UserEntity> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();

            for (Integer id : listOfId) {
                users = session.get(UserEntity.class, id);
                list.add(users);
            }

            transaction.commit();
            logger.info(UserEntity.class.getSimpleName() + Constants.FOUND);

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
    public List<UserEntity> selectAllUsers() {
        Transaction transaction;
        List<UserEntity> list = new ArrayList<>();
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            list = session.createQuery("select UserEntity from UserEntity ", UserEntity.class).list();
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
    public boolean updateUser(UserEntity entity) {
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
            session.delete(new UserEntity());
            transaction.commit();
            logger.info(UserEntity.class.getSimpleName() + id + Constants.DELETED);
            return true;
        } catch (Exception e) {
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    /**
     * методы для работы с группами
     */
    @Override
    public GroupEntity insertGroup(GroupEntity entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            entity = (GroupEntity) session.merge(entity);
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
    public boolean updateGroup(GroupEntity entity) {
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

    /**
     * метод для сервис-отправителя
     * return: объект с id лектора, название команды, имя и фамилия студента
     */
//    @Override
//    public List<Object> getInfoAboutLectorTeamStudent(int id) {
//        Transaction transaction;
//        List<Object> returnedObject = new ArrayList<>();
//        UserEntity users = null;
//        LecturersEntity lecturers = null;
//        TeamEntity teams = null;
//        try (Session session = getSession()) {
//            transaction = session.beginTransaction();
//            /**
//             * Если значение оказывается false, проверка
//             * утверждения getId, getTeamName, getName считается проваленной
//             * и выбрасывается AssertionError
//             */
//            assert false;
//            logger.info(StudentsEntity.class.getSimpleName() + "AssertionError");
//            returnedObject.add(lecturers.getId());
//            returnedObject.add(teams.getTeamName());
//            returnedObject.add(users.getFirstName());
//            returnedObject.add(users.getLastName());
//
//            transaction.commit();
//            logger.info(StudentsEntity.class.getSimpleName() + Constants.FOUND);
//
//            return returnedObject;
//
//        } catch (Exception e) {
//            logger.info(e.getClass() + e.getMessage());
//            return null;
//        }
//    }
//
    Session getSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        return sessionFactory.openSession();
    }
}
