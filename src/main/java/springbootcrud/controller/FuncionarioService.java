package springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootcrud.modelo.Funcionario;
import springbootcrud.modelo.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	public Funcionario saveOrUpdate(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public Iterable<Funcionario> findAll(){
		return funcionarioRepository.findAll();
	}
	
	public Funcionario findByCpf(Long cpf) {
		return funcionarioRepository.findByCpf(cpf);
	}
	
	public void delete(Long cpf) {
		Funcionario funcionario = findByCpf(cpf);
		funcionarioRepository.delete(funcionario);
	}
	
}
