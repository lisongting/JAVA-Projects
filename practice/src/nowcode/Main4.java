package nowcode;

import java.util.ArrayList;
/**
 * 顺时针打印数列
 * @author Administrator
 *
 */
public class Main4 {
	public void go(ArrayList<Integer> list,int[][] arr,int a,int b,int c,int d){
		if(a==c && b==d){
			list.add(arr[a][b]);
			return ;
		}else if(a>c || b>d){
			return;
		}else{
			//右
			for(int i=b;i<d;i++){
				list.add(arr[a][i]);
			}
			//下
			for(int i=a;i<c;i++){
				list.add(arr[i][d]);
			}
			//往左走
			for(int i=d;i>b;i--){
				list.add(arr[c][i]);
			}
			//往上走，注意这里要少一个
			for(int i=c;i>a;i--){
				list.add(arr[i][b]);
			}
		}
		
	}
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		ArrayList<Integer> list = new ArrayList<>();
		if(row==0 || col==0){
			return null;
		}
		//如果只有一行
		if(row ==1){
			for(int i=0;i<col;i++){
				list.add(matrix[0][i]);
			}
		}
		//如果只有一列
		if(col==1){
			for(int i=0;i<col;i++){
				list.add(matrix[i][0]);
			}
		}
		for(int i=0,j=0 ;i<row && j<col; i++,j++){
			int a = i;
			int b = i;
			int c = row -(i+1);
			int d = col -(i+1);
			
				go(list,matrix,a,b,c,d);				
			
		}
		return list;
    }
	public static void main(String[] args) {
		int n = 5;
		for(int i=0;i<n;i++){
			n = 10;
			System.out.println(i);
		}

	}


}

