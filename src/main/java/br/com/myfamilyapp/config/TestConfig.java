package br.com.myfamilyapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.myfamilyapp.entities.Account;
import br.com.myfamilyapp.entities.enums.ProfileType;
import br.com.myfamilyapp.repositories.AccountRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		
		Account account = new Account("Caselli", "victordcporto@gmail.com", passwordEncoder.encode("123"), "RJ", "Rio de Janeiro");
		account.addProfileType(ProfileType.ADMIN);
		accountRepository.save(account);
		
		
		
	}

}
