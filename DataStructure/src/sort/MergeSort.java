package sort;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度：O(nlogn)^2 
 * 空间复杂度:O(1)
 * 稳定性：稳定
 * [分析]将长度为n的无序序列看成是n个长度为1的有序子序列，
 * 首先做两两合并，得到一个n/2个长度为2的有序子序列，
 * 然后再将这些有序子序列进行两两合并，不断的重复这个过程，
 * 最终得到一个长度为n的有序序列。
 * @author Administrator
 */
public class MergeSort {

	
	//left是待排序数组的第一个位置索引，right是最后一个位置索引
	public static void mergeSort(int[] array,int left,int right){
		if(left < right){
			int mid = (left+right)/2;
			mergeSort(array,left,mid);
			mergeSort(array,mid+1,right);
			merge(array,left,mid,right);
		}
	}
	public static void merge(int[] array,int left,int center,int right){
		//定义一个与待排序数组一样大小的临时数组
		int[] tmpArr = new int[array.length];
		int mid = center+1;
		//记录中间数组的索引
		int third = left;
		int tmp = third;
		while(left<=center && mid<=right){
			//从两个数组中取出较小的值放入中间数组
			if(array[left] < array[mid]){
				tmpArr[third++] = array[left++]; 
			}else{
				tmpArr[third++] = array[mid++];
			}
		}
		//剩余部分依次放入中间数组
		while(mid<=right){
			tmpArr[third++] = array[mid++];
		}
		while(left<=center){
			tmpArr[third++] = array[left++];
		}
		//将中间数组中的内容复制到原数组
		while(tmp<=right){
			array[tmp] = tmpArr[tmp++];
		}
		System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {
		int[] array = new int[]{9,5,23,2,0,21,30,13};
		System.out.println("排序前：\n"+Arrays.toString(array));
		System.out.println("开始排序：");
		mergeSort(array,0,array.length-1);
		System.out.println("排序后：\n"+Arrays.toString(array));
	}
	/**[运行结果]
	 排序前：
	[9, 5, 23, 2, 0, 21, 30, 13]
	开始排序：
	[5, 9, 23, 2, 0, 21, 30, 13]
	[5, 9, 2, 23, 0, 21, 30, 13]
	[2, 5, 9, 23, 0, 21, 30, 13]
	[2, 5, 9, 23, 0, 21, 30, 13]
	[2, 5, 9, 23, 0, 21, 13, 30]
	[2, 5, 9, 23, 0, 13, 21, 30]
	[0, 2, 5, 9, 13, 21, 23, 30]
	排序后：
	[0, 2, 5, 9, 13, 21, 23, 30]
	 */
}
