package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>{
	
	//Derived Queries
	List<Funcionario> findByNome(String nome);
	
	//JPQL script no banco 
	@Query("SELECT f FROM Funcionario f WHERE f.nome=:nome AND f.salario >=:salario AND f.dataContratacao=:data")
	List<Funcionario>findNomeSalarioMaiorDataContratacao(@Param("nome") String nome, @Param("salario") Double salario,@Param("data") LocalDate data);
	
	
	//native query do banco maria DB
	@Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true )
	List<Funcionario>findDataContratadaMaior(LocalDate data);
	
	@Query(value = "SELECT f.id,f.nome,f.salario FROM funcionarios f ",nativeQuery = true)
	List<FuncionarioProjecao> findFuncionariSalario();
	
}
