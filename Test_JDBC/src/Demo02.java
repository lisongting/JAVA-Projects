import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ��statement����ִ��SQL��䣬�Լ�SQLע������
 * @author LST
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		try {
			//����������[��Ҫ]
			Class.forName("com.mysql.jdbc.Driver");
			
			//��������[��Ҫ]
			try {
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","123");
				
				//����һ��statement����
				Statement stmt  = conn.createStatement();
				//�ַ�������sql��䣬Ȼ����statament�Ķ����У���ɶ����ݿ�Ĳ��빤��
				String sql = "insert into t_user (name,password,regtime) value('����',888,now())";
				stmt.execute(sql);
				
				//ɾ��ĳһ������
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
		//�˳���û�йرմ򿪵�conn����Ϊһ�����Ӷ��ѣ����ر�Ҳ����ν��
		//���򿪶������ʱ��ռ����Դ���࣬�ǵ���fanally��ʹ��conn.close()���йر�
	}
}
