package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 	�������ݿ⹤����
 * @author Lenovo
 *
 */
public class DBUtil {

	private static String dbUrl = "jdbc:mysql://localhost:3306/mytest?useUnicode=true&characterEncoding=utf8";
	private static String dbUser = "root";
	private static String dbPassword = "20173673";
	private static String jdbcName = "com.mysql.jdbc.Driver";
	private static Connection connection = null;

	/**
	 * 	�������ݿ�
	 * @return
	 */
	public static Connection getConn() {
		try {
			Class.forName(jdbcName);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * �ر����ݿ�����
	 */
	public static void closeCon() {
		if (connection != null)
			try {
				connection.close();
				System.out.println("���ݿ������ѹرգ�");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * �������ݿ��Ƿ����ӳɹ�
	 * @param args
	 */
	public static void main(String[] args) {
		getConn();
		closeCon();
	}

}
