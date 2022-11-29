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

import br.com.adrielrodrigues.apporders.controller.dto.FormQuotationDto;
import br.com.adrielrodrigues.apporders.controller.dto.QuotationDto;
import br.com.adrielrodrigues.apporders.model.Quotation;
import br.com.adrielrodrigues.apporders.repository.QuotationRepository;

@RestController
@RequestMapping("/quotations")
public class QuotationController {
	
	@Autowired
	private QuotationRepository quotationRepository;
	
	@GetMapping
	public List<QuotationDto> findAll(){
		List<Quotation> quotations = quotationRepository.findAll();
		
		return Quotation.toQuotationDto(quotations);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		
		Quotation quotation = quotationRepository.findById(id).get();
		
		QuotationDto quotationDto = Quotation.toQuotationDto(quotation);
		
		return ResponseEntity.ok().body(quotationDto);
	}
	
	@PostMapping
	public ResponseEntity<QuotationDto> create(@RequestBody QuotationDto quotationDto, UriComponentsBuilder uriBuilder){
		
		Quotation quotation = QuotationDto.toQuotation(quotationDto);
		
		quotationRepository.save(quotation);
		
		URI uri = uriBuilder.path("/quotations/{id}").buildAndExpand(quotation.getId()).toUri();
		
		return ResponseEntity.created(uri).body(Quotation.toQuotationDto(quotation));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<QuotationDto> update(@RequestBody QuotationDto quotationDto, @PathVariable Long id){
		
		Quotation quotation = quotationRepository.findById(id).get();
		
		quotation = QuotationDto.toQuotation(quotationDto, id);
		
		quotationRepository.save(quotation);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		quotationRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
		
}
