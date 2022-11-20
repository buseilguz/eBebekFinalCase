package business.rules;

import java.util.List;

import business.abstarcts.BrandService;
import business.abstarcts.RuleService;
import business.concrete.BrandManager;
import dataAccess.concrete.BrandDal;
import entities.concretes.Brand;
import entities.concretes.MobilePhone;
import entities.concretes.Notebook;

public class RuleManager implements RuleService {
    //Baz� k�s�tlamalar�m�z burada tan�mlan�yor
	@Override
	
	//id alan�n� benzersiz k�lmak i�in
	public boolean idIsOnlyOne(List<MobilePhone> mp, MobilePhone mobilePhone) {
		boolean result=true;
		for(MobilePhone mp1:mp) {
			if(mp1.getId()==mobilePhone.getId()) {
				System.out.println("L�tfen daha �nce kullan�lmam�� bir ID girin.");
				result=false;
			}
		}
		return result;
	}

	@Override
	public boolean idIsOnlyOne2(List<Notebook> nt, Notebook notebook) {
		boolean result=true;
		for(Notebook nb1:nt) {
			if(nb1.getId()==notebook.getId()) {
				System.out.println("L�tfen daha �nce kullan�lmam�� bir ID girin.");
				result=false;
			}
		}
		return result;
	}

	@Override
	//Markan�n bizim girdi�imiz markalardan olup olmad���n� kontrol ediyoruz
	public boolean brandIsvalid(MobilePhone mobilePhone) {
		BrandService brandService=new BrandManager(new BrandDal());
		boolean result=true;
		for(Brand b:brandService.getAll()) {
			String d=mobilePhone.getBrand().getName();
			if(b.getName().equals(d)) {
				
			}
		}
		return result;
	}

	@Override
	public boolean brandIsvalid2(Notebook notebook) {
		BrandService brandService=new BrandManager(new BrandDal());
		boolean result=false;
		for(Brand b:brandService.getAll()) {
			if(b.getName().equals(notebook.getBrand().getName())) {
				result=true;
			}
		}
		return result;
	}

	@Override
	//Haf�za istediklerimizden biri mi?
	public boolean memoryIsValid(MobilePhone mp) {
		boolean result=false;
		if(mp.getMemory().equals("128")||mp.getMemory().equals("64")) {
			result=true;
		}else
			System.out.println("L�tfen ge�erli de�erler giriniz.");
		return result;
	}

	@Override
	//Renk ge�erli mi?
	public boolean colorIsValid(MobilePhone mp) {
		boolean result=false;
		if(mp.getColor().equals("Siyah")||mp.getColor().equals("K�rm�z�")||mp.getColor().equals("Mavi")) {
			result=true;
		}else
			System.out.println("L�tfen ge�erli de�erler giriniz.");
		return result;
	}

	@Override
	public boolean storageIsValid(Notebook nt) {
		
		return true;
	}



}
