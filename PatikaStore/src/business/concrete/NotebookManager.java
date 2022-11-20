package business.concrete;


import java.util.List;

import business.abstarcts.NotebookService;
import business.abstarcts.RuleService;
import dataAccess.abstracts.NotebookDao;
import entities.concretes.Brand;
import entities.concretes.Notebook;

public class NotebookManager implements NotebookService {
 private NotebookDao notebookDao;
 private RuleService ruleService;
//Notebook ürünü ile ilgili iþler
public NotebookManager(NotebookDao notebookDao,RuleService ruleService) {
	super();
	this.notebookDao = notebookDao;
	this.ruleService=ruleService;
	
}

@Override
public void add(Notebook notebook) {
	if(ruleService.idIsOnlyOne2(getAll(), notebook)==true) {
		notebookDao.add(notebook);
	}
	
}

@Override
public void delete(int id) {
	notebookDao.delete(id);
	
}

@Override
public List<Notebook> getAll() {
	
	return notebookDao.getAll();
}

@Override
public Notebook get(int id) {

	return notebookDao.get(id);
}

@Override
public List<Notebook> getByBrand(Brand brand) {
	
	return notebookDao.getByBrand(brand);
}
}
