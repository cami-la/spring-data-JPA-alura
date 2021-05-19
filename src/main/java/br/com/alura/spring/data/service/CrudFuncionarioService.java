package br.com.alura.spring.data.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {
	
	private Boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository;
	
	DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scan) {
		while (system) {
			System.out.println("Escolha a opção desejada: ");
			System.out.println("0 - sair");
			System.out.println("1 - salvar");
			System.out.println("2 - atualizar");
			System.out.println("3 - visualizar");
			System.out.println("4 - deletar");


			int action = scan.nextInt();
			switch (action) {
			case 1:
				salvar(scan); break;
			case 2:
				atualizar(scan); break;
			case 3:
				visualizar(); break;
			case 4:
				deletar(scan); break;
			default: system = false; break;
			}
		}
	}

	private void deletar(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	private void visualizar() {
		// TODO Auto-generated method stub
		
	}

	private void atualizar(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	private void salvar(Scanner scan) {
		scan.useDelimiter("\n");
		System.out.println("Preencha as opções a seguir: ");
		
		String nome = scan.next();
		String cpf = scan.next();
		BigDecimal salario = scan.nextBigDecimal();
		
		String data = scan.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataContratacao = LocalDate.parse(data, formatter);
		
		//Funcionario funcionario = new Funcionario(nome, cpf, salario, dataContratacao, cargo);
		
	}

}
