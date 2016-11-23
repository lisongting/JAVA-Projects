  package CCFPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Stack;
/**
 * 逃离矩阵迷宫
 * 116.8.4
 * @author LST
 *
 */
public class Maze {
	private int rows =0,cols = 0;
	private char[][] store ;
	private MazeCell currentCell,exitCell= new MazeCell(),entryCell = new MazeCell();
	private final char exitMarker = 'e',entryMarker = 'm',visited= '.';
	private final char passage = '0',wall = '1';
	private Stack mazeStack = new Stack();
	
	public class MazeCell {
		public int x,y;
		public MazeCell(){};
		public MazeCell(int i,int j){
			x= i;
			y= j;
		}
		public boolean equals(MazeCell cell){
			return x==cell.x && y == cell.y;
		}
	}
	public Maze(){
		int row=0,col= 0;
		Stack mazeRows = new Stack();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(isr);
		System.out.println("请按照下面的格式输入迷宫："+"字符样式:\nm - entry\ne - exit\n1 wall\n0 - passage\n"+
							"每次输入一行；结束就按ctrl+Z");
		try{
			String str = buffer.readLine();
			while(str!=null){
				row++;
				cols = str.length();//列数等于该行的字符串长度
				str = "1"+str+"1";//每一行的首尾用1围起来
				mazeRows.push(str);
				//设置出口的坐标//如果某一行中有exit，则设置exitCell的坐标.如果没有exit则会返回-1
				if(-1!=str.indexOf(exitMarker)){
					exitCell.x= row;
					exitCell.y= str.indexOf(exitMarker);
				}
				//设置起始点的坐标..indexOf里面传入int则会比较它的ascII码值
				if(-1!=str.indexOf(entryMarker)){
					entryCell.x= row;
					entryCell.y= str.indexOf(entryMarker);
				}
				str = buffer.readLine();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		rows = row;
		store = new char[rows+2][];
		store[0] = new char[cols+2];//java中的二维数组可以不是矩形的。此行只是设置了store第一行的列数
		//把之前存在Stack里面的行依次弹出来
		for(;!mazeRows.isEmpty();row--){
			store[row] = ((String)mazeRows.pop()).toCharArray();
		}
		store[rows+1] = new char[cols+2];//store的最后一行
		for(int i=0;i<cols+2;i++){
			store[0][i]=wall;
			store[rows+1][i]=wall;//把store矩阵的上下两行都用墙围起来
		}
		
	}
	private void display(PrintStream out){
		for(int i=0;i<rows+2;i++)
			out.println(store[i]);
		out.println();
	}
	private void pushUnvisited(int row,int col){
		if(store[row][col]==passage||store[row][col]==exitMarker){//如果该点是通道或者出口，则入栈
			mazeStack.push(new MazeCell(row,col));
		}
	}
	public void exitMaze(PrintStream out){
		currentCell = entryCell;
		out.println();
		while(!currentCell.equals(exitCell)){
			int row = currentCell.x;
			int col = currentCell.y;
			display(System.out);
			if(!currentCell.equals(entryCell))//如果当前点不是入口点，则把当前点标记为已访问过
				store[row][col] = visited;
				pushUnvisited(row-1,col);
				pushUnvisited(row+1,col);
				pushUnvisited(row,col-1);
				pushUnvisited(row,col+1);//把上下左右的点依次加入到栈中
				if(mazeStack.isEmpty()){
					display(out);
					out.println("失败，这tm是个死胡同啊");
					return;
				}
				else
					//栈里面存的是Object，把元素丢进去之后Stack就会忘记元素类型，因此这里要类型强制转换一下
					currentCell = (MazeCell) mazeStack.pop();
		}
		display(out);
		out.println("成功");
	}
	public static void main(String[] args) {
		new Maze().exitMaze(System.out);
	}

}
