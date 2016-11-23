package asset_management;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * AssetDaoImpl�̳������ݿ⹤�����AssetDao�ӿ�
 * Ŀ��:��AssetDao ����ķ�����д
 * ��ɹ����ʲ�������ɾ�������ʲ���Ϣ����ɾ�ĵȲ���
 * @author ����Ǭ  �ں��
 *
 */
public class AssetDaoImpl extends BaseDao implements AssetDao{
	Scanner input = new Scanner(System.in);//�����涨��һ��scanner ,��ʡȥ�ڸ��ַ����������ظ�����scanner
	
	//@author ����Ǭ
	public void Categoryadd() {
		//ʵ�������ʲ����ķ���
		System.out.println("������Ҫ�������id");
		int id=input.nextInt();
		String sql = "select ast_category1,ast_category2 from asset where ast_id='"+id+"'";
		//sql����ѯ����Ӧ�ļ�¼��Ϣ
		Getconnection();		//�������ݿ����ӣ�������BaseDao��ʵ��
		try {
			ps = conn.prepareStatement(sql);     //����Preparement����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = ps.executeQuery(sql);           //ִ�в�ѯ���
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next())		//��ȡ��¼ֱ����
			{
				try {
						if(rs.getString("ast_category1")==null||rs.getString("ast_category2")==null)
						{ 
								System.out.println("�����Ӵ�/С��,�������Ӵ�   / С��,����: 1 / 2");
								int function=input.nextInt();
								switch(function)
								{				//����ѡ��
									case 1:
										if(rs.getString("ast_category1")==null)
										{
											System.out.println("����Ҫ���ӵĴ���:");
											String sql1 = "update asset set ast_category1=? where ast_id = '"+id+"'";
											try {
												ps = conn.prepareStatement(sql1);
												System.out.println("��������ӵ����:");
												ps.setObject(1, input.next());
											} catch (SQLException e) {
												e.printStackTrace();
											}
											try {
												if(1==ps.executeUpdate()){
													System.out.println("���Ӵ���ɹ�!");
												}
												else
													System.out.println("����ʧ��!");
											} catch (SQLException e) {
												e.printStackTrace();
											}
										}
										else
											System.out.println("����ʧ��!��������");
										break;
									case 2:
										if(rs.getString("ast_category2")==null)
										{
											System.out.println("����Ҫ���ӵ�С��:");
											String sql2 = "update asset set ast_category2=? where ast_id = '"+id+"'";
											try {
												ps = conn.prepareStatement(sql2);
												System.out.println("��������ӵ����:");
												ps.setObject(1, input.next());
											} catch (SQLException e) {
												e.printStackTrace();
											}
											try {
												if(1==ps.executeUpdate()){
													System.out.println("����С��ɹ�!");
												}
												else
													System.out.println("����ʧ��!");
											} catch (SQLException e) {
												e.printStackTrace();
											}
										}
										else
											System.out.println("����ʧ��!��������");
										break;
								}
						}
						else
								System.out.println("�޷����Ӵ�/С��,������");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//@author ����Ǭ
	public void Categorydel() {
		//ʵ��ɾ���ʲ����ķ���
		System.out.println("������Ҫɾ������id");
		int id=input.nextInt();
		String sql = "select ast_category1,ast_category2 from asset where ast_id='"+id+"'";
		//Ѱ�Ҽ�¼��Ϣ
		Getconnection();		//��������
		try {
			ps = conn.prepareStatement(sql);     //����Preparement����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = ps.executeQuery(sql);           //ִ�в�ѯ���
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				try {
					if(rs.getString("ast_category1")!=null||rs.getString("ast_category2")!=null)
					{
							int function=input.nextInt();
							System.out.println("��ɾ����/С��,����ɾ���� / С��,����: 1 / 2");
							switch(function)
							{
								case 1:
									if(rs.getString("ast_category1")!=null)
									{
										String sql1 = "update asset set ast_category1=null where ast_id = '"+id+"'";
										try {
											ps = conn.prepareStatement(sql1);
										} catch (SQLException e) {
											e.printStackTrace();
										}
										try {
											if(1==ps.executeUpdate()){
												System.out.println("ɾ������ɹ�!");
											}
											else
												System.out.println("ɾ��ʧ��!");
										} catch (SQLException e) {
											e.printStackTrace();
										}
									}
									else
										System.out.println("ɾ��ʧ��!����Ϊ��");
									break;
								case 2:
									if(rs.getString("ast_category2")!=null)
									{
										String sql2 = "update asset set ast_category2=null where ast_id = '"+id+"'";
										try {
											ps = conn.prepareStatement(sql2);
										} catch (SQLException e) {
											e.printStackTrace();
										}
										try {
											if(1==ps.executeUpdate()){
												System.out.println("ɾ��С��ɹ�!");
											}
											else
												System.out.println("ɾ��ʧ��!");
										} catch (SQLException e) {
											e.printStackTrace();
										}
									}
									else
										System.out.println("ɾ��ʧ��!С��Ϊ��");
									break;
							}
					}
					else
							System.out.println("�޷�ɾ����/С��,��ȫΪ��");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//@author ����Ǭ
	public void Add(Asset ass) {
		//ʵ�������ʲ���Ϣ�ķ���
		System.out.println("�����ʲ���ţ�");
		ass.setAst_id(input.nextInt());
		System.out.println("�����ʲ����ƣ�");
		ass.setAst_name(input.next());
		System.out.println("�����ʲ������");
		ass.setAst_category1(input.next());
		System.out.println("�����ʲ�С���");
		ass.setAst_category2(input.next());
		System.out.println("�����ʲ��ͺ�:");
		ass.setAst_type(input.next());
		System.out.println("�����ʲ���ֵ��");
		ass.setAst_value(input.next());
		System.out.println("�����ʲ���������:yyyy-mm-dd��ʽ");
		ass.setAst_boughtDay(input.next());
		System.out.println("�����ʲ�״̬��");
		ass.setAst_status(input.next());
		System.out.println("�����ʲ���ע��");
		ass.setAst_remark(input.next());
		
		Getconnection();
		String sql = "insert into Asset(ast_id,ast_name,ast_category1,ast_category2,ast_type,ast_value,ast_boughtDay,ast_status,ast_remark) " +
				"values('"+ass.getAst_id()+"','"+ass.getAst_name()+"','"+ass.getAst_category1()+"','"+ass.getAst_category2()+"','"+ass.getAst_type()+"','"+ass.getAst_value()+"','"+ass.getAst_boughtDay()+"','"+ass.getAst_status()+"','"+ass.getAst_remark()+"')";
		//sql��䣬�����ݿ����һ����¼��Ϣ
		try {
			ps = conn.prepareStatement(sql);		//����prepareStatement����
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(1==ps.executeUpdate()){
				System.out.println("������ɹ�");
			}
			else
				System.out.println("���ʧ��");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,null);		//�ر����ݿ�����
	}

	//@author ����Ǭ
	public void Del(Asset ass){
		//ʵ��ɾ���ʲ��ķ���
		System.out.println("�����ʲ���Ż��ʲ�����ɾ���̶��ʲ�    ");
		System.out.println("��ѡ��1.���ݱ��ɾ�� / 2.��������ɾ��");
			Getconnection();		//��������
			int function=input.nextInt();
			switch(function)
			{
				case 1:
					System.out.println("�����ʲ����ɾ����������Ҫɾ���ʲ��ı��:");
					String sql = "delete from Asset where ast_id = '"+input.nextInt()+"'";
					try {
						ps = conn.prepareStatement(sql);	//����prepareStatement����
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if(1==ps.executeUpdate()){
							System.out.println("ɾ���ɹ�!");
						}
						else
							System.out.println("ɾ��ʧ��!�����ڴ���Ϣ!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("�����ʲ�����ɾ����������Ҫɾ���ʲ�������:");
					String sql2 = "delete from Asset where ast_name = '"+input.next()+"'";
					try {
						ps = conn.prepareStatement(sql2);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if(1==ps.executeUpdate()){
							System.out.println("ɾ���ɹ�!");
						}
						else
							System.out.println("ɾ��ʧ��!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("��������");
			}
			CloseAll(conn,ps,null);
	}
	
	//@author ����Ǭ
	public void Revise(Asset ass){
		//ʵ���޸��ʲ���Ϣ�ķ���
		 System.out.println("��������Ҫ�޸��ʲ���id");
		 int id = input.nextInt();
		 Object[] Param = new Object[9];		//����10������������,������ʱ�洢��¼
		 
		 System.out.println("����������Ҫ�޸ĵ�ֵ��");
		 System.out.println("�ʲ����");
		 ass.setAst_id(input.nextInt());
		 System.out.println("�ʲ�����");
		 ass.setAst_name(input.next());
		 System.out.println("�ʲ������");
		 ass.setAst_category1(input.next());
		 System.out.println("�ʲ�С���");
		 ass.setAst_category2(input.next());
		 System.out.println("�ʲ��ͺ�");
		 ass.setAst_type(input.next());
		 System.out.println("�ʲ���ֵ");
		 ass.setAst_value(input.next());
		 System.out.println("�ʲ���������,�밴�ո�ʽxxxx-xx-xx");
		 ass.setAst_boughtDay(input.next());
		 System.out.println("�ʲ�״̬");
		 ass.setAst_status(input.next());
		 System.out.println("�ʲ���ע");
		 ass.setAst_remark(input.next());
		 Param[0] = ass.getAst_id();		//��ʱ�洢��¼��Ϣ
		 Param[1] = ass.getAst_name();
		 Param[2] = ass.getAst_category1();
		 Param[3] = ass.getAst_category2();
		 Param[4] = ass.getAst_type();
		 Param[5] = ass.getAst_value();
		 Param[6] = ass.getAst_boughtDay();
		 Param[7] = ass.getAst_status();
		 Param[8] = ass.getAst_remark();
		 Getconnection();
		 
		 String sql = "update asset set ast_id=?,ast_name=?,ast_category1=?,ast_category2=?,ast_type=?,ast_value=?,ast_boughtDay=?,ast_status=?,ast_remark=? where ast_id = '"+id+"'";
		 //sql��䣬�������ݿ���Ϣ������?Ϊռλ��
		 if(1==updateExecute(sql,Param)){		//����¼���������ݿ�
			 System.out.println("�޸ĳɹ�");		 
		 }
		 else{
			 System.out.println("�޸�ʧ��");
		 }
		
		}

	//@author �ں��
	@Override//��ѯ�ʲ���Ϣ������id��ѯ
	public void FindById() {
		// �ֹ�����6(�ں��)	
		System.out.println("��������Ҫ���ҵ��ʲ���id");
		int id = input.nextInt();
		String sql = "select * from asset where ast_id = '"+id+"'";
		List<Asset> asset1 =new ArrayList<Asset>();
		asset1 = LookUpAsset(sql);
		if(asset1.size()>0){
			int i=0;
			System.out.println("���--����-----����----С��------�ͺ�---��ֵ--��������---״̬-----ʹ����---��ע--");
			while(i<asset1.size()){
				System.out.print(asset1.get(i).getAst_id()+"--");
				System.out.print(asset1.get(i).getAst_name()+"--");
				System.out.print(asset1.get(i).getAst_category1()+"--");
				System.out.print(asset1.get(i).getAst_category2()+"--");
				System.out.print(asset1.get(i).getAst_type()+"--");
				System.out.print(asset1.get(i).getAst_value()+"--");
				System.out.print(asset1.get(i).getAst_boughtDay()+"--");
				System.out.print(asset1.get(i).getAst_status()+"--");
				System.out.print(asset1.get(i).getAst_user()+"--");
				System.out.println(asset1.get(i).getAst_remark()+"--");
				i++;
			
			}
		}
		else{
			System.out.println("��Ҫ���ҵ��ʲ�������");
		}
		
	}

	//@author �ں��
	@Override//��ѯ�ʲ���Ϣ�����ݴ����С������ѯ
	public void FindByCatgy() {
		// �ֹ�����6(�ں��)
		System.out.println("��������Ҫ�����ʲ��Ĵ������С����");
		String ast_catgry = input.next();
		String sql = "select * from asset where (ast_category1 = '"+ast_catgry+"' or ast_category2 = '"+ast_catgry+"' )";
		List<Asset> asset1 =new ArrayList<Asset>();
		asset1 = LookUpAsset(sql);
		if(asset1.size()>0){
			int i=0;
			System.out.println("���--����-----����----С��------�ͺ�---��ֵ--��������---״̬-----ʹ����---��ע--");
			while(i<asset1.size()){
				System.out.print(asset1.get(i).getAst_id()+"--");
				System.out.print(asset1.get(i).getAst_name()+"--");
				System.out.print(asset1.get(i).getAst_category1()+"--");
				System.out.print(asset1.get(i).getAst_category2()+"--");
				System.out.print(asset1.get(i).getAst_type()+"--");
				System.out.print(asset1.get(i).getAst_value()+"--");
				System.out.print(asset1.get(i).getAst_boughtDay()+"--");
				System.out.print(asset1.get(i).getAst_status()+"--");
				System.out.print(asset1.get(i).getAst_user()+"--");
				System.out.println(asset1.get(i).getAst_remark()+"--");
				i++;
			}
		}
		else{
			System.out.println("��Ҫ��ѯ���ʲ���𲻴���");
		}
	}

	//@author �ں��
	@Override//��ѯ�ʲ���Ϣ������ʹ���߲�ѯ
	//���һ����Ա�����˶���ʲ��������Щ�������õ��ʲ�ȫ����ӡ����
	public void FindByUser() {
		// �ֹ�����6(�ں��)	
		System.out.println("��������Ҫ�����ʲ���ʹ����");
		String ast_user = input.next();
		String sql = "select * from asset where ast_user = '"+ast_user+"'";
		List<Asset> asset1 =new ArrayList<Asset>();
		asset1 = LookUpAsset(sql);
		if(asset1.size()>0){
			int i=0;
			System.out.println("���--����-----����----С��------�ͺ�---��ֵ--��������---״̬-----ʹ����---��ע--");
			while(i<asset1.size()){
				System.out.print(asset1.get(i).getAst_id()+"--");
				System.out.print(asset1.get(i).getAst_name()+"--");
				System.out.print(asset1.get(i).getAst_category1()+"--");
				System.out.print(asset1.get(i).getAst_category2()+"--");
				System.out.print(asset1.get(i).getAst_type()+"--");
				System.out.print(asset1.get(i).getAst_value()+"--");
				System.out.print(asset1.get(i).getAst_boughtDay()+"--");
				System.out.print(asset1.get(i).getAst_status()+"--");
				System.out.print(asset1.get(i).getAst_user()+"--");
				System.out.println(asset1.get(i).getAst_remark()+"--");
				i++;
			}
		}
		else{
			System.out.println("��ְ��û�������κ��ʲ�");
		}
	}

	//@author �ں��
	@Override//���ʲ��������ʲ���Ϣ�����ֳ��������ܹ���ʾ�����С��������ʲ�������ʲ�״��
	public void Display() {
		// �ֹ�����6(�ں��)	
		System.out.println("������桪����������������������");
		//�������ʲ��Ľ����װ��һ������������
		String sql1 = "select * from asset where ast_id >0";
		List<Asset> asset1 =new ArrayList<Asset>();
		asset1 = LookUpAsset(sql1);
		
		//������String[] catgry1  ����ž���Ĵ�������Щ��String[] catgry2����ž����С������Щ
		String[] catgry1 = new String[5];//�����ⶨ���5������
		int k=0;
		catgry1[k] = asset1.get(0).getAst_category1();
		k++;
		
		int i;
		int j=0;
		String temp = new String();
		int flag1=3 ;//�������catgry1�����Ƿ��Ѿ�����temp�е�ĳ�����࣬����У���flag1=1
		
		for(i=1;i<asset1.size();i++){
			temp = asset1.get(i).getAst_category1();//��ȡasset1(1)����Ĵ��࣬����temp
			for(j=0;j<catgry1.length;j++){
				if(catgry1[j] == temp){
					flag1=1;
					break;
				}
				else if(j==(catgry1.length-1)&&catgry1[j]!=temp){
					flag1= 2;//����ô���û�д洢��catgry1�����flag1 = 2
				}
			}
			
			if(flag1==1){//��ʾ�ô����Ѿ��洢��catgry1��������
				continue;//ɨ����һ��asset����
			}
			else if(2 ==flag1){//��ʾ�ô���û�д洢��catgry1������
				catgry1[k] = temp;
				if(k<4)//��ֹk���5Խ��
				k++;
			}
			else{
				//System.out.println(flag1);
			}
			flag1 = 3;//ɨ����һ��֮���flag��Ϊ������3
		}	
		//��setȥ��**********************
		Set<String> set = new TreeSet<String>();
		for(int t=0;t<catgry1.length;t++){
			if(catgry1[t]!=null)
			set.add(catgry1[t]);
		}
		String[] catgry_1 =  new String[set.size()];
		catgry_1 = (String[])set.toArray(new String[0]);//new String[0]��ʾ�����Ԫ��תΪ�ַ����� ������(��ʱû�㶮)
		/*
		for(int t=0;t<catgry_1.length;t++){
			System.out.println(catgry_1[t]);
		}*/
		//�������ϲ����ҵ����еĴ��ಢ�����Ƿ�������catgry_1 ��
		//**************************************************************************
		
		//*************************************************************************
		//�������ҵ�����С�ಢ����������
		String[] catgry2 = new String[20];//�����ⶨ���10��С��
		int k2=0;
		catgry2[k2] = asset1.get(0).getAst_category2();
		k2++;
		
		int i2;
		int j2=0;
		String temp2 = new String();
		int flag2=3 ;//�������catgry2�����Ƿ��Ѿ�����temp2�е�ĳ��С�࣬����У���flag2=1
		
		for(i2=1;i2<asset1.size();i2++){
			temp2 = asset1.get(i2).getAst_category2();//��ȡasset1(1)�����С�࣬����temp
			for(j2=0;j2<catgry2.length;j2++){
				if(catgry2[j2] == temp2){
					flag2=1;
					break;
				}
				else if(j2==(catgry2.length-1)&&catgry2[j2]!=temp2){
					flag2= 2;//����ô���û�д洢��catgry2�����flag2 = 2
				}
			}
			
			if(flag2==1){//��ʾ�ô����Ѿ��洢��catgry2��������
				continue;//ɨ����һ��asset����
			}
			else if(2 ==flag2){//��ʾ�ô���û�д洢��catgry1������
				catgry2[k2] = temp2;
				//if(k2<=?)//��ֹkԽ��(��ʱû�㶮)
				k2++;
			}
			else{
				//System.out.println(flag2);
			}
			flag2 = 3;//ɨ����һ��֮���flag2��Ϊ������3
		}	
		//��setȥ��**********************
		Set<String> set2 = new TreeSet<String>();
		for(int t=0;t<catgry2.length;t++){
			if(catgry2[t]!=null)
			set2.add(catgry2[t]);
		}
		String[] catgry_2 =  new String[set2.size()];
		catgry_2 = set2.toArray(new String[0]);//new String[0]��ʾ�����Ԫ��תΪ�ַ����� ������(��ʱû�㶮)
		/*
		for(int t=0;t<catgry_2.length;t++){
			System.out.println(catgry_2[t]);
		}*/
		
		//�ٷּ���������Լ����Ӧ��С����ʲ���Ŀ
		for(int m=0;m<catgry_1.length;m++){
			String bigClass = catgry_1[m];
			for(int n=0;n<catgry_2.length;n++){
				String smallClass = catgry_2[n];
				
				String sql0 = "select * from asset where ast_category1 ='"+bigClass+"' and ast_category2 ='"+smallClass+"' ";
				try {
					//ps = conn.prepareStatement(sql0);
					ps = conn.prepareStatement(sql0, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
						System.out.println("���ࣺ"+bigClass+"   С��:"+smallClass );
						rs.previous();
						System.out.println("���--����-----����----С��------�ͺ�---��ֵ--��������---״̬-----ʹ����---��ע--");
						while(rs.next()){
							System.out.println(rs.getString(1)+"--"+rs.getString(2)+"--"+rs.getString(3)+"--"+rs.getString(4)+"--"+
									rs.getString(5)+"--"+rs.getString(6)+"--"+rs.getString(7)+"--"+rs.getString(8)+"--"+
									rs.getString(9)+"--"+rs.getString(10)+"--");
							System.out.println();
						}
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		System.out.println();
	}


}
