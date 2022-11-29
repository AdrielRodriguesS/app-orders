package br.com.adrielrodrigues.apporders.controller;

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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.adrielrodrigues.apporders.controller.dto.AdressDto;
import br.com.adrielrodrigues.apporders.model.Adress;
import br.com.adrielrodrigues.apporders.model.Client;
import br.com.adrielrodrigues.apporders.repository.AdressRepository;
import br.com.adrielrodrigues.apporders.repository.ClientRepository;

@RestController
@RequestMapping("/adress")
public class AdressController {
	
	@Autowired
	private AdressRepository adressRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public List<AdressDto> findAll(){
		List<Adress> adresses = adressRepository.findAll();
		return Adress.toAdressDto(adresses);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		Adress adress = adressRepository.findById(id).get();
		return ResponseEntity.ok().body(adress);
		
	}
	
	@PostMapping
	public ResponseEntity<AdressDto> create(@Valid @RequestBody AdressDto adressDto, UriComponentsBuilder uriBuilder){
		
		Client client = clientRepository.findById(adressDto.getClientId()).get();
		
		System.out.println(client.getId());
		
		Adress adress = AdressDto.toAdress(adressDto);
		
		adress.setClient(client);
		
		adressRepository.save(adress);
		
		URI uri = uriBuilder.path("/adress/{id}").buildAndExpand(adress.getId()).toUri();
		
		return ResponseEntity.created(uri).body(Adress.toAdressDto(adress));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AdressDto> update(
			@Valid @RequestBody AdressDto adressDto, @PathVariable Long id){
		
		Client client = clientRepository.findById(adressDto.getClientId()).get();
		
		Adress adress = adressRepository.findById(id).get();
		
		adress = AdressDto.toAdress(adressDto, id);
		
		adress.setClient(client);
		
		adressRepository.save(adress);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		adressRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}	

}
