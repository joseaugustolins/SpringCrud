package springbootcrud.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootcrud.modelo.Departamento;

@RestController
@RequestMapping("/api/departamento")
//@Controller //caso se queira usar web
@CrossOrigin //permite acessar de requisições externas


public class DepartamentoController {
     
	@Autowired
	private DepartamentoService departamentoService;
	
	
	@PostMapping("")
    public ResponseEntity<?> addDepartamento(@Valid @RequestBody Departamento departamento, BindingResult result){		
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Departamento novoDepartamento = departamentoService.saveOrUpdate(departamento);
        return new ResponseEntity<Departamento>(novoDepartamento, HttpStatus.CREATED);
    }
	
	@GetMapping("/all")
	public Iterable<Departamento> findAll(){
		return departamentoService.findAll();
	} 
    
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getFuncionarioById(@PathVariable Integer id){
		Departamento departamento = departamentoService.findById(id);
		return new ResponseEntity<Departamento>(departamento, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public Departamento updateDepartamento(@RequestBody Departamento departamento, @PathVariable Integer id) {
		Departamento dep = departamentoService.findById(id);
		dep.setNome(departamento.getNome());
		return departamentoService.saveOrUpdate(dep);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartamento(@PathVariable Integer id){
		System.out.println("deletando");
		departamentoService.delete(id);
		return new ResponseEntity<String> ( "Departamento deletado", HttpStatus.OK);
	}
	

}
