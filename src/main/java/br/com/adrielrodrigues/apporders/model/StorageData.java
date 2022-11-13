package br.com.adrielrodrigues.apporders.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.adrielrodrigues.apporders.controller.dto.StorageDataDto;

@Entity
public class StorageData {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String location;
	private Double quantity;	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public StorageData() {
	}

	public StorageData(Long id, String location, Double quantity) {
		super();
		this.id = id;
		this.location = location;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static List<StorageDataDto> toStorageDataDto(List<StorageData> storageData) {
		
		List<StorageDataDto> storageDto = new ArrayList<>();
		
		storageData.forEach(p -> {
			
			StorageDataDto storageDataDto = new StorageDataDto();
			
			storageDataDto.setId(p.getId());
			storageDataDto.setLocation(p.getLocation());
			storageDataDto.setQuantity(p.getQuantity());
			
			storageDto.add(storageDataDto);			
		});	
		
		return storageDto;
	}	


	public static StorageDataDto toStorageDataDto(StorageData storageData) {
		
			
		StorageDataDto storageDataDto = new StorageDataDto();
		
		storageDataDto.setId(storageData.getId());
		storageDataDto.setLocation(storageData.getLocation());
		storageDataDto.setQuantity(storageData.getQuantity());
			
		return storageDataDto;
	}

}