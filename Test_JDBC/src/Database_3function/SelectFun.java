package Database_3function;

import java.util.Scanner;
/**
 * ѡ���ܵ���
 * @author LST
 *2016.7.7
 */
public class SelectFun {
	int fun ;
	boolean contin = true;//��������Ƿ�������в˵�
	Scanner input = new Scanner(System.in);
	 void Select(){
		 while(contin)
			{
				System.out.println("��ӭʹ�ø����ݿ�ϵͳ");
				System.out.println("��ѡ����ȷ�Ĺ���ѡ�");
				System.out.println("1.ע��");
				System.out.println("2.��¼");
				System.out.println("3.�鿴���б���<����Ա>");
				System.out.println("4.�˳�");
				fun = input.nextInt();
					switch(fun){
					case 1:{
						System.out.println("-->ע�����");
						Register R = new Register();
						R.Regi();
						break;
					}
					case 2:{
						System.out.println("-->��¼����");
						Login L = new Login();
						L.Log();
						break;
					}
					case 3:{
						System.out.println("���ݿ��еı������£�");
						Display D = new Display();
						D.Show();
						break;
					}
					case 4:{
						System.out.println("���˳�");
						contin =false;
						break;
					}	
					
					default:
						continue;
					}
			}
		 
			
	}
}
