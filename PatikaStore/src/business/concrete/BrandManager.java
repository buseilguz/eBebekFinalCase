package business.concrete;

import java.util.ArrayList;

import java.util.List;

import business.abstarcts.BrandService;

import dataAccess.abstracts.BrandDao;
import entities.concretes.Brand;

public class BrandManager implements BrandService{

	private BrandDao brandDao;
	
	//Marka eklemek,silmek gibi iþleri yapan sýnýfýmýz
	public BrandManager(BrandDao brandDao) {
		super();
		this.brandDao = brandDao;
		
	}
	


	public BrandManager() {
		// TODO Auto-generated constructor stub
	}

	


	@Override
	public void add(Brand brand) {
		List<Brand> brands=new ArrayList<Brand>();
		brandDao.add(brand);
		
	}

	@Override
	public void delete(int id) {
		brandDao.delete(id);
		
	}

	@Override
	public List<Brand> getAll() {
		
		return brandDao.getAll();
	}

	@Override
	public Brand get(int id) {
		
		
		return brandDao.get(id);
	}

	

}
