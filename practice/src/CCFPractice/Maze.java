  package CCFPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Stack;
/**
 * ��������Թ�
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
		System.out.println("�밴������ĸ�ʽ�����Թ���"+"�ַ���ʽ:\nm - entry\ne - exit\n1 wall\n0 - passage\n"+
							"ÿ������һ�У������Ͱ�ctrl+Z");
		try{
			String str = buffer.readLine();
			while(str!=null){
				row++;
				cols = str.length();//�������ڸ��е��ַ�������
				str = "1"+str+"1";//ÿһ�е���β��1Χ����
				mazeRows.push(str);
				//���ó��ڵ�����//���ĳһ������exit��������exitCell������.���û��exit��᷵��-1
				if(-1!=str.indexOf(exitMarker)){
					exitCell.x= row;
					exitCell.y= str.indexOf(exitMarker);
				}
				//������ʼ�������..indexOf���洫��int���Ƚ�����ascII��ֵ
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
		store[0] = new char[cols+2];//java�еĶ�ά������Բ��Ǿ��εġ�����ֻ��������store��һ�е�����
		//��֮ǰ����Stack����������ε�����
		for(;!mazeRows.isEmpty();row--){
			store[row] = ((String)mazeRows.pop()).toCharArray();
		}
		store[rows+1] = new char[cols+2];//store�����һ��
		for(int i=0;i<cols+2;i++){
			store[0][i]=wall;
			store[rows+1][i]=wall;//��store������������ж���ǽΧ����
		}
		
	}
	private void display(PrintStream out){
		for(int i=0;i<rows+2;i++)
			out.println(store[i]);
		out.println();
	}
	private void pushUnvisited(int row,int col){
		if(store[row][col]==passage||store[row][col]==exitMarker){//����õ���ͨ�����߳��ڣ�����ջ
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
			if(!currentCell.equals(entryCell))//�����ǰ�㲻����ڵ㣬��ѵ�ǰ����Ϊ�ѷ��ʹ�
				store[row][col] = visited;
				pushUnvisited(row-1,col);
				pushUnvisited(row+1,col);
				pushUnvisited(row,col-1);
				pushUnvisited(row,col+1);//���������ҵĵ����μ��뵽ջ��
				if(mazeStack.isEmpty()){
					display(out);
					out.println("ʧ�ܣ���tm�Ǹ�����ͬ��");
					return;
				}
				else
					//ջ��������Object����Ԫ�ض���ȥ֮��Stack�ͻ�����Ԫ�����ͣ��������Ҫ����ǿ��ת��һ��
					currentCell = (MazeCell) mazeStack.pop();
		}
		display(out);
		out.println("�ɹ�");
	}
	public static void main(String[] args) {
		new Maze().exitMaze(System.out);
	}

}
