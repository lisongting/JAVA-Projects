package PetAdopt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 * PetDaoImpl�̳������ݿ⹤�����petDao�ӿڣ���PetDao ����ķ�����д
 * ��pet����ɾ�Ĳ�
 * @author LST
 *
 */
public class PetDaoImpl extends BaseDao implements PetDao {
	Scanner input = new Scanner(System.in);
	
	
	@Override//���ӳ���
	public int Add(Pet pet) {
		System.out.println("�������������");
		pet.setName(input.next());
		System.out.println("��������｡��ֵ");
		pet.setHealth(input.nextInt());
		System.out.println("������������ܶ�");
		pet.setLove(input.nextInt());
		System.out.println("���������Ʒ��");
		pet.setStrain(input.next());
		System.out.println("��������ﻨ��");
		pet.setCost(input.nextInt());
		
		Getconnection();
		String sql1 = "insert into pet (pet_name,health,love,strain,cost,status) value('"+pet.getName()+"','"+pet.getHealth()+"','"+pet.getLove()+"','"+pet.getStrain()+"','"+pet.getCost()+"','adoptable')";
		try {
			ps = conn.prepareStatement(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(1==ps.executeUpdate()){
				System.out.println("��ӳ���ɹ�");
			}
			else
				System.out.println("���ʧ��");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
		return 0;
	}

	@Override//ɾ������
	public int Del(Pet pet) {
		System.out.println("���������ID");
		int input_id = input.nextInt();

		Getconnection();
		String sql = "delete from pet where pet_id = '"+input_id+"'";
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(1==ps.executeUpdate()){
				System.out.println("ɾ������ɹ�");
			}
			else
				System.out.println("ɾ��ʧ��");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
		return 0;
	}

	@Override//�޸ĳ���
	public int Update(Pet pet) {
		 System.out.println("���������ID");
		 int id = input.nextInt();
		 Object[] Param = new Object[5];//����5������������
		 
		 System.out.println("����������Ҫ�޸ĵ�ֵ��");
		 System.out.println("��������");
		 pet.setName(input.next());
		 System.out.println("���｡��ֵ");
		 pet.setHealth(input.nextInt());
		 System.out.println("�������ܶ�");
		 pet.setLove(input.nextInt());
		 System.out.println("����Ʒ��");
		 pet.setStrain(input.next());
		 System.out.println("������������");
		 pet.setCost(input.nextInt());
		 Param[0] = pet.getName();
		 Param[1] = pet.getHealth();
		 Param[2] = pet.getLove();
		 Param[3] = pet.getStrain();
		 Param[4] = pet.getCost();
		 
		 Getconnection();
		 
		 String sql = "update pet set pet_name=?,health=?,love=?,strain=?,cost=? where pet_id = '"+id+"'";
		 if(1==ExecuteUpdate(sql,Param)){
			 System.out.println("�޸ĳɹ�");		 
		 }
		 else{
			 System.out.println("�޸�ʧ��");
		 }
		 return 0;
	}

	
	@Override//�������־�ȷ����
	public void  GetByName() {
		System.out.println("������׼ȷ�ĳ�������");
		String input_name = input.next();
		String sql = "select * from pet where pet_name='"+input_name+"'";
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
				System.out.println("Id--����--����ֵ---���ܶ�---Ʒ��----��������----����ʱ��----״̬----��������----");
				rs.previous();
				while(rs.next()){ 
						try {
							System.out.println(rs.getString(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"-----"+rs.getString(4)+"----"+rs.getString(5)+"----"+rs.getString(6)+"------"+rs.getString(7)+"----"+rs.getString(8)+"----"+rs.getString(9));
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
			}
			else{ 

					System.out.println("û���ҵ��ó���");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//�ر���Դ	
	}

	@Override//��������ģ������  
	public void FindByName() {
		System.out.println("��������µĳ�������");
		String input_name = input.next();
		String sql = "select * from pet where pet_name like '"+input_name+"%'";
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
				System.out.println("Id--����--����ֵ---���ܶ�---Ʒ��----��������----����ʱ��----״̬----��������----");
				rs.previous();
				while(rs.next()){ 
						try {
							System.out.println(rs.getString(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"-----"+rs.getString(4)+"----"+rs.getString(5)+"----"+rs.getString(6)+"------"+rs.getString(7)+"----"+rs.getString(8)+"----"+rs.getString(9));
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
			}
			else{ 

					System.out.println("û���ҵ��ó���");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//�ر���Դ			

	}

	@Override//����Ʒ�ֲ���
	public void FindByStrain() {
		System.out.println("���������Ʒ��");
		String input_strain = input.next();
		String sql = "select * from pet where strain='"+input_strain+"'";
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
				System.out.println("Id--����--����ֵ---���ܶ�---Ʒ��----��������----����ʱ��----״̬----��������----");
				rs.previous();
				while(rs.next()){ 
						try {
							System.out.println(rs.getString(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"-----"+rs.getString(4)+"----"+rs.getString(5)+"----"+rs.getString(6)+"------"+rs.getString(7)+"----"+rs.getString(8)+"----"+rs.getString(9));
						} catch (SQLException e) {
							e.printStackTrace();
						}
				}
			}
			else{ 

					System.out.println("û���ҵ���Ʒ�ֵĳ���");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//�ر���Դ	
	}

}
