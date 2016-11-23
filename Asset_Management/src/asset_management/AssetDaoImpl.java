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
 * AssetDaoImpl继承了数据库工具类和AssetDao接口
 * 目的:对AssetDao 里面的方法覆写
 * 完成关于资产类别的增删操作，资产信息的增删改等操作
 * @author 尤龙乾  于海淼
 *
 */
public class AssetDaoImpl extends BaseDao implements AssetDao{
	Scanner input = new Scanner(System.in);//在外面定义一个scanner ,就省去在各种方法体里面重复定义scanner
	
	//@author 尤龙乾
	public void Categoryadd() {
		//实现增加资产类别的方法
		System.out.println("输入需要添加类别的id");
		int id=input.nextInt();
		String sql = "select ast_category1,ast_category2 from asset where ast_id='"+id+"'";
		//sql语句查询到相应的记录信息
		Getconnection();		//建立数据库联接，功能在BaseDao中实现
		try {
			ps = conn.prepareStatement(sql);     //建立Preparement对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = ps.executeQuery(sql);           //执行查询语句
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next())		//读取记录直到空
			{
				try {
						if(rs.getString("ast_category1")==null||rs.getString("ast_category2")==null)
						{ 
								System.out.println("能增加大/小类,如需增加大   / 小类,输入: 1 / 2");
								int function=input.nextInt();
								switch(function)
								{				//功能选择
									case 1:
										if(rs.getString("ast_category1")==null)
										{
											System.out.println("输入要增加的大类:");
											String sql1 = "update asset set ast_category1=? where ast_id = '"+id+"'";
											try {
												ps = conn.prepareStatement(sql1);
												System.out.println("请输入添加的类别:");
												ps.setObject(1, input.next());
											} catch (SQLException e) {
												e.printStackTrace();
											}
											try {
												if(1==ps.executeUpdate()){
													System.out.println("增加大类成功!");
												}
												else
													System.out.println("增加失败!");
											} catch (SQLException e) {
												e.printStackTrace();
											}
										}
										else
											System.out.println("增加失败!大类已满");
										break;
									case 2:
										if(rs.getString("ast_category2")==null)
										{
											System.out.println("输入要增加的小类:");
											String sql2 = "update asset set ast_category2=? where ast_id = '"+id+"'";
											try {
												ps = conn.prepareStatement(sql2);
												System.out.println("请输入添加的类别:");
												ps.setObject(1, input.next());
											} catch (SQLException e) {
												e.printStackTrace();
											}
											try {
												if(1==ps.executeUpdate()){
													System.out.println("增加小类成功!");
												}
												else
													System.out.println("增加失败!");
											} catch (SQLException e) {
												e.printStackTrace();
											}
										}
										else
											System.out.println("增加失败!大类已满");
										break;
								}
						}
						else
								System.out.println("无法增加大/小类,类已满");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//@author 尤龙乾
	public void Categorydel() {
		//实现删除资产类别的方法
		System.out.println("输入需要删除类别的id");
		int id=input.nextInt();
		String sql = "select ast_category1,ast_category2 from asset where ast_id='"+id+"'";
		//寻找记录信息
		Getconnection();		//建立连接
		try {
			ps = conn.prepareStatement(sql);     //建立Preparement对象
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = ps.executeQuery(sql);           //执行查询语句
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
							System.out.println("能删除大/小类,如需删除大 / 小类,输入: 1 / 2");
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
												System.out.println("删除大类成功!");
											}
											else
												System.out.println("删除失败!");
										} catch (SQLException e) {
											e.printStackTrace();
										}
									}
									else
										System.out.println("删除失败!大类为空");
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
												System.out.println("删除小类成功!");
											}
											else
												System.out.println("删除失败!");
										} catch (SQLException e) {
											e.printStackTrace();
										}
									}
									else
										System.out.println("删除失败!小类为空");
									break;
							}
					}
					else
							System.out.println("无法删除大/小类,类全为空");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//@author 尤龙乾
	public void Add(Asset ass) {
		//实现增加资产信息的方法
		System.out.println("输入资产编号：");
		ass.setAst_id(input.nextInt());
		System.out.println("输入资产名称：");
		ass.setAst_name(input.next());
		System.out.println("输入资产大类别：");
		ass.setAst_category1(input.next());
		System.out.println("输入资产小类别");
		ass.setAst_category2(input.next());
		System.out.println("输入资产型号:");
		ass.setAst_type(input.next());
		System.out.println("输入资产价值：");
		ass.setAst_value(input.next());
		System.out.println("输入资产购买日期:yyyy-mm-dd形式");
		ass.setAst_boughtDay(input.next());
		System.out.println("输入资产状态：");
		ass.setAst_status(input.next());
		System.out.println("输入资产备注：");
		ass.setAst_remark(input.next());
		
		Getconnection();
		String sql = "insert into Asset(ast_id,ast_name,ast_category1,ast_category2,ast_type,ast_value,ast_boughtDay,ast_status,ast_remark) " +
				"values('"+ass.getAst_id()+"','"+ass.getAst_name()+"','"+ass.getAst_category1()+"','"+ass.getAst_category2()+"','"+ass.getAst_type()+"','"+ass.getAst_value()+"','"+ass.getAst_boughtDay()+"','"+ass.getAst_status()+"','"+ass.getAst_remark()+"')";
		//sql语句，向数据库插入一条记录信息
		try {
			ps = conn.prepareStatement(sql);		//建立prepareStatement联接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(1==ps.executeUpdate()){
				System.out.println("添加类别成功");
			}
			else
				System.out.println("添加失败");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CloseAll(conn,ps,null);		//关闭数据库联接
	}

	//@author 尤龙乾
	public void Del(Asset ass){
		//实现删除资产的方法
		System.out.println("依据资产编号或资产名称删除固定资产    ");
		System.out.println("请选择：1.根据编号删除 / 2.根据名称删除");
			Getconnection();		//建立连接
			int function=input.nextInt();
			switch(function)
			{
				case 1:
					System.out.println("按照资产编号删除，请输入要删除资产的编号:");
					String sql = "delete from Asset where ast_id = '"+input.nextInt()+"'";
					try {
						ps = conn.prepareStatement(sql);	//建立prepareStatement连接
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if(1==ps.executeUpdate()){
							System.out.println("删除成功!");
						}
						else
							System.out.println("删除失败!不存在此信息!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("按照资产名称删除，请输入要删除资产的名称:");
					String sql2 = "delete from Asset where ast_name = '"+input.next()+"'";
					try {
						ps = conn.prepareStatement(sql2);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if(1==ps.executeUpdate()){
							System.out.println("删除成功!");
						}
						else
							System.out.println("删除失败!");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("操作错误！");
			}
			CloseAll(conn,ps,null);
	}
	
	//@author 尤龙乾
	public void Revise(Asset ass){
		//实现修改资产信息的方法
		 System.out.println("请输入需要修改资产的id");
		 int id = input.nextInt();
		 Object[] Param = new Object[9];		//保存10个参数的数组,用于暂时存储记录
		 
		 System.out.println("请输入以下要修改的值：");
		 System.out.println("资产编号");
		 ass.setAst_id(input.nextInt());
		 System.out.println("资产名称");
		 ass.setAst_name(input.next());
		 System.out.println("资产大类别");
		 ass.setAst_category1(input.next());
		 System.out.println("资产小类别");
		 ass.setAst_category2(input.next());
		 System.out.println("资产型号");
		 ass.setAst_type(input.next());
		 System.out.println("资产价值");
		 ass.setAst_value(input.next());
		 System.out.println("资产购买日期,请按照格式xxxx-xx-xx");
		 ass.setAst_boughtDay(input.next());
		 System.out.println("资产状态");
		 ass.setAst_status(input.next());
		 System.out.println("资产备注");
		 ass.setAst_remark(input.next());
		 Param[0] = ass.getAst_id();		//暂时存储记录信息
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
		 //sql语句，更新数据库信息，其中?为占位符
		 if(1==updateExecute(sql,Param)){		//将记录更新入数据库
			 System.out.println("修改成功");		 
		 }
		 else{
			 System.out.println("修改失败");
		 }
		
		}

	//@author 于海淼
	@Override//查询资产信息：根据id查询
	public void FindById() {
		// 分工任务6(于海淼)	
		System.out.println("请输入您要查找的资产的id");
		int id = input.nextInt();
		String sql = "select * from asset where ast_id = '"+id+"'";
		List<Asset> asset1 =new ArrayList<Asset>();
		asset1 = LookUpAsset(sql);
		if(asset1.size()>0){
			int i=0;
			System.out.println("编号--名称-----大类----小类------型号---价值--购买日期---状态-----使用者---备注--");
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
			System.out.println("您要查找的资产不存在");
		}
		
	}

	//@author 于海淼
	@Override//查询资产信息：根据大类或小类名查询
	public void FindByCatgy() {
		// 分工任务6(于海淼)
		System.out.println("请输入您要查找资产的大类或者小类名");
		String ast_catgry = input.next();
		String sql = "select * from asset where (ast_category1 = '"+ast_catgry+"' or ast_category2 = '"+ast_catgry+"' )";
		List<Asset> asset1 =new ArrayList<Asset>();
		asset1 = LookUpAsset(sql);
		if(asset1.size()>0){
			int i=0;
			System.out.println("编号--名称-----大类----小类------型号---价值--购买日期---状态-----使用者---备注--");
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
			System.out.println("您要查询的资产类别不存在");
		}
	}

	//@author 于海淼
	@Override//查询资产信息：根据使用者查询
	//如果一个人员领用了多份资产，则把这些被他领用的资产全都打印出来
	public void FindByUser() {
		// 分工任务6(于海淼)	
		System.out.println("请输入您要查找资产的使用者");
		String ast_user = input.next();
		String sql = "select * from asset where ast_user = '"+ast_user+"'";
		List<Asset> asset1 =new ArrayList<Asset>();
		asset1 = LookUpAsset(sql);
		if(asset1.size()>0){
			int i=0;
			System.out.println("编号--名称-----大类----小类------型号---价值--购买日期---状态-----使用者---备注--");
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
			System.out.println("该职工没有领用任何资产");
		}
	}

	//@author 于海淼
	@Override//按资产类别浏览资产信息，类别分成两级，能够显示大类和小类下面的资产情况、资产状况
	public void Display() {
		// 分工任务6(于海淼)	
		System.out.println("浏览界面————————————");
		//把所有资产的结果集装到一个泛型容器中
		String sql1 = "select * from asset where ast_id >0";
		List<Asset> asset1 =new ArrayList<Asset>();
		asset1 = LookUpAsset(sql1);
		
		//用数组String[] catgry1  来存放具体的大类有哪些，String[] catgry2来存放具体的小类有哪些
		String[] catgry1 = new String[5];//初步拟定最多5个大类
		int k=0;
		catgry1[k] = asset1.get(0).getAst_category1();
		k++;
		
		int i;
		int j=0;
		String temp = new String();
		int flag1=3 ;//用来标记catgry1里面是否已经有了temp中的某个大类，如果有，则flag1=1
		
		for(i=1;i<asset1.size();i++){
			temp = asset1.get(i).getAst_category1();//获取asset1(1)对象的大类，传给temp
			for(j=0;j<catgry1.length;j++){
				if(catgry1[j] == temp){
					flag1=1;
					break;
				}
				else if(j==(catgry1.length-1)&&catgry1[j]!=temp){
					flag1= 2;//如果该大类没有存储到catgry1数组里，flag1 = 2
				}
			}
			
			if(flag1==1){//表示该大类已经存储到catgry1数组里了
				continue;//扫描下一个asset对象
			}
			else if(2 ==flag1){//表示该大类没有存储到catgry1数组里
				catgry1[k] = temp;
				if(k<4)//防止k变成5越界
				k++;
			}
			else{
				//System.out.println(flag1);
			}
			flag1 = 3;//扫描完一个之后把flag设为中立的3
		}	
		//用set去重**********************
		Set<String> set = new TreeSet<String>();
		for(int t=0;t<catgry1.length;t++){
			if(catgry1[t]!=null)
			set.add(catgry1[t]);
		}
		String[] catgry_1 =  new String[set.size()];
		catgry_1 = (String[])set.toArray(new String[0]);//new String[0]表示里面的元素转为字符串数 组类型(暂时没搞懂)
		/*
		for(int t=0;t<catgry_1.length;t++){
			System.out.println(catgry_1[t]);
		}*/
		//经过以上步骤找到所有的大类并把它们放在数组catgry_1 中
		//**************************************************************************
		
		//*************************************************************************
		//接下来找到所有小类并存于数组中
		String[] catgry2 = new String[20];//初步拟定最多10个小类
		int k2=0;
		catgry2[k2] = asset1.get(0).getAst_category2();
		k2++;
		
		int i2;
		int j2=0;
		String temp2 = new String();
		int flag2=3 ;//用来标记catgry2里面是否已经有了temp2中的某个小类，如果有，则flag2=1
		
		for(i2=1;i2<asset1.size();i2++){
			temp2 = asset1.get(i2).getAst_category2();//获取asset1(1)对象的小类，传给temp
			for(j2=0;j2<catgry2.length;j2++){
				if(catgry2[j2] == temp2){
					flag2=1;
					break;
				}
				else if(j2==(catgry2.length-1)&&catgry2[j2]!=temp2){
					flag2= 2;//如果该大类没有存储到catgry2数组里，flag2 = 2
				}
			}
			
			if(flag2==1){//表示该大类已经存储到catgry2数组里了
				continue;//扫描下一个asset对象
			}
			else if(2 ==flag2){//表示该大类没有存储到catgry1数组里
				catgry2[k2] = temp2;
				//if(k2<=?)//防止k越界(暂时没搞懂)
				k2++;
			}
			else{
				//System.out.println(flag2);
			}
			flag2 = 3;//扫描完一个之后把flag2设为中立的3
		}	
		//用set去重**********************
		Set<String> set2 = new TreeSet<String>();
		for(int t=0;t<catgry2.length;t++){
			if(catgry2[t]!=null)
			set2.add(catgry2[t]);
		}
		String[] catgry_2 =  new String[set2.size()];
		catgry_2 = set2.toArray(new String[0]);//new String[0]表示里面的元素转为字符串数 组类型(暂时没搞懂)
		/*
		for(int t=0;t<catgry_2.length;t++){
			System.out.println(catgry_2[t]);
		}*/
		
		//再分级输出大类以及其对应的小类的资产条目
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
						System.out.println("大类："+bigClass+"   小类:"+smallClass );
						rs.previous();
						System.out.println("编号--名称-----大类----小类------型号---价值--购买日期---状态-----使用者---备注--");
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
