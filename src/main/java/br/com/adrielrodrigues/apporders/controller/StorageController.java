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

import br.com.adrielrodrigues.apporders.controller.dto.StorageDto;
import br.com.adrielrodrigues.apporders.model.Storage;
import br.com.adrielrodrigues.apporders.repository.StorageRepository;

@RestController
@RequestMapping("/storages")

public class StorageController {
	
	@Autowired
	private StorageRepository storageRepository;
	
	@GetMapping
	public List<StorageDto> findAll(){
		List<Storage> storages = storageRepository.findAll();
		
		return Storage.toStorageDto(storages);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		Storage storage = storageRepository.findById(id).get();
		return ResponseEntity.ok().body(storage);
	}
	
	@PostMapping
	public ResponseEntity<StorageDto> create(@RequestBody StorageDto storageDto, UriComponentsBuilder uriBuilder) {
		
		Storage storage = StorageDto.toStorage(storageDto);
		
		storageRepository.save(storage);
		
		URI uri = uriBuilder.path("/storages/{id}").buildAndExpand(storage.getId()).toUri();
		
		return ResponseEntity.created(uri).body(Storage.toStorageDto(storage));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<StorageDto> update(@RequestBody StorageDto storageDto, @PathVariable("id")Long id){
	
		Storage storage = storageRepository.findById(id).get();
	
		storage = StorageDto.toStorage(storageDto, id);
		
		storageRepository.save(storage);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		storageRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}

}
