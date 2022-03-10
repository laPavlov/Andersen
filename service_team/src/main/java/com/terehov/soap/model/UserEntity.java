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
@Table(name = "user", schema = "service_team", catalog = "postgres")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private int lastName;
    @Basic
    @Column(name = "id_telegram")
    private Long idTelegram;

    @OneToMany(mappedBy = "idUserEntity")
    private List<UsersInClassEntity> usersInClassEntitiesFK;

    @OneToMany(mappedBy = "idUserEntity")
    private List<UsersInGroupEntity> usersInGroupEntitiesFK;

    @OneToMany(mappedBy = "idUserEntity")
    private List<TaskEntity> taskEntitiesFK;

}
