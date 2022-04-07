package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	
	private Boolean system = true;
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final FuncionarioRepository funcionarioRepository;
	
	
	
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial (Scanner scanner) {
		
		while(system) {
			System.out.println("Selecione qual das opções:");
			System.out.println("0 - Sair");
			System.out.println("1 - Buscar nome funcionario");
			System.out.println("2 - Buscar funcionario nome, salario maior,data contratação");
			System.out.println("3 - Buscar funcionario data contratação");
			
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscarFuncionario(scanner);
				break;
			case 2:
				buscarFuncionarioNomeSalarioMaiorData(scanner);
				break;
			case 3:
				buscaFuncionarioDataContratacao(scanner);
				break;
			default:
				System.out.println("Fim!");
				system = false;
				break;
			}	
		}		
	}

	

	private void buscarFuncionario(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}

	private void buscarFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("qual o nome :");
		String nome = scanner.next();
		
		System.out.println("qual o maior salario:");
		Double maiorSalario = scanner.nextDouble();
		
		System.out.println("qual a Data da contratação:");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data,formatter);
		
		List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome,maiorSalario,localDate);
		list.forEach(System.out::println);
		
	}
	
	private void buscaFuncionarioDataContratacao(Scanner scanner) {
		
		System.out.println("Qual a data de contratação :");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data,formatter);
		
	    List<Funcionario> list = funcionarioRepository.findDataContratadaMaior(localDate);
		list.forEach(System.out::println);
	}
}
