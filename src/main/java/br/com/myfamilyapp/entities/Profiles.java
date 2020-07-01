package br.com.myfamilyapp.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.myfamilyapp.entities.enums.ProfileType;

@Entity
public class Profiles implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String fullName; 
	private String birthDate; 
	private String gender; 
	private String familyRelationship; 
	private Double points; 
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="GameProfile")
	private Set<Integer> parentalControl = new HashSet<>();
	private Integer pin; 
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "idAccount")
	private Account account;
	
	
	public Profiles() { 
		
	}


	public Profiles(String fullName, String birthDate, String gender, String familyRelatioshop, Double points,
			Integer pin) {
		
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.familyRelationship = familyRelatioshop;
		this.points = points;
		this.pin = pin;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getFamilyRelationship() {
		return familyRelationship;
	}


	public void setFamilyRelatioship(String familyRelatioshop) {
		this.familyRelationship = familyRelatioshop;
	}


	public Double getPoints() {
		return points;
	}


	public void setPoints(Double points) {
		this.points = points;
	}


	public Integer getPin() {
		return pin;
	}


	public void setPin(Integer pin) {
		this.pin = pin;
	}
	
	public Set<ProfileType> getParentalControl() {
		return parentalControl.stream().map(x -> ProfileType.toEnum(x)).collect(Collectors.toSet());
	}

	public void addProfileType(ProfileType pt) { 
		parentalControl.add(pt.getCod());
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

	
	
}
