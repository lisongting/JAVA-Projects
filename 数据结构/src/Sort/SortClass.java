package Sort;

import java.util.ArrayDeque;

/**
 * 八种排序算法以及分析
 * 16.8.24
 * @author Administrator
 *
 */
public class SortClass {
	private int[] data;
	public SortClass(){};
	public SortClass(int[] a){//新建一个数组对象。。
		data = new int[a.length];
		for(int i=0;i<a.length;i++)
			data[i] = a[i];	
	}
	public void Display(){
		for(int i:data){
			System.out.print(i+" ");
		}
	}
	//1冒泡排序*****************************************************************
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
	//[分析]最慢，效率最低的排序算法
	//1冒泡排序*****************************************************************
	
	
	//2插入排序********************************************************************
	public void InsertSort(){
		for(int i=1,j;i<data.length;i++){
			int cursor = data[i];//cursor从第二个元素依次向后面移动
			for(j=i;j>0 && cursor<data[j-1];j--){//在i位置之前找到比tmp更大的元素，然后tmp之前的每一位元素向后复制一位
				data[j] = data[j-1];
			}
			data[j] = cursor;//最后把cursor放到正确的位置上
		}
	}
	//[分析]插入排序适用于数据量在1000以下的规模
	//2插入排序********************************************************************
	
	
	//3选择排序**********************************************************
	public void SelectSort(){
		int i,j,least;
		for(i=0;i<data.length-1;i++){//大循环，从第1个元素依次向后移动，
			for(j=i+1,least=i;j<data.length;j++){//第i位的后面是未排序区，每一趟在未排序区中找到最小的元素
				if(data[j]<data[least]){
					least = j;
				}
			}//在这个for循环中找到无序区中的最小元素
			if(i!=least){//找到最小的元素之后，将data[i]与least元素交换
				int tmp = data[least];
				data[least] = data[i];
				data[i]= tmp;
			}
		}
	}
	//[分析]和冒泡排序一样效率较低
	//3选择排序************************************************************
	
	
	//4希尔排序*************************************************************
	//希尔排序（递减增量排序法）：先比较距离较远的元素，再比较距离较近的元素
	//将每隔增量gap的元素拆分开，把数组拆分成几个子数组。 
	public void ShellSort(){
		int i,j,gap;
		for(gap =data.length/2;gap>0;gap/=2){//第一层:间距gap依次递减，每次除以一半
			for(i=gap;i<data.length;i++){//第二层:i从gap位置开始，依次递增，每次增1
				for(j=i-gap;j>=0&&data[j]>data[j+gap];j=j-gap){//第三层:从data[j]与间距gap的元素data[j+gap]比较，如果前者大，则交换
					int tmp = data[j];
					data[j] = data[j+gap];
					data[j+gap] = tmp;
				}
			}
		}
	}
	//[分析]Shell排序比冒泡排序快5倍，比插入排序大致快2倍。Shell排序比起QuickSort，MergeSort，HeapSort慢很多。
	//		但是它相对比较简单，它适合于数据量在5000以下并且速度并不是特别重要的场合
	//4希尔排序*************************************************************
	
	
	//5快速排序****************************************************************
	//分别从初始序列“8,5,1,17,26,3,20,9,10,33”两端开始“探测”。
	//先从右往左找一个小于8的数，再从左往右找一个大于8的数，然后交换他们。这里可以用两个变量i和j，分别指向序列最左边和最右边
	public void QuickSort(int left,int right){
		int i,j,tmp,pivot;//pivot是中轴数
		if(left>right)
			return;
		i = left;
		j = right;
		pivot = data[left];
		while(i!=j){
			while(data[j]>=pivot&&i<j)//从右往左，找到小于pivot的数
				j--;
			while(data[i]<=pivot&&i<j)//从左往右，找到大于pivot的数
				i++;
			if(i<j){
				tmp = data[i];
				data[i] = data[j];
				data[j] = tmp;
			}
		}
		data[left] = data[i];
		data[i] = pivot;//将中轴数放到合适的位置
		QuickSort(left,i-1);//对左边进行快速排序
		QuickSort(i+1,right);//对右边进行快速排序
	}
	//[分析]快速排序比大部分排序算法都要快。缺点：非常占用内存
	//5快速排序****************************************************************
	
	
	//6堆排序*****************************************************************************
	void HeapSort(int[] data){
		for(int i=data.length/2-1;i>=0;i--)
			moveDown(data,i,data.length-1);//首先将数组构建成一个堆
		//接下来再进行堆排序
		for(int i=data.length-1;i>=1;i--){
			int tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;//因为顶部元素就是最大的那个数，将末尾元素与顶部元素交换，就不再去管那个每趟中最大的元素了
			//进行堆排序
			moveDown(data,0,i-1);//把最大的那个数放在尾部之后，对之前的数再进行moveDown 操作
		}
		
	}

	//moveDown就是堆的初始化。把一个数组构建成满足堆的条件：
	//1.每一个节点的值都大于等于它的所有孩子节点 2.树是一棵完全二叉树
	//每一次moveDown都会把堆中最大的那个元素挑出来放到堆顶
	public void moveDown(int[] data,int first,int last){
		int largest = first*2+1;
		while(largest<=last){
			if(largest<last && data[largest]<data[largest+1])
				largest++;   //标记左右孩子中较大的那个
			if(data[first]<data[largest]){//将当前节点的值与较大的孩子值进行交换
				int tmp;
				tmp = data[largest];
				data[largest] = data[first];
				data[first] = tmp;
				
				first = largest;
				largest = first*2+1;//继续往下移动
			}
			else break;//如果该节点已经比两个孩子大，则跳出循环
		}
	}
	//[分析]堆排序适合于数据量非常大的场合（百万数据）
	//6堆排序*****************************************************************************
	
	//7归并排序****************************************************************************
	// 归并排序是利用递归和分而治之的技术将数据序列划分成为越来越小的半子表，
	//再对半子表排序，最后再用递归步骤将排好序的半子表合并成为越来越大的有序序列，归并排序包括两个步骤，分别为：
	//  1划分子表  2合并半子表
	public void Merge(int[] array,int first,int mid,int last){
		ArrayDeque queue = new ArrayDeque();
		int i=first,j=mid;
		while(i<mid&&j<last){
			if(array[i]<array[j]){
				queue.add(array[i]);//把小的元素加进去
				i++;
			}
			else{
				queue.add(array[j]);
				j++;
			}
		}
		//复制没有比较完的子表中的元素
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
			array[first+index]= (int)queue.poll();//把队列中的元素依次复制到数组data中
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
	//[分析]归并排序需要一个同等大小的额外数组，需要占用额外的空间
	//7归并排序****************************************************************************
	
	//8基数排序**************************************************************************
	public void RadixSort(int[] array,int d){//d表示最大的数有多少位
		int k=0;//数组array的下表的标记符
		int n=1;//n=1取出数组中元素的个位。。n=10时取出的是元素的十位
		int m=1;//控制键值排序依据在哪一位
		int[][] temp = new int[10][array.length];//数组第一维表示可能的余数
		int[] order = new int[10];//新建一个数组并初始化为全0。表示数字该位是i的数的个数。
		while(m<=d){
			for(int i=0;i<array.length;i++){
				int lsd = (array[i]/n)%10;//n=1取出数组中元素的个位。。n=10时取出的是元素的十位
				temp[lsd][order[lsd]] = array[i];//temp[i][]中存的是个位数为i的元素
				order[lsd]++;//order[i]的值就是个位数为i的数的个数
			}
			for(int i=0;i<10;i++){
				if(order[i]!=0){//如果数组中有个位数是i的数
					for(int j=0;j<order[i];j++){
						array[k] = temp[i][j];//将temp矩阵中的元素依次放入到array中，完成对array的重排序
						k++;
					}
				}
				System.out.print("order["+i+"]是"+order[i]+" ");
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
	
	//[分析]基数排序只适合于整数排序，而且非常占用存储空间
	//8基数排序**************************************************************************
	
	
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
