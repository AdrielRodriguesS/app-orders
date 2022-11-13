package br.com.adrielrodrigues.apporders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adrielrodrigues.apporders.controller.dto.StorageDataDto;
import br.com.adrielrodrigues.apporders.model.Product;
import br.com.adrielrodrigues.apporders.model.StorageData;
import br.com.adrielrodrigues.apporders.repository.ProductRepository;
import br.com.adrielrodrigues.apporders.repository.StorageDataRepository;

@RestController
@RequestMapping("/storage-data")
public class StorageDataController {
	
	@Autowired
	private StorageDataRepository storageDataRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<StorageDataDto> findAll(){
		List<StorageData> storageData = storageDataRepository.findAll();
		
		return StorageData.toStorageDataDto(storageData);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		StorageData storageData = storageDataRepository.findById(id).get();
		
		StorageDataDto storageDataDto = StorageData.toStorageDataDto(storageData);
		
		return ResponseEntity.ok().body(storageDataDto);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<StorageDataDto> Create(@RequestBody StorageDataDto storageDataDto, @PathVariable("id") Long id){
		
		Product product = productRepository.findById(id).get();
		
		StorageData storageData = storageDataDto.toStorageData(storageDataDto);
		
		storageData.setProduct(product);
		
		storageDataRepository.save(storageData);
		
		return ResponseEntity.ok().build();
		
	}

}
