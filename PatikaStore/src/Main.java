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
			//Kullan�c� aray�z� i�in bunu kullan�yoruz.
		System.out.println("L�tfen yapmak istedi�iniz i�lemi se�iniz.\n"
				+ "Markalar� listelemek i�in : 1 \n"
				+ "Cep Telefonlar�n� listelemek i�in : 2\n"
				+ "Notebook'lar� listelemek i�in : 3\n"
				+ "�r�n eklemek i�in : 4\n"
				+ "�r�n silmek i�in : 5\n"
				+ "Id'ye g�re filtrelemek i�in : 6\n"
				+ "Markaya g�re filtrelemek i�in : 7\n"
				+ "��k�� i�in : 0");
		
		choose=scn.nextInt();
		switch(choose) {
		case 1:
			//Markalar listeleniyor.
			for (Brand brand : brandService.getAll()) {
				
				System.out.format("|  %3s  |",brand.getName());
			}	System.in.read();
		break;
		
		case 2:
			//Cep telefonlar� listeleniyor
			System.out.println("|  ID   ||�r�n Ad�|| Haf�zas� ||Birim Fiyat�|| Stok Adedi||"
					+ "  Markas�  ||Ekran Boyutu||Pil G�c�||  RAM  || Renk    ||�ndirim Oran�| ");
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
			System.out.println("|  ID   ||  �r�n Ad� || Haf�zas�  ||Birim Fiyat�|| Stok Adedi||"
					+ "Markas�||Ekran Boyutu||Pil G�c�||  RAM  || �ndirim Oran� | ");
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
			//�r�n ekleme i�lemleri
			System.out.println("L�tfen eklemek istedi�iniz �r�n tipini se�iniz.\n"
					+ "Cep Telefonu i�in 1 \n"
					+ "Notebook i�in     2");
			choose=scn.nextInt();
			if(choose==1) {
				MobilePhone mp=new MobilePhone();
				System.out.println("�r�n�n Ad�n� giriniz.");
				mp.setName(scn.next());
				
			
				System.out.println("�r�n ID'sini giriniz.");
				mp.setId(scn.nextInt());
				
				System.out.println("�r�n Birim Fiyat�n� giriniz.");
				mp.setUnitPrice(scn.nextDouble());
				
				System.out.println("�r�n �ndirim Oran�n� giriniz.");
				mp.setDiscountRate(scn.nextDouble());
				
				System.out.println("�r�n�n Stok Adedini giriniz.");
				mp.setAmountOfStock(scn.nextInt());
				
				
				System.out.println("�r�n�n markas�n� giriniz.\n"
						+ "Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster");
			
				String st=scn.next();
				
				
				for (Brand br : brandService.getAll()) {
					if(br.getName().equals(st)) {
						mp.setBrand(br);
						System.out.println(mp.getBrand().getName());
					}
						
				
				}
				System.out.println("�r�n�n haf�zas�n� giriniz.128 GB/64 GB");
				mp.setMemory(scn.next());
				
				mp.setScreenSize("6.1'");
				mp.setBatterypower("4000");
				mp.setRAM("6MB");
				System.out.println("�r�n�n rengini giriniz.  Siyah,Mavi,K�rm�z�");
				mp.setColor(scn.next());
				mobilePhoneService.add(mp);
				
				
			}
			else if(choose==2) {
				Notebook notebook=new Notebook();
				System.out.println("�r�n�n Ad�n� giriniz.");
				notebook.setName(scn.next());
				
			
				System.out.println("�r�n ID'sini giriniz.");
				notebook.setId(scn.nextInt());
				
				System.out.println("�r�n Birim Fiyat�n� giriniz.");
				notebook.setUnitPrice(scn.nextDouble());
				
				System.out.println("�r�n �ndirim Oran�n� giriniz.");
				notebook.setDiscountRate(scn.nextDouble());
				
				System.out.println("�r�n�n Stok Adedini giriniz.");
				notebook.setAmountOfStock(scn.nextInt());
				
				
				System.out.println("�r�n�n markas�n� giriniz.\n"
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
			//�r�n silme i�lemleri
			System.out.println("L�tfen silmek istedi�iniz �r�n tipini se�iniz.\n"
					+ "Cep Telefonu i�in 1 \n"
					+ "Notebook i�in     2");
			choose=scn.nextInt();
			if(choose==1) {
				System.out.println("L�tfen silmek istedi�iniz telefonun ID'sini giriniz.");
				mobilePhoneService.delete(scn.nextInt());
				
			}
			else if(choose==2) {
				System.out.println("L�tfen silmek istedi�iniz notebook'un ID'sini giriniz.");
				notebookService.delete(scn.nextInt());
			
			}	System.in.read();
		break;
		case 6:
			//�d ye g�re filtreleme
			System.out.println("L�tfen g�r�nt�lemek istedi�iniz �r�n tipini se�iniz.\n"
				+ "Cep Telefonu i�in 1 \n"
				+ "Notebook i�in     2");
		choose=scn.nextInt();
		if(choose==1) {
			System.out.println("L�tfen g�r�nt�lemek istedi�iniz telefonun ID'sini giriniz.");
			int choose2=scn.nextInt();
			System.out.println("|  ID   ||�r�n Ad�|| Haf�zas� ||Birim Fiyat�|| Stok Adedi||"
					+ "  Markas�  ||Ekran Boyutu||Pil G�c�||  RAM  || Renk    ||�ndirim Oran�| ");
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
			System.out.println("L�tfen g�r�nt�lemek istedi�iniz notebook ID'sini giriniz.");
			int choose2=scn.nextInt();
			System.out.println("|  ID   ||  �r�n Ad� || Haf�zas�  ||Birim Fiyat�|| Stok Adedi||"
					+ "Markas�||Ekran Boyutu||Pil G�c�||  RAM  || �ndirim Oran� | ");
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
			//Markaya g�re filtreleme
			System.out.println("L�tfen g�r�nt�lemek istedi�iniz �r�n tipini se�iniz.\n"
					+ "Cep Telefonu i�in 1 \n"
					+ "Notebook i�in     2");
			choose=scn.nextInt();
			if(choose==1) {
				System.out.println("�r�n�n markas�n� giriniz.\n"
						+ "Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster");
				String st=scn.next();
				for (Brand br : brandService.getAll()) {
					if(br.getName().equals(st)) {
						System.out.println("|  ID   ||�r�n Ad�|| Haf�zas� ||Birim Fiyat�|| Stok Adedi||"
								+ "  Markas�  ||Ekran Boyutu||Pil G�c�||  RAM  || Renk    ||�ndirim Oran�| ");
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
				System.out.println("�r�n�n markas�n� giriniz.\n"
					+ "Samsung, Lenovo, Apple, Huawei, Casper, Asus, HP, Xiaomi, Monster");
			String st=scn.next();
			for (Brand br : brandService.getAll()) {
				if(br.getName().equals(st)) {
					System.out.println("|  ID   ||  �r�n Ad� || Haf�zas�  ||Birim Fiyat�|| Stok Adedi||"
							+ "Markas�||Ekran Boyutu||Pil G�c�||  RAM  || �ndirim Oran� | ");
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
