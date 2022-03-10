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
@Table(name = "class", schema = "service_team", catalog = "postgres")
public class ClassEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "class_name")
    private String className;

    @OneToMany(mappedBy = "idClassEntity")
    private List<UsersInClassEntity> usersInClassEntitiesFK;

    @OneToMany(mappedBy = "idGroupEntity")
    private List<GroupInClassEntity> groupInClassEntitiesFK;

    @OneToMany(mappedBy = "idClassEntity")
    private List<TaskEntity> taskEntitiesFK;

    public ClassEntity(int id) {
        this.id = id;
    }
}
