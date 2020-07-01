package br.com.myfamilyapp.resources;

import java.net.URI;
import java.util.List;

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

import br.com.myfamilyapp.entities.Profiles;
import br.com.myfamilyapp.services.ProfilesService;

@RequestMapping("/profiles")
@RestController
public class ProfilesResource {

	
	@Autowired
	private ProfilesService service;
	
	@GetMapping
	public ResponseEntity<List<Profiles>> findAll(){ 
		List<Profiles> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Profiles> insert(@PathVariable Long id, @RequestBody Profiles prof){ 
		Profiles entity = service.insert(prof, id); 
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(entity.getId())
				.toUri();
		return ResponseEntity.created(uri).body(entity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Profiles> findById(@PathVariable Long id){ 
		Profiles prof = service.findByid(id);
		return ResponseEntity.ok().body(prof);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){ 
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/{id}")
	public ResponseEntity<Profiles> update(@RequestBody Profiles neo, @PathVariable Long id){
		Profiles prof = service.update(neo, id);
		return ResponseEntity.ok().body(prof);
	}
	
}
