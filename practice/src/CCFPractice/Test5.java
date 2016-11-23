package CCFPractice;

import java.util.Scanner;
/***
 * 有问题的俄罗斯方块下降算法。把方块都分成条处理了。
 * @author LST
 *
 */
public class Test5{
	
	
	public static void main(String[] args){
		int[][] metrix = new int[15][10];
		int[][] block = new int[4][4];
		int start;
		Scanner input = new Scanner(System.in);
		for(int i=0;i<15;i++){
			for(int j=0;j<10;j++){
				metrix[i][j] = input.nextInt();
			}
		}
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				block[i][j] = input.nextInt();
			}
		}
		start = input.nextInt();
		
		int col=0;//j是block中的列号,初始为0
		for(int i=start-1;i<start+3;i++){//每一个循环移动一个竖条
			int stopFlag = -1;//metrix中第i列从上往下的第一个1位置
			int lastOne = -1; //block中第col列最后一个1的位置
			for(int k=0;k<15;k++){//在矩阵i列，从上往下找到第一个1的位置
				if(1==metrix[k][i]){
					stopFlag = k;
					break;//执行了这个就跳出循环
				}
				if(k==14&&stopFlag==-1){//如果该列没有1，则把stopFlag=15
					stopFlag =15; 
				}
			}
			
			for(int m=3;m>=0;m--){//在block  第1列中找最后一个1的位置
				if(1==block[m][col]){
					lastOne = m;
					break;
				}
				if(m==0&&lastOne==-1){//如果该列没有1，则把lastOne=-2,表示不会对metrix造成任何影响
					lastOne=-2;
				}
			}
			
			//block降落的过程
			if(lastOne==-2){
				col++;
				continue;
			}
			else if(lastOne!=-1&&lastOne!=-2){
				int fill = stopFlag-1;
				for(int a=lastOne;a>=0;a--){
					metrix[fill][i] = block[a][col];
					fill--;
				}
				col++;
			}
		}
		
		//结果输出
		for(int i1=0;i1<15;i1++){
			for(int j1=0;j1<10;j1++){
				System.out.print(metrix[i1][j1]+" ");
			}
			System.out.println();
		}
	}
}