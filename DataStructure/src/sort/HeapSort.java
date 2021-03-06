package sort;

import java.util.Arrays;
/**
 * 堆排序
 * （属于选择排序）
 * 时间复杂度：O(nlogn) 
 * 空间复杂度:O(1)
 * 稳定性：不稳定
 * [分析]堆中通过 重建堆，
 * 从根结点开始进行从上向下的调整。
 * 每次调整都将未排序区中最大的元素放在堆顶
 * 然后将堆顶的元素与未排序区中的最后一个元素交换
 * 这个最大元素就进入一排序区
 * 然后再进行堆的重新调整操作。
 * 如此重复实现排序
 * @author Administrator
 */
public class HeapSort {
	
	public static void heapSort(int[] array){
		//先把array数组构建成一个大顶堆
		//从完全二叉树最右边的叶子节点的父节点开始
		for(int i = array.length/2-1;i>=0;i--){
			moveDown(array,i,array.length-1);
		}
		//经过上一轮的调整，已经将数组中最大的元素置于堆顶
		//接下来进行堆排序
		for(int i =array.length-1;i>=1;i--){
			//将未排序的末尾元素与堆顶元素交换
			//此时未排序区中的最大的元素会放在未排序区的最后
			swap(array,0,i);
			System.out.println(Arrays.toString(array));
			//进行堆排序
			moveDown(array,0,i-1);
		}
	}
	//每一次moveDown都会把未排序区中最大的数挑出来放在堆顶
	public static void moveDown(int[] array,int first,int last){
		//将first的左子节点设为largest
		int largest = first*2 +1;
		while(largest <= last){
			//如果first的右子节点大于左子节点
			if(largest<last&&array[largest]<array[largest+1]){
				//标记较大的那个右子节点
				largest++;
			}
			//如果第一个元素小于largest元素
			if(array[first]<array[largest]){
				//将first和largest对应的元素进行交换
				swap(array,first,largest);
				
				//继续往下移动
				first = largest;
				largest = 2*first+1;
			}else{
				//如果该节点比它的两个孩子都大，则退出循环
				break;
			}
		}
	}
	public static void swap(int[] array,int i,int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) {
		int[] array = new int[]{9,5,23,2,0,21,30,13};
		System.out.println("排序前：\n"+Arrays.toString(array));
		System.out.println("开始排序：");
		heapSort(array);
		System.out.println("排序后：\n"+Arrays.toString(array));
	}
	/*[运行结果]
	排序前：
	[9, 5, 23, 2, 0, 21, 30, 13]
	开始排序：
	[2, 13, 23, 5, 0, 21, 9, 30]
	[9, 13, 21, 5, 0, 2, 23, 30]
	[2, 13, 9, 5, 0, 21, 23, 30]
	[0, 5, 9, 2, 13, 21, 23, 30]
	[2, 5, 0, 9, 13, 21, 23, 30]
	[0, 2, 5, 9, 13, 21, 23, 30]
	[0, 2, 5, 9, 13, 21, 23, 30]
	排序后：
	[0, 2, 5, 9, 13, 21, 23, 30]
	 */

}
