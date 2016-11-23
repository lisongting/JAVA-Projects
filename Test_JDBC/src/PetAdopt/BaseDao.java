package PetAdopt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 2016.7.8
 * ���ݿ�������رչ����ࡣ
 * �Ժ�ʹ�����ݿ�ʱ����Ԥ�ȶ��������
 * @author LST
 */
public class BaseDao {
	private String driver = 
			"com.mysql.jdbc.Driver";// ���ݿ������ַ���
	private String url = 
		"jdbc:mysql://localhost:3306/pet";// ����URL�ַ���
	
	private  String user = "root"; // ���ݿ��û���
	private  String password = "123"; // �û�����
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return conn;//�������Ӷ���
	}
	
	
	 //[����]�ر����ݿ����ӡ�
	 //@param conn ���ݿ�����
	 // @param stmt Statement����
	 // @param rs �����
	public void CloseAll(Connection conn,PreparedStatement ps,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
	
	
	//[����]����sql����������ɾ���Ĳ������������ȡ����sql���
	//������insert into    ɾ����delete from      �޸���update
	//param���� ��   Ԥ����� SQL ����еġ������������ַ�������  
	//����Ӱ�������
	public int ExecuteUpdate(String sql,Object[] param){
		int num = 0;
		try {
			ps = conn.prepareStatement(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					ps.setObject(i+1, param[i]); // ΪԤ����sql���ò���
				}
			}
			num = ps.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//CloseAll(conn, ps, null);
		}
		return num;//���ر�Ӱ�������
	}
	
}
