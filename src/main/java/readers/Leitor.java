package readers;

import java.io.File;
import java.util.List;

public interface Leitor<T> {
	public List<T> ler(File f1, List<T> lista);
}
