package springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springbootcrud.modelo.Departamento;
import springbootcrud.modelo.DepartamentoRepository;


@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public Departamento saveOrUpdate(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	public Iterable<Departamento> findAll(){
		return departamentoRepository.findAll();
	}
	
	public Departamento findById(Integer id) {
		Departamento departamento = departamentoRepository.findById(id).get();
		return departamento;
	}
	
	public void delete(Integer id) {
		Departamento departamento = findById(id);
		departamentoRepository.delete(departamento);
	}
	
}
