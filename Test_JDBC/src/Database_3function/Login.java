package Database_3function;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * ��¼��
 * @author LST
 *2016.7.7
 */
public class Login {
	Connection conn = null;//���Ӷ���
	PreparedStatement ps = null;//sql����������
	ResultSet s = null;//������Ų�ѯ���
	Scanner input3 = new Scanner(System.in);
	String stu_name = new String();
	String stu_password = new String();
	boolean rightName=false;
	boolean rightPassword = false;
	void Log(){
		System.out.println("�������û���");
		stu_name = input3.next();
		System.out.println("����������");
		stu_password = input3.next();
		
		//�������ݿ�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//name��ͬʱ����ѡ�����뼯,��Ϊ�����ж����ͬ��
			//�����������ǳ���Ҫ����ס��sql�������ӱ����ķ�����������˫����'"+stu_name+"'
			String sql1 = "select password,regtime from table2 where name= '"+stu_name+"'";
			
			try {
				ps = conn.prepareStatement(sql1);
				
				s= ps.executeQuery();  //�γɽ������
				int flag =0;   //��������Ƿ�������ȷ
				while(s.next()){
					if(s.getString(1).equals(stu_password)){
						System.out.println("��¼�ɹ�");
						flag =1;
					}
					if(flag==1)
						break;
					System.out.println(s.getString(1)+"---"+s.getString(2));
				}
				if(0==flag){
					System.out.println("�û������������");
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
