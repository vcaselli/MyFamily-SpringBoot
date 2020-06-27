package br.com.myfamilyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.myfamilyapp.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
