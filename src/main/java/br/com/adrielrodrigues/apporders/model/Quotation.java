package br.com.adrielrodrigues.apporders.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import br.com.adrielrodrigues.apporders.controller.dto.QuotationDto;

@Entity
public class Quotation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate quotationDate;
	private BigDecimal finalPrice;
	
	@Enumerated(EnumType.STRING)
	private QuotationStatus quotationStatus;
	
	@OneToMany(mappedBy = "quotation", fetch = FetchType.LAZY)
	private List<QuotationProduct> quotationProducts;
	
	public Quotation() {
	}

	public Quotation(Long id, LocalDate quotationDate, BigDecimal finalPrice, QuotationStatus quotationStatus,
			List<QuotationProduct> quotationProduct) {
		super();
		this.id = id;
		this.quotationDate = quotationDate;
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

	public List<QuotationProduct> getQuotationProducts() {
		return quotationProducts;
	}

	public void setQuotationProducts(List<QuotationProduct> quotationProducts) {
		this.quotationProducts = quotationProducts;
	}

	public static List<QuotationDto> toQuotationDto(List<Quotation> quotations) {

		List<QuotationDto> quotationsDto = new ArrayList<>();
		
		quotations.forEach(q -> {
			
			QuotationDto quotationDto =  new QuotationDto();
			
			quotationDto.setId(q.getId());
			quotationDto.setQuotationDate(q.getQuotationDate());
			quotationDto.setFinalPrice(q.getFinalPrice());
			quotationDto.setQuotationStatus(q.getQuotationStatus());
			
			quotationsDto.add(quotationDto);
		});
		
		
		return quotationsDto;
	}
	
	public static QuotationDto toQuotationDto(Quotation quotation) {

			QuotationDto quotationDto =  new QuotationDto();
			
			quotationDto.setId(quotation.getId());
			quotationDto.setQuotationDate(quotation.getQuotationDate());
			quotationDto.setFinalPrice(quotation.getFinalPrice());
			quotationDto.setQuotationStatus(quotation.getQuotationStatus());
		
		return quotationDto;
	}
	
}
