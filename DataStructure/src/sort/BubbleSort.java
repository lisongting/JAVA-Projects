package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * （属于交换排序）
 * 时间复杂度：O(n*n) 
 * 空间复杂度:O(1)
 * 稳定性：稳定
 * [分析]最慢，效率最低的排序算法
 * @author Administrator
 */
public class BubbleSort {
	public static void bubbleSort(int[] array){
		System.out.println("开始排序：");
		for(int i=0;i<array.length-1; i++){
			//该flag用来标记某一趟是否经过了元素交换
			boolean flag = false;
			for(int j=0;j<array.length-1-i; j++){
				//如果一个元素比它后面的一个大
				if(array[j] > array[j+1]){
					int tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
					flag = true;
				}
			}
			System.out.println(Arrays.toString(array));
			//如果某一趟中元素没有交换，则说明数组已经有序
			//为提高效率，则直接退出
			if(!flag){
				break;
			}
		}
	}
	public static void main(String[] args) {
		int[] array = new int[]{5,10,3,29,12,52,36,25};
		System.out.println("排序前：");
		System.out.println(Arrays.toString(array));
		BubbleSort.bubbleSort(array);
		System.out.println("排序后：");
		System.out.println(Arrays.toString(array));	
	}
	/**[运行结果]
	 * 排序前：
	 * [5, 10, 3, 29, 12, 52, 36, 25]
	 * 开始排序：
	 * [5, 3, 10, 12, 29, 36, 25, 52]
	 * [3, 5, 10, 12, 29, 25, 36, 52]
	 * [3, 5, 10, 12, 25, 29, 36, 52]
	 * [3, 5, 10, 12, 25, 29, 36, 52]
	 * 排序后：
	 * [3, 5, 10, 12, 25, 29, 36, 52]
	 */
}
