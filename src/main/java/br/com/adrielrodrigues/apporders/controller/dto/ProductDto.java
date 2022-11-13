package br.com.adrielrodrigues.apporders.controller.dto;

import java.math.BigDecimal;

import br.com.adrielrodrigues.apporders.model.Product;
import br.com.adrielrodrigues.apporders.model.PurchaseUnit;

public class ProductDto {
	
	private Long id;
	private String description;
	private String reference;
	private BigDecimal price;
	private String manufacturer;	
	private PurchaseUnit purchaseUnit;
	
	public ProductDto() {
		super();
	}

	public ProductDto(Long id, String description, String reference, BigDecimal price, String manufacturer) {
		this.id = id;
		this.description = description;
		this.reference = reference;
		this.price = price;
		this.manufacturer = manufacturer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public PurchaseUnit getPurchaseUnit() {
		return purchaseUnit;
	}

	public void setPurchaseUnit(PurchaseUnit purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}

	public Product toProduct(ProductDto productDto) {

		Product product = new Product();
		
		product.setDescription(productDto.getDescription());
		product.setReference(productDto.getReference());
		product.setPrice(productDto.getPrice());
		product.setManufacturer(productDto.getManufacturer());
		product.setPurchaseUnit(productDto.getPurchaseUnit());
		
		return product;
	}
	
	public Product toProduct(ProductDto productDto, Long id) {

		Product product = new Product();
		
		product.setId(id);
		product.setDescription(productDto.getDescription());
		product.setReference(productDto.getReference());
		product.setPrice(productDto.getPrice());
		product.setManufacturer(productDto.getManufacturer());
		product.setPurchaseUnit(productDto.getPurchaseUnit());
		
		return product;
	}
}
