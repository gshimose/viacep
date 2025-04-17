package com.teste.correio.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.teste.correio.model.ConsultaCepModel;

public interface CepRepository extends JpaRepository<ConsultaCepModel, Long>    {
	
	ConsultaCepModel findByIpContaining(String pIp);


}
