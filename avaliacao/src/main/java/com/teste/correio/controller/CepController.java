package com.teste.correio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.teste.correio.dto.CepResponse;
import com.teste.correio.service.CepService;

@RestController
@RequestMapping("/correio")
public class CepController {
	
	@Autowired
	private CepService cepService;
	
	@ResponseBody
	@GetMapping("/consulta/{cep}")
	public ResponseEntity<CepResponse> consultaPorCep (@PathVariable("cep") String pCep) {
		
		return cepService.consultaPorCep("cep", pCep);
		
		
	}

}
