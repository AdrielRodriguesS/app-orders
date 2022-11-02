package br.com.adrielrodrigues.apporders.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class StorageData {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String location;
	private Double quanttity;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;
	
	public StorageData() {
	}

	public StorageData(Long id, String location, Double quanttity) {
		super();
		this.id = id;
		this.location = location;
		this.quanttity = quanttity;
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

	public Double getQuanttity() {
		return quanttity;
	}

	public void setQuanttity(Double quanttity) {
		this.quanttity = quanttity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
