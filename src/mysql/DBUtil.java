package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 	连接数据库工具类
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
	 * 	连接数据库
	 * @return
	 */
	public static Connection getConn() {
		try {
			Class.forName(jdbcName);
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
			System.out.println("数据库链接成功！");
		} catch (Exception e) {
			System.out.println("数据库链接失败！");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 关闭数据库连接
	 */
	public static void closeCon() {
		if (connection != null)
			try {
				connection.close();
				System.out.println("数据库链接已关闭！");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	/**
	 * 检验数据库是否连接成功
	 * @param args
	 */
	public static void main(String[] args) {
		getConn();
		closeCon();
	}

}
