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

		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println();
		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.finByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println();

		System.out.println("=== TEST 3: seller findAll ===");
		List<Seller> list2 = sellerDao.findAll();
		for (Seller obj : list2) {
			System.out.println(obj);
		}
		System.out.println();
		System.out.println("=== TEST 4: seller findAll ===");
		System.out.print("Name: ");
		String name = ler.nextLine();
		System.out.print("Email");
		String email = ler.nextLine();
		System.out.print("BirthDate");
		Date data = sdf.parse(ler.next());
		System.out.print("BaseSalary");
		double salary = ler.nextDouble();
		System.out.print("Department id");
		int id = ler.nextInt();
		Department dep = new Department(id, null);

		Seller seller3 = new Seller(null, name, email, data, salary, dep);
		sellerDao.insert(seller3);

	}

}
