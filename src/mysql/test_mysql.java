package mysql;

import java.sql.SQLException;
import java.util.Scanner;

public class test_mysql {
	private static Scanner scanner;

	public static void main(String[] args) {

		int id;
		String name, english, math, computer;
		scanner = new Scanner(System.in);
		System.out.println("������ӵ�����\n");
		id = scanner.nextInt();
		name = scanner.next();
		english = scanner.next();
		math = scanner.next();
		computer = scanner.next();
		Student student = new Student(id, name, english, math, computer);
		try {
			Dao.add(student);
			System.out.println("��ӳɹ���");
		} catch (Exception e) {
			System.out.println("���ʧ�ܣ�");
			// TODO: handle exception
		}
		
		try {
			Dao.select();
			System.out.println("���ҳɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("����ʧ�ܣ�");
		}
	}
}
