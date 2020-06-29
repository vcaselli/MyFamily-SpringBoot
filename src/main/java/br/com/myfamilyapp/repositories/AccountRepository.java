package br.com.myfamilyapp.repositories;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.myfamilyapp.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Transactional(readOnly=true)
	Account findByEmail(String email);
	

}
