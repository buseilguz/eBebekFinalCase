package business.abstarcts;

import java.util.List;


import entities.concretes.MobilePhone;
import entities.concretes.Notebook;

public interface RuleService {
 
	public  boolean idIsOnlyOne(List<MobilePhone> mp,MobilePhone mobilePhone);
	public  boolean idIsOnlyOne2(List<Notebook> nt,Notebook notebook);
	public  boolean brandIsvalid(MobilePhone mobilePhone);
	public  boolean brandIsvalid2(Notebook notebook);

	public boolean memoryIsValid(MobilePhone mp);
	public boolean colorIsValid(MobilePhone mp);
	public boolean storageIsValid(Notebook nt);
	
}
