package com.example.demosecurity.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "roles")
@Data
public class RoleEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@ManyToMany(mappedBy = "roles")
	private Set<UserEntity> users = new HashSet<>();

	public RoleEntity() {

	}

}