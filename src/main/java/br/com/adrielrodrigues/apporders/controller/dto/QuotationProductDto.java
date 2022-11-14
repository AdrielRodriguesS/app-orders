package br.com.adrielrodrigues.apporders.controller.dto;

import java.math.BigDecimal;

import br.com.adrielrodrigues.apporders.model.QuotationProduct;

public class QuotationProductDto {
	
	private Long id;
	private Integer quantity;
	private BigDecimal totalPrice;
	
	public QuotationProductDto() {
	}

	public QuotationProductDto(Long id, Integer quantity, BigDecimal totalPrice) {
		this.id = id;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
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

	public static QuotationProduct toQuotationProduct(QuotationProductDto quotationProductDto) {

		
		QuotationProduct quotationProduct = new QuotationProduct();
		
		quotationProduct.setQuantity(quotationProductDto.getQuantity());
		quotationProduct.setTotalPrice(quotationProductDto.getTotalPrice());
		
		return quotationProduct;
	}
	
	public static QuotationProduct toQuotationProduct(QuotationProductDto quotationProductDto, Long id) {
		
		QuotationProduct quotationProduct = new QuotationProduct();

		quotationProduct.setId(id);
		quotationProduct.setQuantity(quotationProductDto.getQuantity());
		quotationProduct.setTotalPrice(quotationProductDto.getTotalPrice());
		
		return quotationProduct;
	}

}
