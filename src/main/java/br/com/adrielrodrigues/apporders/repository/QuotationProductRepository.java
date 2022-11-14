package br.com.adrielrodrigues.apporders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adrielrodrigues.apporders.model.QuotationProduct;

public interface QuotationProductRepository extends JpaRepository<QuotationProduct, Long> {

}
