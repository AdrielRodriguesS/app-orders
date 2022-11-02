package br.com.adrielrodrigues.apporders.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quotation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private BigDecimal finalPrice;
	
	@Enumerated(EnumType.STRING)
	private QuotationStatus quotationStatus;
	
	@OneToMany(mappedBy = "quotation", fetch = FetchType.LAZY)
	private List<QuotationProduct> quotationProducts;
	
	public Quotation() {
	}

	public Quotation(Long id, LocalDate date, BigDecimal finalPrice, QuotationStatus quotationStatus,
			List<QuotationProduct> quotationProduct) {
		super();
		this.id = id;
		this.date = date;
		this.finalPrice = finalPrice;
		this.quotationStatus = quotationStatus;
		this.quotationProducts = quotationProduct;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(BigDecimal finalPrice) {
		this.finalPrice = finalPrice;
	}

	public QuotationStatus getQuotationStatus() {
		return quotationStatus;
	}

	public void setQuotationStatus(QuotationStatus quotationStatus) {
		this.quotationStatus = quotationStatus;
	}

	public List<QuotationProduct> getQuotationProducts() {
		return quotationProducts;
	}

	public void setQuotationProducts(List<QuotationProduct> quotationProducts) {
		this.quotationProducts = quotationProducts;
	}
	
}
