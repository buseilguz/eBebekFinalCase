import business.abstarcts.BrandService;
import business.abstarcts.MobilePhoneService;
import business.abstarcts.NotebookService;
import business.abstarcts.RuleService;
import business.concrete.BrandManager;
import business.concrete.MobilePhoneManager;
import business.concrete.NotebookManager;
import business.rules.RuleManager;
import dataAccess.concrete.BrandDal;
import dataAccess.concrete.MobilePhoneDal;
import dataAccess.concrete.NotebookDal;
import entities.concretes.Brand;
import entities.concretes.MobilePhone;
import entities.concretes.Notebook;

import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scn=new Scanner(System.in);
		
		BrandService brandService=new BrandManager(new BrandDal());
		MobilePhoneService mobilePhoneService=new MobilePhoneManager(new MobilePhoneDal(),new RuleManager());
		NotebookService notebookService=new NotebookManager(new NotebookDal(),new RuleManager());
		Formatter fmt=new Formatter();
		Brand Samsung =new Brand(1,"Samsung"); 
		Brand Lenovo =new Brand(2,"Lenovo"); 
		Brand Apple =new Brand(3,"Apple"); 
		Brand Huawei =new Brand(4,"Huawei"); 
		Brand Casper =new Brand(5,"Casper"); 
		Brand Asus =new Brand(6,"Asus"); 
		Brand HP=new Brand(7,"HP"); 
		Brand Xiaomi =new Brand(8,"Xiaomi"); 
		Brand Monster =new Brand(9,"Monster"); 
		brandService.add(Samsung);
		brandService.add(Lenovo);
		brandService.add(Apple);
		brandService.add(Huawei);
		brandService.add(Casper);
		brandService.add(Asus);
		brandService.add(HP);
		brandService.add(Xiaomi);
		brandService.add(Monster);
		int choose=0;
		
		do {
			//Kullanýcý arayüzü için bunu kullanýyoruz.
		System.out.println("Lütfen yapmak istediðiniz iþlemi seçiniz.\n"
				+ "Markalarý listelemek için : 1 \n"
				+ "Cep Telefonlarýný listelemek için : 2\n"
				+ "Notebook'larý listelemek için : 3\n"
				+ "Ürün eklemek için : 4\n"
				+ "Ürün silmek için : 5\n"
				+ "Id'ye göre filtrelemek için : 6\n"
				+ "Markaya göre filtrelemek için : 7\n"
				+ "Çýkýþ için : 0");
		
		choose=scn.nextInt();
		switch(choose) {
		case 1:
			//Markalar listeleniyor.
			for (Brand brand : brandService.getAll()) {
				
				System.out.format("|  %3s  |",brand.getName());
			}	System.in.read();
		break;
		
		case 2:
			//Cep telefonlarý listeleniyor
			System.out.println("|  ID   ||Ürün Adý|| Hafýzasý ||Birim Fiyatý|| Stok Adedi||"
					+ "  Markasý  ||Ekran Boyutu||Pil Gücü||  RAM  || Renk    ||Ýndirim Oraný| ");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			
			for(MobilePhone mp:mobilePhoneService.getAll()) {
				
				System.out.format("|  %3s  |", mp.getId());
				System.out.format("|  %3s   |", mp.getName());
				System.out.format("|  %3s     |", mp.getMemory());
				System.out.format("|  %3s    |", mp.getUnitPrice());
				System.out.format("|  %3s      |", mp.getAmountOfStock());
				System.out.format("|  %3s  |", mp.getBrand().getName());
				System.out.format("|    %3s     |", mp.getScreenSize());
				System.out.format("|  %3s  |", mp.getBatterypower());
				System.out.format("|  %3s  |", mp.getRAM());
				System.out.format("|  %3s  |", mp.getColor());
				System.out.format("|    %3s   |", mp.getDiscountRate());
				System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");

				
			}System.in.read();
			break;
			
		case 3:
			//Notebooklar listeleniyor.
			System.out.println("|  ID   ||  Ürün Adý || Hafýzasý  ||Birim Fiyatý|| Stok Adedi||"
					+ "Markasý||Ekran Boyutu||Pil Gücü||  RAM  || Ýndirim Oraný | ");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			
			for(Notebook notebook:notebookService.getAll()) {
				
				System.out.format("|  %3s  |", notebook.getId());
				System.out.format("|  %3s |", notebook.getName());
				System.out.format("|  %3s   |", notebook.getStorage());
				System.out.format("|  %3s    |", notebook.getUnitPrice());
				System.out.format("|  %3s      |", notebook.getAmountOfStock());
				System.out.format("|  %3s  |", notebook.getBrand().getName());
				System.out.format("|    %3s     |", notebook.getScreenSize());
				System.out.format("|  %3s  |", notebook.getBatterypower());
				System.out.format("|  %3s  |", notebook.getRAM());
				System.out.format("|     %3s      |", notebook.getDiscountRate());
				System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");

				
			}System.in.read();
			break;
		case 4:
			//Ürün ekleme iþlemleri
			System.out.println("Lütfen eklemek istediðiniz ürün tipini seçiniz.\n"
					+ "Cep Telefonu için 1 \n"
					+ "Notebook için     2");
			choose=scn.nextInt();
			if(choose==1) {
				MobilePhone mp=new MobilePhone();
				System.out.println("Ürünün Adýný giriniz.");
				mp.setName(scn.next());
				
			
				System.out.println("Ürün ID'sini giriniz.");
				mp.setId(scn.nextInt());
				
				System.out.println("Ürün Birim Fiyatýný giriniz.");
				mp.setUnitPrice(scn.nextDouble());
				
				System.out.println("Ürün Ýndirim Oranýný giriniz.");
				mp.setDiscountRate(scn.nextDouble());
				
				System.out.println("Ürünün Stok Adedini giriniz.");
				mp.setAmountOfStock(scn.nextInt());
				
				
				System.out.println("Ürünün markasýný giriniz.\n"
						+ "Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster");
			
				String st=scn.next();
				
				
				for (Brand br : brandService.getAll()) {
					if(br.getName().equals(st)) {
						mp.setBrand(br);
						System.out.println(mp.getBrand().getName());
					}
						
				
				}
				System.out.println("Ürünün hafýzasýný giriniz.128 GB/64 GB");
				mp.setMemory(scn.next());
				
				mp.setScreenSize("6.1'");
				mp.setBatterypower("4000");
				mp.setRAM("6MB");
				System.out.println("Ürünün rengini giriniz.  Siyah,Mavi,Kýrmýzý");
				mp.setColor(scn.next());
				mobilePhoneService.add(mp);
				
				
			}
			else if(choose==2) {
				Notebook notebook=new Notebook();
				System.out.println("Ürünün Adýný giriniz.");
				notebook.setName(scn.next());
				
			
				System.out.println("Ürün ID'sini giriniz.");
				notebook.setId(scn.nextInt());
				
				System.out.println("Ürün Birim Fiyatýný giriniz.");
				notebook.setUnitPrice(scn.nextDouble());
				
				System.out.println("Ürün Ýndirim Oranýný giriniz.");
				notebook.setDiscountRate(scn.nextDouble());
				
				System.out.println("Ürünün Stok Adedini giriniz.");
				notebook.setAmountOfStock(scn.nextInt());
				
				
				System.out.println("Ürünün markasýný giriniz.\n"
						+ "Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster");
			
				String st=scn.next();
				
				
				for (Brand br : brandService.getAll()) {
					if(br.getName().equals(st)) {
						notebook.setBrand(br);
						System.out.println(notebook.getBrand().getName());
					}
						
				
				}
				
				notebook.setStorage("512 SSD");
				notebook.setScreenSize("14'");
				notebook.setBatterypower("4000");
				notebook.setRAM("8MB");
				notebookService.add(notebook);
				
				
			}
			break;
		case 5:
			//ürün silme iþlemleri
			System.out.println("Lütfen silmek istediðiniz ürün tipini seçiniz.\n"
					+ "Cep Telefonu için 1 \n"
					+ "Notebook için     2");
			choose=scn.nextInt();
			if(choose==1) {
				System.out.println("Lütfen silmek istediðiniz telefonun ID'sini giriniz.");
				mobilePhoneService.delete(scn.nextInt());
				
			}
			else if(choose==2) {
				System.out.println("Lütfen silmek istediðiniz notebook'un ID'sini giriniz.");
				notebookService.delete(scn.nextInt());
			
			}	System.in.read();
		break;
		case 6:
			//Ýd ye göre filtreleme
			System.out.println("Lütfen görüntülemek istediðiniz ürün tipini seçiniz.\n"
				+ "Cep Telefonu için 1 \n"
				+ "Notebook için     2");
		choose=scn.nextInt();
		if(choose==1) {
			System.out.println("Lütfen görüntülemek istediðiniz telefonun ID'sini giriniz.");
			int choose2=scn.nextInt();
			System.out.println("|  ID   ||Ürün Adý|| Hafýzasý ||Birim Fiyatý|| Stok Adedi||"
					+ "  Markasý  ||Ekran Boyutu||Pil Gücü||  RAM  || Renk    ||Ýndirim Oraný| ");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			
			System.out.format("|  %3s  |", mobilePhoneService.get(choose2).getId());
			System.out.format("|  %3s  |",mobilePhoneService.get(choose2).getName());
			System.out.format("|  %3s     |", mobilePhoneService.get(choose2).getMemory());
			System.out.format("|  %3s    |", mobilePhoneService.get(choose2).getUnitPrice());
			System.out.format("|  %3s      |", mobilePhoneService.get(choose2).getAmountOfStock());
			System.out.format("|  %3s  |", mobilePhoneService.get(choose2).getBrand().getName());
			System.out.format("|    %3s     |",mobilePhoneService.get(choose2).getScreenSize());
			System.out.format("|  %3s  |", mobilePhoneService.get(choose2).getBatterypower());
			System.out.format("|  %3s  |", mobilePhoneService.get(choose2).getRAM());
			System.out.format("|  %3s  |", mobilePhoneService.get(choose2).getColor());
			System.out.format("|    %3s   |",mobilePhoneService.get(choose2).getDiscountRate());
			System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");

			
			
		}
		else if(choose==2) {
			System.out.println("Lütfen görüntülemek istediðiniz notebook ID'sini giriniz.");
			int choose2=scn.nextInt();
			System.out.println("|  ID   ||  Ürün Adý || Hafýzasý  ||Birim Fiyatý|| Stok Adedi||"
					+ "Markasý||Ekran Boyutu||Pil Gücü||  RAM  || Ýndirim Oraný | ");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			System.out.format("|  %3s  |", notebookService.get(choose2).getId());
			System.out.format("|  %3s  |",notebookService.get(choose2).getName());
			System.out.format("|  %3s     |", notebookService.get(choose2).getStorage());
			System.out.format("|  %3s    |", notebookService.get(choose2).getUnitPrice());
			System.out.format("|  %3s      |", notebookService.get(choose2).getAmountOfStock());
			System.out.format("|  %3s  |", notebookService.get(choose2).getBrand().getName());
			System.out.format("|    %3s     |",notebookService.get(choose2).getScreenSize());
			System.out.format("|  %3s  |", notebookService.get(choose2).getBatterypower());
			System.out.format("|  %3s  |", notebookService.get(choose2).getRAM());
			
			System.out.format("|    %3s   |",notebookService.get(choose2).getDiscountRate());
			System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");

			
			
		}System.in.read();
			break;
		case 7:
			//Markaya göre filtreleme
			System.out.println("Lütfen görüntülemek istediðiniz ürün tipini seçiniz.\n"
					+ "Cep Telefonu için 1 \n"
					+ "Notebook için     2");
			choose=scn.nextInt();
			if(choose==1) {
				System.out.println("Ürünün markasýný giriniz.\n"
						+ "Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster");
				String st=scn.next();
				for (Brand br : brandService.getAll()) {
					if(br.getName().equals(st)) {
						System.out.println("|  ID   ||Ürün Adý|| Hafýzasý ||Birim Fiyatý|| Stok Adedi||"
								+ "  Markasý  ||Ekran Boyutu||Pil Gücü||  RAM  || Renk    ||Ýndirim Oraný| ");
						System.out.println("------------------------------------------------------------------------------------------------------------------------------");
						for (MobilePhone mp : mobilePhoneService.getByBrand(br)) {
							
							System.out.format("|  %3s  |", mp.getId());
							System.out.format("|  %3s  |",mp.getName());
							System.out.format("|  %3s     |", mp.getMemory());
							System.out.format("|  %3s    |", mp.getUnitPrice());
							System.out.format("|  %3s      |", mp.getAmountOfStock());
							System.out.format("|  %3s  |", mp.getBrand().getName());
							System.out.format("|    %3s     |",mp.getScreenSize());
							System.out.format("|  %3s  |", mp.getBatterypower());
							System.out.format("|  %3s  |", mp.getRAM());
							System.out.format("|  %3s  |", mp.getColor());
							System.out.format("|    %3s   |",mp.getDiscountRate());
							System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");
							
						} 
						
					}
						
				
				}
			}
			else if(choose==2) {
				System.out.println("Ürünün markasýný giriniz.\n"
					+ "Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster");
			String st=scn.next();
			for (Brand br : brandService.getAll()) {
				if(br.getName().equals(st)) {
					System.out.println("|  ID   ||  Ürün Adý || Hafýzasý  ||Birim Fiyatý|| Stok Adedi||"
							+ "Markasý||Ekran Boyutu||Pil Gücü||  RAM  || Ýndirim Oraný | ");
					System.out.println("------------------------------------------------------------------------------------------------------------------------------");
					for (Notebook nt : notebookService.getByBrand(br)) {
						
						System.out.format("|  %3s  |", nt.getId());
						System.out.format("|  %3s  |",nt.getName());
						System.out.format("|  %3s     |", nt.getStorage());
						System.out.format("|  %3s    |", nt.getUnitPrice());
						System.out.format("|  %3s      |",nt.getAmountOfStock());
						System.out.format("|  %3s  |", nt.getBrand().getName());
						System.out.format("|    %3s     |",nt.getScreenSize());
						System.out.format("|  %3s  |", nt.getBatterypower());
						System.out.format("|  %3s  |", nt.getRAM());
						
						System.out.format("|    %3s   |",nt.getDiscountRate());
						System.out.println("\n------------------------------------------------------------------------------------------------------------------------------");
						
					} 
					
				}
					
			
			}}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		while(choose!=0);
	
	}

}
