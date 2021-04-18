package com.zian.platform.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="tb_role")
public class RoleEntity {

    @Id
    private Long id;
    @Column(name="role_name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;

}
