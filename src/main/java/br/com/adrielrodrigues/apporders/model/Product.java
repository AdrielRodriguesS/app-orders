package br.com.adrielrodrigues.apporders.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.adrielrodrigues.apporders.controller.dto.ProductDto;

@Entity
public class Product {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String reference;
	private BigDecimal price;
	private String manufacturer;
	
	@Enumerated(EnumType.STRING)
	private PurchaseUnit purchaseUnit;
	

	@OneToOne(mappedBy = "product")
	private StorageData storageData;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storage_id")
	private Storage storage;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<QuotationProduct> quotationProduct = new ArrayList<>();
	
	public Product() {
	}

	public Product(Long id, String description, String reference, BigDecimal price, String manufacturer, PurchaseUnit purchaseUnit) {
		super();
		this.id = id;
		this.description = description;
		this.reference = reference;
		this.price = price;
		this.manufacturer = manufacturer;
		this.purchaseUnit = purchaseUnit;
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

	public StorageData getStorageData() {
		return storageData;
	}

	public void setStorageData(StorageData storageData) {
		this.storageData = storageData;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	
	public List<QuotationProduct> getQuotationProduct() {
		return quotationProduct;
	}

	public void setQuotationProduct(List<QuotationProduct> quotationProduct) {
		this.quotationProduct = quotationProduct;
	}

	public static List<ProductDto> toProductDto(List<Product> products) {

		List<ProductDto> productsDto = new ArrayList<>();
		
		products.forEach(p -> {
			
			ProductDto productDto = new ProductDto();
			
			productDto.setId(p.getId());
			productDto.setDescription(p.getDescription());
			productDto.setReference(p.getReference());
			productDto.setPrice(p.getPrice());
			productDto.setManufacturer(p.getManufacturer());
			productDto.setPurchaseUnit(p.getPurchaseUnit());
			productsDto.add(productDto);
			
		});		
		return productsDto;
	}
	
	public static ProductDto toProductDto(Product product) {

		ProductDto productDto = new ProductDto();
			
			productDto.setId(product.getId());
			productDto.setDescription(product.getDescription());
			productDto.setReference(product.getReference());
			productDto.setPrice(product.getPrice());
			productDto.setManufacturer(product.getManufacturer());
			productDto.setPurchaseUnit(product.getPurchaseUnit());
			
		return productDto;
	}	
	
}
