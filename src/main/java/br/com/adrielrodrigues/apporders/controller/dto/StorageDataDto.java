package br.com.adrielrodrigues.apporders.controller.dto;

import br.com.adrielrodrigues.apporders.model.StorageData;

public class StorageDataDto {
	
	private Long id;
	private String location;
	private Double quantity;	
	
	public StorageDataDto(Long id, String location, Double quantity) {
		this.id = id;
		this.location = location;
		this.quantity = quantity;
	}

	public StorageDataDto() {
		super();
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

	public static StorageData toStorageData(StorageDataDto storageDataDto) {
		
		StorageData storageData = new StorageData();
		
		storageData.setLocation(storageDataDto.getLocation());
		storageData.setQuantity(storageDataDto.getQuantity());
		
		return storageData;
	}
	
	public static StorageData toStorageData(StorageDataDto storageDataDto, Long id) {
		
		StorageData storageData = new StorageData();
		
		storageData.setId(id);
		storageData.setLocation(storageDataDto.getLocation());
		storageData.setQuantity(storageDataDto.getQuantity());
		
		return storageData;
	}
}
