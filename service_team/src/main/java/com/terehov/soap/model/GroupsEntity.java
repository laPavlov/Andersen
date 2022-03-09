package com.terehov.soap.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "groups", schema = "service_team", catalog = "postgres")
public class GroupsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "specializations")
    private String specializations;
    @Basic
    @Column(name = "lecturer_id")
    private Integer lecturerId;
    @Basic
    @Column(name = "number")
    private Integer number;

    public GroupsEntity() {
    }

    public GroupsEntity(int id, String specializations, Integer lecturerId, Integer number) {
        this.id = id;
        this.specializations = specializations;
        this.lecturerId = lecturerId;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecializations() {
        return specializations;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }

    public Integer getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Integer lecturerId) {
        this.lecturerId = lecturerId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupsEntity that = (GroupsEntity) o;
        return id == that.id && Objects.equals(specializations, that.specializations) && Objects.equals(lecturerId, that.lecturerId) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specializations, lecturerId, number);
    }
}
