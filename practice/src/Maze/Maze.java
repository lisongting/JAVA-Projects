package Maze;

import java.util.Scanner;
import java.util.Stack;

public class Maze {
	private int rows,cols,badPoint;
	private int[][] store;//存放整个迷宫盘??
	private int time=0;//时间
	private Stack mazeStack = new Stack();//用来存放格子的栈
	private MazeCell[] dangerGroup ;//用来存放危险点的数组
	private MazeCell[][] mazeGroup;//用来存放迷宫盘上所有格子对象
	private MazeCell currentCell,entryCell,exitCell;
	
	public void play(){
		Scanner input = new Scanner(System.in);
		rows = input.nextInt();
		cols = input.nextInt();
		badPoint = input.nextInt();
		dangerGroup = new MazeCell[badPoint];
		int c=0;
		while(input.hasNextLine()){//构建危险点集合
			int row = input.nextInt()-1;
			int col = input.nextInt()-1;
			int start = input.nextInt();
			int end = input.nextInt();
			dangerGroup[c] = new MazeCell(row,col,start,end);
			mazeGroup[row][col] = dangerGroup[c];//把这些危险点加入到mazeGroup中
			c++;
		}
		//构建所有格子对象并且做初始化
		mazeGroup = new MazeCell[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(mazeGroup[i][j]!=null){//如果mazeGroup中已经加入了危险点，则跳过
					continue;
				}
				else
					mazeGroup[i][j] = new MazeCell(i,j);//如果没有点，则添加
				
			}
		}
	}
	
	public void pushUnvisited(int row,int col){
		if(!mazeGroup[row][col].isDanger()){
			mazeStack.push(mazeGroup[row][col]);
		}
	}
	
	//找寻出口过程
	public void exitMaze(){
		currentCell = entryCell=mazeGroup[0][0];
		exitCell = mazeGroup[rows-1][cols-1];
		
	}

	
	//内部类：格子中的点
	public class MazeCell{
		private int x,y;
		private int badStart=-1,badEnd=-1;
		public MazeCell(){};
		public MazeCell(int i,int j){
				x= i;y= j;
		}
		public MazeCell(int i,int j,int s,int e){
			x=i;y=j;badStart = s;badEnd =e;
				
		}
		public boolean equals(MazeCell cell){
			if(cell.x==x&&cell.y==y&&cell.badStart==badStart&&cell.badEnd==badEnd)
				return true;
			else
				return false;
		}
		public boolean isDanger(){
			if(time>=badStart&&time<=badEnd)
				return true;
			else
				return false;
		}
		
	}
	public static void main(String[] args) {
		new Maze().play();
	}

}
