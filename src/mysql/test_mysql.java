package mysql;

import java.sql.SQLException;
import java.util.Scanner;

public class test_mysql {
	private static Scanner scanner;

	public static void main(String[] args) {

		int id;
		String name, english, math, computer;
		scanner = new Scanner(System.in);
		System.out.println("输入添加的数据\n");
		id = scanner.nextInt();
		name = scanner.next();
		english = scanner.next();
		math = scanner.next();
		computer = scanner.next();
		Student student = new Student(id, name, english, math, computer);
		try {
			Dao.add(student);
			System.out.println("添加成功！");
		} catch (Exception e) {
			System.out.println("添加失败！");
			// TODO: handle exception
		}
		
		try {
			Dao.select();
			System.out.println("查找成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("查找失败！");
		}
	}
}
