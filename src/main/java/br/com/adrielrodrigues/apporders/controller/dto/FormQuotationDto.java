package br.com.adrielrodrigues.apporders.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.adrielrodrigues.apporders.model.Adress;
import br.com.adrielrodrigues.apporders.model.Client;
import br.com.adrielrodrigues.apporders.model.Product;
import br.com.adrielrodrigues.apporders.model.Quotation;
import br.com.adrielrodrigues.apporders.model.QuotationProduct;

public class FormQuotationDto {
	
	private Quotation quotation;
	
	private Client client;
	
	private List<Adress> adresses = new ArrayList<>();
	
	private List<QuotationProduct> quotationProducts = new ArrayList<>();
	
	private List<Product> products = new ArrayList<>();

	public FormQuotationDto(Quotation quotation, Client client, List<Adress> adresses,
			List<QuotationProduct> quotationProducts, List<Product> products) {
		this.quotation = quotation;
		this.client = client;
		this.adresses = adresses;
		this.quotationProducts = quotationProducts;
		this.products = products;
	}

	public Quotation getQuotation() {
		return quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}

	public List<QuotationProduct> getQuotationProducts() {
		return quotationProducts;
	}

	public void setQuotationProducts(List<QuotationProduct> quotationProducts) {
		this.quotationProducts = quotationProducts;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	
	/*
	 * 
	//Quotation
	private BigDecimal finalPrice = quotation.getFinalPrice();
	private LocalDate quotationDate;
	private QuotationStatus quotationStatus;
	//Client
	private String cnpj;
	private String companyName;
	private String email;
	private String phone;
	//Adress
	private String adress;
	private Integer number;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	//QuotationProduct
	private Integer quantity;
	private BigDecimal totalPrice;
	//Product
	private String description;
	private String reference;
	private String manufacturer;
	private PurchaseUnit purchaseUnit;
	private BigDecimal price;
		
	 */
	
	

}
