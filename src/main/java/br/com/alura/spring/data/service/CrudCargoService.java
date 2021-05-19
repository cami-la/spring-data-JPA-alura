package br.com.alura.spring.data.service;

import java.util.Iterator;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

	private Boolean system = true;
	private final CargoRepository cargoRepository;

	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
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
		System.out.println("Informe o Id do cargo que deseja deletar: ");
		
		int id = scan.nextInt();
		
		Cargo cargo = this.cargoRepository.findById(id).get();
		
		this.cargoRepository.delete(cargo);
		
		System.out.printf("Cargo %s deletado com sucesso!\n", cargo.getDescricao());

	}

	private void visualizar() {
		Iterator<Cargo> cargos = this.cargoRepository.findAll().iterator();
		
		while(cargos.hasNext()) {
			System.out.println(cargos.next());
		}
		
	}
	
	private void atualizar(Scanner scan) {		
		scan.useDelimiter("\n");
		System.out.println("Informe o Id do cargo que deseja atualizar: ");
		
		Integer id = scan.nextInt();
		
		Cargo cargo = this.cargoRepository.findById(id).get();
		
		System.out.println("Novo cargo: ");
		
		String novoCargo = scan.next();
		
		cargo.setDescricao(novoCargo);
		
		this.cargoRepository.save(cargo);
		
		System.out.printf("Cargo de id %d atualizado com sucesso: %s!\n", id, cargo.getDescricao());
		
	}

	private void salvar(Scanner scan) {
		System.out.println("Descrição do cargo: ");
		scan.useDelimiter("\n");

		String descricao = scan.next();

		Cargo cargo = new Cargo(descricao);

		this.cargoRepository.save(cargo);

		System.out.println("Salvo");
	}
	
}
