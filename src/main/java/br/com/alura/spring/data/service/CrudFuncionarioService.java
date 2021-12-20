package br.com.alura.spring.data.service;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {
	
	private final  FuncionarioRepository  funcionarioRepository;
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	
}
