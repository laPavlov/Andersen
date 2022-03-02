package Models;

import java.util.List;

/**
 * Модель для создания обьекта из таблицы (ManyToMany) UsersCourses
 */
public class UsersCourses {
    private Integer idUser;

    private List<Integer> idUsers;

    private Integer idCourse;

    private List<Integer> idCourses;
    public UsersCourses(Integer idUser, Integer idCourse) {
        this.idUser = idUser;
        this.idCourse = idCourse;
    }
    public void setIdUsers(List<Integer> idUsers) {
        this.idUsers = idUsers;
    }

    public void setIdCourses(List<Integer> idCourses) {
        this.idCourses = idCourses;
    }

    public List<Integer> getIdUsers() {
        return idUsers;
    }

    public List<Integer> getIdCourses() {
        return idCourses;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }
}
