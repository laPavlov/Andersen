package modelToResponce;

import java.util.Objects;

public class Groups {

    private int id;
    private String specialization;
    private Integer lecturerId;

    public Groups(int id, String specialization, Integer lecturerId) {
        this.id = id;
        this.specialization = specialization;
        this.lecturerId = lecturerId;
    }

    public Groups() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public int getId() {
        return id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "id=" + id +
                ", specialization='" + specialization + '\'' +
                ", lecturerId=" + lecturerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Groups groups = (Groups) o;
        return id == groups.id && Objects.equals(specialization, groups.specialization) && Objects.equals(lecturerId, groups.lecturerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specialization, lecturerId);
    }
}
