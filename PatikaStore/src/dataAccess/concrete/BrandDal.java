package dataAccess.concrete;


import java.util.List;

import dataAccess.abstracts.BrandDao;
import entities.concretes.Brand;


public class BrandDal implements BrandDao {
    InMemory inmemory=new InMemory();
    
	@Override
	public void add(Brand brand) {
	 inmemory.brands.add(brand);
	
	}

	@Override
	public void update(Brand brand) {
		
		
	}
	@Override
	public void delete(int id) {
		Brand filterBrand=inmemory.brands.stream().filter(s->s.getBrandId()==id).findFirst().orElse(null);
		inmemory.brands.remove(filterBrand);
		
	}

	@Override
	public Brand get(int id) {
		Brand filterBrand=inmemory.brands.stream().filter(s->s.getBrandId()==id).findFirst().orElse(null);
		return filterBrand;
	}

	@Override
	public List<Brand> getAll() {
		
		return inmemory.brands;
	}

	

}
