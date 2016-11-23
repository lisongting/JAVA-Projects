package myproject01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * ����5������array����,��600���������ƥ��
 * @author Administrator
 *
 */
public class NameMakerAppTest {
	static final int DATA_ROW=600;
	
	public static void main(String[] args) {
		new NameMakerAppTest().run();
		
	}
	
	public void run(){
		int[] int_keys = new int[DATA_ROW];
		int [][] int_keys2 = new int[DATA_ROW][5];
		String [] str = new String[DATA_ROW];
		int[] array = new int[5];
		List<Integer> resultList = new ArrayList<>();
		try {
			FileReader freader = new FileReader("data.txt");
			BufferedReader buffer = new BufferedReader(freader);
			String tmp = null;
			int h=0;
			while((tmp=buffer.readLine())!=null){
				int_keys[h] = Integer.parseInt(tmp);
				h++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(int i=0;i<DATA_ROW;i++){
			 str[i] =  String.valueOf(int_keys[i]);
			for(int j=0;j<5;j++){
				int_keys2[i][j] = str[i].charAt(j)-48;
			}
		}
		
		System.out.println("����array����");
		Scanner input = new Scanner(System.in);
		for(int i=0;i<5;i++){
			array[i] = input.nextInt();
		}
		resultList = find(array,int_keys,int_keys2);
		for(int tt:resultList){
			System.out.println("ƥ�䵽����:"+tt);
		}
		
	}
	
	public List<Integer> find(int array[],int int_keys[],int int_keys2[][]){
		int count = 5;//5����Чλ
		List<Integer> result = new ArrayList<>();
		for(int i=0;i<5;i++){
			if(array[i]==0){
				count--;
			}
		}
		if(count==5){
			//�Ȱ�array����ת��Ϊ5λ��������ʽ
			StringBuilder tmp=new StringBuilder();
			for(int i=0;i<5;i++){
				tmp.append(array[i]);
			}
			int value = Integer.parseInt(tmp.toString());
			//ֱ��ƥ��
			for(int i=0;i<DATA_ROW;i++){
				if(value==int_keys[i]){
					result.add(int_keys[i]);
				}
			}
			//ֱ��ƥ��ʧ��,����4λȥ��
			if(result.isEmpty()){
				//��array��ÿһλ�����α��0,ѭ��5��,����4λ������ȥ��
				for(int i=0;i<5;i++){
					int t = array[i];
					array[i]=0;
					//����4λ����ʽ���жԱ�
					int[] index = new int[4];
					for(int j=0,k=0;j<5&&k<4;j++){
						if(array[j]!=0){
							index[k]=j;
							k++;
						}
					}
					for(int j=0;j<DATA_ROW;j++){
						if(int_keys2[j][index[0]]==array[index[0]]
								&&int_keys2[j][index[1]]==array[index[1]]
								&&int_keys2[j][index[2]]==array[index[2]]
								&&int_keys2[j][index[3]]==array[index[3]]){
							result.add(int_keys[j]);//���ֱ��ƥ�䵽,����뵽���������
						}
					}
					array[i]=t;
				}
				//�������4λ������ȥ����Ȼʧ��,����3λ,����3λ������ȥƥ��
				if(result.isEmpty()){
					//5λ����,ȡ��λΪ0,�������������10��ֵ
					for(int i=0;i<4;i++){
						int t1 = array[i];
						array[i]=0;
						for(int j=i+1;j<5;j++){
							int t2 = array[j];
							array[j]=0;
							result = findByThree(array,int_keys,int_keys2,result);
							array[j] = t2;
						}
						array[i] = t1;
					}
				}
			}
		}else if(count==4){
			result = findByFour(array,int_keys,int_keys2,result);
		}else if(count==3){
			result = findByThree(array,int_keys,int_keys2,result);
		}else{
			System.out.println("���������쳣");
		}
		return result;
	}
	
	
	public List<Integer> findByFour(int array[],int int_keys[],int int_keys2[][],List<Integer> result){
		int[] index = new int[4];//���������λ�����������е��±�
		for(int i=0,j=0;i<5&&j<4;i++){
			if(array[i]!=0){
				index[j]=i;
				j++;
			}
		}
		int id0 = index[0];int id1 = index[1];int id2 = index[2];int id3 = index[3];//����Чλ���±�
		int a = array[id0];int b = array[id1];int c = array[id2];int d = array[id3];//����Чλ��ֵ
		//��һ��,ֱ��ƥ��
		for(int i=0;i<DATA_ROW;i++){
			if(int_keys2[i][id0]==a
					&&int_keys2[i][id1]==b
					&&int_keys2[i][id2]==c
					&&int_keys2[i][id3]==d){
				result.add(int_keys[i]);//���ֱ��ƥ�䵽,����뵽���������
			}
		}
		//�����һ��û��ƥ�䵽,��4λ��Чλ���θ�ֵ0,ת��Ϊ3λ��ֵ,����3λƥ���㷨
		if(result.isEmpty()){
			for(int i=0;i<4;i++){
				int tmp = array[i];
				array[index[i]]=0;
				result = findByThree(array,int_keys,int_keys2,result);
				array[index[i]] = tmp;
			}
		}else{
			return result;
		}
		return result;
		
	}
	
	public List<Integer> findByThree(int array[],int int_keys[],int int_keys2[][],List<Integer> result){
		int[] index = new int[3];//���������λ�����������е��±�
		for(int i=0,j=0;i<5&&j<3;i++){
			if(array[i]!=0){
				index[j]=i;
				j++;
			}
		}
		int id0 = index[0];int id1 = index[1];int id2 = index[2];//����Чλ���±�
		int a = array[id0];int b = array[id1];int c = array[id2];//����Чλ��ֵ
		if(a==0||b==0||c==0){
			System.out.println("�����쳣");
			return result;
		}
		//��һ��:ֱ��ƥ��,3��λ�õ���һһ��Ӧ���
		for(int i=0;i<DATA_ROW;i++){
			if(int_keys2[i][id0]==a&&int_keys2[i][id1]==b&&int_keys2[i][id2]==c){
				result.add(int_keys[i]);//���ֱ��ƥ�䵽,����뵽���������
			}
		}
		//���û���ҵ����,����еڶ���:��������λ��һ��������Ӧ���
		if(result.isEmpty()){
			for(int i=0;i<DATA_ROW;i++){
				if(int_keys2[i][id0]==a&&int_keys2[i][id1]==b)
					result.add(int_keys[i]);
				if(int_keys2[i][id0]==a&&int_keys2[i][id2]==c)
					result.add(int_keys[i]);
				if(int_keys2[i][id1]==b&&int_keys2[i][id2]==c)
					result.add(int_keys[i]);
			}
			
		}
		
		return result;
	}
}
