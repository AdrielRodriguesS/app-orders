package br.com.adrielrodrigues.apporders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.adrielrodrigues.apporders.controller.dto.FormQuotationDto;
import br.com.adrielrodrigues.apporders.model.Quotation;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long> {

//	@Query("SELECT q.finalPrice, q.quotationDate, q.quotationStatus, "
//			+ "c.cnpj, c.companyName, c.email, c.phone, "
//			+ "a.adress, a.number, a.city, a.state, a.country, a.zipCode, "
//			+ "qp.quantity, qp.totalPrice,"
//			+ "p.description, p.reference, p.manufacturer, p.purchaseUnit, p.price, "
//			+ "FROM Quotation q JOIN Client c JOIN Adress a JOIN QuotationProduct qp JOIN Product p "
//			+ "WHERE c.id = :id "
//			+ "AND a.clientId = c.id "
//			+ "AND q.client = c.id "
//			+ "AND qp.quotationId = q.client")	
//	FormQuotationDto FindQuotationData (/*@Param("id")*/Long id);
	
}
