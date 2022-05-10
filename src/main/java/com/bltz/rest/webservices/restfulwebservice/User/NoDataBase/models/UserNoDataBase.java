package com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.models;

import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.helper.validator.DateNotEmptyValidator;
import com.bltz.rest.webservices.restfulwebservice.User.NoDataBase.helper.validator.DateToAgeValidator;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.*;
import java.util.Date;
public class UserNoDataBase {
	private Integer id;
	@NotNull(message="name is required")
	@NotEmpty(message="name cannot be empty")
	@NotBlank(message="name cannot be blank")
	@Size(min=2, max=120, message="name must be greater than or equal to 2")
	private String name;
//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "birthDate is required")
	@DateNotEmptyValidator(message = "birthDate cannot be empty")
	@Past(message = "birthDate must be in the past")
	@DateToAgeValidator(message = "The birth date must be greater or equal than 18")
	private Date birthDate;

	public UserNoDataBase(Integer id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "UserNoDataBase{" +
				"id=" + id +
				", name='" + name + '\'' +
				", birthDate=" + birthDate +
				'}';
	}
}
