package asset_management;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * UserDaoImpl�̳������ݿ⹤�����UserDao�ӿ�
 * Ŀ��:��UserDao ����ķ�����д
 * @author  �ƺ���
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao{
	Scanner input =new Scanner(System.in);//�����涨��һ��scanner ,��ʡȥ�ڸ��ַ����������ظ�����scanner
	
	
	// @author  �ƺ���
	@Override                 //������Ա
	public void Add(User user) {
		// �ֹ�����3(�ƺ���)
		System.out.println("����������Ҫ���ӵ���Ŀ��");
		System.out.println("��Աid���");
		user.setUsr_id(input.nextInt());           //������Ա���
		System.out.println("��Ա����");
		user.setUsr_name(input.next());            //������Ա����
		System.out.println("��Աְ��");
		user.setJob(input.next());                 //������Աְ��
		System.out.println("��ע");
		user.setRemark(input.next());              //���뱸ע
		Getconnection();                           //�������ݿ�
		//sql��䣬��������Ϣд�����ݿ�
		//user��sqlserver�Ĺؼ��֣���sqlserver����ֱ��ʹ��
		String sql1 = "insert into [user](user_id,user_name,user_job,user_remark) values('"+user.getUsr_id()+"','"+user.getUsr_name()+"','"+user.getJob()+"','"+user.getRemark()+"')";
		try {
			ps = conn.prepareStatement(sql1);
			//ps = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(1==ps.executeUpdate()){
				System.out.println("�����Ա�ɹ���");
			}
			else
				System.out.println("�����Աʧ�ܣ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
	}

	// @author  �ƺ���
	@Override                 //ɾ����Ա
	public void Del(User user) {
		// �ֹ�����3(�ƺ���)
		System.out.println("������Ҫɾ����Աid���");
		int input_id = input.nextInt();

		Getconnection();                           //�������ݿ�
		String sql = "delete from [user] where user_id = '"+input_id+"'";
		try {
			//ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(1==ps.executeUpdate()){
				System.out.println("ɾ����Ա�ɹ���");
			}
			else
				System.out.println("ɾ����Աʧ�ܣ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
	}

	// @author  �ƺ���
	@Override                 //�޸���Ա��Ϣ
	public void Update(User user) {
		// �ֹ�����3(�ƺ���)
		System.out.println("������Ҫ�޸���Աid���");
		int id = input.nextInt();
		Object[] Param = new Object[3];//����3������������
		 
		System.out.println("����������Ҫ�޸ĵ���Ŀ��");
		System.out.println("��Ա����");
		user.setUsr_name(input.next());
		System.out.println("��Աְ��");
		user.setJob(input.next());
		System.out.println("��ע");
		user.setRemark(input.next());
		
		Param[0] = user.getUsr_name();
		Param[1] = user.getJob();
		Param[2] = user.getRemark();
		 
		//Getconnection();
		 
		String sql = "update [user] set user_name=?,user_job=?,user_remark=? where user_id = '"+id+"'";
		if(1==updateExecute(sql,Param)){
			System.out.println("�޸ĳɹ���");		 
		}
		else{
			System.out.println("�޸�ʧ�ܣ�");
		}
		CloseAll(conn,ps,null);
	}

	// @author  �ƺ���
	@Override                 //������Ա������ţ�
	public void FindById() {
		// �ֹ�����3(�ƺ���)
		System.out.println("������Ҫ���ҵ���Աid���");
		int input_id = input.nextInt();
		String sql = "select * from [user] where user_id='"+input_id+"'";
		Getconnection();
		try {
			//ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rs!=null&&rs.next()){
				System.out.println("ID----����---ְ��---��ע--");
				rs.previous();
				while(rs.next()){
					try {
						System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"----"+rs.getString(4));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			else{ 

					System.out.println("û���ҵ�����Ա��Ϣ��");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//�ر���Դ
	}
	
	// @author  �ƺ���
	@Override                 //������Ա����������
	public void FindByName() {
		// �ֹ�����3(�ƺ���)
		System.out.println("������Ҫ���ҵ���Ա����");
		String input_name = input.next();
		String sql = "select * from [user] where user_name='"+input_name+"'";
		Getconnection();
		try {
			//ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(rs!=null&&rs.next()){
				System.out.println("ID----����---ְ��---��ע--");
				rs.previous();
				while(rs.next()){
					try {
						System.out.println(rs.getInt(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"----"+rs.getString(4));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			else{ 

					System.out.println("û���ҵ�����Ա��Ϣ��");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//CloseAll(conn,ps,rs);//�ر���Դ
	}

	@Override
	public void Display() {
		String sql1 = "select * from [user] where user_id>0";
		List<User> user1 =new ArrayList<User>();
		user1 = LookUpUser(sql1);
		int i=0;
		System.out.println("ID----����---ְ��---��ע--");
		while(i<user1.size()){
			System.out.print(user1.get(i).getUsr_id()+"----");
			System.out.print(user1.get(i).getUsr_name()+"----");
			System.out.print(user1.get(i).getJob()+"---");
			System.out.println(user1.get(i).getRemark()+"--");
			i++;
		}
	}
}