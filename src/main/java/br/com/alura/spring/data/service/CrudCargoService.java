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
		this.cargoRepository =cargoRepository;
	}
	
	public void  inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual ação de cargo deseja executar ?");
			System.out.println("0-Sair");
			System.out.println("1-Salvar");
			System.out.println("2-Atualizar");
			System.out.println("3-Buscar todos");
			System.out.println("4-Excluir");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				buscar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}	
		}	
	}
	public void salvar(Scanner scanner) {
		
		System.out.println("Descrição do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo!");
	}

	public void atualizar(Scanner scanner) {
		
		System.out.println("qual o ID?");
		int id = scanner.nextInt();
		System.out.println("Qual a nova descrição?");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		
		cargoRepository.save(cargo);
		
		System.out.println("Cargo Atulaizado com Sucesso!");
	}
	
	private void buscar() {
		
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo-> System.out.println(cargo));
		
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Excluido com sucesso !");
		
	}

}
