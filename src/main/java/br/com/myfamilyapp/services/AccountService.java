package br.com.myfamilyapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.myfamilyapp.dto.AccountDTO;
import br.com.myfamilyapp.entities.Account;
import br.com.myfamilyapp.entities.enums.ProfileType;
import br.com.myfamilyapp.repositories.AccountRepository;
import br.com.myfamilyapp.resources.exceptions.AuthorizationException;
import br.com.myfamilyapp.resources.exceptions.ObjectNotFoundException;
import br.com.myfamilyapp.security.UserSS;

@Service
public class AccountService {

	@Autowired
	AccountRepository repo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public List<Account> findAll() {
		return repo.findAll();
	}

	public Account findById(Long id) {
		Optional<Account> object = repo.findById(id);
		return object.get();
	}

	public Account findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(ProfileType.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Access denied");
		}

		Account object = repo.findByEmail(email);
		if (object == null) {
			throw new ObjectNotFoundException(
					"Object not found! ID: " + user.getId() + ", Type: " + Account.class.getName());
		}
		return object;
	}

	public Account insert(Account entity) {
		Account account = repo.save(entity);
		return account;
	}

	public void remove(Long id) {
		repo.deleteById(id);
	}

	public Account fromDTO(AccountDTO dto) {
		return new Account(dto.getFamilyName(), dto.getEmail(), passwordEncoder.encode(dto.getPassword()),
				dto.getState(), dto.getCity());
	}

	public void updateData(Account account, Account neo) {
		account.setFamilyName(neo.getFamilyName());
		account.setEmail(neo.getEmail());
		account.setState(neo.getState());
		account.setCity(neo.getCity());

	}

	public Account update(Long id, Account neo) {
		Account account = repo.getOne(id);
		updateData(account, neo);
		return repo.save(account);
	}

}
