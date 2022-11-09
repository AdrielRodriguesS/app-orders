package br.com.adrielrodrigues.apporders.controller.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import br.com.adrielrodrigues.apporders.model.Adress;

public class AdressDto{
	
	private Long id;
	private String adress;
	
	@NotNull
	private Integer number;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private Long clientId;
		
	public AdressDto() {
		
	}
	
	public AdressDto(Long id, String adress, Integer number, String city,
			String state, String country, String zipCode) {
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

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}	

	@Override
	public String toString() {
		return "AdressDto [id=" + id + ", adress=" + adress + ", number=" + number + ", city=" + city + ", state="
				+ state + ", country=" + country + ", zipCode=" + zipCode + ", clientId=" + clientId + "]";
	}

	public static Adress toAdressDto(AdressDto adressDto) {		
		
		Adress adress = new Adress();
				
		adress.setAdress(adressDto.getAdress());
		adress.setNumber(adressDto.getNumber());
		adress.setCity(adressDto.getCity());
		adress.setState(adressDto.getState());
		adress.setCountry(adressDto.getCountry());
		adress.setZipCode(adressDto.getZipCode());
		adress.setClientId(adressDto.getClientId());

		return adress;
	}
	
	public static Adress toAdressDto(AdressDto adressDto, Long id) {		
		
		Adress adress = new Adress();
		
		adress.setId(id);				
		adress.setAdress(adressDto.getAdress());
		adress.setNumber(adressDto.getNumber());
		adress.setCity(adressDto.getCity());
		adress.setState(adressDto.getState());
		adress.setCountry(adressDto.getCountry());
		adress.setZipCode(adressDto.getZipCode());
		adress.setClientId(adressDto.getClientId());

		return adress;
	}
}
