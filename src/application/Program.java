package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department obj = new Department(1, "Malucos");
		Seller obj1 = new Seller(1, "Maicon Lucas", "nicholasnk@gmail.com", new Date(), 500.00, obj);

		System.out.println(obj);
		System.out.println(obj1);
	}

}
