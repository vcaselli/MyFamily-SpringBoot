package br.com.myfamilyapp.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.com.myfamilyapp.services.validations.AccountInsert;

@AccountInsert
public class AccountDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id; 
	@NotEmpty(message="Preenchimento obrigatório")
	private String familyName;
	@NotEmpty(message="Preenchimento obrigatório")
	@Email
	private String email; 
	@NotEmpty(message="Preenchimento obrigatório")
	private String password; 
	@NotEmpty(message="Preenchimento obrigatório")
	private String state; 
	@NotEmpty(message="Preenchimento obrigatório")
	private String city;
	
	
	public AccountDTO() { 
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	
}
