package business.abstarcts;

import java.util.List;

import entities.concretes.Brand;

public interface BrandService {
	void add(Brand brand);
	void delete(int id);
	List<Brand> getAll();
	Brand get(int id);
	
}
