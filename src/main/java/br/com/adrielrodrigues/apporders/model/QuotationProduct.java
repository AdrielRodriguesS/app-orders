package br.com.adrielrodrigues.apporders.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.adrielrodrigues.apporders.controller.dto.QuotationProductDto;

@Entity
public class QuotationProduct {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer quantity;
	private BigDecimal totalPrice;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quotation_id")
	private Quotation quotation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private PurchaseOrder purchaseOrder;
	
	public QuotationProduct() {
	}

	public QuotationProduct(Long id, Integer quantity, BigDecimal totalPrice, Product product) {
		this.id = id;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Quotation getQuotation() {
		return quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public static List<QuotationProductDto> toQuotationProductDto(List<QuotationProduct> quotations) {

		List<QuotationProductDto> quotationproductsDto = new ArrayList<>();
		
		quotations.forEach(q -> {
			
			QuotationProductDto quotationProductDto = new QuotationProductDto();
			
			quotationProductDto.setId(q.getId());
			quotationProductDto.setQuantity(q.getQuantity());
			quotationProductDto.setTotalPrice(q.getTotalPrice());
			
			quotationproductsDto.add(quotationProductDto);
		});
		
		return quotationproductsDto;
	}
	
	public static QuotationProductDto toQuotationProductDto(QuotationProduct quotationProduct) {
			
			QuotationProductDto quotationProductDto = new QuotationProductDto();
			
			quotationProductDto.setId(quotationProduct.getId());
			quotationProductDto.setQuantity(quotationProduct.getQuantity());
			quotationProductDto.setTotalPrice(quotationProduct.getTotalPrice());

		
		return quotationProductDto;
	}

}
