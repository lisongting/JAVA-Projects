package Sort;

import java.util.ArrayDeque;

/**
 * ���������㷨�Լ�����
 * 16.8.24
 * @author Administrator
 *
 */
public class SortClass {
	private int[] data;
	public SortClass(){};
	public SortClass(int[] a){//�½�һ��������󡣡�
		data = new int[a.length];
		for(int i=0;i<a.length;i++)
			data[i] = a[i];	
	}
	public void Display(){
		for(int i:data){
			System.out.print(i+" ");
		}
	}
	//1ð������*****************************************************************
	public void BubbleSort(){
		for(int i=0;i<data.length-1;i++){
			for(int j=0;j<data.length-1-i;j++){
				if(data[j]>data[j+1]){
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
	//[����]������Ч����͵������㷨
	//1ð������*****************************************************************
	
	
	//2��������********************************************************************
	public void InsertSort(){
		for(int i=1,j;i<data.length;i++){
			int cursor = data[i];//cursor�ӵڶ���Ԫ������������ƶ�
			for(j=i;j>0 && cursor<data[j-1];j--){//��iλ��֮ǰ�ҵ���tmp�����Ԫ�أ�Ȼ��tmp֮ǰ��ÿһλԪ�������һλ
				data[j] = data[j-1];
			}
			data[j] = cursor;//����cursor�ŵ���ȷ��λ����
		}
	}
	//[����]����������������������1000���µĹ�ģ
	//2��������********************************************************************
	
	
	//3ѡ������**********************************************************
	public void SelectSort(){
		int i,j,least;
		for(i=0;i<data.length-1;i++){//��ѭ�����ӵ�1��Ԫ����������ƶ���
			for(j=i+1,least=i;j<data.length;j++){//��iλ�ĺ�����δ��������ÿһ����δ���������ҵ���С��Ԫ��
				if(data[j]<data[least]){
					least = j;
				}
			}//�����forѭ�����ҵ��������е���СԪ��
			if(i!=least){//�ҵ���С��Ԫ��֮�󣬽�data[i]��leastԪ�ؽ���
				int tmp = data[least];
				data[least] = data[i];
				data[i]= tmp;
			}
		}
	}
	//[����]��ð������һ��Ч�ʽϵ�
	//3ѡ������************************************************************
	
	
	//4ϣ������*************************************************************
	//ϣ�����򣨵ݼ��������򷨣����ȱȽϾ����Զ��Ԫ�أ��ٱȽϾ���Ͻ���Ԫ��
	//��ÿ������gap��Ԫ�ز�ֿ����������ֳɼ��������顣 
	public void ShellSort(){
		int i,j,gap;
		for(gap =data.length/2;gap>0;gap/=2){//��һ��:���gap���εݼ���ÿ�γ���һ��
			for(i=gap;i<data.length;i++){//�ڶ���:i��gapλ�ÿ�ʼ�����ε�����ÿ����1
				for(j=i-gap;j>=0&&data[j]>data[j+gap];j=j-gap){//������:��data[j]����gap��Ԫ��data[j+gap]�Ƚϣ����ǰ�ߴ��򽻻�
					int tmp = data[j];
					data[j] = data[j+gap];
					data[j+gap] = tmp;
				}
			}
		}
	}
	//[����]Shell�����ð�������5�����Ȳ���������¿�2����Shell�������QuickSort��MergeSort��HeapSort���ܶࡣ
	//		��������ԱȽϼ򵥣����ʺ�����������5000���²����ٶȲ������ر���Ҫ�ĳ���
	//4ϣ������*************************************************************
	
	
	//5��������****************************************************************
	//�ֱ�ӳ�ʼ���С�8,5,1,17,26,3,20,9,10,33�����˿�ʼ��̽�⡱��
	//�ȴ���������һ��С��8�������ٴ���������һ������8������Ȼ�󽻻����ǡ������������������i��j���ֱ�ָ����������ߺ����ұ�
	public void QuickSort(int left,int right){
		int i,j,tmp,pivot;//pivot��������
		if(left>right)
			return;
		i = left;
		j = right;
		pivot = data[left];
		while(i!=j){
			while(data[j]>=pivot&&i<j)//���������ҵ�С��pivot����
				j--;
			while(data[i]<=pivot&&i<j)//�������ң��ҵ�����pivot����
				i++;
			if(i<j){
				tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
		data[left] = data[i];
		data[i] = pivot;//���������ŵ����ʵ�λ��
		QuickSort(left,i-1);//����߽��п�������
		QuickSort(i+1,right);//���ұ߽��п�������
	}
	//[����]��������ȴ󲿷������㷨��Ҫ�졣ȱ�㣺�ǳ�ռ���ڴ�
	//5��������****************************************************************
	
	
	//6������*****************************************************************************
	void HeapSort(int[] data){
		for(int i=data.length/2-1;i>=0;i--)
			moveDown(data,i,data.length-1);//���Ƚ����鹹����һ����
		//�������ٽ��ж�����
		for(int i=data.length-1;i>=1;i--){
			int tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;//��Ϊ����Ԫ�ؾ��������Ǹ�������ĩβԪ���붥��Ԫ�ؽ������Ͳ���ȥ���Ǹ�ÿ��������Ԫ����
			//���ж�����
			moveDown(data,0,i-1);//�������Ǹ�������β��֮�󣬶�֮ǰ�����ٽ���moveDown ����
		}
		
	}

	//moveDown���Ƕѵĳ�ʼ������һ�����鹹��������ѵ�������
	//1.ÿһ���ڵ��ֵ�����ڵ����������к��ӽڵ� 2.����һ����ȫ������
	//ÿһ��moveDown����Ѷ��������Ǹ�Ԫ���������ŵ��Ѷ�
	public void moveDown(int[] data,int first,int last){
		int largest = first*2+1;
		while(largest<=last){
			if(largest<last && data[largest]<data[largest+1])
				largest++;   //������Һ����нϴ���Ǹ�
			if(data[first]<data[largest]){//����ǰ�ڵ��ֵ��ϴ�ĺ���ֵ���н���
				int tmp;
				tmp = data[largest];
				data[largest] = data[first];
				data[first] = tmp;
				
				first = largest;
				largest = first*2+1;//���������ƶ�
			}
			else break;//����ýڵ��Ѿ����������Ӵ�������ѭ��
		}
	}
	//[����]�������ʺ����������ǳ���ĳ��ϣ��������ݣ�
	//6������*****************************************************************************
	
	//7�鲢����****************************************************************************
	// �鲢���������õݹ�ͷֶ���֮�ļ������������л��ֳ�ΪԽ��ԽС�İ��ӱ�
	//�ٶ԰��ӱ�����������õݹ鲽�轫�ź���İ��ӱ�ϲ���ΪԽ��Խ����������У��鲢��������������裬�ֱ�Ϊ��
	//  1�����ӱ�  2�ϲ����ӱ�
	public void Merge(int[] array,int first,int mid,int last){
		ArrayDeque queue = new ArrayDeque();
		int i=first,j=mid;
		while(i<mid&&j<last){
			if(array[i]<array[j]){
				queue.add(array[i]);//��С��Ԫ�ؼӽ�ȥ
				i++;
			}
			else{
				queue.add(array[j]);
				j++;
			}
		}
		//����û�бȽ�����ӱ��е�Ԫ��
		while(i<mid){
			queue.add(array[i]);
			i++;
		}
		while(j<last){
			queue.add(array[j]);
			j++;
		}
		int index=0;
		while(!queue.isEmpty()){
			array[first+index]= (int)queue.poll();//�Ѷ����е�Ԫ�����θ��Ƶ�����data��
			index++;
		}
		
	}
	
	public void MergeSort(int[] array ,int first,int last){
		if(first+1<last){
			int mid = (first+last)/2;
			MergeSort(array,first,mid);
			MergeSort(array,mid,last);
			Merge(array,first,mid,last);
		}
	}
	//[����]�鲢������Ҫһ��ͬ�ȴ�С�Ķ������飬��Ҫռ�ö���Ŀռ�
	//7�鲢����****************************************************************************
	
	//8��������**************************************************************************
	public void RadixSort(int[] array,int d){//d��ʾ�������ж���λ
		int k=0;//����array���±�ı�Ƿ�
		int n=1;//n=1ȡ��������Ԫ�صĸ�λ����n=10ʱȡ������Ԫ�ص�ʮλ
		int m=1;//���Ƽ�ֵ������������һλ
		int[][] temp = new int[10][array.length];//�����һά��ʾ���ܵ�����
		int[] order = new int[10];//�½�һ�����鲢��ʼ��Ϊȫ0����ʾ���ָ�λ��i�����ĸ�����
		while(m<=d){
			for(int i=0;i<array.length;i++){
				int lsd = (array[i]/n)%10;//n=1ȡ��������Ԫ�صĸ�λ����n=10ʱȡ������Ԫ�ص�ʮλ
				temp[lsd][order[lsd]] = array[i];//temp[i][]�д���Ǹ�λ��Ϊi��Ԫ��
				order[lsd]++;//order[i]��ֵ���Ǹ�λ��Ϊi�����ĸ���
			}
			for(int i=0;i<10;i++){
				if(order[i]!=0){//����������и�λ����i����
					for(int j=0;j<order[i];j++){
						array[k] = temp[i][j];//��temp�����е�Ԫ�����η��뵽array�У���ɶ�array��������
						k++;
					}
				}
				System.out.print("order["+i+"]��"+order[i]+" ");
				order[i]=0;	//
			}
			System.out.println();
			n = n*10;
			k=0;
			m++;
			
			for(int i=0;i<10;i++){
				for(int j=0;j<array.length;j++){
					System.out.print(temp[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}
	
	//[����]��������ֻ�ʺ����������򣬶��ҷǳ�ռ�ô洢�ռ�
	//8��������**************************************************************************
	
	
	public  static void main(String[] args){
		int[] array = new int[]{8,5,1,17,26,3,20,9,10,33};
		SortClass sc = new SortClass(array);
		//sc.BubbleSort();
		//sc.InsertSort();
		//sc.SelectSort();
		//sc.ShellSort();
		//sc.QuickSort(0, 9);
		//sc.HeapSort(array);
		//sc.MergeSort(array, 0, 9);
		sc.RadixSort(array, 2);
		for(int i:array)
			System.out.print(i+" ");
		System.out.println();
		sc.Display();

	}
}
