package Database_3function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * 显示整个表
 * @author LST
 *
 */
public class Display {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet s = null;
	Scanner input = new Scanner(System.in);
	String stu_name = new String();
	String stu_password = new String();
	String sql = "select name,password,regtime from table2 where id>0";
	void Show(){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
				 ps = conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
							
				s = ps.executeQuery(sql);
				while(s.next()){
					System.out.println(s.getString(1)+"---"+s.getString(2)+"----"+s.getString(3));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
			//在finally里面把打开的资源关闭
			try {
				s.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
