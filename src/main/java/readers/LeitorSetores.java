package readers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import entities.Setor;

public class LeitorSetores implements Leitor<Setor>{

	@Override
	public List<Setor> ler(File f1, List<Setor> lista) {
		try (BufferedReader bf = new BufferedReader(new FileReader(f1))){
			String line = bf.readLine();
			while(bf.ready()) {
				line = bf.readLine();
				String splitedLine[] = line.split(",");
				Setor s = new Setor(splitedLine[1]);
				lista.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
