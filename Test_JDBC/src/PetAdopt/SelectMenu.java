package PetAdopt;

import java.util.Scanner;
/**
 * 菜单类
 * Select()功能:显示菜单,选择选项
 * @author LST
 *
 */
public class SelectMenu {
	int function = 0;
	Scanner input = new Scanner(System.in);
	boolean conti = true;//用来标识用户是否要退出
	MasterManager M1 = new MasterManager();
	void Select(){
		while(conti){
			System.out.println("—————————————————————————————————————————");
			System.out.println("|	<欢迎使用宠物管理系统>		|");
			System.out.println("|	请选择相应的功能选项：		|");
			System.out.println("|	1.注册:				|");
			System.out.println("|	2.登录				|");
			System.out.println("|	3.增加宠物			|");
			System.out.println("|	4.根据id删除宠物			|");
			System.out.println("|	5.根据id修改宠物			|");
			System.out.println("|	6.查找宠物			|");
			System.out.println("|	7.领养宠物			|");
			System.out.println("|	8.增加主人			|");
			System.out.println("|	9.删除主人			|");
			System.out.println("|	10.修改主人信息			| ");
			System.out.println("|	11.查找主人信息			|");
			System.out.println("|	12.显示所有宠物信息		|");
			System.out.println("|	13.显示所有主人信息		|");
			System.out.println("|	14.退出				|");
			System.out.println("————————————————————————————————————————");
			System.out.print("请选择：");
			function = input.nextInt();
			switch(function){
				case 1:{
					System.out.println("<----注册界面---->");
					MasterManager M = new MasterManager();
					M.Register();
					break;
				}
				case 2:{
					System.out.println("<----登录界面---->");
					M1.Log();
					
					break;
				}
				case 3:{
					System.out.println("<----增加宠物界面---->");
					PetDaoImpl PDI = new PetDaoImpl();
					Pet pet = new Pet();
					PDI.Add(pet);
					break;
				}
				case 4:{
					System.out.println("<----删除宠物界面---->");
					PetDaoImpl PDI = new PetDaoImpl();
					Pet pet = new Pet();
					PDI.Del(pet);
					break;
				}
				case 5:{
					System.out.println("<----修改宠物界面---->");
					PetDaoImpl PDI = new PetDaoImpl();
					Pet pet = new Pet();
					PDI.Update(pet);
					break;
				}
				case 6:{
					System.out.println("<----查找宠物界面---->");
					System.out.println("请选择查找方式");
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
					break;
				}
				case 7:{
					M1.Adopt();
					break;
				}
				case 8:{
					System.out.println("<----增加用户界面---->");
					MasterImpl M = new MasterImpl();
					M.Add();
					break;
				}
				case 9:{
					System.out.println("<----删除用户界面---->");
					MasterImpl M = new MasterImpl();
					M.Del();
					break;
				}
				case 10:{
					System.out.println("<----修改用户界面---->");
					MasterImpl MDI = new MasterImpl();
					Master master = new Master();
					MDI.Update(master);
					break;
				}
				case 11:{
					System.out.println("<----查找用户界面---->");
					System.out.println("请选择查找方式");
					System.out.println("1.根据名字精确查找");
					System.out.println("2.根据名字模糊查找");
					MasterImpl MDI = new MasterImpl();
					int s = input.nextInt();
					switch(s){
						case 1:{
							MDI.FindMasterPrecisely();
							break;
						}
						case 2:{
							MDI.FindMasterRoughly();
							break;
						}
						default:
							System.out.println("输入错误");
							break;
					}
					break;
				}
				case 12:{
					System.out.println("<--------------->");
					System.out.println("所有宠物的信息如下：");
					Display D = new Display();
					D.ShowAllPet();
					System.out.println();
					break;
				}
				case 13:{
					System.out.println("<--------------->");					
					System.out.println("所以主人的信息如下：");
					Display D = new Display();
					System.out.println();
					D.ShowAllMaster();
					break;
				}
				case 14:{
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
