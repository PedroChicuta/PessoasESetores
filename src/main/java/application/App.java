package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import DB.DBOperations;
import entities.Pessoa;
import entities.Setor;
import readers.Leitor;
import readers.LeitorPessoas;
import readers.LeitorSetores;

public class App {
	public static void main(String[] args) {
		File f1 = new File("C:\\Users\\naipe\\OneDrive\\Desktop\\JavaEstagio2\\AulaDeJpa\\in.csv");
		File f2 = new File("C:\\Users\\naipe\\OneDrive\\Desktop\\JavaEstagio2\\AulaDeJpa\\in1.csv");
		
		Leitor<Pessoa> lp = new LeitorPessoas();
		Leitor<Setor> ls = new LeitorSetores();
		DBOperations db = new DBOperations();
		
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		List<Setor> setores = new ArrayList<Setor>();
		
		
		pessoas = lp.ler(f1, pessoas);
		setores = ls.ler(f2, setores);
		
		for(Pessoa p : pessoas) {
			db.adicionarPessoa(p);

		}
		for(Setor s : setores) {
			db.adicionarSetor(s);
		}
		
		int i = 1;
		while(true) {
			if(db.encontrarPessoa(i) != null) {
				System.out.println(db.PessoaInfo(i));
				i++;
			}else {
				break;
			}
		}
		System.out.println("Fim");
		db.fecharDB();
	}
	
}
