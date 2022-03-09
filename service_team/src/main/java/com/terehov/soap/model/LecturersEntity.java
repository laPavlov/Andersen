package com.terehov.soap.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lecturers", schema = "service_team", catalog = "postgres")
public class LecturersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "id_telegram")
    private int idTelegram;

    public LecturersEntity() {
    }

    public LecturersEntity(int id, String firstName, String lastName, int idTelegram) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idTelegram = idTelegram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdTelegram() {
        return idTelegram;
    }

    public void setIdTelegram(int idTelegram) {
        this.idTelegram = idTelegram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LecturersEntity that = (LecturersEntity) o;
        return id == that.id && idTelegram == that.idTelegram && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, idTelegram);
    }
}
