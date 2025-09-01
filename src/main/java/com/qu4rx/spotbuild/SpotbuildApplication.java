// Define o pacote onde esta classe está localizada
package com.qu4rx.spotbuild;

// Importa as classes necessárias do Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação que marca esta classe como uma aplicação Spring Boot
@SpringBootApplication
public class SpotbuildApplication {

	// Método principal que inicia a aplicação
	public static void main(String[] args) {
		// Executa a aplicação Spring Boot, passando a classe principal e os argumentos da linha de comando
		SpringApplication.run(SpotbuildApplication.class, args);
	}

}