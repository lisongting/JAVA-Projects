package asset_management;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ManagerDaoImpl�̳������ݿ⹤�����ManagerDao�ӿ�
 * Ŀ��:��ManagerDao ����ķ�����д
 * @author ����  LST
 *
 */
public class ManagerDaoImpl extends BaseDao implements ManagerDao{
	boolean islogin = false;//������ʶ����Ա�Ƿ��ѵ�¼
	Scanner input =new Scanner(System.in);//�����涨��һ��scanner ,��ʡȥ�ڸ��ַ����������ظ�����scanner
	String log_name = new String();		//��ŵ�¼ʱ�Ĺ���Աname
	String log_password = new String();//��ŵ�¼ʱ�Ĺ���Ա����
	String log_id = new String();//7.15���������,�����������Ա��id
	int flagId=0;  //����Ѱ����Ҫ�޸������ID
	String Odpwd=null;  //�������ԭ����
	
	//@author ����
	@Override
	public void Register() {
		// �ֹ�����1(����)
				System.out.println("�������û���:");
				String input_name=input.next();
				System.out.println("����������:");
				String input_password=input.next();
				//Getconnection();//�������ݿ�
				
				//String sql2="insert into manager(name,password) values('"+input_name+"','"+input_password+"') ";
				
				String sql1 = 
						"insert into manager(name,password) values(?,?) ";
				
				Object[] param = new Object[2];//��Object�����д���3������
				param[0] = input_name;
				param[1] = input_password;
				//�ж��Ƿ��û����Ѿ�����
				
				try {
					if(updateExecute(sql1, param)==1)//ִ�������û���sql���
						System.out.println("ע��ɹ�");
					//CloseAll(conn, ps,null);//�ر����ݿ����ӣ��ͷ���Դ
				} catch (Exception e) {
					// TODO: handle exception
					
					e.printStackTrace();
				}		
	}

	//@author ����
	@Override
	public void Log() {
		// �ֹ�����1(����)
		int i=0;//�ж��Ƿ��˳�
		System.out.println("��ӭ���٣�����е�¼:"); 
		System.out.println("�����û���:");
		log_name=input.next();
		System.out.print("��������:\n");
		log_password=input.next();
		boolean passwordRight = false;//������������Ƿ���ȷ
		 
		Manager mas=new Manager();
		mas.setMgr_name(log_name);
		mas.setMgr_pwd(log_password);
		  
		Getconnection();
		String sql = "select password,manager_id from manager where name= '"+log_name+"'";
		PreparedStatement ps1 =null;
		ResultSet rs1 = null;


		  try {
				ps1 = conn.prepareStatement(sql);//����prepearedStatement ����				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 	
		  try {
			rs1 = ps1.executeQuery();//��ѯ�����
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
		
		 
		 try {
			while(rs1.next()){
				 if(rs1.getString("password").equals(log_password)){
					 System.out.println("��¼�ɹ�");
					 passwordRight = true;
					 islogin = true;
					 flagId=rs1.getInt("manager_id");
					 Odpwd=log_password;
					// System.out.println(flagId);			 
				 } 
				 if(passwordRight){
					 break;
				 }
			  }
			if(!passwordRight){
				System.out.println("��¼ʧ�ܣ��û������������,����0���µ�¼������1�˳�");
				i=input.nextInt();
				if(i!=1)
				{
				Log();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//@author ����
	@Override
	public void ChangePassword() {
		// �ֹ�����1(����)
		 int i=0;// ����ѭ������
		 if(islogin)
		 {
			 System.out.println("������ԭ���룺");
			 String Opwd=input.next();
			 Getconnection();
			 String sql1 = "select password from manager where manager_id = '"+flagId+"'";
			 PreparedStatement ps1 =null;
			  ResultSet rs1 = null;
			  try {
					ps1 = conn.prepareStatement(sql1);//����prepearedStatement ����				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 	
			  try {
				rs1 = ps1.executeQuery();//��ѯ�����
			  } catch (SQLException e) {
				e.printStackTrace();
			  }
			  try {
				  rs1.next();
					while(i!=1){
						 if(rs1.getString("password").equals(Opwd)){
							 System.out.println("�����������룺");
							 String Npwd=input.next();
							 System.out.println("���ٴ����������룺");
							 String Nwpwd=input.next();
							 if(Npwd.equals(Nwpwd))
							 {
								// Getconnection();
								 String sql2="update manager set password=? where manager_id = '"+flagId+"'";
								 Object[] param1 = new Object[1];
									param1[0] = Npwd; 
									if( updateExecute(sql2,param1)==1)
									{
										System.out.println("�޸ĳɹ���");
										i=1;
									}
									else
									{
										System.out.println("�޸�ʧ�ܣ�");
										i=1;
									}
						     } 
							 else
							 {
								 System.out.println("�������벻һ�£�");
							 }
					  }
						 else{
						System.out.println("ԭ����������������룡");
						Opwd=input.next();
					         }
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			  
		 }
		 else{
			 System.out.println("���ȵ�¼��");
		 }
	}

	//@author ����͢
	@Override
	public void AssetLend() {
		// �ֹ�����4(����͢)
		//Ҫ�������ű��ʲ����õǼǱ���ʲ���Ϣ�����(���ú�Ҫ�޸�ʹ���ߺ�״̬)
		if(!islogin){
			//�������Աû�е�¼,����ʾ�ȵ�¼
			System.out.println("����û�е�¼,���ȵ�¼");
		}
		else{
			System.out.println("�ʲ����ý���---->");
			System.out.println("������Ҫ�����豸����Ա����");
			//�ж�:�����Ƿ�Ϸ�(��д)
			String borrow_name  = input.next();
			
			//������п������õ��豸
			System.out.println();
			String sql1 = "select * from asset where ast_status='����'";
			List<Asset> asset_nomal = new ArrayList<Asset>();
			asset_nomal = LookUpAsset(sql1);
			System.out.println("��ǰ�����õ��豸��:");
			System.out.println("���--����--����--С��--�ͺ�--��ֵ--��������--״̬--ʹ����--��ע");
			int i=0;
			while(i<asset_nomal.size()){
				System.out.print(asset_nomal.get(i).getAst_id()+"--");
				System.out.print(asset_nomal.get(i).getAst_name()+"--");
				System.out.print(asset_nomal.get(i).getAst_category1()+"--");
				System.out.print(asset_nomal.get(i).getAst_category2()+"--");
				System.out.print(asset_nomal.get(i).getAst_type()+"--");
				System.out.print(asset_nomal.get(i).getAst_value()+"--");
				System.out.print(asset_nomal.get(i).getAst_boughtDay()+"--");
				System.out.print(asset_nomal.get(i).getAst_status()+"--");
				System.out.print(asset_nomal.get(i).getAst_user()+"--");
				System.out.println(asset_nomal.get(i).getAst_remark()+"--");
				i++;
			
			}
			
			Object[] param = new Object[3];
			System.out.println("������Ҫ���õ��豸�ı��");
			int lend_id = input.nextInt();
			param[0] = lend_id;
			System.out.println("�������豸��;");
			param[1] = input.next();
			System.out.println("�����뱸ע");
			param[2] = input.next();
			
			//�޸��ʲ���Ϣ�����Ŀ:status /ast_user
			String sql2 = "update asset set ast_status='�ѽ��',ast_user='"+borrow_name+"' where ast_id = '"+lend_id+"'";
			PreparedStatement ps1 = null;
			try {
				ps1 = conn.prepareStatement(sql2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(1==ps1.executeUpdate()){
					System.out.println("�ʲ���Ϣ�����Ŀ�ѳɹ��޸�");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			String sql3 = "select ast_name from asset where ast_id='"+lend_id+"'";//Ϊ�˻�ȡ�������豸������
			String device_name=new String();
			try {
				ps = conn.prepareStatement(sql3);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				rs = ps.executeQuery();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				if(rs.next()){
					device_name = rs.getString("ast_name");//��ȡ�������豸������
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			//��ȡ������Ա�� id
			int id=0;
			String sql4 = "select manager_id from manager where name='"+log_name+"'";
			try {
				ps = conn.prepareStatement(sql4);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				rs = ps.executeQuery();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				if(rs.next()){
					id = rs.getInt("manager_id");//
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			//���ʲ����õǼǱ������Ŀ:asset_id /asset_name/ lend_day/ purpose/manager_id/manager_name/remark
			
			String sql5 =
					"insert into lendlist (asset_id,asset_name,lend_day,_user,purpose,manager_id,manager_name,remark) values(?,'"+device_name+"',GetDate(),'"+borrow_name+"',?,'"+id+"','"+log_name+"',?)";
			if(1==updateExecute(sql5,param)){
				System.out.println("�ʲ����óɹ�");
			}
		}
		
	}

	//@author ����͢
	@Override
	public void AssetReturn() {
		// �ֹ�����5(����͢)
		//ʵ�ֶ��ʲ��黹�ǼǱ���޸Ĺ���
		if(!islogin){
			System.out.println("����û�е�¼,���ȵ�¼");
		}
		else{
			System.out.println("�ʲ��黹����---->");
			System.out.println("������Ҫ�黹�豸����Ա����");
			String return_name  = input.next();
			
			//�����豸ʹ����Ա������,��ȡ�������豸�����ֺ�id
			String sql1 = "select ast_id,ast_name from asset where ast_user='"+return_name+"'";
			int device_id = 0;
			String device_name=new String();
			try {
				ps = conn.prepareStatement(sql1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				rs = ps.executeQuery();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				if(rs.next()){
					device_id = rs.getInt("ast_id");
					device_name = rs.getString("ast_name");//��ȡ�������豸������
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			//�޸��ʲ���Ϣ�����Ŀ:ast_user /ast_status
			String sql2 = "update asset set ast_status='����',ast_user=null where ast_user = '"+return_name+"'";
			ps = null;
			try {
				ps = conn.prepareStatement(sql2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(1==ps.executeUpdate()){
					System.out.println("�ʲ���Ϣ�����Ŀ�ѳɹ��޸�");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//��ȡ������Ա�� id
			int id=0;
			String sql4 = "select manager_id from manager where name='"+log_name+"'";
			try {
				ps = conn.prepareStatement(sql4);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				rs = ps.executeQuery();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				if(rs.next()){
					id = rs.getInt("manager_id");//
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			//���ʲ��黹�ǼǱ������Ŀ:asset_id / asset_name/return_day/manager_id/manager_name/remark
			ps = null;
			String sql3 =
					"insert into returnlist (asset_id,asset_name,return_day,_user,manager_id,manager_name) values('"+device_id+"','"+device_name+"',GetDate(),'"+return_name+"','"+id+"','"+log_name+"')";
			try {
				ps = conn.prepareStatement(sql3);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(1==ps.executeUpdate()){
					System.out.println("�ʲ��ɹ��黹");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
