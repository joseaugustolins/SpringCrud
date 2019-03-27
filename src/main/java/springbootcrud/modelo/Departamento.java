package springbootcrud.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Departamento {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    @NotBlank(message="Nome Obrigatório")
    private String nome;
    
    public Departamento() {
    	
    }
    
	public Departamento(Integer id, @NotBlank(message = "Nome Obrigatório") String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
    
	
	
}
