package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Integer opcao = -1;
		do {
			System.out.println("        \n          MENU\n"
					+ "\n|   1 - Seller Find By Id	 		"
					+ "\n|   2 - Seller Find By Department	"
					+ "\n|   3 - Seller Find All			"
					+ "\n|   4 - Seller Delete			"
					+ "\n|   5 - Seller Update	"
					+ "\n|   6 - Seller Insert \n"
					+ "\n|   0 - E X I T	");
			
			System.out.println();
			System.out.print("  Opção: ");
			opcao = ler.nextInt();
			
			switch(opcao) {
			case 1:
				System.out.println("  1: Seller find By Id \n	");
				System.out.print("  ID Seller: ");
				int id = ler.nextInt();
				Seller seller = sellerDao.findById(id);
				System.out.println(seller);
				break;
			case 2:
				System.out.println("  2: Seller find By Department	\n");
				System.out.print("  Department Id: ");
				int departId = ler.nextInt();
				Department department = new Department(departId, null);
				List<Seller> list = sellerDao.finByDepartment(department);
				for (Seller obj : list) {
					System.out.println(obj);
				}
				break;
			case 3:
				System.out.println("  3: Seller find All	\n");
				List<Seller> list2 = sellerDao.findAll();
				for (Seller obj : list2) {
					System.out.println(obj);
				}
				break;
			case 4:
				System.out.println("  4: Seller Delete	\n");
				System.out.print("  Id for Delete: ");
				int id2 = ler.nextInt();
				sellerDao.deleteById(id2);
				 System.out.println();
				  System.out.println("  Successfully Deleted");
				break;
			case 5:
				  System.out.println("  5: seller Update	\n");
				  System.out.print("  Name: "); 
				  ler.nextLine();
				  String name5 = ler.nextLine();
				  System.out.print("  Email: "); 
				  String email = ler.nextLine();
				  System.out.print("  BirthDate (dd/MM/yyyy): ");
				  Date data = sdf.parse(ler.next());
				  System.out.print("  BaseSalary: "); 
				  double salary = ler.nextDouble();
				  System.out.print("  Department id: "); 
				  int id3 = ler.nextInt(); 
				  Department dep = new Department(id3, null); 
				  System.out.print("  Id for update: ");
				  int id4 = ler.nextInt(); 
				  Seller seller3 = new Seller(id4, name5, email, data, salary, dep); 
				  sellerDao.update(seller3);
				  System.out.println();
				  System.out.println("  Successfully Updated");
				  break;
			case 6:
				  System.out.println("  6: seller Insert	\n");
				  System.out.print("  Name: "); 
				  ler.nextLine();
				  String name1 = ler.nextLine();
				  System.out.print("  Email: "); 
				  String email1 = ler.nextLine();
				  System.out.print("  BirthDate: "); 
				  Date data1 = sdf.parse(ler.next());
				  System.out.print("  BaseSalary: "); 
				  double salary1 = ler.nextDouble();
				  System.out.print("  Department id: "); 
				  int id5 = ler.nextInt(); 
				  Department dep1 = new Department(id5, null);
				  Seller seller4 = new Seller(null, name1, email1, data1, salary1, dep1);
				  sellerDao.insert(seller4);
				  System.out.println();
				  System.out.println("  Successfully inserted");
				  break;
			}
		}while(opcao != 0); 
			System.out.println("  Thank you for use program	");
			ler.close();
	}

}
