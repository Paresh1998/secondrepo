package com.tyss.jspiders.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class AppUser {
    @Id
    private String username;
    private String password;

    @JoinTable(
            name = "map_usr_role",
            joinColumns = @JoinColumn(name = "app_user_fk"),
            inverseJoinColumns = @JoinColumn(name = "role_fk")
    )
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Role> roles;
}
