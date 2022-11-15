package br.com.adrielrodrigues.apporders.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.adrielrodrigues.apporders.model.Quotation;
import br.com.adrielrodrigues.apporders.model.QuotationStatus;

public class QuotationDto {
	
	private Long id;
	private LocalDate quotationDate;
	private BigDecimal finalPrice;	
	private QuotationStatus quotationStatus;
	
	public QuotationDto() {
	}

	public QuotationDto(Long id, LocalDate quotationDate, BigDecimal finalPrice, QuotationStatus quotationStatus) {
		this.id = id;
		this.quotationDate = quotationDate;
		this.finalPrice = finalPrice;
		this.quotationStatus = quotationStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getQuotationDate() {
		return quotationDate;
	}

	public void setQuotationDate(LocalDate quotationDate) {
		this.quotationDate = quotationDate;
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

	public static Quotation toQuotation(QuotationDto quotationDto) {

		Quotation quotation = new Quotation();
		
		quotation.setQuotationDate(quotationDto.getQuotationDate());
		quotation.setFinalPrice(quotationDto.getFinalPrice());
		quotation.setQuotationStatus(quotationDto.getQuotationStatus());
		return quotation;
	}
	
	public static Quotation toQuotation(QuotationDto quotationDto, Long id) {

		Quotation quotation = new Quotation();
		
		quotation.setId(id);
		quotation.setQuotationDate(quotationDto.getQuotationDate());
		quotation.setFinalPrice(quotationDto.getFinalPrice());
		quotation.setQuotationStatus(quotationDto.getQuotationStatus());
		return quotation;
	}
	
}
