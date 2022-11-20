package business.concrete;


import java.util.List;

import business.abstarcts.MobilePhoneService;
import business.abstarcts.RuleService;
import dataAccess.abstracts.MobilePhoneDao;
import entities.concretes.Brand;
import entities.concretes.MobilePhone;

public class MobilePhoneManager implements MobilePhoneService {
 private MobilePhoneDao mobilePhoneDao;
 private RuleService ruleService;
 
 
//Cep TElefonu Ürünü ile ilgili iþlemler
 
 
public MobilePhoneManager(MobilePhoneDao mobilePhoneDao,RuleService ruleService) {
	super();
	this.mobilePhoneDao = mobilePhoneDao;
	this.ruleService=ruleService;
}

@Override
public void add(MobilePhone mp) {
	if(ruleService.idIsOnlyOne(getAll(), mp)==true&&ruleService.brandIsvalid(mp)==true&&
			ruleService.memoryIsValid(mp)==true&&ruleService.colorIsValid(mp)==true) {
		mobilePhoneDao.add(mp);
		
	}
	
}

@Override
public void delete(int id) {
	mobilePhoneDao.delete(id);
}

@Override
public List<MobilePhone> getAll() {
	// TODO Auto-generated method stub
	return mobilePhoneDao.getAll();
}

@Override
public MobilePhone get(int id) {
	// TODO Auto-generated method stub
	return mobilePhoneDao.get(id);
}

@Override
public List<MobilePhone> getByBrand(Brand brand) {
	// TODO Auto-generated method stub
	return mobilePhoneDao.getByBrand(brand);
}
}
