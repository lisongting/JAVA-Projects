package PetAdopt;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * MasterImpl继承了数据库工具类和BaseDao接口，对MastertDao 里面的方法覆写
 * 对主人的增删改查
 * @author LST
 *
 */
public class MasterImpl extends BaseDao implements MasterDao{
	Scanner input = new Scanner(System.in);
	
	@Override	//增加主人
	public void Add() {
		MasterManager M = new MasterManager();
		M.Register();
	}

	
	@Override//删除主人
	public void Del() {
		System.out.println("请输入要删除的用户ID");
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
				System.out.println("删除用户成功");
			}
			else
				System.out.println("删除失败");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
	}

	
	@Override//修改主人信息
	public int Update(Master master) {
		 System.out.println("请输入要修改的用户的ID");
		 int id = input.nextInt();
		 Object[] Param = new Object[3];//保存3个参数的数组
		 
		 System.out.println("请输入以下要修改的值：");
		 System.out.println("用户名称:");
		 master.setName(input.next());
		 System.out.println("用户密码:");
		 master.setPassword(input.next());
		 System.out.println("用户余额:");
		 master.setMoney(input.next());
		 Param[0] = master.getName();
		 Param[1] = master.getPassword();
		 Param[2] = master.getMoney();
		 
		 Getconnection();
		 
		 String sql = "update master set person_name=?,password=?,money=? where person_id = '"+id+"'";
		 if(1==ExecuteUpdate(sql,Param)){
			 System.out.println("修改成功");		 
		 }
		 else{
			 System.out.println("修改失败");
		 }
		 return 0;
	}

	@Override//查找主人信息
	public void FindMasterPrecisely() {
		System.out.println("请输入准确的主人名称");
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
				System.out.println("ID----姓名---密码---余额--宠物id--");
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

					System.out.println("没有找到该主人");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//关闭资源	
	}
	public void FindMasterRoughly() {
		System.out.println("请输入大致的主人名称");
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
				System.out.println("ID----姓名---密码---余额--宠物id--");
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

					System.out.println("没有找到该主人");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//关闭资源			
	}

}
