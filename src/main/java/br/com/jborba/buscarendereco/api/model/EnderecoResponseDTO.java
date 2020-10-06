package br.com.jborba.buscarendereco.api.model;

import lombok.Builder;

@Builder
public class EnderecoResponseDTO implements Endereco {
	 
	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String uf;
	
	@Override
	public String getCep() {
		return cep;
	}

	@Override
	public String getRua() {
		return rua;
	}

	@Override
	public String getBairro() { 
		return bairro;
	}

	@Override
	public String getCidade() {
		return cidade;
	}

	@Override
	public String getUf() { 
		return uf;
	}
	
	public boolean isEnderecoValido() {
		return cep!= null
				&& rua != null
				&& bairro != null
				&& cidade != null
				&& uf != null; 
	}

	@Override
	public String toString() {
		return "EnderecoResponseDTO [cep=" + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", uf=" + uf + "]";
	}

}
