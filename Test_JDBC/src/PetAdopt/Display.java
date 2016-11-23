package PetAdopt;

import java.sql.SQLException;
/**
 * display 函数
 * 功能：显示所有主人信息，显示所有宠物信息
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
			System.out.println("ID----姓名---密码---余额--宠物id--");
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
		CloseAll(conn,ps,rs);//关闭所有打开的资源
	}
	
	public void ShowAllPet(){
		Getconnection();//得到连接
		String sql = "select pet_id,pet_name,health,love,strain,master_name,adoptTime,status,cost from pet where pet_id>0";
		
		//建立preparedStatement 对象
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//得到结果集
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//输入结果
		try {
			System.out.println("Id--名称--健康值---亲密度---品种----主人名字----领养时间----状态----领养花费----");
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
		CloseAll(conn,ps,rs);//关闭资源	
		
		
	}
}
