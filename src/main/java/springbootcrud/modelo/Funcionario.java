package springbootcrud.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Funcionario {

	@Id
    private Long cpf;
    @NotBlank(message="Nome Obrigatório")
    private String nome;
    @ManyToOne
    private Departamento departamento;
    
    public Funcionario() {
    	
    }
    
    
    
	public Funcionario(Long cpf, @NotBlank(message = "Nome Obrigatório") String nome, Departamento departamento) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.departamento = departamento;
	}



	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
}
