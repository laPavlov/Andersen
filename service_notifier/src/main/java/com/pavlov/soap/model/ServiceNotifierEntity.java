package com.pavlov.soap.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "service_notifier", schema = "public", catalog = "postgres")
public class ServiceNotifierEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "count_of_miss")
    private Integer countOfMiss;
    @Basic
    @Column(name = "student_id")
    private Integer studentId;

    public ServiceNotifierEntity(int id, Integer countOfMiss, Integer studentId) {
        this.id = id;
        this.countOfMiss = countOfMiss;
        this.studentId = studentId;
    }

    public ServiceNotifierEntity(int studentId) {
        this.studentId = studentId;
    }

    public ServiceNotifierEntity(Integer countOfMiss, Integer studentId) {
        this.countOfMiss = countOfMiss;
        this.studentId = studentId;
    }

    public ServiceNotifierEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCountOfMiss() {
        return countOfMiss;
    }

    public void setCountOfMiss(Integer countOfMiss) {
        this.countOfMiss = countOfMiss;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceNotifierEntity that = (ServiceNotifierEntity) o;
        return id == that.id && Objects.equals(countOfMiss, that.countOfMiss) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countOfMiss, studentId);
    }
}
