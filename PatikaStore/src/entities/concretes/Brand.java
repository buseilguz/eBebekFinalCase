package entities.concretes;

import entities.abstracts.Entity;

public class Brand implements Entity{
	private int brandId;
	private String name;
	
	


	public Brand() {
		super();
	}
	
	public Brand(int brandId, String name) {
		super();
		this.brandId = brandId;
		this.name = name;
		
	}
	
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	
}
