package PetAdopt;

import java.sql.SQLException;
/**
 * display ����
 * ���ܣ���ʾ����������Ϣ����ʾ���г�����Ϣ
 * @author LST
 *
 */
public class Display extends BaseDao{
	
	public void ShowAllMaster(){
		Getconnection();
		String sql = "select person_id,person_name,password,money,pet_id from master where person_id>0";
		
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
			System.out.println("ID----����---����---���--����id--");
			while(rs.next()){
				try {
					System.out.println(rs.getString(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"----"+rs.getLong(4)+"----"+rs.getLong(5));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//�ر����д򿪵���Դ
	}
	
	public void ShowAllPet(){
		Getconnection();//�õ�����
		String sql = "select pet_id,pet_name,health,love,strain,master_name,adoptTime,status,cost from pet where pet_id>0";
		
		//����preparedStatement ����
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//�õ������
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//������
		try {
			System.out.println("Id--����--����ֵ---���ܶ�---Ʒ��----��������----����ʱ��----״̬----��������----");
			while(rs.next()){
				try {
					System.out.println(rs.getString(1)+"----"+rs.getString(2)+"----"+rs.getString(3)+"-----"+rs.getString(4)+"----"+rs.getString(5)+"----"+rs.getString(6)+"------"+rs.getString(7)+"----"+rs.getString(8)+"----"+rs.getString(9));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//�ر���Դ	
		
		
	}
}
