package sort;

import java.util.Arrays;

/**
 * 快速排序
 * （属于交换排序）
 * 时间复杂度：最好O(nlogn) 最坏O(n*n) 
 * 空间复杂度:O(logn)
 * 稳定性：不稳定
 * [分析]快速排序比大部分排序算法都要快。
 * 快速排序思路：从待排序的数据序列中任意去一个数据作为分界，
 * 所有比它小的数据元素一律放在左边，所有比它大的元素一律放在右边，
 * 这样一趟下来，形成左右两个子序列，再对这两个子序列进行相同的处理，
 * 即重新选取中心元素。进行递归处理
 * @author Administrator
 */
public class QuickSort {
	public static void quickSort(int[] array,int start,int end){
		//需要排序
		if(start < end){
			//以第一个元素作为分界值
			int pivot = array[start];
			//i从左边开始搜索，查找大于分界值的元素索引
			int i = start;
			//j从右边开始搜索，查找小于分界值的元素索引
			int j = end;
			while(true){
				while(array[j]>=pivot && i<j){
					j--;
				}
				
				while(array[i]<=pivot && i<j){
					i++;
				}
				//如果i小于j则交换
				if(i<j){
					swap(array,i,j);
				}else{
					break;
				}
			}
			//pivot是array[start],因此将pivot放到合适的位置
			swap(array,start,j);
			System.out.println(Arrays.toString(array));
			quickSort(array,start,j-1);
			quickSort(array,j+1,end);
		}
	}
	//交换函数
		public static void swap(int[] array,int i,int j){
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
	
	public static void main(String[] args) {
		int[] array = new int[]{9,5,23,2,0,21,30,13};
		System.out.println("排序前：\n"+Arrays.toString(array));
		System.out.println("开始排序：");
		QuickSort.quickSort(array, 0,array.length-1);
		System.out.println("排序后：\n"+Arrays.toString(array));
	}
	/*[运行结果]
	 排序前：
	[9, 5, 23, 2, 0, 21, 30, 13]
	开始排序：
	[2, 5, 0, 9, 23, 21, 30, 13]
	[0, 2, 5, 9, 23, 21, 30, 13]
	[0, 2, 5, 9, 13, 21, 23, 30]
	[0, 2, 5, 9, 13, 21, 23, 30]
	排序后：
	[0, 2, 5, 9, 13, 21, 23, 30]
	 */
}
