package sort;

import java.util.Arrays;

/**
 * 折半插入排序
 * （属于插入排序）
 * 时间复杂度：O(n*n) 
 * 空间复杂度:O(1)
 * 稳定性：稳定
 * [分析]是直接插入排序算法的改进，
 * 每次都将有序区折半，查找存放cursor的合适位置
 * 这样可以加快查找速度
 * @author Administrator
 */
public class HalfInsertSort {
	
	public static void halfInsertSort(int[] array){
		for(int i=1;i<array.length;i++){
			int cursor = array[i];
			//有序区的左边界0，右边界i-1
			int low = 0;
			int high = i-1;
			//将有序区折半
			while(low <= high){
				//将有序区折半，查找存放cursor的合适位置	
				int mid = (low+high)/2;
				//如果cursor比分界元素大，则在右半区域查找
				if(cursor>array[mid]){
					low = mid+1;
				}else{
					high = mid-1;
				}
			}
			//将low到i的元素整体右移一位
			for(int j= i;j>low;j--){
				array[j] = array[j-1];
			}
			//low处的元素是有序区中刚好大于等于cursor的数的位置
			array[low] = cursor;
			System.out.println(Arrays.toString(array)+"low:"+low);
		}
	}
	public static void main(String[] args) {
		int[] array = new int[]{9,5,23,2,0,21,30,13};
		System.out.println("排序前：\n"+Arrays.toString(array));
		System.out.println("开始排序：");
		halfInsertSort(array);
		System.out.println("排序后：\n"+Arrays.toString(array));
	}
	/**[运行结果]
	排序前：
	[9, 5, 23, 2, 0, 21, 30, 13]
	开始排序：
	[5, 9, 23, 2, 0, 21, 30, 13]low:0
	[5, 9, 23, 2, 0, 21, 30, 13]low:2
	[2, 5, 9, 23, 0, 21, 30, 13]low:0
	[0, 2, 5, 9, 23, 21, 30, 13]low:0
	[0, 2, 5, 9, 21, 23, 30, 13]low:4
	[0, 2, 5, 9, 21, 23, 30, 13]low:6
	[0, 2, 5, 9, 13, 21, 23, 30]low:4
	排序后：
	[0, 2, 5, 9, 13, 21, 23, 30]
	 */
}
