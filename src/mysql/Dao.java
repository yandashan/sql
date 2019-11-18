package mysql;

import java.sql.*;

/**
 * 操作数据库
 * 
 * @author Lenovo
 *
 */
public class Dao {

	/**
	 * 添加操作
	 */
	public static void add(Student stu) {
		// 获取数据库连接
		Connection connection = DBUtil.getConn();
		String sql = "insert into student(id,name,english,math,computer)values(?,?,?,?,?)";
		// 用于验证数据是否添加成功
		int i = 0;
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, stu.getId());
	        pstmt.setString(2, stu.getName());
	        pstmt.setString(3, stu.getEnglish());
	        pstmt.setString(4, stu.getMath());
	        pstmt.setString(5, stu.getComputer());
	        i = pstmt.executeUpdate();
	        pstmt.close();
		} catch (SQLException e) {
			// if (i>0) {
			// System.out.println("添加成功");
			// }
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeCon();
	}

	/**
	 * 查询操作
	 * 
	 * @throws SQLException
	 */
	public static void select() throws SQLException {
		Connection connection = DBUtil.getConn();
		String sql = "select english from student where name='scofield'";
		// 创建Statement对象
		Statement stmt = connection.createStatement();
		// 创建数据对象
		ResultSet rs = stmt.executeQuery(sql);
		// System.out.println("------------表中所有数据为------------");
		// while (rs.next()) {
		// System.out.println("id :" + rs.getInt(1) + "\t");
		// System.out.println("name :" + rs.getString(2) + "\t");
		// System.out.println("english :" + rs.getString(3) + "\t");
		// System.out.println("math :" + rs.getString(4) + "\t");
		// System.out.println("computer :" + rs.getString(5) + "\t");
		// System.out.println("----------------------------------------------");
		// }
		while (rs.next()) {
			System.out.println("------------英语成绩为------------");
			System.out.println("english :" + rs.getString(1) + "\t");
			System.out.println("----------------------------------");
		}
		DBUtil.closeCon();
	}

	public static void main(String[] args) throws SQLException {
		select();
	}
}
