import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用PreparedStatement类来执行SQL语句，实现增删改查功能
 * @author LST
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
				
				//增加数据
				String sql1 = "insert into t_user(name,password) value('辛德拉',4242)";
				PreparedStatement ps = conn.prepareStatement(sql1);
				ps.execute(sql1);
				
				
				//String sq1 = "insert into t_user(name,password) value(?,?)";//?是占位符
				/*也可以用这种方式增加数据
				ps.setString(1, "赵信");//第一个参数索引，(从1开始算)
				ps.setString(2, "123456");//第二个参数索引
				ps.execute();//执行
				ps.setString(1, "盖伦");//第一个参数索引，(从1开始算)
				ps.setString(2, "1456");//第二个参数索引
				ps.executeUpdate();//执行
				*/
				
				//删除数据
				String sql2 = "delete from t_user where id=10";
				ps.execute(sql2);
				
				//修改数据
				String sql3 = "update t_user set name='普朗克' where id=14";
				ps.execute(sql3);
				
				//查看数据
				//String sql4 = "select * from t_user where id>3";//select* 表示只取列名
				String sql4 = "select name,password,regtime from t_user where id>3";
				
				ResultSet s = ps.executeQuery(sql4);
				while(s.next()){
					System.out.println(s.getString(1)+"---"+s.getString(2)+"----"+s.getString(3));
				}
				
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
		//遵循ResultSet-->Statement-->Connection这样的关闭顺序！！
	}

}
