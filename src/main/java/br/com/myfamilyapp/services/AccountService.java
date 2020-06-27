package br.com.myfamilyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myfamilyapp.entities.Account;
import br.com.myfamilyapp.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository repo; 
	
	
	public List<Account> findAll(){ 
		return repo.findAll();
	}
	
	public Account findById(Long id) { 
		Optional<Account> object = repo.findById(id);
		return object.get();
	}
	
	public Account insert(Account entity) { 
		Account account = repo.save(entity); 
		return account;
	}
	
	public void remove(Long id) { 
		repo.deleteById(id);
	}
	
	
	public void updateData(Account account, Account neo) { 
		account.setFamilyName(neo.getFamilyName());
		account.setEmail(account.getEmail());
		account.setState(neo.getState());
		account.setCity(neo.getCity());
	}
	
	public Account update(Long id, Account neo) { 
		Account account = repo.getOne(id); 
		updateData(account, neo);
		return repo.save(account);
	}

}
