package Database_3function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * 登录类
 * @author LST
 *2016.7.7
 */
public class Login {
	Connection conn = null;//连接对象
	PreparedStatement ps = null;//sql声明语句对象
	ResultSet s = null;//用来存放查询结果
	Scanner input3 = new Scanner(System.in);
	String stu_name = new String();
	String stu_password = new String();
	boolean rightName=false;
	boolean rightPassword = false;
	void Log(){
		System.out.println("请输入用户名");
		stu_name = input3.next();
		System.out.println("请输入密码");
		stu_password = input3.next();
		
		//连接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//name相同时，挑选出密码集,因为可能有多个人同名
			//下面这条语句非常重要，记住在sql语句中添加变量的方法：单引号双引号'"+stu_name+"'
			String sql1 = "select password,regtime from table2 where name= '"+stu_name+"'";
			
			try {
				ps = conn.prepareStatement(sql1);
				
				s= ps.executeQuery();  //形成结果集合
				int flag =0;   //用来标记是否密码正确
				while(s.next()){
					if(s.getString(1).equals(stu_password)){
						System.out.println("登录成功");
						flag =1;
					}
					if(flag==1)
						break;
					System.out.println(s.getString(1)+"---"+s.getString(2));
				}
				if(0==flag){
					System.out.println("用户名或密码错误");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
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
