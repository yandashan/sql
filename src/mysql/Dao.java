package mysql;

import java.sql.*;

/**
 * �������ݿ�
 * 
 * @author Lenovo
 *
 */
public class Dao {

	/**
	 * ��Ӳ���
	 */
	public static void add(Student stu) {
		// ��ȡ���ݿ�����
		Connection connection = DBUtil.getConn();
		String sql = "insert into student(id,name,english,math,computer)values(?,?,?,?,?)";
		// ������֤�����Ƿ���ӳɹ�
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
			// System.out.println("��ӳɹ�");
			// }
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtil.closeCon();
	}

	/**
	 * ��ѯ����
	 * 
	 * @throws SQLException
	 */
	public static void select() throws SQLException {
		Connection connection = DBUtil.getConn();
		String sql = "select english from student where name='scofield'";
		// ����Statement����
		Statement stmt = connection.createStatement();
		// �������ݶ���
		ResultSet rs = stmt.executeQuery(sql);
		// System.out.println("------------������������Ϊ------------");
		// while (rs.next()) {
		// System.out.println("id :" + rs.getInt(1) + "\t");
		// System.out.println("name :" + rs.getString(2) + "\t");
		// System.out.println("english :" + rs.getString(3) + "\t");
		// System.out.println("math :" + rs.getString(4) + "\t");
		// System.out.println("computer :" + rs.getString(5) + "\t");
		// System.out.println("----------------------------------------------");
		// }
		while (rs.next()) {
			System.out.println("------------Ӣ��ɼ�Ϊ------------");
			System.out.println("english :" + rs.getString(1) + "\t");
			System.out.println("----------------------------------");
		}
		DBUtil.closeCon();
	}

	public static void main(String[] args) throws SQLException {
		select();
	}
}
