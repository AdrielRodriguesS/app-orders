package br.com.adrielrodrigues.apporders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.adrielrodrigues.apporders.controller.dto.PurchaseOrderDto;
import br.com.adrielrodrigues.apporders.model.PurchaseOrder;
import br.com.adrielrodrigues.apporders.repository.PurchaseOrderRepository;

@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	
	@GetMapping
	public List<PurchaseOrderDto> findAll(){
		List<PurchaseOrder> purchaseOrders = purchaseOrderRepository.findAll();
		
		return PurchaseOrder.toPurchaseOrderDto(purchaseOrders);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		
		PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).get();
		
		PurchaseOrderDto purchaseOrderDto = PurchaseOrder.toPurchaseOrderDto(purchaseOrder);
		
		return ResponseEntity.ok().body(purchaseOrderDto);
	}
	
	@PostMapping
	public ResponseEntity<PurchaseOrderDto> create(@RequestBody PurchaseOrderDto purchaseOrderDto){
		
		PurchaseOrder purchaseOrder = PurchaseOrderDto.toPurchaseOrder(purchaseOrderDto);
		
		purchaseOrderRepository.save(purchaseOrder);
		
		return ResponseEntity.ok().build();		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PurchaseOrderDto> update(@RequestBody PurchaseOrderDto purchaseOrderDto, @PathVariable Long id){
		
		PurchaseOrder purchaseOrder = purchaseOrderRepository.findById(id).get();
		
		purchaseOrder = PurchaseOrderDto.toPurchaseOrder(purchaseOrderDto, id);
		
		purchaseOrderRepository.save(purchaseOrder);
		
		return ResponseEntity.ok().build();	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		purchaseOrderRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	

}
