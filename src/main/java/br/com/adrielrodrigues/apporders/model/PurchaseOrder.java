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
public class PurchaseOrder {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private BigDecimal finalPrice;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.LAZY)
	private List<QuotationProduct> quotationProducts;
	
	public PurchaseOrder() {
	}
	
	public PurchaseOrder(Long id, LocalDate date, BigDecimal finalPrice, OrderStatus orderStatus,
			List<QuotationProduct> quotationProducts) {
		super();
		this.id = id;
		this.date = date;
		this.finalPrice = finalPrice;
		this.orderStatus = orderStatus;
		this.quotationProducts = quotationProducts;
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

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<QuotationProduct> getQuotationProducts() {
		return quotationProducts;
	}

	public void setQuotationProducts(List<QuotationProduct> quotationProducts) {
		this.quotationProducts = quotationProducts;
	}	

}
