package br.com.myfamilyapp.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.myfamilyapp.dto.AccountDTO;
import br.com.myfamilyapp.entities.Account;
import br.com.myfamilyapp.services.AccountService;

@RequestMapping("/account")
@RestController
public class AccountResource {
	
	@Autowired
	AccountService service;
	
	
	@GetMapping
	public ResponseEntity<List<Account>> findAll(){ 
		List<Account> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> findById(@PathVariable Long id){ 
		Account entity = service.findById(id);
		return ResponseEntity.ok().body(entity);
	}
	
	@PostMapping
	public ResponseEntity<Account> insert(@Valid @RequestBody AccountDTO entity){ 
		Account account = service.fromDTO(entity);
		account = service.insert(account);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(account.getId())
				.toUri();
		return ResponseEntity.created(uri).body(account);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		service.remove(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account neo){ 
		Account account = service.update(id, neo);
		return ResponseEntity.ok().body(account);
	}

}
