package br.com.adrielrodrigues.apporders.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String companyName;
	private String cnpj;
	private String email;
	private String phone;
	private LocalDate clientSince;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Adress> adresses = new ArrayList<>();
	
	public Client() {
	}
	
	public Client(Long id, String companyName, String cnpj, String email, String phone, LocalDate clientSince) {
		this.id = id;
		this.companyName = companyName;
		this.cnpj = cnpj;
		this.email = email;
		this.phone = phone;
		this.clientSince = clientSince;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public LocalDate getClientSince() {
		return clientSince;
	}
	
	public void setClientSince(LocalDate clientSince) {
		this.clientSince = clientSince;
	}

	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}
	
	
}
