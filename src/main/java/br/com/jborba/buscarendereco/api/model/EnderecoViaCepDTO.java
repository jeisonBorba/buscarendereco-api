package br.com.jborba.buscarendereco.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnderecoViaCepDTO implements Endereco {
	
	private String cep;
	
	@JsonProperty("logradouro")
	private String rua; 
	
	private String bairro;
	
	@JsonProperty("localidade")
	private String cidade;
	
	private String uf;
	
	public EnderecoViaCepDTO() {
		
	}
	
	@Override
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Override
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "EnderecoViaCEPDTO [cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", uf="
				+ uf + "]";
	}

}
