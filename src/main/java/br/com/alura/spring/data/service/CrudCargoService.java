package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private final CargoRepository cargoRepository;


	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial (Scanner scan) {
		salvar(scan);
	}
	
	private void salvar(Scanner scan) {
		System.out.println("Descrição do cargo: ");
		scan.useDelimiter("\n");
		
		String descricao = scan.next();
		
		Cargo cargo = new Cargo(descricao);
		
		cargoRepository.save(cargo);
		
		System.out.println("Salvo");
	}
}
