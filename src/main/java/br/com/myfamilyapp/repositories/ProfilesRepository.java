package br.com.myfamilyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.myfamilyapp.entities.Profiles;

public interface ProfilesRepository extends JpaRepository<Profiles, Long> {

}
