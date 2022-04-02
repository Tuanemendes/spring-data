package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import br.com.alura.spring.data.repository.UnidadeDeTrabalhoRepository;
@Service
public class CrudUnidadeDeTrabalhoService {
	
	private final UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository;
	private Boolean system = true;
	public CrudUnidadeDeTrabalhoService(UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository) {
		this.unidadeDeTrabalhoRepository = unidadeDeTrabalhoRepository;
	}
		public void inicial(Scanner scanner) {
		
			while(system) {
				System.out.println("Escolha a opção:");
				System.out.println("0-Sair ");
				System.out.println("1-Inserir");
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
					deletar(scanner);
					break;
	
				default:
					system = false;
					break;
				}
			}
			salvar(scanner);
		}
	
	public void salvar(Scanner scanner) {
		System.out.println("Descricação da Unidade de Trabalho");
		String descricao = scanner.next();
		
		System.out.println("Ddo endereço");
		String endereco = scanner.next();
		
		UnidadeDeTrabalho unidadeDeTrabaho = new UnidadeDeTrabalho();
		unidadeDeTrabaho.setDescricao(descricao);
		unidadeDeTrabaho.setEndereco(endereco);
		unidadeDeTrabalhoRepository.save(unidadeDeTrabaho);
		System.out.println("Unidade de trabalho salva com sucesso!");
	}
	public void atualizar(Scanner scanner) {
		System.out.println("Informe o Id para atualizar:");
		int id = scanner.nextInt();
		System.out.println("Nova Descricão da Unidade de Trabalho:");
		String descricao = scanner.next();
		
		System.out.println("Novo enedereço  da Unidade de Trabalho:");
		String endereco = scanner.next();
		UnidadeDeTrabalho unidadeDeTrabalho = new UnidadeDeTrabalho();
		unidadeDeTrabalho.setId(id);
		unidadeDeTrabalho.setEndereco(endereco);
		unidadeDeTrabalho.setDescricao(descricao);
		unidadeDeTrabalho.setDescricao(endereco);
		unidadeDeTrabalhoRepository.save(unidadeDeTrabalho);
		System.out.println("Unidade de Trabalho atualizada com sucesso");
		
		
	}
	public void buscarTodos() {
		Iterable<UnidadeDeTrabalho>unidadesDeTrabalho = unidadeDeTrabalhoRepository.findAll();
		unidadesDeTrabalho.forEach(unidadeDeTrabalho -> System.out.println(unidadeDeTrabalho));
	}
	public void deletar(Scanner scanner){
		System.out.println("Infome o Id para unidade de trabakho ser deletada:");
		int id = scanner.nextInt();
		unidadeDeTrabalhoRepository.deleteById(id);
		System.out.println("Unidade de Trabalho deletada com sucesso!");
	}
}
