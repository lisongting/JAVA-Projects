
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
/**
 * 2016.7.8
 * 数据库连接与关闭工具类。
 * 以后使用数据库时可以预先定义这个类
 */
public class BaseDao {
	private String driver = 
			"com.mysql.jdbc.Driver";// 数据库驱动字符串
	private String url = 
		"jdbc:mysql://localhost:3306/jdbc";// 连接URL字符串
	
	private  String user = "root"; // 数据库用户名
	private  String password = "123"; // 用户密码
	Connection conn = null;// 数据连接对象
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//[函数]获取数据库连接对象
	public Connection Getconnection(){
		if(conn!=null){
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				conn = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;//返回连接对象
	}
	
	/**
	 * [函数]关闭数据库连接。
	 * @param conn 数据库连接
	 * @param stmt Statement对象
	 * @param rs 结果集
	 */
	public void CloseAll(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//[函数]传入sql语句进行增、删、改操作，具体操作取决于sql语句
	//增加用insert into    删除用delete from      修改用update
	//param数组 ：   预编译的 SQL 语句中的‘？’参数的字符串数组  
	//返回影响的行数
	public int updateExecute(String sql,Object[]param){
		int num = 0;
		conn =  Getconnection(); 
		try {
			ps = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ps.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			num = ps.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			CloseAll(conn, ps, null);
			//这里要看具体情况而定,如果程序功能段的后面还要使用conn连接对象,则先不要关闭资源,如果不再使用conn和ps对象,则可以关闭
		}
		return num;//返回被影响的行数
	}
	
	//[函数] 实现查询功能
	//使用泛型容器
	public List<String> LookUp(String sql){
		conn = Getconnection();
		try {
			ps = conn.prepareStatement(sql);     //建立Preparement对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();           //执行查询语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return (List<String>) rs; //把resultSet 对象rs转换为List<String> 输出
		
		
	}
	
}
