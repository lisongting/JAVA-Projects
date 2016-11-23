package PetAdopt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * �����û���ע��Register()  �͵�¼Log()
 * adopt()ʵ�ֳ������������   2016.7.11 ����ʵ�����й���
 * (�ر���Դ�����û�����Ƿ������ж�)
 * @author LST
 *
 */
public class MasterManager extends BaseDao{
	public Master master=null;
	boolean islogin = false;//������ʶ�û��Ƿ��ѵ�¼
	Scanner input =new Scanner(System.in);
	String log_name = new String();
	String log_password = new String();
	public void Register(){
		
		System.out.println("�������û���:");
		String input_name=input.next();
		System.out.println("����������:");
		String input_password=input.next();
		System.out.println("����������");
		String input_money = input.next();
		Getconnection();//�������ݿ�
		
		String sql1 = 
				"insert into master (person_name,password,money) value(?,?,?)";
		
		String[] param = new String[3];//��Object�����д���3������
		param[0] = input_name;
		param[1] = input_password;
		param[2] = input_money;
		if(ExecuteUpdate(sql1, param)==1)//ִ�������û���sql���
			System.out.println("ע��ɹ�");
		CloseAll(conn, ps,null);//�ر����ݿ����ӣ��ͷ���Դ
		
	}
	
	public void Log()
	  {
		  System.out.println("��ӭ���٣�����е�¼:"); 
		  System.out.println("�����û���:");
		  log_name=input.next();
		  System.out.print("��������:\n");
		  log_password=input.next();
		  boolean passwordRight = false;//������������Ƿ���ȷ
		 
		  Master mas=new Master();
		  mas.setName(log_name);
		  mas.setPassword(log_password);
		  
		  Getconnection();
		  String sql = "select password from master where person_name= '"+log_name+"'";
		  try {
				ps = conn.prepareStatement(sql);//����prepearedStatement ����				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 	
		 
			try {
				rs = ps.executeQuery();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//��ѯ�����
		 
		
		  
		  try {
			while(rs.next()){
				 if(rs.getString(1).equals(log_password)){
					 System.out.println("��¼�ɹ�");
					 passwordRight = true;
					 islogin = true;
				 } 
				 if(passwordRight){
					 break;
				 }
			  }
			if(!passwordRight){
				System.out.println("��¼ʧ�ܣ��û������������");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//CloseAll(conn,ps,rs);	 //��¼��ɺ󲻹ر���Դ����Ϊ�û���¼��Ҫ���������ʱ��ȻҪ�������ݿ⴦������״̬
	 }
	
	public void Adopt(){
		if(!islogin){
			System.out.println("�����ȵ�¼");
		}
		else{
			System.out.println("<----������������---->");
			System.out.println("���Ȳ��Һ��ʵĳ���");
			System.out.println("��ѡ�������ҷ�ʽ");
			System.out.println("1.�������־�ȷ����");
			System.out.println("2.��������ģ������");
			System.out.println("3.����Ʒ�ֲ���");
			PetDaoImpl PDI = new PetDaoImpl();
			int s = input.nextInt();
			switch(s){
				case 1:{
					PDI.GetByName();
					break;
				}
				case 2:{
					PDI.FindByName();
					break;
				}
				case 3:{
					PDI.FindByStrain();
					break;
				}
				default:
					System.out.println("�������");
					break;
			}
			Getconnection();
			String sql4 = "select money,pet_id from master where person_name='"+log_name+"'";
			PreparedStatement ps2 = null;
			try {
				ps2 = conn.prepareStatement(sql4);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ResultSet rs2 = null;
			try {
				rs2 = ps2.executeQuery();    //rs2�д�������˵���Ϣ��
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(rs2.next()){
					try {
						if(rs2.getString("pet_id") == null){
							//�������֮ǰû�й�����
							System.out.println("��������Ҫ�����ĳ���id");
							int change = input.nextInt();
							//�޸ı������ĳ����������Ϣ�������������������ڣ�״̬
							String sql1 = "update pet set master_name = ?,adoptTime=now(),status = 'adopted' where pet_id = '"+change+"'";
							Object[] param1 = new Object[1];
							param1[0] = log_name; 
							int a = ExecuteUpdate(sql1,param1);     //��Ǳ�Ӱ�������
							
							
							//�޸���󣬻�ȡ�����cost
							String sql2 = "select cost from pet where pet_id = '"+change+"'";
							PreparedStatement ps1 = null;
							ResultSet rs1 = null;
							String pet_cost = null;
							try {
								 ps1 = conn.prepareStatement(sql2);//
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							try {
								rs1 = ps1.executeQuery();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							try {
								if(rs1.next())
								pet_cost = rs1.getString("cost");
								System.out.println(pet_cost);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							int Int_cost = Integer.parseInt(pet_cost); //��ȡ�������cost
							System.out.println(Int_cost);
							
							
							//�޸������ߵ�������Ϣ������id��ʣ����
							String sql3 = "update master set pet_id=?,money=? where person_name = '"+log_name+"'";
							
				
							String person_money=null;
							try {
								rs2.previous();
								if(rs2.next())
								person_money = rs2.getString("money");
							} catch (SQLException e) {
								e.printStackTrace();
							}
							int Int_money = Integer.parseInt(person_money); //��õ�ǰ���˵Ľ�Ǯ
							int money_left = Int_money-Int_cost;         //ʣ��Ľ�Ǯ
							String str_money =  money_left+"";     //ʣ��Ľ�Ǯ���ַ���
							
							//3
							Object[] param2 = new Object[2]; 
							ExecuteUpdate(sql3,param2);
							param2[0] = change;
							param2[1] = str_money;
							int b= ExecuteUpdate(sql3,param2);
							
							if(a==1&&b==1)
							System.out.println("�����ɹ�");
						}
						else{
							System.out.println("����������Ҫ�����ĳ����id");
							//���޸ı������ĳ����������Ϣ���������֣�״̬������ʱ��
							int change = input.nextInt();
							String sql1 = "update pet set master_name = ?,adoptTime=now(),status = 'adopted' where pet_id = '"+change+"'";
							Object[] param1 = new Object[1];
							param1[0] = log_name; 
							int a = ExecuteUpdate(sql1,param1);     //��Ǳ�Ӱ�������
							
							
							//�޸���󣬻�ȡ�����cost
							String sql2 = "select cost from pet where pet_id = '"+change+"'";
							PreparedStatement ps1 = null;
							ResultSet rs1 = null;
							String pet_cost = null;
							try {
								 ps1 = conn.prepareStatement(sql2);//
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							try {
								rs1 = ps1.executeQuery();
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
							try {
								if(rs1.next())
								pet_cost = rs1.getString("cost");
								System.out.println(pet_cost);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							int Int_cost = Integer.parseInt(pet_cost); //��ȡ�������cost
							System.out.println(Int_cost);
							
							
							//�޸������ߵ�������Ϣ������id��ʣ����
							String sql3 = "update master set pet_id=?,money=? where person_name = '"+log_name+"'";
							String person_money=null;
							try {
								rs2.previous();
								if(rs2.next())
								person_money = rs2.getString("money");
							} catch (SQLException e) {
								e.printStackTrace();
							}
							int Int_money = Integer.parseInt(person_money); //��õ�ǰ���˵Ľ�Ǯ
							int money_left = Int_money-Int_cost;         //ʣ��Ľ�Ǯ
							String str_money =  money_left+"";     //ʣ��Ľ�Ǯ���ַ���
							
							//3
							Object[] param2 = new Object[2]; 
							ExecuteUpdate(sql3,param2);
							param2[0] = change;
							param2[1] = str_money;
							int b= ExecuteUpdate(sql3,param2);
							
							if(a==1&&b==1)
							System.out.println("�����ɹ�");//����������޸ĳɹ�
							
							//�޸ı������ĳ����״̬Ϊadoptable����������Ϊnull
							String str_abandon = null;   //�����������id
							try {
								rs2.previous();//rs2����������Ѿ��еĳ���id����ȡ���id
								if(rs2.next())
								str_abandon = rs2.getString("pet_id");
							} catch (SQLException e) {
								e.printStackTrace();
							}
							int abandon = Integer.parseInt(str_abandon);
							String sql5 = "update pet set master_name = null,status= 'adoptable',adoptTime= null where pet_id = '"+abandon+"'";
							PreparedStatement ps3 = conn.prepareStatement(sql5);
							if(ps3.executeUpdate()==1){
								System.out.println("��������ɹ�");
							}
							//�����Ƿ�����ɹ���
									//�����˵ĳ���id�����˵Ľ�Ǯ�ı仯
									//���������ĳ����״̬���������ֵı仯
									//���������ĳ����״̬�ı仯
							
						}
						
					
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
