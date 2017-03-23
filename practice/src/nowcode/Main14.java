package nowcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/**
 *  设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *  路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 *  如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *  例如[a b c e s f c s a d e e]是3*4矩阵，其包含字符串"bcced"的路径，
 *  但是矩阵中不包含“abcb”路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 *  路径不能再次进入该格子。
 * @author Administrator
 *
 */
public class Main14 {
	
	//一个网上的递归方法
	public boolean hasPath(char[] matrix,int rows,int cols,char[] str){
		int[] flag = new int[matrix.length];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(helper(matrix,rows,cols,i,j,str,0,flag)){
					return true;
				}
			}
		}
		return false;
	}
	private boolean helper(char[] matrix,int rows,int cols,int i,int j,char[] str,int k,int[]flag){
		int index = i*cols+j;
		if(i<0||i>=rows||j<0||j>=cols||matrix[index]!=str[k]||flag[index]==1){
			return false;
		}
		if(k==str.length-1){
			return true;
		}
		flag[index] = 1;
		if(helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
				||helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
				||helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
				||helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)){
			return true;
		}
		flag[index]=0;
		return false;
	}
	/*自己尝试写的，小的矩阵可以得到正确结果，遇到大的矩阵就不对了
	 * 估计问题是在路径的回溯时出问题了，估计没有把index减少到合适的值
	 * 不知道怎么改
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	{
		int index =0,t=0,i,j;
		int len = str.length;
		boolean hasPath = false;
		char[][] square = new char[rows][cols];
		int[][] arrive = new int[rows][cols];
		Stack<String> stack = new Stack<>();
		if(matrix==null||str==null){
			return false;
		}
		//构造二维数组
		for(i=0;i<rows;i++){
			for(j=0;j<cols;j++){
				square[i][j] = matrix[t++];
			}
		}
		for(i=0;i<rows;i++){
			for(j=0;j<cols;j++){
				if(square[i][j]==str[index]){
					//如果遇到第一个相等的，入栈
					stack.push(new String(square[i][j]+","+i+","+j));
					index++;
					while(!stack.isEmpty()){
						//出栈，取出当前出栈元素的信息，和横纵坐标
						String curString = stack.pop();
						String[] arr = curString.split(",");
						char cur = arr[0].charAt(0);
						int curRow = Integer.parseInt(arr[1]);
						int curCol = Integer.parseInt(arr[2]);
						//当出栈时，表示走一步,将arrive矩阵中相应位置坐标记
						arrive[curRow][curCol]=1;
						
						int oldIndex = index;
						if(curRow>=1){
							char up = square[curRow-1][curCol];
							//如果相等并且没有被走过
							if(up == str[oldIndex] && arrive[curRow-1][curCol]!=1){
								stack.push(new String(up+","+(curRow-1)+","+(curCol)));
								index++;
							}
						}
						if(curRow<=rows-2){
							char down = square[curRow+1][curCol];
							if(down == str[oldIndex] && arrive[curRow+1][curCol]!=1){
								stack.push(new String(down+","+(curRow+1)+","+curCol));
								index++;
							}
						}
						if(curCol>=1){
							char left = square[curRow][curCol-1];
							if(left == str[oldIndex] && arrive[curRow][curCol-1]!=1){
								stack.push(new String(left+","+curRow+","+(curCol-1)));
								index ++;
							}
						}
						if(curCol<=cols-2){
							char right = square[curRow][curCol+1];
							if(right == str[oldIndex] &&arrive[curRow][curCol+1]!=1){
								stack.push(new String(right+","+curRow+","+(curCol+1)));
								index++;
							}
						}
						if(index==str.length){
							hasPath = true;
							return hasPath;
						}
						//如果index还是和oldIndex相等，则说明该条路走不通，即四周都与下一个元素不匹配
						if(index == oldIndex){
							//将arrive中的位置还原为0
							arrive[curRow][curCol] = 0;
						}
					}//while end
				}//if end
				//注意这里index要重置为0
				index = 0;
			}//for i end
		}// for j end
		return hasPath;
	}
	*/
	public static void main(String[] args){
		Main14 m = new Main14();
		//char[] matrix = new char[]{'a','b','c','e','s','f','c','s','a','d','e','e'};
		//char[] str = new char[]{'b','c','c','e','d'};
		//char[] str = new char[]{'f','c','c','e','s','e','q','d','a'};
		//char[] str = new char[]{'e','s','c','f','b','a'};
		char[] matrix = new char[]{'A','B','C','E','H','J','I','G','S','F','C','S','L','O','P','Q','A','D','E','E','M','N','O','E','A','D','I','D','E','J','F','M','V','C','E','I','F','G','G','S'};
		
		//char[] str = new char[]{'a','b','c','b'};
		//char[] str = new char[]{'d','f','c','s'};
		char[] str = new char[]{'S','L','H','E','C','C','E','I','D','E','J','F','G','G','F','I','E'};
		char[] str2 = new char[]{'S','L','H','E','C','C','E','I','D','E','J','F','G','G','F','I','E'};
		Arrays.sort(str);
		Arrays.sort(str2);
		Set<char[]> set = new HashSet<>();
		set.add(str);
		set.add(str2);
		System.out.println(set.size());
		//System.out.println(m.hasPath(matrix, 5, 8, str));
	}
}