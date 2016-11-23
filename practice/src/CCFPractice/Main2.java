package CCFPractice;

import java.util.*; 
/**
 * 计算直方图中最大矩形（答案代码）
 * 这个代码看不明白
 * @author LST
 *
 */
public class Main2 { 
	 public static void main(String[] args) { 
	 new Main2().run(); 
	 } 
	 
	 public void run() { 
		 Scanner fin = new Scanner(System.in); 
		 int N = fin.nextInt(); 
		 int[] height = new int[N]; 
		 for (int i = 0; i < N; ++i) height[i] = fin.nextInt(); 
		 
		 int result = 0; 
		 for (int i = 0; i < N; ++i) { 
			 int width = 1; 
			 for (int j = i - 1; j >= 0; --j) { 
				 if (height[j] < height[i]) break; 
				 ++width; 
			 } 
			 for (int j = i + 1; j < N; ++j) { 
				 if (height[j] < height[i]) break; 
				 ++width; 
			 } 
			 int area = width * height[i]; 
			 result = Math.max(result, area); 
		} 
		 System.out.println(result); 
		} 
} /*在横轴上放了n个相邻的矩形，每个矩形的宽度是1，而第i（1 ≤ i ≤ n）个矩形的高度是hi。这n个矩形构成了一个直方图。例如，下图中六个矩形的高度就分别是3, 1, 6, 5, 2, 3。
找出能放在给定直方图里面积最大的矩形，它的边要与坐标轴平行。对于上面给出的例子，最大矩形如下图所示的阴影部分，面积是10*/

