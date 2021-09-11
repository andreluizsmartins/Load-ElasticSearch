package br.com.elastic.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import br.com.sankhya.dao.loadDB;

@SpringBootApplication
@Controller
public class ElasticApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticApplication.class, args);
		
		loadDB.get();
		
	}

}
