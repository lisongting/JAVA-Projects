package PetAdopt;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/**
 * PetDaoImpl继承了数据库工具类和petDao接口，对PetDao 里面的方法覆写
 * 对pet的增删改查
 * @author LST
 *
 */
public class PetDaoImpl extends BaseDao implements PetDao {
	Scanner input = new Scanner(System.in);
	
	
	@Override//增加宠物
	public int Add(Pet pet) {
		System.out.println("请输入宠物名称");
		pet.setName(input.next());
		System.out.println("请输入宠物健康值");
		pet.setHealth(input.nextInt());
		System.out.println("请输入宠物亲密度");
		pet.setLove(input.nextInt());
		System.out.println("请输入宠物品种");
		pet.setStrain(input.next());
		System.out.println("请输入宠物花费");
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
				System.out.println("添加宠物成功");
			}
			else
				System.out.println("添加失败");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
		return 0;
	}

	@Override//删除宠物
	public int Del(Pet pet) {
		System.out.println("请输入宠物ID");
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
				System.out.println("删除宠物成功");
			}
			else
				System.out.println("删除失败");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		CloseAll(conn,ps,null);
		return 0;
	}

	@Override//修改宠物
	public int Update(Pet pet) {
		 System.out.println("请输入宠物ID");
		 int id = input.nextInt();
		 Object[] Param = new Object[5];//保存5个参数的数组
		 
		 System.out.println("请输入以下要修改的值：");
		 System.out.println("宠物名称");
		 pet.setName(input.next());
		 System.out.println("宠物健康值");
		 pet.setHealth(input.nextInt());
		 System.out.println("宠物亲密度");
		 pet.setLove(input.nextInt());
		 System.out.println("宠物品种");
		 pet.setStrain(input.next());
		 System.out.println("宠物领养花费");
		 pet.setCost(input.nextInt());
		 Param[0] = pet.getName();
		 Param[1] = pet.getHealth();
		 Param[2] = pet.getLove();
		 Param[3] = pet.getStrain();
		 Param[4] = pet.getCost();
		 
		 Getconnection();
		 
		 String sql = "update pet set pet_name=?,health=?,love=?,strain=?,cost=? where pet_id = '"+id+"'";
		 if(1==ExecuteUpdate(sql,Param)){
			 System.out.println("修改成功");		 
		 }
		 else{
			 System.out.println("修改失败");
		 }
		 return 0;
	}

	
	@Override//根据名字精确查找
	public void  GetByName() {
		System.out.println("请输入准确的宠物名称");
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
				System.out.println("Id--名称--健康值---亲密度---品种----主人名字----领养时间----状态----领养花费----");
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

					System.out.println("没有找到该宠物");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//关闭资源	
	}

	@Override//根据名字模糊查找  
	public void FindByName() {
		System.out.println("请输入大致的宠物名称");
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
				System.out.println("Id--名称--健康值---亲密度---品种----主人名字----领养时间----状态----领养花费----");
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

					System.out.println("没有找到该宠物");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//关闭资源			

	}

	@Override//根据品种查找
	public void FindByStrain() {
		System.out.println("请输入宠物品种");
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
				System.out.println("Id--名称--健康值---亲密度---品种----主人名字----领养时间----状态----领养花费----");
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

					System.out.println("没有找到该品种的宠物");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,rs);//关闭资源	
	}

}
