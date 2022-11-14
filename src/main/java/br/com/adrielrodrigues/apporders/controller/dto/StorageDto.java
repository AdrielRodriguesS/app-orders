package br.com.adrielrodrigues.apporders.controller.dto;

import java.time.LocalDate;

import br.com.adrielrodrigues.apporders.model.Storage;

public class StorageDto {
	
	private Long id;
	private LocalDate inventoryDate = LocalDate.now();
	
	public StorageDto() {
	}

	public StorageDto(Long id, LocalDate inventoryDate) {
		this.id = id;
		this.inventoryDate = inventoryDate;
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

	public static Storage toStorage(StorageDto storageDto) {

		Storage storage = new Storage();
		storage.setInventoryDate(storageDto.getInventoryDate());
		return storage;
	}
	
	public static Storage toStorage(StorageDto storageDto, Long id) {

		Storage storage = new Storage();
		storage.setId(id);
		storage.setInventoryDate(storageDto.getInventoryDate());
		return storage;
	}
	
}
