package modelToResponce;

import java.util.Objects;

public class Lecturers {

    private int id;
    private String firstName;
    private String lastName;
    private Integer idTelegram;

    public Lecturers(int id, String firstName, String lastName, Integer idTelegram) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idTelegram = idTelegram;
    }

    public Lecturers() {
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

    @Override
    public String toString() {
        return "Lecturers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idTelegram=" + idTelegram +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lecturers lecturers = (Lecturers) o;
        return id == lecturers.id && Objects.equals(firstName, lecturers.firstName) && Objects.equals(lastName, lecturers.lastName) && Objects.equals(idTelegram, lecturers.idTelegram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, idTelegram);
    }
}
