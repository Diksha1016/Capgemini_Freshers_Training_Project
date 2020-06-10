package com.capgemini.movieticketsystem.dto;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "account_login")
public class UserBean {
	@Id
	@Column
	private int userId;
	@Column
	private String userName;
	@Column
	private String userPassword;
	@Column
	private  LocalDate dateOfBirth;
	@Column
    private String contact;


}
