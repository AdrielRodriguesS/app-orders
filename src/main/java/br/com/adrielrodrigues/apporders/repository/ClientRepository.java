package br.com.adrielrodrigues.apporders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.adrielrodrigues.apporders.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}
