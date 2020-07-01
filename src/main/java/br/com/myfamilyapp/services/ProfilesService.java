package br.com.myfamilyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.myfamilyapp.entities.Account;
import br.com.myfamilyapp.entities.Profiles;
import br.com.myfamilyapp.repositories.AccountRepository;
import br.com.myfamilyapp.repositories.ProfilesRepository;

@Service
public class ProfilesService {
	
	@Autowired
	private ProfilesRepository repo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	
	public List<Profiles> findAll(){ 
		return repo.findAll();
	}
	
	
	public Profiles findByid(Long id) { 
		Optional<Profiles> prof = repo.findById(id);
		return prof.get();
	}
	
	public Profiles insert(Profiles prof, Long id) { 
		Account account = accountRepo.getOne(id);
		prof.setAccount(account);
		prof = repo.save(prof);
		return prof;
	}
	
	public void delete(Long id) { 
		repo.deleteById(id);
	}
	
	public void updateData(Profiles old, Profiles neo) { 
		old.setFullName(neo.getFullName());
		old.setBirthDate(neo.getBirthDate());
		old.setGender(neo.getGender());
	}
	
	public Profiles update(Profiles neo, Long id) {
		Profiles old = repo.getOne(id);
		updateData(old, neo);
		return repo.save(old);
		
	}

}
