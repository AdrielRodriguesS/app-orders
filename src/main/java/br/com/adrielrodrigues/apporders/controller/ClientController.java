	package br.com.adrielrodrigues.apporders.controller;

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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.adrielrodrigues.apporders.controller.dto.ClientDto;
import br.com.adrielrodrigues.apporders.model.Client;
import br.com.adrielrodrigues.apporders.repository.AdressRepository;
import br.com.adrielrodrigues.apporders.repository.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;	
	
	@Autowired
	private AdressRepository adressRepository;
	
	@GetMapping
	public List<ClientDto> findAll(){
		List<Client> clients = clientRepository.findAll();
		return Client.toClientDto(clients);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		Client client = clientRepository.findById(id).get();
		return ResponseEntity.ok().body(client);
	}
	
	@PostMapping
	public ResponseEntity<ClientDto> create(@RequestBody ClientDto clientDto, UriComponentsBuilder uriBuilder){
		
		Client client = ClientDto.toClient(clientDto);
		
		clientRepository.save(client);
		
		URI uri = uriBuilder.path("/clients/{id}").buildAndExpand(client.getId()).toUri();
		
		return ResponseEntity.created(uri).body(Client.toClientDto(client));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientDto> update(@RequestBody ClientDto clientDto, @PathVariable("id") Long id){
		
		Client client = clientRepository.findById(id).get();
		
		client = ClientDto.toClient(id, clientDto);

		clientRepository.save(client);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		clientRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
