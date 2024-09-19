package com.tyss.jspiders.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Entity
public class Role {
    @GeneratedValue
    @Id
    private Integer roleId;
    @Column(unique = true)
    private String name;

    @ManyToMany(
            mappedBy = "roles",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<AppUser> appUsers = new ArrayList<>();
}
