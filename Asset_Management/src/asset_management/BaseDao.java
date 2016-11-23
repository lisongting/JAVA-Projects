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
 * ���ݿ�������رչ����ࡣ
 * �Ժ�ʹ�����ݿ�ʱ����Ԥ�ȶ��������
 * 7.14���޸ļ�¼:
 * �����public List<Asset> LookUpAsset(String sql)����  Ŀ��:���ڶ��ʲ�����Ĳ�ѯ,���ز�ѯ�������ķ��ͼ���
 * �����public List<User> LookUpUser(String sql)����     Ŀ��:���ڶ������߶���Ĳ�ѯ,���ز�ѯ�������ķ��ͼ���
 * @author LST
 */
public class BaseDao {
	
	/*��sqlserver����������δ���
	private String driver = 
			"com.microsoft.sqlserver.jdbc.SQLServerDriver";// ���ݿ������ַ���
	private String url = 
		"jdbc:sqlserver://localhost:1433;DatabaseName=asset";// ����URL�ַ���     asset���Ҵ�ű�����ݿ���...���ݲ�ͬ�����ݿ������иĶ�
	
	private  String user = "aaa"; // ���ݿ��û���
	private  String password = "123"; // �û�����
	*/
	
	//��mysql�в�����������δ���
	private String driver = 
			"com.mysql.jdbc.Driver";// ���ݿ������ַ���
	private String url = 
			"jdbc:mysql://localhost:3306/asset";// ����URL�ַ���    asset���Ҵ�ű�����ݿ���...���ݲ�ͬ�����ݿ������иĶ�
	
	private  String user = "root"; // ���ݿ��û���
	private  String password = "123"; // �û�����
	//��mysql�в�����������δ���
	
	Connection conn = null;// �������Ӷ���
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//[����]��ȡ���ݿ����Ӷ���
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
		
		return conn;//�������Ӷ���
	}
	
	/**
	 * [����]�ر����ݿ����ӡ�
	 * @param conn ���ݿ�����
	 * @param stmt Statement����
	 * @param rs �����
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
	
	//[����]����sql����������ɾ���Ĳ������������ȡ����sql���
	//param���� ��   Ԥ����� SQL ����еġ������������ַ�������  
	//����Ӱ�������
	public int updateExecute(String sql,Object[]param){
		int num = 0;
		conn =  Getconnection(); 
		try {
			//ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ps.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
				}
			}
			num = ps.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//CloseAll(conn, ps, null);
			//����Ҫ�������������,��������ܶεĺ��滹Ҫʹ��conn���Ӷ���,���Ȳ�Ҫ�ر���Դ,�������ʹ��conn��ps����,����Թر�
		}
		return num;//���ر�Ӱ�������
	}
	

	//[����] ʵ�ֲ�ѯ����(����Ĳ�ѯ�����ɴ����sql����)
	//ʹ�÷�������
	//ע��:��������ò�Ʋ�֧�ַ��ͱ����ĺ�������
	//asset1��ר�Ŵ��asset���������,���������asset1��������
	public List<Asset> LookUpAsset(String sql){
		conn = Getconnection();
		List<Asset> asset1 =new ArrayList<Asset>();  
		try {
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// ps = conn.prepareStatement(sql);

     //����Preparement����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();           //ִ�в�ѯ���
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()){
				Asset temp = new Asset();
				try {
					 //�ѽ����rs�е���Ŀ��ֵ����ʱ��asset����
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
				asset1.add(temp);//�ѵ�ǰ���asset������뵽asset1������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asset1; //��resultSet ����rsת��ΪList<String> ���
		
	}
	
	 //�÷�����������������
	public List<User> LookUpUser(String sql){    
		conn = Getconnection();
		List<User> user1 =new ArrayList<User>();  
		try {
			//ps = conn.prepareStatement(sql);     //����Preparement����
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();           //ִ�в�ѯ���
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()){
				User temp = new User();
				try {
					 //�ѽ����rs�е���Ŀ��ֵ����ʱ��asset����
					temp.setUsr_id(rs.getInt("user_id"));
					temp.setUsr_name(rs.getString("user_name"));  
					temp.setJob(rs.getString("user_job"));
					temp.setRemark(rs.getString("user_remark"));
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				user1.add(temp);//�ѵ�ǰ���asset������뵽asset1������
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user1;
	}
	
}

