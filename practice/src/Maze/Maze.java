package Maze;

import java.util.Scanner;
import java.util.Stack;

public class Maze {
	private int rows,cols,badPoint;
	private int[][] store;//��������Թ���??
	private int time=0;//ʱ��
	private Stack mazeStack = new Stack();//������Ÿ��ӵ�ջ
	private MazeCell[] dangerGroup ;//�������Σ�յ������
	private MazeCell[][] mazeGroup;//��������Թ��������и��Ӷ���
	private MazeCell currentCell,entryCell,exitCell;
	
	public void play(){
		Scanner input = new Scanner(System.in);
		rows = input.nextInt();
		cols = input.nextInt();
		badPoint = input.nextInt();
		dangerGroup = new MazeCell[badPoint];
		int c=0;
		while(input.hasNextLine()){//����Σ�յ㼯��
			int row = input.nextInt()-1;
			int col = input.nextInt()-1;
			int start = input.nextInt();
			int end = input.nextInt();
			dangerGroup[c] = new MazeCell(row,col,start,end);
			mazeGroup[row][col] = dangerGroup[c];//����ЩΣ�յ���뵽mazeGroup��
			c++;
		}
		//�������и��Ӷ���������ʼ��
		mazeGroup = new MazeCell[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				if(mazeGroup[i][j]!=null){//���mazeGroup���Ѿ�������Σ�յ㣬������
					continue;
				}
				else
					mazeGroup[i][j] = new MazeCell(i,j);//���û�е㣬�����
				
			}
		}
	}
	
	public void pushUnvisited(int row,int col){
		if(!mazeGroup[row][col].isDanger()){
			mazeStack.push(mazeGroup[row][col]);
		}
	}
	
	//��Ѱ���ڹ���
	public void exitMaze(){
		currentCell = entryCell=mazeGroup[0][0];
		exitCell = mazeGroup[rows-1][cols-1];
		
	}

	
	//�ڲ��ࣺ�����еĵ�
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
