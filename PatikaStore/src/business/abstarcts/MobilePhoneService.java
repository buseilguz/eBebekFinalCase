package business.abstarcts;

import java.util.List;

import entities.concretes.Brand;
import entities.concretes.MobilePhone;

public interface MobilePhoneService {
	void add(MobilePhone mp);
	void delete(int id);
	List<MobilePhone> getAll();
	List<MobilePhone> getByBrand(Brand brand);
	MobilePhone get(int id);
	
}
