import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��PreparedStatement����ִ��SQL��䣬ʵ����ɾ�Ĳ鹦��
 * @author LST
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
				
				//��������
				String sql1 = "insert into t_user(name,password) value('������',4242)";
				PreparedStatement ps = conn.prepareStatement(sql1);
				ps.execute(sql1);
				
				
				//String sq1 = "insert into t_user(name,password) value(?,?)";//?��ռλ��
				/*Ҳ���������ַ�ʽ��������
				ps.setString(1, "����");//��һ������������(��1��ʼ��)
				ps.setString(2, "123456");//�ڶ�����������
				ps.execute();//ִ��
				ps.setString(1, "����");//��һ������������(��1��ʼ��)
				ps.setString(2, "1456");//�ڶ�����������
				ps.executeUpdate();//ִ��
				*/
				
				//ɾ������
				String sql2 = "delete from t_user where id=10";
				ps.execute(sql2);
				
				//�޸�����
				String sql3 = "update t_user set name='���ʿ�' where id=14";
				ps.execute(sql3);
				
				//�鿴����
				//String sql4 = "select * from t_user where id>3";//select* ��ʾֻȡ����
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
		//�˳���û�йرմ򿪵�conn
		//���򿪶������ʱ��ռ����Դ���࣬�ǵ���fanally��ʹ��conn.close()���йر�
		//��ѭResultSet-->Statement-->Connection�����Ĺر�˳�򣡣�
	}

}
