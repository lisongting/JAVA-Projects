package asset_management;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ManagerDaoImpl继承了数据库工具类和ManagerDao接口
 * 目的:对ManagerDao 里面的方法覆写
 * @author 李泽华  LST
 *
 */
public class ManagerDaoImpl extends BaseDao implements ManagerDao{
	boolean islogin = false;//用来标识管理员是否已登录
	Scanner input =new Scanner(System.in);//在外面定义一个scanner ,就省去在各种方法体里面重复定义scanner
	String log_name = new String();		//存放登录时的管理员name
	String log_password = new String();//存放登录时的管理员密码
	String log_id = new String();//7.15日晚新添加,用来保存管理员的id
	int flagId=0;  //用来寻找需要修改密码的ID
	String Odpwd=null;  //用来标记原密码
	
	//@author 李泽华
	@Override
	public void Register() {
		// 分工任务1(李泽华)
				System.out.println("请输入用户名:");
				String input_name=input.next();
				System.out.println("请输入密码:");
				String input_password=input.next();
				//Getconnection();//连接数据库
				
				//String sql2="insert into manager(name,password) values('"+input_name+"','"+input_password+"') ";
				
				String sql1 = 
						"insert into manager(name,password) values(?,?) ";
				
				Object[] param = new Object[2];//给Object数组中传入3个参数
				param[0] = input_name;
				param[1] = input_password;
				//判断是否用户名已经存在
				
				try {
					if(updateExecute(sql1, param)==1)//执行增加用户的sql语句
						System.out.println("注册成功");
					//CloseAll(conn, ps,null);//关闭数据库连接，释放资源
				} catch (Exception e) {
					// TODO: handle exception
					
					e.printStackTrace();
				}		
	}

	//@author 李泽华
	@Override
	public void Log() {
		// 分工任务1(李泽华)
		int i=0;//判断是否退出
		System.out.println("欢迎光临，请进行登录:"); 
		System.out.println("输入用户名:");
		log_name=input.next();
		System.out.print("输入密码:\n");
		log_password=input.next();
		boolean passwordRight = false;//标记输入密码是否正确
		 
		Manager mas=new Manager();
		mas.setMgr_name(log_name);
		mas.setMgr_pwd(log_password);
		  
		Getconnection();
		String sql = "select password,manager_id from manager where name= '"+log_name+"'";
		PreparedStatement ps1 =null;
		ResultSet rs1 = null;


		  try {
				ps1 = conn.prepareStatement(sql);//建立prepearedStatement 对象				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 	
		  try {
			rs1 = ps1.executeQuery();//查询结果集
		  } catch (SQLException e) {
			e.printStackTrace();
		  }
		
		 
		 try {
			while(rs1.next()){
				 if(rs1.getString("password").equals(log_password)){
					 System.out.println("登录成功");
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
				System.out.println("登录失败，用户名或密码错误,输入0重新登录，输入1退出");
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

	//@author 李泽华
	@Override
	public void ChangePassword() {
		// 分工任务1(李泽华)
		 int i=0;// 输入循环条件
		 if(islogin)
		 {
			 System.out.println("请输入原密码：");
			 String Opwd=input.next();
			 Getconnection();
			 String sql1 = "select password from manager where manager_id = '"+flagId+"'";
			 PreparedStatement ps1 =null;
			  ResultSet rs1 = null;
			  try {
					ps1 = conn.prepareStatement(sql1);//建立prepearedStatement 对象				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 	
			  try {
				rs1 = ps1.executeQuery();//查询结果集
			  } catch (SQLException e) {
				e.printStackTrace();
			  }
			  try {
				  rs1.next();
					while(i!=1){
						 if(rs1.getString("password").equals(Opwd)){
							 System.out.println("请输入新密码：");
							 String Npwd=input.next();
							 System.out.println("请再次输入新密码：");
							 String Nwpwd=input.next();
							 if(Npwd.equals(Nwpwd))
							 {
								// Getconnection();
								 String sql2="update manager set password=? where manager_id = '"+flagId+"'";
								 Object[] param1 = new Object[1];
									param1[0] = Npwd; 
									if( updateExecute(sql2,param1)==1)
									{
										System.out.println("修改成功！");
										i=1;
									}
									else
									{
										System.out.println("修改失败！");
										i=1;
									}
						     } 
							 else
							 {
								 System.out.println("两次输入不一致！");
							 }
					  }
						 else{
						System.out.println("原密码错误！请重新输入！");
						Opwd=input.next();
					         }
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			  
		 }
		 else{
			 System.out.println("请先登录！");
		 }
	}

	//@author 李松廷
	@Override
	public void AssetLend() {
		// 分工任务4(李松廷)
		//要操作两张表，资产领用登记表和资产信息管理表(领用后要修改使用者和状态)
		if(!islogin){
			//如果管理员没有登录,则提示先登录
			System.out.println("您还没有登录,请先登录");
		}
		else{
			System.out.println("资产领用界面---->");
			System.out.println("请输入要领用设备的人员姓名");
			//判断:输入是否合法(待写)
			String borrow_name  = input.next();
			
			//输出所有可以领用的设备
			System.out.println();
			String sql1 = "select * from asset where ast_status='正常'";
			List<Asset> asset_nomal = new ArrayList<Asset>();
			asset_nomal = LookUpAsset(sql1);
			System.out.println("当前可领用的设备有:");
			System.out.println("编号--名称--大类--小类--型号--价值--购买日期--状态--使用者--备注");
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
			System.out.println("请输入要领用的设备的编号");
			int lend_id = input.nextInt();
			param[0] = lend_id;
			System.out.println("请输入设备用途");
			param[1] = input.next();
			System.out.println("请输入备注");
			param[2] = input.next();
			
			//修改资产信息表的条目:status /ast_user
			String sql2 = "update asset set ast_status='已借出',ast_user='"+borrow_name+"' where ast_id = '"+lend_id+"'";
			PreparedStatement ps1 = null;
			try {
				ps1 = conn.prepareStatement(sql2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(1==ps1.executeUpdate()){
					System.out.println("资产信息表的条目已成功修改");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			String sql3 = "select ast_name from asset where ast_id='"+lend_id+"'";//为了获取到借用设备的名字
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
					device_name = rs.getString("ast_name");//获取到借用设备的名字
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			//获取到管理员的 id
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
			//向资产领用登记表添加条目:asset_id /asset_name/ lend_day/ purpose/manager_id/manager_name/remark
			
			String sql5 =
					"insert into lendlist (asset_id,asset_name,lend_day,_user,purpose,manager_id,manager_name,remark) values(?,'"+device_name+"',GetDate(),'"+borrow_name+"',?,'"+id+"','"+log_name+"',?)";
			if(1==updateExecute(sql5,param)){
				System.out.println("资产领用成功");
			}
		}
		
	}

	//@author 李松廷
	@Override
	public void AssetReturn() {
		// 分工任务5(李松廷)
		//实现对资产归还登记表的修改功能
		if(!islogin){
			System.out.println("您还没有登录,请先登录");
		}
		else{
			System.out.println("资产归还界面---->");
			System.out.println("请输入要归还设备的人员姓名");
			String return_name  = input.next();
			
			//根据设备使用人员的姓名,获取到借用设备的名字和id
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
					device_name = rs.getString("ast_name");//获取到借用设备的名字
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			//修改资产信息表的条目:ast_user /ast_status
			String sql2 = "update asset set ast_status='正常',ast_user=null where ast_user = '"+return_name+"'";
			ps = null;
			try {
				ps = conn.prepareStatement(sql2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(1==ps.executeUpdate()){
					System.out.println("资产信息表的条目已成功修改");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			//获取到管理员的 id
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
			
			//向资产归还登记表添加条目:asset_id / asset_name/return_day/manager_id/manager_name/remark
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
					System.out.println("资产成功归还");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
