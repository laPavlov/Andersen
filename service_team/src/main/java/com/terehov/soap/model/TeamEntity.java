package com.terehov.soap.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "teamEntity")
    private List<StudentsEntity> teamEntity;

    @ManyToOne
    @JoinColumn(name = "team_leader_id")
    private StudentsEntity teamLeaderIdEntity;
}
