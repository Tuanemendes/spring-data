package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.UnidadeDeTrabalho;
import br.com.alura.spring.data.repository.CargoRepository;
import br.com.alura.spring.data.repository.FuncionarioRepository;
import br.com.alura.spring.data.repository.UnidadeDeTrabalhoRepository;

@Service
public class CrudFuncionarioService {
	
	private final FuncionarioRepository funcionarioRepository;
	private final CargoRepository cargoRepository;
	private final UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository;
	
	private Boolean system = true;
	
	//formatação de data 
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository,UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository ) {
		this.funcionarioRepository = funcionarioRepository;
		this.cargoRepository = cargoRepository;
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
				buscarTodos(scanner);
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
		System.out.println("Digite o nome:");
		String nome = scanner.next();
		
		System.out.println("Digite o CPF:");
		String cpf = scanner.next();
		
		System.out.println("Digite o salario:");
		Double salario = scanner.nextDouble();
				
		System.out.println("Digite data da contratação:");
		String dataContratacao = scanner.next();
		
		System.out.println("Digite o cargo Id:");
		Integer cargoId = scanner.nextInt();
		
		List<UnidadeDeTrabalho> unidades = unidade(scanner);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDataContratacao(LocalDate.parse(dataContratacao,formatter));
		Optional<Cargo> cargo = cargoRepository.findById(cargoId);
		funcionario.setCargo(cargo.get());
		funcionario.setUnidadeDeTrabalhos(unidades);
		
		funcionarioRepository.save(funcionario);
		System.out.println("Funcionario salvo com sucesso!");
	}
	
	private List<UnidadeDeTrabalho>unidade(Scanner scanner){
		Boolean isTrue = true;
		List<UnidadeDeTrabalho> unidades = new  ArrayList<>();
		
		while(isTrue) {
			System.out.println("Digite a unidadeId (Para sair digite 0)");
			Integer unidadeId = scanner.nextInt();
			
			if (unidadeId != 0 ) {
				Optional<UnidadeDeTrabalho> unidade = unidadeDeTrabalhoRepository.findById(unidadeId);
				unidades.add(unidade.get());
			}else {
				isTrue = false;
			}
		}
		return unidades;
	}
	
	
	
	public void atualizar(Scanner scanner) {
		System.out.println("Digite o nome:");
		String nome = scanner.next();
		
		System.out.println("Digite o CPF:");
		String cpf = scanner.next();
		
		System.out.println("Digite o salario:");
		Double salario = scanner.nextDouble();
				
		System.out.println("Digite data da contratação:");
		String dataContratacao = scanner.next();
		
		System.out.println("Digite o cargo Id:");
		Integer cargoId = scanner.nextInt();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionario.setCpf(cpf);
		funcionario.setSalario(salario);
		funcionario.setDataContratacao(LocalDate.parse(dataContratacao,formatter));
		Optional<Cargo> cargo = cargoRepository.findById(cargoId);
		funcionario.setCargo(cargo.get());
		
		funcionarioRepository.save(funcionario);
		
		System.out.println("Funcionario atualizado com sucesso!");
	}
	public void buscarTodos(Scanner scanner) {
		System.out.println("qual pagina deseja visualizar?");
		Integer page = scanner.nextInt();
		
		//Pageable pageable = PageRequest.of(page, 3, Sort.unsorted()); sem ordenação 
		// page é a pagina  3 é o numero de paginas 
		Pageable pageable = PageRequest.of(page, 3, Sort.by(Sort.Direction.DESC,"salario")); // com ordenação descrescente salario sendo o nome da coluna no banco 
		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
		
		System.out.println(funcionarios);
		System.out.println("Pagina Atual " + funcionarios.getNumber());
		System.out.println("Total de elementos" + funcionarios.getTotalElements());
		
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}
	public void deletar(Scanner scanner ){
		System.out.println("Informe o id para deletar funcionario:");
		int id = scanner.nextInt();
		funcionarioRepository.deleteById(id);
		System.out.println("Funcionario deletado sucesso!");
		
	}
}
