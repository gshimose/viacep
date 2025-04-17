package com.teste.correio.model;

import org.hibernate.annotations.Type;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Tb_Log_Consulta_Cep")
@Data
public class ConsultaCepModel {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "data", nullable = false, length = 20)
	    private String data;
	    
	    @Column(name = "ip", nullable = false, length = 20)
	    private String ip;

	    @Column(name = "tipoConsulta", nullable = false, length = 100)
	    private String tipoConsulta;
	    
	    @Column(name = "parametroBusca", nullable = false, length = 10)
	    private String parametroBusca;
	    
	    @Column(columnDefinition = "TEXT", nullable = false)
	    private String response;


}

