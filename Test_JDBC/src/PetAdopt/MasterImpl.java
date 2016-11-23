package PetAdopt;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * MasterImpl�̳������ݿ⹤�����BaseDao�ӿڣ���MastertDao ����ķ�����д
 * �����˵���ɾ�Ĳ�
 * @author LST
 *
 */
public class MasterImpl extends BaseDao implements MasterDao{
	Scanner input = new Scanner(System.in);
	
	@Override	//��������
	public void Add() {
		MasterManager M = new MasterManager();
		M.Register();
	}

	
	@Override//ɾ������
	public void Del() {
		System.out.println("������Ҫɾ�����û�ID");
		int input_id = input.nextInt();

		Getconnection();
		String sql = "delete from master where person_id = '"+input_id+"'";
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(1==ps.executeUpdate()){
				System.out.println("ɾ���û��ɹ�");
			}
			else
				System.out.println("ɾ��ʧ��");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
	}

	
	@Override//�޸�������Ϣ
	public int Update(Master master) {
		 System.out.println("������Ҫ�޸ĵ��û���ID");
		 int id = input.nextInt();
		 Object[] Param = new Object[3];//����3������������
		 
		 System.out.println("����������Ҫ�޸ĵ�ֵ��");
		 System.out.println("�û�����:");
		 master.setName(input.next());
		 System.out.println("�û�����:");
		 master.setPassword(input.next());
		 System.out.println("�û����:");
		 master.setMoney(input.next());
		 Param[0] = master.getName();
		 Param[1] = master.getPassword();
		 Param[2] = master.getMoney();
		 
		 Getconnection();
		 
		 String sql = "update master set person_name=?,password=?,money=? where person_id = '"+id+"'";
		 if(1==ExecuteUpdate(sql,Param)){
			 System.out.println("�޸ĳɹ�");		 
		 }
		 else{
			 System.out.println("�޸�ʧ��");
		 }
		 return 0;
	}

	@Override//����������Ϣ
	public void FindMasterPrecisely() {
		System.out.println("������׼ȷ����������");
		String input_name = input.next();
		String sql = "select * from master where person_name='"+input_name+"'";
		Getconnection();
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs!=null&&rs.next()){
				System.out.println("ID----����---����---���--����id--");
				rs.previous();
				while(rs.next()){
					try {
						System.out.println(rs.getString(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"----"+rs.getLong(4)+"----"+rs.getLong(5));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			else{ 

					System.out.println("û���ҵ�������");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//�ر���Դ	
	}
	public void FindMasterRoughly() {
		System.out.println("��������µ���������");
		String input_name = input.next();
		String sql = "select * from master where person_name like '"+input_name+"%'";
		Getconnection();
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs!=null&&rs.next()){
				System.out.println("ID----����---����---���--����id--");
				rs.previous();
				while(rs.next()){ 
						try {
							System.out.println(rs.getString(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"----"+rs.getLong(4)+"----"+rs.getLong(5));
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
			}
			else{ 

					System.out.println("û���ҵ�������");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//�ر���Դ			
	}

}
