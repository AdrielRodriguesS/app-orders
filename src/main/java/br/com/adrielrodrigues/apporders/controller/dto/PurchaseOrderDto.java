package br.com.adrielrodrigues.apporders.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.adrielrodrigues.apporders.model.OrderStatus;
import br.com.adrielrodrigues.apporders.model.PurchaseOrder;

public class PurchaseOrderDto {
	
	private Long id;
	private LocalDate purchaseOrderDate;
	private BigDecimal finalPrice;	
	private OrderStatus orderStatus;
	
	public PurchaseOrderDto() {
	}

	public PurchaseOrderDto(Long id, LocalDate purchaseOrderDate, BigDecimal finalPrice, OrderStatus orderStatus) {
		this.id = id;
		this.purchaseOrderDate = purchaseOrderDate;
		this.finalPrice = finalPrice;
		this.orderStatus = orderStatus;
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
	
	public static PurchaseOrder toPurchaseOrder(PurchaseOrderDto purchaseOrderDto) {
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		
		purchaseOrder.setPurchaseOrderDate(purchaseOrderDto.getPurchaseOrderDate());
		purchaseOrder.setFinalPrice(purchaseOrderDto.getFinalPrice());
		purchaseOrder.setOrderStatus(purchaseOrderDto.getOrderStatus());
		
		return purchaseOrder;		
	}
	
	public static PurchaseOrder toPurchaseOrder(PurchaseOrderDto purchaseOrderDto, Long id) {
		
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		
		purchaseOrder.setId(id);
		purchaseOrder.setPurchaseOrderDate(purchaseOrderDto.getPurchaseOrderDate());
		purchaseOrder.setFinalPrice(purchaseOrderDto.getFinalPrice());
		purchaseOrder.setOrderStatus(purchaseOrderDto.getOrderStatus());
		
		return purchaseOrder;		
	}

}
