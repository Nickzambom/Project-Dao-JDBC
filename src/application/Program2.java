package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		DepartmentDao DepartmentDao = DaoFactory.createDepartmentDao();

		/*
		 * System.out.println("---- TESTE 1  findById----");
		 * System.out.print("Department Id: "); Integer id = ler.nextInt();
		 * System.out.println(); Department dep = DepartmentDao.findById(id);
		 * System.out.println(dep);
		 */

		/*
		 * System.out.println("---- TESTE 2  ----"); System.out.print("Dep Name: ");
		 * String name = ler.nextLine(); Department dep2 = new Department(null, name);
		 * DepartmentDao.insert(dep2);
		 */

		System.out.println("---- TESTE 3  findAll----");
		List<Department> list = DepartmentDao.findAll();
		System.out.println(list);
		System.out.println();

		/*
		 * System.out.println("---- TESTE 4  Delete----");
		 * System.out.print("Id for delete: "); int id = ler.nextInt();
		 * DepartmentDao.deleteById(id);
		 */

		System.out.println("---- TESTE 5  Update----");
		System.out.print("Id for update: ");
		int id = ler.nextInt();
		ler.nextLine();
		System.out.print("Name for update: ");
		String name = ler.nextLine();
		Department dep5 = new Department(id, name);
		DepartmentDao.update(dep5);
		
	}

}
