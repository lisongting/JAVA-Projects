package CCFPractice;

import java.util.Scanner;
/***
 * ������Ķ���˹�����½��㷨���ѷ��鶼�ֳ��������ˡ�
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
		
		int col=0;//j��block�е��к�,��ʼΪ0
		for(int i=start-1;i<start+3;i++){//ÿһ��ѭ���ƶ�һ������
			int stopFlag = -1;//metrix�е�i�д������µĵ�һ��1λ��
			int lastOne = -1; //block�е�col�����һ��1��λ��
			for(int k=0;k<15;k++){//�ھ���i�У����������ҵ���һ��1��λ��
				if(1==metrix[k][i]){
					stopFlag = k;
					break;//ִ�������������ѭ��
				}
				if(k==14&&stopFlag==-1){//�������û��1�����stopFlag=15
					stopFlag =15; 
				}
			}
			
			for(int m=3;m>=0;m--){//��block  ��1���������һ��1��λ��
				if(1==block[m][col]){
					lastOne = m;
					break;
				}
				if(m==0&&lastOne==-1){//�������û��1�����lastOne=-2,��ʾ�����metrix����κ�Ӱ��
					lastOne=-2;
				}
			}
			
			//block����Ĺ���
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
		
		//������
		for(int i1=0;i1<15;i1++){
			for(int j1=0;j1<10;j1++){
				System.out.print(metrix[i1][j1]+" ");
			}
			System.out.println();
		}
	}
}