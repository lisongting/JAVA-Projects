import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo01 {
/**
 * 首先把mysql-connection-java.jar数据库连接驱动
 * 测试跟数据库建立连接
 * @param args
 */
	public static void main(String[] args) {
		try {
			//加载驱动类[重要]
			Class.forName("com.mysql.jdbc.Driver");
			
			//建立连接[重要]
			//连接test这个数据库.(连接对象内部其实包含了socket对象，相当于是进程间通信的远程连接。比较耗时)
			//真正开发中，为了提高效率，都会使用连接池来管理连接对象
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
				System.out.println(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//此程序没有关闭打开的conn
		//当打开多个连接时，占用资源过多，记得在fanally里使用conn.close()进行关闭
	}

}
