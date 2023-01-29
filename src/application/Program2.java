package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);

		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department findById ===");
		
		Department dep = depDao.findById(sc.nextInt());
		
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> list = depDao.findAll();

		for (Department dep2 : list) {
			System.out.println(dep2);
		}
		
		System.out.println("\n=== TEST 3: department insert ===");
		Department dep3 = new Department(null, sc.next());
		depDao.insert(dep3);
		System.out.println("Inserted! New department id = " + dep3.getId());
	
		System.out.println("\n=== TEST 4: department update ===");
		Department dep4 = depDao.findById(sc.nextInt());
		dep4.setName(sc.next());
		depDao.update(dep4);
		System.out.println("Update completed!");
		System.out.println(dep4);
		
		System.out.println("\n=== TEST 5: department deleted ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
				
		sc.close();
	}

}
