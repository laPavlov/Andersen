package com.terehov.soap.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users_in_group", schema = "service_team", catalog = "postgres")
public class UsersInGroupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private GroupEntity idGroupEntity;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity idUserEntity;

    @Basic
    @Column(name = "role")
    private String role;
}
