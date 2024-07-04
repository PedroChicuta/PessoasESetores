package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String email;
	private int IdSetor;
	public Pessoa() {
		super();
	}
	public Pessoa(String nome, String email, int IdSetor) {
		this.nome = nome;
		this.email = email;
		this.IdSetor = IdSetor;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdSetor() {
		return IdSetor;
	}
	public void setIdSetor(int idSetor) {
		IdSetor = idSetor;
	}
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", IdSetor=" + IdSetor + "]";
	}
	
}
