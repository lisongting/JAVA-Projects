package sort;

import java.util.Arrays;

/**
 * 希尔排序
 * （属于插入排序）
 * 时间复杂度：平均O(nlogn)^2   最坏O(n*n) 
 * 空间复杂度:O(1)
 * 稳定性：不稳定
 * [分析]
 * Shell排序是递减增量排序法：先比较距离较远的元素，再比较距离较近的元素
 * 每次间隔gap的距离
 * 直接插入排序相当于增量为1的希尔排序
 * @author Administrator
 */
public class ShellSort {
	public static void shellSort(int[] array){
		//gap变量保存可变增量
		int gap = 1;
		//由Knuth提出的经验公式：gap = gap*3+1
		//按照3*gap+1得到增量序列的最大值
		while(gap <= array.length/3){
			gap = gap*3+1;
		}
		while(gap>0){
			System.out.println("gap的值："+gap);
			for(int i=gap;i<array.length;i++){
				int tmp = array[i];
				//array[i-gap]是有序区的最大值
				//这个“有序区"是不连续的，每个元素之间相隔gap
				if(array[i] < array[i-gap]){
					int j = i-gap;
					//j每次减少gap的距离
					for(; j>=0 && array[j]>tmp; j-=gap){
						//将"有序区"中的元素依次向后移动
						array[j+gap] = array[j];
					}
					array[j+gap] = tmp;
				}
				System.out.println(Arrays.toString(array));
			}
			//gap按照Knuth的经验公式逐渐减小
			gap = (gap-1)/3;
		}	
	}
	public static void main(String[] args) {
		int[] array = new int[]{9,5,23,2,0,21,30,13};
		System.out.println("排序前：\n"+Arrays.toString(array));
		System.out.println("开始排序：");
		shellSort(array);
		System.out.println("排序后：\n"+Arrays.toString(array));
	}
	/**[运行结果]
	 排序前：
	[9, 5, 23, 2, 0, 21, 30, 13]
	开始排序：
	gap的值：4
	[0, 5, 23, 2, 9, 21, 30, 13]
	[0, 5, 23, 2, 9, 21, 30, 13]
	[0, 5, 23, 2, 9, 21, 30, 13]
	[0, 5, 23, 2, 9, 21, 30, 13]
	gap的值：1
	[0, 5, 23, 2, 9, 21, 30, 13]
	[0, 5, 23, 2, 9, 21, 30, 13]
	[0, 2, 5, 23, 9, 21, 30, 13]
	[0, 2, 5, 9, 23, 21, 30, 13]
	[0, 2, 5, 9, 21, 23, 30, 13]
	[0, 2, 5, 9, 21, 23, 30, 13]
	[0, 2, 5, 9, 13, 21, 23, 30]
	排序后：
	[0, 2, 5, 9, 13, 21, 23, 30]
	 */
}
