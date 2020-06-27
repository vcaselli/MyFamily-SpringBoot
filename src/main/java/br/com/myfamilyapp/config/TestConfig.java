package br.com.myfamilyapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.myfamilyapp.entities.Account;
import br.com.myfamilyapp.repositories.AccountRepository;

@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Account account = new Account("Caselli", "victordcporto@gmail.com", "123", "RJ", "Rio de Janeiro");
		
		accountRepository.save(account);
		
		
		
	}

}
