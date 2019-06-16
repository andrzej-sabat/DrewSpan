package com.drewSpan.drewSpan2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Knt_id")
    private int id;

    @Column(name = "Knt_login")
    @NotEmpty(message = "*Wprowadź Login")
    private String login;

    @NotEmpty(message = "*Wprowadź kod")
    @Column(name = "Knt_kod")
    private String code;

    @Column(name = "Knt_imie")
    @NotEmpty(message = "*Wprowadź imię")
    private String name;

    @Column(name = "Knt_nazwisko")
    @NotEmpty(message = "*Wprowadź nazwisko")
    private String lastName;

    @Column(name = "Knt_wydział")
    private String section;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}
