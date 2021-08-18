package com.gsr.libraryauth.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity(name = "MUser")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date createdAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date modifiedAt;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;
    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;
    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_user",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles;

    public User() {
    }

    public User(User u) {
        this.id = u.getId();
        this.firstName = u.getFirstName();
        this.lastName = u.getLastName();
        this.email = u.getEmail();
        this.createdAt = u.getCreatedAt();
        this.modifiedAt = u.getModifiedAt();

        this.username = u.getUsername();
        this.password = u.getPassword();
        this.enabled = u.isEnabled();
        this.credentialsNonExpired = u.isCredentialsNonExpired();
        this.accountNonExpired = u.isAccountNonExpired();
        this.accountNonLocked = u.isAccountNonLocked();
        this.roles = u.getRoles();
    }

}
