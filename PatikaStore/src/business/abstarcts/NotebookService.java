package business.abstarcts;

import java.util.List;

import entities.concretes.Brand;
import entities.concretes.Notebook;

public interface NotebookService {
	void add(Notebook notebook);
	void delete(int id);
	List<Notebook> getAll();
	List<Notebook> getByBrand(Brand brand);
	Notebook get(int id);
}
