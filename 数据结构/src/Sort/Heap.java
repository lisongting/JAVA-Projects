package Sort;

public class Heap {
	void heapSort(int[] data){
		for(int i=data.length/2-1;i>=0;i--)
			moveDown(data,i,data.length-1);//首先将数组构建成一个堆
		//接下来再进行堆排序
		for(int i=data.length-1;i>=1;i--){
			int tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;//将末尾元素与顶部元素交换
			//进行堆排序
			moveDown(data,0,i-1);
		}
		
	}
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
	public static void main(String[] args){
		int[] data = new int[]{2,8,6,1,10,15,3,12,11}; 
		for(int i:data)
			System.out.print(i+" ");
		System.out.println();
		new Heap().heapSort(data);
		for(int i:data)
			System.out.print(i+" ");
	}
}
