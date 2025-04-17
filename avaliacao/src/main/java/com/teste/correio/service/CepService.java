package com.teste.correio.service;


import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.teste.correio.dto.CepResponse;
import com.teste.correio.model.ConsultaCepModel;
import com.teste.correio.repository.CepRepository;


@Service
public class CepService {
	
	@Autowired
	private CepRepository cepRepository;


    public ResponseEntity<CepResponse> consultaPorCep(String tipoBusca, String parametroBusca) {

    	ResponseEntity<CepResponse> cepResponse = null;
        try {
        	cepResponse =buscaCep(parametroBusca);
        	
        	gravaLogConsulta (tipoBusca, parametroBusca, cepResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cepResponse;
    }
    
    private void gravaLogConsulta (String tipoBusca, String parametroBusca, ResponseEntity<CepResponse> response  ) {
    	
    	ConsultaCepModel consultaCepModel = new ConsultaCepModel();
    	
    	Date dataLog = new Date();
    	
    	consultaCepModel.setData(String.valueOf(dataLog.getTime()));
    	consultaCepModel.setIp("11");
    	consultaCepModel.setTipoConsulta(tipoBusca);
    	consultaCepModel.setParametroBusca(parametroBusca);
     	consultaCepModel.setResponse(response.toString());
     	
     	cepRepository.save(consultaCepModel);

    }
    
    
    private ResponseEntity<CepResponse>  buscaCep(String pCep) {
    	
    	String URL = "https://viacep.com.br/ws/"+pCep+"/json/";
    	RestTemplate rest = new RestTemplate();
    	CepResponse retorno = rest.getForObject(URL , CepResponse.class);
    	
        
        return ResponseEntity.ok(retorno);
    }
 
    
    
    
}
