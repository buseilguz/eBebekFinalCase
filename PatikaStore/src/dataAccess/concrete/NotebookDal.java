package dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.NotebookDao;
import entities.concretes.Brand;
import entities.concretes.MobilePhone;
import entities.concretes.Notebook;

public class NotebookDal implements NotebookDao{
	 InMemory inmemory=new InMemory();
	@Override
	public void add(Notebook notebook) {
	inmemory.notebooks.add(notebook);
	System.out.println("Notebook veritabanýna eklendi");
	}

	@Override
	public void update(Notebook notebook) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		Notebook filterNotebook=inmemory.notebooks.stream().filter(s->s.getId()==id).findFirst().orElse(null);
		inmemory.brands.remove(filterNotebook);
		System.out.println("Notebook baþarýyla silinmiþtir.");
	}

	@Override
	public Notebook get(int id) {
		Notebook filterNotebook=inmemory.notebooks.stream().filter(s->s.getId()==id).findFirst().orElse(null);
		return filterNotebook;
	}

	@Override
	public List<Notebook> getAll() {
		
		return inmemory.notebooks;
	}

	@Override
	public List<Notebook> getByBrand(Brand brand) {
		List<Notebook> mp=new ArrayList<Notebook>();
		for (Notebook notebook : inmemory.notebooks) {
			if(notebook.getBrand().toString()==brand.getName()) {
				mp.add(notebook);
			}
		}
		return mp;
		
	}

}
