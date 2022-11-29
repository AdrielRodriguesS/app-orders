package br.com.adrielrodrigues.apporders.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.adrielrodrigues.apporders.controller.dto.ClientDto;

@Entity
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String companyName;
	private String cnpj;
	private String email;
	private String phone;
	private LocalDate clientSince;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Adress> adresses = new ArrayList<>();
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Quotation> quotations;
	
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
	
	public static List<ClientDto> toClientDto(List<Client> clients) {
		
		List<ClientDto> clientsDto = new ArrayList<>();
		
		clients.forEach(c -> {
		
		ClientDto clientDto= new ClientDto();
		
		clientDto.setId(c.getId());
		clientDto.setCompanyName(c.getCompanyName());
		clientDto.setCnpj(c.getCnpj());
		clientDto.setEmail(c.getEmail());
		clientDto.setPhone(c.getPhone());
		clientDto.setClientSince(c.getClientSince());
		clientDto.setAdresses(c.getAdresses());
		
		clientsDto.add(clientDto);});
		
		return clientsDto;		
	}
	
	public static ClientDto toClientDto(Client client) {
			
		
		ClientDto clientDto= new ClientDto();
		
		clientDto.setId(client.getId());
		clientDto.setCompanyName(client.getCompanyName());
		clientDto.setCnpj(client.getCnpj());
		clientDto.setEmail(client.getEmail());
		clientDto.setPhone(client.getPhone());
		clientDto.setClientSince(client.getClientSince());
		clientDto.setAdresses(client.getAdresses());
				
		return clientDto;		
	}
	
}
