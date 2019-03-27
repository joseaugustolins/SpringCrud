package springbootcrud.modelo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
	Funcionario findByCpf(Long cpf);
	List<Funcionario> findByNome(String nome);	
}