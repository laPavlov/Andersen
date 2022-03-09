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
@Table(name = "groups", schema = "service_team", catalog = "postgres")
public class GroupsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "specializations")
    private String specializations;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private LecturersEntity lecturerIdEntity;

    @Basic
    @Column(name = "number")
    private Integer number;

    @OneToMany(mappedBy = "groupIdEntity")
    private List<StudentsEntity> groupIdEntity;
}
