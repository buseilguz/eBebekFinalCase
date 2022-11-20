package dataAccess.abstracts;

import java.util.List;

import entities.concretes.Brand;

public interface BrandDao {

	void add(Brand brand);
	void update(Brand brand);
	void delete(int id);
	Brand get(int id);
	List<Brand> getAll();
}
