package sort;

import java.util.Arrays;

/**
 * 直接选择排序
 * （属于选择排序）
 * 时间复杂度：O(n*n) 
 * 空间复杂度:O(1)
 * 稳定性：不稳定
 * [分析]和冒泡排序一样效率较低
 * 思路：第一趟从所有数据中选出最小的，放在第一位
 * 第二趟从其他未排序位置中选出最小的，放在第二位
 * 依次类推。
 * 一共需要进行n-1趟才能排好
 * @author Administrator
 */
public class SelectSort {
	public static void selectSort(int[] array){
		//进行n-1趟比较，第i趟比较将第i大的值选出来放在i位置上
		for(int i=0;i<array.length-1;i++){
			//第i个数据只需和它后面的数据比较
			for(int j=i+1;j<array.length;j++){
				//如果第i位的数据大于第j位的数据，则交换它们
				if(array[i]>array[j]){
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
			System.out.println(Arrays.toString(array));
		}
	}
	public static void main(String[] args) {
		int[] array = new int[]{9,5,23,2,0,21,30,13};
		System.out.println("排序前：\n"+Arrays.toString(array));
		System.out.println("开始排序：");
		SelectSort.selectSort(array);
		System.out.println("排序后：\n"+Arrays.toString(array));
	}
	/*[运行结果]
	 排序前：
	[9, 5, 23, 2, 0, 21, 30, 13]
	开始排序：
	[0, 9, 23, 5, 2, 21, 30, 13]
	[0, 2, 23, 9, 5, 21, 30, 13]
	[0, 2, 5, 23, 9, 21, 30, 13]
	[0, 2, 5, 9, 23, 21, 30, 13]
	[0, 2, 5, 9, 13, 23, 30, 21]
	[0, 2, 5, 9, 13, 21, 30, 23]
	[0, 2, 5, 9, 13, 21, 23, 30]
	排序后：
	[0, 2, 5, 9, 13, 21, 23, 30]
	 */
}
