package asset_management;

import java.util.Scanner;


/**
 * ѡ��˵�
 * Select()����:��ʾ�˵�,ѡ��ѡ��
 * @author LST
 */
public class Select_menu {
	int function = 0;
	Scanner input = new Scanner(System.in);
	boolean conti = true;//������ʶ�û��Ƿ�Ҫ�˳�
	ManagerDaoImpl M = new ManagerDaoImpl();
	void Select(){
		while(conti){
			System.out.println("����������������������������������������������������������������������������������");
			System.out.println("|	<��ӭʹ����ҵ�̶��ʲ�����ϵͳ>	|");
			System.out.println("|	��ѡ����Ӧ�Ĺ���ѡ�		|");
			System.out.println("|	1. ����Աע��			|");
			System.out.println("|	2. ����Ա��¼			|");
			System.out.println("|	3. ���Ĺ���Ա����		|");
			System.out.println("|	4. ��������ʲ���Ϣ		|");
			System.out.println("|	5. ��ʾ����ְ����Ϣ		|");
			System.out.println("|	6. �����ʲ�			|");
			System.out.println("|	7. ɾ���ʲ�			|");
			System.out.println("|	8. �޸��ʲ���Ϣ			|");
			System.out.println("|	9. ��ѯ�ʲ���Ϣ			|");
			System.out.println("|	10.���ְ����Ϣ			|");
			System.out.println("|	11.ɾ��ְ����Ϣ			| ");
			System.out.println("|	12.�޸�ְ����Ϣ			|");
			System.out.println("|	13.��ѯְ����Ϣ			|");
			System.out.println("|	14.�ʲ�����			|");
			System.out.println("|	15.�ʲ��黹			|");
			System.out.println("|	16.�˳�				|");
			System.out.println("��������������������������������������������������������������������������������");
			System.out.print("��ѡ��");
			function = input.nextInt();
			switch(function){
				case 1:{
					System.out.println("<������������Աע����桪������>");
					M.Register();
					break;
				}
				case 2:{
					System.out.println("<������������Ա��¼���桪������>");
					M.Log();
					break;
				}
				case 3:{
					System.out.println("<���������޸�������桪������>");
					M.ChangePassword();
					break;
				}
				case 4:{
					System.out.println("�����ʲ���Ϣ���£�");
					AssetDaoImpl AD = new AssetDaoImpl();
					AD.Display();
					break;
				}
				case 5:{
					System.out.println("����ְ����Ϣ���£�");
					UserDaoImpl UD = new UserDaoImpl();
					UD.Display();
					break;
				}
				case 6:{
					System.out.println("<�������������ʲ����桪������>");
					AssetDaoImpl AD = new AssetDaoImpl();
					Asset ass = new Asset();
					AD.Add(ass);
					break;
				}
				case 7:{
					System.out.println("<��������ɾ���ʲ����桪������>");
					AssetDaoImpl AD = new AssetDaoImpl();
					Asset ass = new Asset();
					AD.Del(ass);				
					break;
				}
				case 8:{
					System.out.println("<���������޸��ʲ����桪������>");
					AssetDaoImpl AD = new AssetDaoImpl();
					Asset ass = new Asset();
					AD.Revise(ass);
					break;
				}
				case 9:{
					System.out.println("�������ѯ��ʽ��");
					System.out.println("1.���ʲ�id��ѯ");
					System.out.println("2.���ʲ�����ѯ");
					System.out.println("3.���ʲ�ʹ���߲�ѯ");
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
					System.out.println("<�����������ְ�����桪������>");
					UserDaoImpl UD = new UserDaoImpl();
					User user = new User();
					UD.Add(user);
					break;
				}
				case 11:{
					System.out.println("<��������ɾ��ְ�����桪������>");
					UserDaoImpl UD = new UserDaoImpl();
					User user = new User();
					UD.Del(user);
					break;
				}
				case 12:{
					System.out.println("<���������޸�ְ�����桪������>");
					UserDaoImpl UD = new UserDaoImpl();
					User user = new User();
					UD.Update(user);
					break;
				}
				case 13:{
					System.out.println("�������ѯ��ʽ��");
					System.out.println("1.��ְ��id����");
					System.out.println("2.��ְ����������");
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
					System.out.println("<���������ʲ����ý��桪������>");
					M.AssetLend();
					break;
				}
				case 15:{
					System.out.println("<���������ʲ��黹���桪������>");
					M.AssetReturn();
					break;
				}
				case 16:{
					System.out.println("���˳�");
					conti=false;
					break;
				}
				default:
					continue;
			}
		}
	}	
}
