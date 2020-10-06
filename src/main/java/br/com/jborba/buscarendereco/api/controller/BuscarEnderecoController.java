package br.com.jborba.buscarendereco.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jborba.buscarendereco.api.model.EnderecoResponseDTO;
import br.com.jborba.buscarendereco.api.service.BuscarEnderecoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/buscar-endereco/cep")
public class BuscarEnderecoController {
	
	private BuscarEnderecoService buscarEnderecoService;
	
	public BuscarEnderecoController(BuscarEnderecoService buscarEnderecoService) {
		this.buscarEnderecoService = buscarEnderecoService;
	}
	
	@GetMapping("/{cep}")
	public ResponseEntity<EnderecoResponseDTO> buscarCep(@PathVariable("cep") String cep) throws Exception {
		log.info("Recebimento de requisição para o CEP {}", cep);
		
		EnderecoResponseDTO enderecoResponseDTO = buscarEnderecoService.buscarEndereco(cep);
		return ResponseEntity.ok(enderecoResponseDTO);
	}

}
