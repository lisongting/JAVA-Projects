package PetAdopt;

import java.util.Scanner;
/**
 * �˵���
 * Select()����:��ʾ�˵�,ѡ��ѡ��
 * @author LST
 *
 */
public class SelectMenu {
	int function = 0;
	Scanner input = new Scanner(System.in);
	boolean conti = true;//������ʶ�û��Ƿ�Ҫ�˳�
	MasterManager M1 = new MasterManager();
	void Select(){
		while(conti){
			System.out.println("����������������������������������������������������������������������������������");
			System.out.println("|	<��ӭʹ�ó������ϵͳ>		|");
			System.out.println("|	��ѡ����Ӧ�Ĺ���ѡ�		|");
			System.out.println("|	1.ע��:				|");
			System.out.println("|	2.��¼				|");
			System.out.println("|	3.���ӳ���			|");
			System.out.println("|	4.����idɾ������			|");
			System.out.println("|	5.����id�޸ĳ���			|");
			System.out.println("|	6.���ҳ���			|");
			System.out.println("|	7.��������			|");
			System.out.println("|	8.��������			|");
			System.out.println("|	9.ɾ������			|");
			System.out.println("|	10.�޸�������Ϣ			| ");
			System.out.println("|	11.����������Ϣ			|");
			System.out.println("|	12.��ʾ���г�����Ϣ		|");
			System.out.println("|	13.��ʾ����������Ϣ		|");
			System.out.println("|	14.�˳�				|");
			System.out.println("��������������������������������������������������������������������������������");
			System.out.print("��ѡ��");
			function = input.nextInt();
			switch(function){
				case 1:{
					System.out.println("<----ע�����---->");
					MasterManager M = new MasterManager();
					M.Register();
					break;
				}
				case 2:{
					System.out.println("<----��¼����---->");
					M1.Log();
					
					break;
				}
				case 3:{
					System.out.println("<----���ӳ������---->");
					PetDaoImpl PDI = new PetDaoImpl();
					Pet pet = new Pet();
					PDI.Add(pet);
					break;
				}
				case 4:{
					System.out.println("<----ɾ���������---->");
					PetDaoImpl PDI = new PetDaoImpl();
					Pet pet = new Pet();
					PDI.Del(pet);
					break;
				}
				case 5:{
					System.out.println("<----�޸ĳ������---->");
					PetDaoImpl PDI = new PetDaoImpl();
					Pet pet = new Pet();
					PDI.Update(pet);
					break;
				}
				case 6:{
					System.out.println("<----���ҳ������---->");
					System.out.println("��ѡ����ҷ�ʽ");
					System.out.println("1.�������־�ȷ����");
					System.out.println("2.��������ģ������");
					System.out.println("3.����Ʒ�ֲ���");
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
							System.out.println("�������");
							break;
					}
					break;
				}
				case 7:{
					M1.Adopt();
					break;
				}
				case 8:{
					System.out.println("<----�����û�����---->");
					MasterImpl M = new MasterImpl();
					M.Add();
					break;
				}
				case 9:{
					System.out.println("<----ɾ���û�����---->");
					MasterImpl M = new MasterImpl();
					M.Del();
					break;
				}
				case 10:{
					System.out.println("<----�޸��û�����---->");
					MasterImpl MDI = new MasterImpl();
					Master master = new Master();
					MDI.Update(master);
					break;
				}
				case 11:{
					System.out.println("<----�����û�����---->");
					System.out.println("��ѡ����ҷ�ʽ");
					System.out.println("1.�������־�ȷ����");
					System.out.println("2.��������ģ������");
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
							System.out.println("�������");
							break;
					}
					break;
				}
				case 12:{
					System.out.println("<--------------->");
					System.out.println("���г������Ϣ���£�");
					Display D = new Display();
					D.ShowAllPet();
					System.out.println();
					break;
				}
				case 13:{
					System.out.println("<--------------->");					
					System.out.println("�������˵���Ϣ���£�");
					Display D = new Display();
					System.out.println();
					D.ShowAllMaster();
					break;
				}
				case 14:{
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
