import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo01 {
/**
 * ���Ȱ�mysql-connection-java.jar���ݿ���������
 * ���Ը����ݿ⽨������
 * @param args
 */
	public static void main(String[] args) {
		try {
			//����������[��Ҫ]
			Class.forName("com.mysql.jdbc.Driver");
			
			//��������[��Ҫ]
			//����test������ݿ�.(���Ӷ����ڲ���ʵ������socket�����൱���ǽ��̼�ͨ�ŵ�Զ�����ӡ��ȽϺ�ʱ)
			//���������У�Ϊ�����Ч�ʣ�����ʹ�����ӳ����������Ӷ���
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
		//�˳���û�йرմ򿪵�conn
		//���򿪶������ʱ��ռ����Դ���࣬�ǵ���fanally��ʹ��conn.close()���йر�
	}

}
