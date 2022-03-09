package com.terehov.soap.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "team", schema = "service_team", catalog = "postgres")
public class TeamEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "team_name")
    private String teamName;
    @Basic
    @Column(name = "group_id")
    private Integer groupId;
    @Basic
    @Column(name = "team_leader_id")
    private Integer teamLeaderId;

    public TeamEntity() {
    }

    public TeamEntity(int id, String teamName, Integer groupId, Integer teamLeaderId) {
        this.id = id;
        this.teamName = teamName;
        this.groupId = groupId;
        this.teamLeaderId = teamLeaderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Integer teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamEntity that = (TeamEntity) o;
        return id == that.id && Objects.equals(teamName, that.teamName) && Objects.equals(groupId, that.groupId) && Objects.equals(teamLeaderId, that.teamLeaderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, groupId, teamLeaderId);
    }
}
