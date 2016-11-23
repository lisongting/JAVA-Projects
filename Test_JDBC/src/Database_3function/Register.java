package Database_3function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * 注册类
 * @author LST
 *2016.7.7
 */
public class Register {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet s = null;
	Scanner input2 = new Scanner(System.in);
	String stu_name = new String();
	String stu_password = new String();
	
	void Regi(){
		//注册函数
		try {
			//加载驱动类[重要]
			Class.forName("com.mysql.jdbc.Driver");
			try {
				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
				System.out.println("数据库连接成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("请输入用户名");
			stu_name = input2.next();
			System.out.println("请输入密码");
			stu_password = input2.next();
			
			
			String sq = "insert into table2(name,password,regtime) value(?,?,now())";
			try {
				ps = conn.prepareStatement(sq);
				
				try {
					ps.setString(1,stu_name);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					ps.setString(2,stu_password);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}	
				ps.execute();
				
				System.out.println("注册成功");
				String sql4 = "select name,password,regtime from table2 where id>0";
				s = ps.executeQuery(sql4);
				System.out.println("更新后的表为：");
				while(s.next()){
					System.out.println(s.getString(1)+"---"+s.getString(2)+"----"+s.getString(3));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
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
