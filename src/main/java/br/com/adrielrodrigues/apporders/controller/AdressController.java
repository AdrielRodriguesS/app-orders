package br.com.adrielrodrigues.apporders.controller;

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
		return Adress.toAdress(adresses);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		Adress adress = adressRepository.findById(id).get();
		return ResponseEntity.ok().body(adress);
		
	}
	
	@PostMapping
	public ResponseEntity<AdressDto> create(@Valid @RequestBody AdressDto adressDto){
		
		Client client = clientRepository.findById(adressDto.getClientId()).get();
		
		Adress adress = AdressDto.toAdressDto(adressDto);
		
		adress.setClient(client);
		
		adressRepository.save(adress);
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AdressDto> update(
			@RequestBody AdressDto adressDto, @PathVariable Long id){
		
		Client client = clientRepository.findById(adressDto.getClientId()).get();
		
		Adress adress = adressRepository.findById(id).get();
		
		System.out.println(adress);
		
		adress = AdressDto.toAdressDto(adressDto, id);

		System.out.println(adressDto);
		
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
