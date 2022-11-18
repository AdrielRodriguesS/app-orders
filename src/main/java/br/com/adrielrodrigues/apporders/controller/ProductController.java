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

import br.com.adrielrodrigues.apporders.controller.dto.ProductDto;
import br.com.adrielrodrigues.apporders.model.Product;
import br.com.adrielrodrigues.apporders.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
		
	@GetMapping
	public List<ProductDto> findAll() {
		List<Product> products = productRepository.findAll();
		return Product.toProductDto(products);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		Product product = productRepository.findById(id).get();
		ProductDto productDto = Product.toProductDto(product);
		return ResponseEntity.ok().body(productDto);
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto, UriComponentsBuilder uriBuilder){
		
		Product product = productDto.toProduct(productDto);
		
		productRepository.save(product);
		
		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		
		return ResponseEntity.created(uri).body(Product.toProductDto(product));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> update (@RequestBody ProductDto productDto, @PathVariable("id") Long id){
		
		Product product = productRepository.findById(id).get();
		
		product = productDto.toProduct(productDto, id);
		
		productRepository.save(product);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		productRepository.deleteById(id);
		
		return ResponseEntity.ok().build();	
		
	}
}
