package br.com.adrielrodrigues.apporders.controller;

import java.net.URI;
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
import org.springframework.web.util.UriComponentsBuilder;

import br.com.adrielrodrigues.apporders.controller.dto.QuotationProductDto;
import br.com.adrielrodrigues.apporders.model.Product;
import br.com.adrielrodrigues.apporders.model.QuotationProduct;
import br.com.adrielrodrigues.apporders.repository.ProductRepository;
import br.com.adrielrodrigues.apporders.repository.QuotationProductRepository;

@RestController
@RequestMapping("/quotation-products")
public class QuotationProductController {
	
	@Autowired
	private QuotationProductRepository quotationProductRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<QuotationProductDto> findAll(){
		List<QuotationProduct> quotationProducts = quotationProductRepository.findAll();
		return QuotationProduct.toQuotationProductDto(quotationProducts);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
	
		QuotationProduct quotationProduct = quotationProductRepository.findById(id).get();
		
		QuotationProductDto quotationProductDto = QuotationProduct.toQuotationProductDto(quotationProduct);
		
		return ResponseEntity.ok().body(quotationProductDto);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<QuotationProductDto> create(@RequestBody QuotationProductDto quotationProductDto,
			@PathVariable("id") Long id,  UriComponentsBuilder uriBuilder){
		
		Product product = productRepository.findById(id).get();
		
		QuotationProduct quotationProduct = QuotationProductDto.toQuotationProduct(quotationProductDto);
		
		quotationProduct.setProduct(product);
		
		quotationProductRepository.save(quotationProduct);
		
		URI uri = uriBuilder.path("/quotation-products/{id}").buildAndExpand(quotationProduct.getId()).toUri();
		
		return ResponseEntity.created(uri).body(QuotationProduct.toQuotationProductDto(quotationProduct));
			
	}

	@PutMapping("/{id}")
	public ResponseEntity<QuotationProductDto> update(@RequestBody QuotationProductDto quotationProductDto, @PathVariable("id") Long id) {
		
		QuotationProduct quotationProduct = quotationProductRepository.findById(id).get();
		
		quotationProduct = QuotationProductDto.toQuotationProduct(quotationProductDto, id);
		
		quotationProductRepository.save(quotationProduct);
		
		return ResponseEntity.ok().build();	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		quotationProductRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
}
