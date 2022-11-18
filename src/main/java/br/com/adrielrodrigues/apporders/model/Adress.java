package br.com.adrielrodrigues.apporders.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.adrielrodrigues.apporders.controller.dto.AdressDto;

@Entity
public class Adress {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull @NotEmpty
	private String adress;
	@NotNull
	private Integer number;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	@Column(name="client_id", updatable=false, insertable=false)
	private Long clientId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false)
	private Client client;
	
	public Adress() {
	}
	
	public Adress(Long id, String adress, Integer number, String city, String state, String country, String zipCode) {
		this.id = id;
		this.adress = adress;
		this.number = number;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", adress=" + adress + ", number=" + number + ", city=" + city + ", state=" + state
				+ ", country=" + country + ", zipCode=" + zipCode + ", client=" + client + "]";
	}

	// create
	public static List<AdressDto> toAdressDto(List<Adress> adresses) {
		
		List<AdressDto> adressesDto = new ArrayList<>();
		
		adresses.forEach (a -> {
			
			AdressDto adressDto = new AdressDto();
			
			adressDto.setId(a.getId());
			adressDto.setAdress(a.getAdress());
			adressDto.setNumber(a.getNumber());
			adressDto.setCity(a.getCity());
			adressDto.setState(a.getState());
			adressDto.setCountry(a.getCountry());
			adressDto.setZipCode(a.getZipCode());
			adressDto.setClientId(a.getClientId());
			
			adressesDto.add(adressDto);
						
		});
		
		return adressesDto;
	}
	
	public static AdressDto toAdressDto(Adress adress) {
			
			
			AdressDto adressDto = new AdressDto();
			
			adressDto.setId(adress.getId());
			adressDto.setAdress(adress.getAdress());
			adressDto.setNumber(adress.getNumber());
			adressDto.setCity(adress.getCity());
			adressDto.setState(adress.getState());
			adressDto.setCountry(adress.getCountry());
			adressDto.setZipCode(adress.getZipCode());
			adressDto.setClientId(adress.getClientId());
		
		return adressDto;
	}
}
