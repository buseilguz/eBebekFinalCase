package dataAccess.concrete;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.MobilePhoneDao;
import entities.concretes.Brand;
import entities.concretes.MobilePhone;

public class MobilePhoneDal implements MobilePhoneDao{
	//Veritabanýndaki iþlemleri yapan sýnýf
	 InMemory inmemory=new InMemory();
	@Override
	public void add(MobilePhone mp) {
		inmemory.mobilePhones.add(mp);
		 System.out.println("Cep Telefonu veritabanýna eklendi");
		
	}

	@Override
	public void update(MobilePhone mp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		MobilePhone filterMp=inmemory.mobilePhones.stream().filter(s->s.getId()==id).findFirst().orElse(null);
		inmemory.mobilePhones.remove(filterMp);
		System.out.println("Ürün baþarýyla silindi.");
		
	}

	@Override
	public MobilePhone get(int id) {
		MobilePhone filterMp=inmemory.mobilePhones.stream().filter(s->s.getId()==id).findFirst().orElse(null);
		return filterMp;
	}

	@Override
	public List<MobilePhone> getAll() {
		
		return inmemory.mobilePhones;
	}

	@Override
	public List<MobilePhone> getByBrand(Brand brand) {
		List<MobilePhone> mp=new ArrayList<MobilePhone>();
		for (MobilePhone mobilePhone : inmemory.mobilePhones) {
			if(mobilePhone.getBrand().getName()==brand.getName()) {
				mp.add(mobilePhone);
			}
		}
		return mp;
	}

}
