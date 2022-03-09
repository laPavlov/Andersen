package com.terehov.soap.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students", schema = "service_team", catalog = "postgres")
public class StudentsEntity {
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
    @Basic
    @Column(name = "group_id")
    private Integer groupId;
    @Basic
    @Column(name = "team_id")
    private Integer teamId;

    public StudentsEntity() {
    }

    public StudentsEntity(int id, String firstName, String lastName, int idTelegram, Integer groupId, Integer teamId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idTelegram = idTelegram;
        this.groupId = groupId;
        this.teamId = teamId;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsEntity that = (StudentsEntity) o;
        return id == that.id && idTelegram == that.idTelegram && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(groupId, that.groupId) && Objects.equals(teamId, that.teamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, idTelegram, groupId, teamId);
    }
}
