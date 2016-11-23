package Database_3function;

import java.util.Scanner;
/**
 * 选择功能的类
 * @author LST
 *2016.7.7
 */
public class SelectFun {
	int fun ;
	boolean contin = true;//用来标记是否继续运行菜单
	Scanner input = new Scanner(System.in);
	 void Select(){
		 while(contin)
			{
				System.out.println("欢迎使用该数据库系统");
				System.out.println("请选择正确的功能选项：");
				System.out.println("1.注册");
				System.out.println("2.登录");
				System.out.println("3.查看所有表项<管理员>");
				System.out.println("4.退出");
				fun = input.nextInt();
					switch(fun){
					case 1:{
						System.out.println("-->注册界面");
						Register R = new Register();
						R.Regi();
						break;
					}
					case 2:{
						System.out.println("-->登录界面");
						Login L = new Login();
						L.Log();
						break;
					}
					case 3:{
						System.out.println("数据库中的表项如下：");
						Display D = new Display();
						D.Show();
						break;
					}
					case 4:{
						System.out.println("已退出");
						contin =false;
						break;
					}	
					
					default:
						continue;
					}
			}
		 
			
	}
}
