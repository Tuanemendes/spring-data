package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeDeTrabalhoService;
import br.com.alura.spring.data.service.RelatoriosService;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	// objeto criado para salvar
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeDeTrabalhoService unidadeDeTrabalhoService;
	private final RelatoriosService relatoriosService;
	
	private Boolean system = true;
	
	//injeção de dependecia
	public SpringDataApplication(CrudCargoService cargoService,CrudFuncionarioService funcionarioService, CrudUnidadeDeTrabalhoService unidadeDeTrabalhoService, RelatoriosService relatoriosService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeDeTrabalhoService = unidadeDeTrabalhoService;
		this.relatoriosService = relatoriosService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(system) {
			System.out.println("Escolha uma opção:");
			System.out.println("0-Sair");
			System.out.println("1-Cargo");
			System.out.println("2-Funcionario");
			System.out.println("3-Unidade de Trabalho");
			System.out.println("4-Relatorio Funcionario");
		
			
			Integer  action = scanner.nextInt();
			
			switch (action) {
			case 1:
				cargoService.inicial(scanner);
				break;
			case 2:
				funcionarioService.inicial(scanner);
				break;
			case 3:
				unidadeDeTrabalhoService.inicial(scanner);
				break;
			case 4:
				relatoriosService.inicial(scanner);
			default:
				System.out.println("Fim!");
				system = false;
				break;
			}
	
			
		}
	
	}
	

}
