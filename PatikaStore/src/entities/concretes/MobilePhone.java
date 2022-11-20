package entities.concretes;

import entities.abstracts.Entity;

public class MobilePhone implements Entity {
   private int Id;
   private double unitPrice;
   private double discountRate;
   private int amountOfStock;
   private String name;
   private Brand brand;
   private String memory;
   private String screenSize;
   private String batterypower;
   private String RAM;
   private String color;
   
   
public int getId() {
	return Id;
}


public void setId(int id) {
	Id = id;
}


public double getUnitPrice() {
	return unitPrice;
}


public void setUnitPrice(double unitPrice) {
	this.unitPrice = unitPrice;
}


public double getDiscountRate() {
	return discountRate;
}


public void setDiscountRate(double discountRate) {
	this.discountRate = discountRate;
}


public int getAmountOfStock() {
	return amountOfStock;
}


public void setAmountOfStock(int amountOfStock) {
	this.amountOfStock = amountOfStock;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public Brand getBrand() {
	return brand;
}


public void setBrand(Brand brand) {
	this.brand = brand;
}


public String getMemory() {
	return memory;
}


public void setMemory(String memory) {
	this.memory = memory;
}


public String getScreenSize() {
	return screenSize;
}


public void setScreenSize(String screenSize) {
	this.screenSize = screenSize;
}


public String getBatterypower() {
	return batterypower;
}


public void setBatterypower(String batterypower) {
	this.batterypower = batterypower;
}


public String getRAM() {
	return RAM;
}


public void setRAM(String rAM) {
	RAM = rAM;
}


public String getColor() {
	return color;
}


public void setColor(String color) {
	this.color = color;
}


public MobilePhone() {
	super();
}


public MobilePhone(int id, double unitPrice, double discountRate, int amountOfStock, String name, Brand brand,
		String memory, String screenSize, String batterypower, String rAM, String color) {
	super();
	Id = id;
	this.unitPrice = unitPrice;
	this.discountRate = discountRate;
	this.amountOfStock = amountOfStock;
	this.name = name;
	this.brand = brand;
	this.memory = memory;
	this.screenSize = screenSize;
	this.batterypower = batterypower;
	RAM = rAM;
	this.color = color;
}
   
   
   
   
}
