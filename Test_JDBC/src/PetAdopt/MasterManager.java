package PetAdopt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * 管理用户的注册Register()  和登录Log()
 * adopt()实现宠物的领养功能   2016.7.11 基本实现所有功能
 * (关闭资源。。用户金额是否充足的判断)
 * @author LST
 *
 */
public class MasterManager extends BaseDao{
	public Master master=null;
	boolean islogin = false;//用来标识用户是否已登录
	Scanner input =new Scanner(System.in);
	String log_name = new String();
	String log_password = new String();
	public void Register(){
		
		System.out.println("请输入用户名:");
		String input_name=input.next();
		System.out.println("请输入密码:");
		String input_password=input.next();
		System.out.println("请输入存款金额");
		String input_money = input.next();
		Getconnection();//连接数据库
		
		String sql1 = 
				"insert into master (person_name,password,money) value(?,?,?)";
		
		String[] param = new String[3];//给Object数组中传入3个参数
		param[0] = input_name;
		param[1] = input_password;
		param[2] = input_money;
		if(ExecuteUpdate(sql1, param)==1)//执行增加用户的sql语句
			System.out.println("注册成功");
		CloseAll(conn, ps,null);//关闭数据库连接，释放资源
		
	}
	
	public void Log()
	  {
		  System.out.println("欢迎光临，请进行登录:"); 
		  System.out.println("输入用户名:");
		  log_name=input.next();
		  System.out.print("输入密码:\n");
		  log_password=input.next();
		  boolean passwordRight = false;//标记输入密码是否正确
		 
		  Master mas=new Master();
		  mas.setName(log_name);
		  mas.setPassword(log_password);
		  
		  Getconnection();
		  String sql = "select password from master where person_name= '"+log_name+"'";
		  try {
				ps = conn.prepareStatement(sql);//建立prepearedStatement 对象				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 	
		 
			try {
				rs = ps.executeQuery();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//查询结果集
		 
		
		  
		  try {
			while(rs.next()){
				 if(rs.getString(1).equals(log_password)){
					 System.out.println("登录成功");
					 passwordRight = true;
					 islogin = true;
				 } 
				 if(passwordRight){
					 break;
				 }
			  }
			if(!passwordRight){
				System.out.println("登录失败，用户名或密码错误");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//CloseAll(conn,ps,rs);	 //登录完成后不关闭资源，因为用户登录后还要领养宠物，此时仍然要保持数据库处于连接状态
	 }
	
	public void Adopt(){
		if(!islogin){
			System.out.println("请您先登录");
		}
		else{
			System.out.println("<----宠物领养界面---->");
			System.out.println("请先查找合适的宠物");
			System.out.println("请选择宠物查找方式");
			System.out.println("1.根据名字精确查找");
			System.out.println("2.根据名字模糊查找");
			System.out.println("3.根据品种查找");
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
					System.out.println("输入错误");
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
				rs2 = ps2.executeQuery();    //rs2中存放着主人的信息行
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(rs2.next()){
					try {
						if(rs2.getString("pet_id") == null){
							//如果主人之前没有过宠物
							System.out.println("请输入您要领养的宠物id");
							int change = input.nextInt();
							//修改被领养的宠物的如下信息：主人姓名和领养日期，状态
							String sql1 = "update pet set master_name = ?,adoptTime=now(),status = 'adopted' where pet_id = '"+change+"'";
							Object[] param1 = new Object[1];
							param1[0] = log_name; 
							int a = ExecuteUpdate(sql1,param1);     //标记被影响的行数
							
							
							//修改完后，获取宠物的cost
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
							int Int_cost = Integer.parseInt(pet_cost); //获取到宠物的cost
							System.out.println(Int_cost);
							
							
							//修改领养者的如下信息：宠物id和剩余金额
							String sql3 = "update master set pet_id=?,money=? where person_name = '"+log_name+"'";
							
				
							String person_money=null;
							try {
								rs2.previous();
								if(rs2.next())
								person_money = rs2.getString("money");
							} catch (SQLException e) {
								e.printStackTrace();
							}
							int Int_money = Integer.parseInt(person_money); //获得当前主人的金钱
							int money_left = Int_money-Int_cost;         //剩余的金钱
							String str_money =  money_left+"";     //剩余的金钱的字符串
							
							//3
							Object[] param2 = new Object[2]; 
							ExecuteUpdate(sql3,param2);
							param2[0] = change;
							param2[1] = str_money;
							int b= ExecuteUpdate(sql3,param2);
							
							if(a==1&&b==1)
							System.out.println("领养成功");
						}
						else{
							System.out.println("请输入您想要更换的宠物的id");
							//先修改被领养的宠物的如下信息：主人名字，状态，领养时间
							int change = input.nextInt();
							String sql1 = "update pet set master_name = ?,adoptTime=now(),status = 'adopted' where pet_id = '"+change+"'";
							Object[] param1 = new Object[1];
							param1[0] = log_name; 
							int a = ExecuteUpdate(sql1,param1);     //标记被影响的行数
							
							
							//修改完后，获取宠物的cost
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
							int Int_cost = Integer.parseInt(pet_cost); //获取到宠物的cost
							System.out.println(Int_cost);
							
							
							//修改领养者的如下信息：宠物id和剩余金额
							String sql3 = "update master set pet_id=?,money=? where person_name = '"+log_name+"'";
							String person_money=null;
							try {
								rs2.previous();
								if(rs2.next())
								person_money = rs2.getString("money");
							} catch (SQLException e) {
								e.printStackTrace();
							}
							int Int_money = Integer.parseInt(person_money); //获得当前主人的金钱
							int money_left = Int_money-Int_cost;         //剩余的金钱
							String str_money =  money_left+"";     //剩余的金钱的字符串
							
							//3
							Object[] param2 = new Object[2]; 
							ExecuteUpdate(sql3,param2);
							param2[0] = change;
							param2[1] = str_money;
							int b= ExecuteUpdate(sql3,param2);
							
							if(a==1&&b==1)
							System.out.println("领养成功");//如果两个表都修改成功
							
							//修改被遗弃的宠物的状态为adoptable，主人设置为null
							String str_abandon = null;   //被遗弃宠物的id
							try {
								rs2.previous();//rs2存放着主人已经有的宠物id，获取这个id
								if(rs2.next())
								str_abandon = rs2.getString("pet_id");
							} catch (SQLException e) {
								e.printStackTrace();
							}
							int abandon = Integer.parseInt(str_abandon);
							String sql5 = "update pet set master_name = null,status= 'adoptable',adoptTime= null where pet_id = '"+abandon+"'";
							PreparedStatement ps3 = conn.prepareStatement(sql5);
							if(ps3.executeUpdate()==1){
								System.out.println("宠物更换成功");
							}
							//检验是否更换成功：
									//看主人的宠物id，主人的金钱的变化
									//看被领养的宠物的状态和主人名字的变化
									//看被遗弃的宠物的状态的变化
							
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
