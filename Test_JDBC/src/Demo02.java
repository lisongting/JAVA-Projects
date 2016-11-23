import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 用statement类来执行SQL语句，以及SQL注入问题
 * @author LST
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		try {
			//加载驱动类[重要]
			Class.forName("com.mysql.jdbc.Driver");
			
			//建立连接[重要]
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
				
				//创建一个statement对象
				Statement stmt  = conn.createStatement();
				//字符串里存放sql语句，然后传入statament的对象中，完成对数据库的插入工作
				String sql = "insert into t_user (name,password,regtime) value('王二',888,now())";
				stmt.execute(sql);
				
				//删除某一条表项
				String sql2 = "delete from t_user where id=9";
				stmt.execute(sql2);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//此程序没有关闭打开的conn，因为一个连接而已，不关闭也无所谓。
		//当打开多个连接时，占用资源过多，记得在fanally里使用conn.close()进行关闭
	}
}
