package CCFPractice;

import java.util.Scanner;

public class test8 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[][] metrix = new int[n][m];
		int[][] inputArray = new int[n][m];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				inputArray[i][j] = input.nextInt();
				metrix[i][j] = inputArray[i][j];
			}
		}
		/*
		if(m>=3){
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					//ǰ���������ʱ���α���󻬶�
					if(j==(m-1)){
						if(metrix[i][j]==metrix[i][j-1]&&metrix[i][j-1]==metrix[i][j-2]){
							metrix[i][j]*=10;
							metrix[i][j-1]*=10;
							metrix[i][j-2]*=10;
							
						}
					
					}
					else if(metrix[i][j]==metrix[i][j+1]){
						boolean flg=false;//��ǣ��Ƿ�������������ȵ�Ԫ��
						for(int k=j+2;k<m;k++){
							if(metrix[i][k]==metrix[i][j]){
								flg =true;
								continue;
							}
							if(flg){
								//�������һ����������
								metrix[i][j] *=10;
								metrix[i][j+1] *=10;
								for(int kk =j+2;kk<k;kk++){
									metrix[i][kk] *=10;//����Щ��ȵ�����Ϊԭ����10�� 
								}
							}
								
						}
							
					}
						
				}
			}
		}
		*/
		if(n>3){
			for(int i=0;i<m;i++){//��
				for(int j=0;j<n;j++){//��
					//ǰ���������ʱ���α���󻬶�
					if(j==(n-1)){
						if(inputArray[j][i]==inputArray[j-1][i]&&inputArray[j-1][i]==inputArray[j-2][i]){
							metrix[j][i]*=10;
							metrix[j-1][i]*=10;
							metrix[j-2][i]*=10;
							
						}
					
					}
					else if(inputArray[j][i]==inputArray[j+1][i]){
						boolean flg=false;//��ǣ��Ƿ�������������ȵ�Ԫ��
						for(int k=j+2;k<n;k++){
							if(inputArray[k][i]==inputArray[j][i]){
								flg =true;
								continue;
							}
							if(flg){
								//�������һ����������
								metrix[j][i] *=10;
								metrix[j+1][i] *=10;
								for(int kk =j+2;kk<k;kk++){
									metrix[kk][i] *=10;//����Щ��ȵ�����Ϊԭ����10�� 
								}
							}
								
						}
							
					}
						
				}
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++)
				System.out.print(metrix[i][j]+" ");
			System.out.println();
		}
	}

}
