package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class UserRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private  String username;
	private String password;
	private String role;

	public UserRegister() {
	}

//getter setter methods and Constructors


	public UserRegister(int id, String username, String password, String role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
}
