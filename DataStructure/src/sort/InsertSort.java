package sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * （属于插入排序）
 * 时间复杂度：O(n*n) 
 * 空间复杂度:O(1)
 * 稳定性：稳定
 * [分析]将第一个元素看做有序区，
 * 使用游标从数组的第二个数开始扫描，
 * 然后将第二个数插入到有序区中的位置
 * 有序区增长，游标依次后移，然后再把游标处
 * 的元素再次插入有序区
 * @author Administrator
 */
public class InsertSort {

	public static void insertSort(int[] array){
		for(int i=1;i<array.length;i++){
			//从第二个元素开始，依次向后
			//将每个cursor插入到前面的已排序区域
			int cursor = array[i];
			//i-1索引之前的元素都已经有序，i-1处的元素就是最大的值
			//如果i位置的元素比i-1处的小，则需要将该元素插入到有序区
			if(array[i] < array[i-1]){
				//将数组中的数据依次往后移动一位
				int j;
				//array[j]是有序区中最大的元素
				for(j=i-1; j>=0&&cursor<array[j] ;j--){
					//数组中的元素依次右移
					array[j+1] = array[j];
				}
				//当找到合适cursor插入的位置j+1时
				//将cursor的值放到合适的位置中去
				array[j+1] = cursor;
			}
			System.out.println(Arrays.toString(array));
		}
	}
	public static void main(String[] args) {
		int[] array = new int[]{9,5,23,2,0,21,30,13};
		System.out.println("排序前：\n"+Arrays.toString(array));
		System.out.println("开始排序：");
		insertSort(array);
		System.out.println("排序后：\n"+Arrays.toString(array));
	}
	/*[运行结果]
	 排序前：
	[9, 5, 23, 2, 0, 21, 30, 13]
	开始排序：
	[5, 9, 23, 2, 0, 21, 30, 13]
	[5, 9, 23, 2, 0, 21, 30, 13]
	[2, 5, 9, 23, 0, 21, 30, 13]
	[0, 2, 5, 9, 23, 21, 30, 13]
	[0, 2, 5, 9, 21, 23, 30, 13]
	[0, 2, 5, 9, 21, 23, 30, 13]
	[0, 2, 5, 9, 13, 21, 23, 30]
	排序后：
	[0, 2, 5, 9, 13, 21, 23, 30]
	 */
}
