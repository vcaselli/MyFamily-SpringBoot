package br.com.myfamilyapp.entities.enums;

public enum ProfileType {
	ADMIN(1, "ROLE_ADMIN"),
	CLIENT(2, "ROLE_CLIENT"),
	CONTROLLER(3, "ROLE_CONTROLLER"),
	GAMER(4, "ROLE_GMAER");
	
	private Integer cod; 
	private String description;
	
	
	private ProfileType(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescription() {
		return description;
	}
	
	
	public static ProfileType toEnum(Integer cod) { 
		
		if (cod == null) {
			return null;
		}
		
		for(ProfileType x : ProfileType.values()) { 
			if (cod.equals(x.getCod())) { 
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
	
	

}
