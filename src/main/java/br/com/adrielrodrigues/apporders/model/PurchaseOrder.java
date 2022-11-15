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

import br.com.adrielrodrigues.apporders.controller.dto.PurchaseOrderDto;

@Entity
public class PurchaseOrder {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate purchaseOrderDate;
	private BigDecimal finalPrice;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "purchaseOrder", fetch = FetchType.LAZY)
	private List<QuotationProduct> quotationProducts;
	
	public PurchaseOrder() {
	}
	
	public PurchaseOrder(Long id, LocalDate purchaseOrderDate, BigDecimal finalPrice, OrderStatus orderStatus,
			List<QuotationProduct> quotationProducts) {
		super();
		this.id = id;
		this.purchaseOrderDate = purchaseOrderDate;
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

	public LocalDate getPurchaseOrderDate() {
		return purchaseOrderDate;
	}

	public void setPurchaseOrderDate(LocalDate purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
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
	
	public static List<PurchaseOrderDto> toPurchaseOrderDto(List<PurchaseOrder> purchaseOrders){
		
		List<PurchaseOrderDto> purchaseOrdersDto = new ArrayList<>();
		
		purchaseOrders.forEach(p -> {
			
			PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();
			
			purchaseOrderDto.setId(p.getId());
			purchaseOrderDto.setPurchaseOrderDate(p.getPurchaseOrderDate());
			purchaseOrderDto.setFinalPrice(p.getFinalPrice());
			purchaseOrderDto.setOrderStatus(p.getOrderStatus());
			
			purchaseOrdersDto.add(purchaseOrderDto);			
		});
		
		return purchaseOrdersDto;
	}
	
	public static PurchaseOrderDto toPurchaseOrderDto(PurchaseOrder purchaseOrder){
		
		
		PurchaseOrderDto purchaseOrderDto = new PurchaseOrderDto();
		
		purchaseOrderDto.setId(purchaseOrder.getId());
		purchaseOrderDto.setPurchaseOrderDate(purchaseOrder.getPurchaseOrderDate());
		purchaseOrderDto.setFinalPrice(purchaseOrder.getFinalPrice());
		purchaseOrderDto.setOrderStatus(purchaseOrder.getOrderStatus());
		
		return purchaseOrderDto;
	}

}
