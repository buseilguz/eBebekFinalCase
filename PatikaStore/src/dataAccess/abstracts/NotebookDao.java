package dataAccess.abstracts;

import java.util.List;

import entities.concretes.Brand;
import entities.concretes.Notebook;


public interface NotebookDao {

	
	void add(Notebook notebook);
	void update(Notebook notebook);
	void delete(int id);
	Notebook get(int id);
	List<Notebook> getAll();
	List<Notebook> getByBrand(Brand brand);
}
