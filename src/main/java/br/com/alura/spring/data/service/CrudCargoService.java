package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

	private final CargoRepository cargoRepository;
	
	private Boolean system = true;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository= cargoRepository;
	}
	
	public void inicial(Scanner scanner) {
		
		while(system) {
			System.out.println("Escolha a opção para cargo: ");
			System.out.println("0-Sair ");
			System.out.println("1-Salvar");
			System.out.println("2-Atualizar");
			System.out.println("3-Buscar Todos");
			System.out.println("4-Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				buscarTodos();
				break;
			case 4:
				deletarId(scanner);
				break;
				
			default:
				system = false;
				break;
			}
		}
		
		
	}
	
	private void salvar(Scanner scanner){
		System.out.println("Descrição do cargo:");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo!");
	}
	
	private void atualizar(Scanner scanner){
		System.out.println("Infome o id: ");
		int id = scanner.nextInt();
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo  cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado");
		
	}
	private void buscarTodos() {
		Iterable<Cargo> cargos	= cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	
	private void deletarId(Scanner scanner) {
		System.out.println("Informe qual vai ser deletado:");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado!");
	}
	
}
