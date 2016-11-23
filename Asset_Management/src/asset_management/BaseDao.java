package asset_management;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * 数据库连接与关闭工具类。
 * 以后使用数据库时可以预先定义这个类
 * 7.14日修改记录:
 * 添加了public List<Asset> LookUpAsset(String sql)函数  目的:便于对资产对象的查询,返回查询结果对象的泛型集合
 * 添加了public List<User> LookUpUser(String sql)函数     目的:便于对领用者对象的查询,返回查询结果对象的泛型集合
 * @author LST
 */
public class BaseDao {
	
	/*在sqlserver中用下面这段代码
	private String driver = 
			"com.microsoft.sqlserver.jdbc.SQLServerDriver";// 数据库驱动字符串
	private String url = 
		"jdbc:sqlserver://localhost:1433;DatabaseName=asset";// 连接URL字符串     asset是我存放表的数据库名...根据不同的数据库名进行改动
	
	private  String user = "aaa"; // 数据库用户名
	private  String password = "123"; // 用户密码
	*/
	
	//在mysql中测试用下面这段代码
	private String driver = 
			"com.mysql.jdbc.Driver";// 数据库驱动字符串
	private String url = 
			"jdbc:mysql://localhost:3306/asset";// 连接URL字符串    asset是我存放表的数据库名...根据不同的数据库名进行改动
	
	private  String user = "root"; // 数据库用户名
	private  String password = "123"; // 用户密码
	//在mysql中测试用上面这段代码
	
	Connection conn = null;// 数据连接对象
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//[函数]获取数据库连接对象
	public Connection Getconnection(){
		if(conn==null){
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
				e.printStackTrace();
			}
		}
	}
	
	//[函数]传入sql语句进行增、删、改操作，具体操作取决于sql语句
	//param数组 ：   预编译的 SQL 语句中的‘？’参数的字符串数组  
	//返回影响的行数
	public int updateExecute(String sql,Object[]param){
		int num = 0;
		conn =  Getconnection(); 
		try {
			//ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ps.setObject(i + 1, param[i]); // 为预编译sql设置参数
				}
			}
			num = ps.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//CloseAll(conn, ps, null);
			//这里要看具体情况而定,如果程序功能段的后面还要使用conn连接对象,则先不要关闭资源,如果不再使用conn和ps对象,则可以关闭
		}
		return num;//返回被影响的行数
	}
	

	//[函数] 实现查询功能(具体的查询规则由传入的sql而定)
	//使用泛型容器
	//注意:函数重载貌似不支持泛型变量的函数重载
	//asset1是专门存放asset对象的容器,这个函数把asset1容器返回
	public List<Asset> LookUpAsset(String sql){
		conn = Getconnection();
		List<Asset> asset1 =new ArrayList<Asset>();  
		try {
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// ps = conn.prepareStatement(sql);

     //建立Preparement对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();           //执行查询语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()){
				Asset temp = new Asset();
				try {
					 //把结果集rs中的条目赋值给临时的asset对象
					temp.setAst_id(rs.getInt("ast_id"));
					temp.setAst_name(rs.getString("ast_name"));  
					temp.setAst_category1(rs.getString("ast_category1"));
					temp.setAst_category2(rs.getString("ast_category2"));
					temp.setAst_boughtDay(rs.getString("ast_boughtDay"));
					temp.setAst_status(rs.getString("ast_status"));
					temp.setAst_type(rs.getString("ast_type"));
					temp.setAst_user(rs.getString("ast_user"));
					temp.setAst_value(rs.getString("ast_value"));
					temp.setAst_remark(rs.getString("ast_remark"));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				asset1.add(temp);//把当前这个asset对象加入到asset1容器中
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asset1; //把resultSet 对象rs转换为List<String> 输出
		
	}
	
	 //用泛型容器查找领用者
	public List<User> LookUpUser(String sql){    
		conn = Getconnection();
		List<User> user1 =new ArrayList<User>();  
		try {
			//ps = conn.prepareStatement(sql);     //建立Preparement对象
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();           //执行查询语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()){
				User temp = new User();
				try {
					 //把结果集rs中的条目赋值给临时的asset对象
					temp.setUsr_id(rs.getInt("user_id"));
					temp.setUsr_name(rs.getString("user_name"));  
					temp.setJob(rs.getString("user_job"));
					temp.setRemark(rs.getString("user_remark"));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				user1.add(temp);//把当前这个asset对象加入到asset1容器中
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user1;
	}
	
}

