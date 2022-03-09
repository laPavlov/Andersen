package modelToResponce;

import java.util.Objects;

public class Students {

    private int id;
    private String firstName;
    private String lastName;
    private Integer idTelegram;
    private Integer idGroup;

    public Students() {
    }

    public Students(int id, String firstName, String lastName, Integer idTelegram, Integer idGroup) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idTelegram = idTelegram;
        this.idGroup = idGroup;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdTelegram(Integer idTelegram) {
        this.idTelegram = idTelegram;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getIdTelegram() {
        return idTelegram;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idTelegram=" + idTelegram +
                ", idGroup=" + idGroup +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return id == students.id && Objects.equals(firstName, students.firstName) && Objects.equals(lastName, students.lastName) && Objects.equals(idTelegram, students.idTelegram) && Objects.equals(idGroup, students.idGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, idTelegram, idGroup);
    }
}
