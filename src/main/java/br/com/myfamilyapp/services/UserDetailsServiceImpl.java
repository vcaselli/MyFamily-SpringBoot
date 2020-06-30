package br.com.myfamilyapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.myfamilyapp.entities.Account;
import br.com.myfamilyapp.repositories.AccountRepository;
import br.com.myfamilyapp.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	
	@Autowired
	private AccountRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account account = repo.findByEmail(email);
		if(account == null) { 
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(account.getId(), account.getEmail(), account.getPassword(), account.getProfileType());
	}

}
