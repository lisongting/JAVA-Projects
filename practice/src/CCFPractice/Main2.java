package CCFPractice;

import java.util.*; 
/**
 * ����ֱ��ͼ�������Σ��𰸴��룩
 * ������뿴������
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
} /*�ں����Ϸ���n�����ڵľ��Σ�ÿ�����εĿ����1������i��1 �� i �� n�������εĸ߶���hi����n�����ι�����һ��ֱ��ͼ�����磬��ͼ���������εĸ߶Ⱦͷֱ���3, 1, 6, 5, 2, 3��
�ҳ��ܷ��ڸ���ֱ��ͼ��������ľ��Σ����ı�Ҫ��������ƽ�С�����������������ӣ�����������ͼ��ʾ����Ӱ���֣������10*/

