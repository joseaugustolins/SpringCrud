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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springbootcrud.modelo.Funcionario;

@RestController
@RequestMapping("/api/funcionario")
//@Controller //caso se queira usar web
@CrossOrigin //permite acessar de requisições externas

public class FuncionarioController {
     
	@Autowired
	private FuncionarioService funcionarioService;
	
	
	@PostMapping("")
    public ResponseEntity<?> addFuncionario(@Valid @RequestBody Funcionario funcionario, BindingResult result){
		System.out.println("Testar");
        if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        Funcionario novoFuncionario = funcionarioService.saveOrUpdate(funcionario);
        return new ResponseEntity<Funcionario>(novoFuncionario, HttpStatus.CREATED);
    }
	
	@GetMapping("/all")
	public Iterable<Funcionario> findAll(){
		return funcionarioService.findAll();
	} 
	
	@GetMapping("/{cpf}")
	public ResponseEntity<Funcionario> getFuncionarioByCpf(@PathVariable Long cpf){
		Funcionario funcionario = funcionarioService.findByCpf(cpf);
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}
	
    @PostMapping("/update/{id}")
    public ResponseEntity updateFuncionario(@RequestBody @Valid Funcionario funcionario, BindingResult result) {
    	if(result.hasErrors()){
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error: result.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }
        funcionarioService.saveOrUpdate(funcionario);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
        
    }
	
	@DeleteMapping("/{cpf}")
	public ResponseEntity<?> deleteAluno(@PathVariable Long cpf){
		funcionarioService.delete(cpf);
		return new ResponseEntity<String> ( "Funcionário deletado", HttpStatus.OK);
	}

    
}