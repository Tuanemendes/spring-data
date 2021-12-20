package br.com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.spring.data.orm.UnidadeDeTrabalho;

public interface UnidadeTrabalhoRepository extends CrudRepository<UnidadeDeTrabalho, Integer> {

}
