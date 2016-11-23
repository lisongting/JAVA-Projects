package asset_management;

import java.util.Scanner;


/**
 * 选择菜单
 * Select()功能:显示菜单,选择选项
 * @author LST
 */
public class Select_menu {
	int function = 0;
	Scanner input = new Scanner(System.in);
	boolean conti = true;//用来标识用户是否要退出
	ManagerDaoImpl M = new ManagerDaoImpl();
	void Select(){
		while(conti){
			System.out.println("—————————————————————————————————————————");
			System.out.println("|	<欢迎使用企业固定资产管理系统>	|");
			System.out.println("|	请选择相应的功能选项：		|");
			System.out.println("|	1. 管理员注册			|");
			System.out.println("|	2. 管理员登录			|");
			System.out.println("|	3. 更改管理员密码		|");
			System.out.println("|	4. 浏览所有资产信息		|");
			System.out.println("|	5. 显示所有职工信息		|");
			System.out.println("|	6. 增加资产			|");
			System.out.println("|	7. 删除资产			|");
			System.out.println("|	8. 修改资产信息			|");
			System.out.println("|	9. 查询资产信息			|");
			System.out.println("|	10.添加职工信息			|");
			System.out.println("|	11.删除职工信息			| ");
			System.out.println("|	12.修改职工信息			|");
			System.out.println("|	13.查询职工信息			|");
			System.out.println("|	14.资产领用			|");
			System.out.println("|	15.资产归还			|");
			System.out.println("|	16.退出				|");
			System.out.println("————————————————————————————————————————");
			System.out.print("请选择：");
			function = input.nextInt();
			switch(function){
				case 1:{
					System.out.println("<————管理员注册界面————>");
					M.Register();
					break;
				}
				case 2:{
					System.out.println("<————管理员登录界面————>");
					M.Log();
					break;
				}
				case 3:{
					System.out.println("<————修改密码界面————>");
					M.ChangePassword();
					break;
				}
				case 4:{
					System.out.println("所有资产信息如下：");
					AssetDaoImpl AD = new AssetDaoImpl();
					AD.Display();
					break;
				}
				case 5:{
					System.out.println("所有职工信息如下：");
					UserDaoImpl UD = new UserDaoImpl();
					UD.Display();
					break;
				}
				case 6:{
					System.out.println("<————增加资产界面————>");
					AssetDaoImpl AD = new AssetDaoImpl();
					Asset ass = new Asset();
					AD.Add(ass);
					break;
				}
				case 7:{
					System.out.println("<————删除资产界面————>");
					AssetDaoImpl AD = new AssetDaoImpl();
					Asset ass = new Asset();
					AD.Del(ass);				
					break;
				}
				case 8:{
					System.out.println("<————修改资产界面————>");
					AssetDaoImpl AD = new AssetDaoImpl();
					Asset ass = new Asset();
					AD.Revise(ass);
					break;
				}
				case 9:{
					System.out.println("请输入查询方式：");
					System.out.println("1.按资产id查询");
					System.out.println("2.按资产类别查询");
					System.out.println("3.按资产使用者查询");
					AssetDaoImpl AD = new AssetDaoImpl();
					int choice = input.nextInt();
					switch(choice){
					case 1:
						AD.FindById();
						break;
					case 2:
						AD.FindByCatgy();
						break;
					case 3:
						AD.FindByUser();
						break;
						
					default:
						continue;
					} 
					break;
				}
				case 10:{
					System.out.println("<————添加职工界面————>");
					UserDaoImpl UD = new UserDaoImpl();
					User user = new User();
					UD.Add(user);
					break;
				}
				case 11:{
					System.out.println("<————删除职工界面————>");
					UserDaoImpl UD = new UserDaoImpl();
					User user = new User();
					UD.Del(user);
					break;
				}
				case 12:{
					System.out.println("<————修改职工界面————>");
					UserDaoImpl UD = new UserDaoImpl();
					User user = new User();
					UD.Update(user);
					break;
				}
				case 13:{
					System.out.println("请输入查询方式：");
					System.out.println("1.按职工id查找");
					System.out.println("2.按职工姓名查找");
					UserDaoImpl UD = new UserDaoImpl();
					int choice = input.nextInt();
					switch(choice){
					case 1:
						UD.FindById();
						break;
					case 2:
						UD.FindByName();
						break;
					default:
						continue;
					} 
					break;
				}
				case 14:{
					System.out.println("<————资产领用界面————>");
					M.AssetLend();
					break;
				}
				case 15:{
					System.out.println("<————资产归还界面————>");
					M.AssetReturn();
					break;
				}
				case 16:{
					System.out.println("已退出");
					conti=false;
					break;
				}
				default:
					continue;
			}
		}
	}	
}
