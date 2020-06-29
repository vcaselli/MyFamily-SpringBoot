package br.com.myfamilyapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.myfamilyapp.entities.enums.ProfileType;

@Entity
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String familyName;
	@Column(unique=true)
	private String email; 
	private String password; 
	private String state; 
	private String city;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="ProfileType")
	private Set<Integer> profileType = new HashSet<>();
	
	public Account() { 
		
	}

	public Account(String familyName, String email, String password, String state, String city) {
		super();
		this.familyName = familyName;
		this.email = email;
		this.password = password;
		this.state = state;
		this.city = city;
		addProfileType(ProfileType.CLIENT);
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

	public Set<ProfileType> getProfileType() {
		return profileType.stream().map(x -> ProfileType.toEnum(x)).collect(Collectors.toSet());
	}

	public void addProfileType(ProfileType pt) { 
		profileType.add(pt.getCod());
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", familyName=" + familyName + ", email=" + email + ", password=" + password
				+ ", state=" + state + ", city=" + city + ", profileType=" + profileType + "]";
	}
	
	
}
