import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * 实现用户注册功能，并把用户数据导入数据库
 * 2016.7.7
 * @author LST
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet s = null;
		Scanner input = new Scanner(System.in);
		String stu_name = new String();
		String stu_password = new String();
		try {
			//加载驱动类[重要]
			Class.forName("com.mysql.jdbc.Driver");
			try {
				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
				System.out.println("数据库连接成功");
				System.out.println("请您先注册");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println("请输入用户名");
			stu_name = input.next();
			System.out.println("请输入密码");
			stu_password = input.next();
			
			
			String sq = "insert into t_user(name,password,regtime) value(?,?,now())";
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
				
				
				String sql4 = "select name,password,regtime from t_user where id>0";
				s = ps.executeQuery(sql4);
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
