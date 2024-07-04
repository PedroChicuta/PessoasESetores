package DB;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Pessoa;
import entities.Setor;

import javax.persistence.EntityManager;

public class DBOperations {
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	
	
	public DBOperations() {
		criarEntityManager();
	}

	private void criarEntityManager() {
		emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		em = emf.createEntityManager();
	}
	
	public void fecharDB() {
		em.close();
		emf.close();
	}
	
	public void adicionarPessoa(Pessoa pessoa) {
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
	}
	public void remover(Pessoa pessoa) {
		em.getTransaction().begin();
		em.remove(pessoa);
		em.getTransaction().commit();
	}
	public Pessoa encontrarPessoa(int id) {
		Pessoa p = em.find(Pessoa.class, id);
		return p;
	}
	public String PessoaInfo(int id) {
		Pessoa pessoa = encontrarPessoa(id);
		Setor s = em.find(Setor.class, 2);
		return String.format("%s: ID:%d, Email: %s, Setor: %s ", pessoa.getNome(),pessoa.getId(), pessoa.getEmail(), s.getNome());
	}
	public void adicionarSetor(Setor setor) {
		em.getTransaction().begin();
		em.persist(setor);
		em.getTransaction().commit();
	}
	public void remover(Setor setor) {
		em.getTransaction().begin();
		em.remove(setor);
		em.getTransaction().commit();
	}
	public Setor encontrarSetor(int id) {
		Setor s = em.find(Setor.class, id);
		return s;
	}
}
