package dataAccess.abstracts;

import java.util.List;

import entities.concretes.Brand;
import entities.concretes.MobilePhone;



public interface MobilePhoneDao {
	void add(MobilePhone mp);
	void update(MobilePhone mp);
	void delete(int id);
	MobilePhone get(int id);
	List<MobilePhone> getByBrand(Brand brand);
	List<MobilePhone> getAll();
}
