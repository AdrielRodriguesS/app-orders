package br.com.adrielrodrigues.apporders.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.adrielrodrigues.apporders.controller.dto.StorageDto;

@Entity
public class Storage {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate inventoryDate = LocalDate.now();
	
	@JsonIgnore
	@OneToMany(mappedBy = "storage", fetch = FetchType.LAZY)
	private List<Product> products; 
	
	public Storage() {
	}
	
	public Storage(Long id, List<String> locations, LocalDate inventoryDate, List<Product> products) {
		super();
		this.id = id;
		this.inventoryDate = inventoryDate;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(LocalDate inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static List<StorageDto> toStorageDto(List<Storage> storage) {
		
		List<StorageDto> storagesDto = new ArrayList<>();
		
		storage.forEach(s -> {
			
			StorageDto storageDto = new StorageDto();
			
			storageDto.setId(s.getId());
			storageDto.setInventoryDate(s.getInventoryDate());
			
			storagesDto.add(storageDto);			
		});
		
		return storagesDto;
	}
}
