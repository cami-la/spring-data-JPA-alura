package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private Boolean system = true;
	
	private final CrudCargoService cargoService;

	private final CrudFuncionarioService funcionarioService;

	private CrudUnidadeTrabalhoService unidadeTrabalhoService;
	
	
	public SpringDataApplication(CrudCargoService cargoService, CrudFuncionarioService funcionarioService,
			CrudUnidadeTrabalhoService unidadeTrabalhoService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		while(system) {
			System.out.println("\nQual ação você quer executar: ");
			System.out.println("0 - sair ");
			System.out.println("1 - cargo ");
			System.out.println("2 - funcionário ");
			System.out.println("3 - unidade de trabalho ");

			
			int action = scan.nextInt();
			switch(action) {
			case 1: cargoService.inicial(scan); break;
			case 2: funcionarioService.inicial(scan); break;
			case 3: unidadeTrabalhoService.inicial(scan); break;
			default: system = false;
			}
		}
	}
}
