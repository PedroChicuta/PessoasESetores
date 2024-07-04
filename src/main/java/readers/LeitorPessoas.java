package readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import entities.Pessoa;

public  class LeitorPessoas implements Leitor<Pessoa>{
	@Override
	public List<Pessoa> ler(File f1, List<Pessoa> lista) {
		try (BufferedReader bf = new BufferedReader(new FileReader(f1))){
			String line = bf.readLine();
			while(bf.ready()) {
				line = bf.readLine();
				String splitedLine[] = line.split(",");
				Pessoa p = new Pessoa(splitedLine[1], splitedLine[2], Integer.parseInt(splitedLine[3]));
				lista.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
