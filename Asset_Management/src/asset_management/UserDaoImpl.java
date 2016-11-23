package asset_management;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * UserDaoImpl继承了数据库工具类和UserDao接口
 * 目的:对UserDao 里面的方法覆写
 * @author  闫鸿磊
 *
 */
public class UserDaoImpl extends BaseDao implements UserDao{
	Scanner input =new Scanner(System.in);//在外面定义一个scanner ,就省去在各种方法体里面重复定义scanner
	
	
	// @author  闫鸿磊
	@Override                 //增加人员
	public void Add(User user) {
		// 分工任务3(闫鸿磊)
		System.out.println("请输入以下要增加的项目：");
		System.out.println("人员id编号");
		user.setUsr_id(input.nextInt());           //输入人员编号
		System.out.println("人员姓名");
		user.setUsr_name(input.next());            //输入人员姓名
		System.out.println("人员职务");
		user.setJob(input.next());                 //输入人员职务
		System.out.println("备注");
		user.setRemark(input.next());              //输入备注
		Getconnection();                           //连接数据库
		//sql语句，将以上信息写入数据库
		//user是sqlserver的关键字，在sqlserver不能直接使用
		String sql1 = "insert into [user](user_id,user_name,user_job,user_remark) values('"+user.getUsr_id()+"','"+user.getUsr_name()+"','"+user.getJob()+"','"+user.getRemark()+"')";
		try {
			ps = conn.prepareStatement(sql1);
			//ps = conn.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(1==ps.executeUpdate()){
				System.out.println("添加人员成功！");
			}
			else
				System.out.println("添加人员失败！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
	}

	// @author  闫鸿磊
	@Override                 //删除人员
	public void Del(User user) {
		// 分工任务3(闫鸿磊)
		System.out.println("请输入要删除人员id编号");
		int input_id = input.nextInt();

		Getconnection();                           //连接数据库
		String sql = "delete from [user] where user_id = '"+input_id+"'";
		try {
			//ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(1==ps.executeUpdate()){
				System.out.println("删除人员成功！");
			}
			else
				System.out.println("删除人员失败！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
	}

	// @author  闫鸿磊
	@Override                 //修改人员信息
	public void Update(User user) {
		// 分工任务3(闫鸿磊)
		System.out.println("请输入要修改人员id编号");
		int id = input.nextInt();
		Object[] Param = new Object[3];//保存3个参数的数组
		 
		System.out.println("请输入以下要修改的项目：");
		System.out.println("人员姓名");
		user.setUsr_name(input.next());
		System.out.println("人员职务");
		user.setJob(input.next());
		System.out.println("备注");
		user.setRemark(input.next());
		
		Param[0] = user.getUsr_name();
		Param[1] = user.getJob();
		Param[2] = user.getRemark();
		 
		//Getconnection();
		 
		String sql = "update [user] set user_name=?,user_job=?,user_remark=? where user_id = '"+id+"'";
		if(1==updateExecute(sql,Param)){
			System.out.println("修改成功！");		 
		}
		else{
			System.out.println("修改失败！");
		}
		CloseAll(conn,ps,null);
	}

	// @author  闫鸿磊
	@Override                 //查找人员（按编号）
	public void FindById() {
		// 分工任务3(闫鸿磊)
		System.out.println("请输入要查找的人员id编号");
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
				System.out.println("ID----姓名---职务---备注--");
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

					System.out.println("没有找到该人员信息！");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//关闭资源
	}
	
	// @author  闫鸿磊
	@Override                 //查找人员（按姓名）
	public void FindByName() {
		// 分工任务3(闫鸿磊)
		System.out.println("请输入要查找的人员姓名");
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
				System.out.println("ID----姓名---职务---备注--");
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

					System.out.println("没有找到该人员信息！");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//CloseAll(conn,ps,rs);//关闭资源
	}

	@Override
	public void Display() {
		String sql1 = "select * from [user] where user_id>0";
		List<User> user1 =new ArrayList<User>();
		user1 = LookUpUser(sql1);
		int i=0;
		System.out.println("ID----姓名---职务---备注--");
		while(i<user1.size()){
			System.out.print(user1.get(i).getUsr_id()+"----");
			System.out.print(user1.get(i).getUsr_name()+"----");
			System.out.print(user1.get(i).getJob()+"---");
			System.out.println(user1.get(i).getRemark()+"--");
			i++;
		}
	}
}