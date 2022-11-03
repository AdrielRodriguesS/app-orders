package br.com.adrielrodrigues.apporders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.adrielrodrigues.apporders.model.Quotation;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<Quotation, Long> {

}
