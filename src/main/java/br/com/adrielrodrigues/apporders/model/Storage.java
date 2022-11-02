package br.com.adrielrodrigues.apporders.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Storage {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate inventoryDate;
	
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
}
