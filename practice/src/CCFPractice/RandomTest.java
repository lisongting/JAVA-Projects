package CCFPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random r = new Random(8);
		int[][] numbers=new int[1000][5];
		File file = new File("bbb.txt");//以当前路径创建一个File
		//System.out.println(file.getName());
		//System.out.println(file.getAbsoluteFile());
		//1.构建随机数组
		for(int i=0;i<1000;i++){
			for(int j =0;j<5;j++){
				numbers[i][j] = Math.abs(r.nextInt()%8)+1;
			}
		}
		
		//将随机数组写入到文件中保存起来
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			OutputStream out = new FileOutputStream(file,true);//true表示以追加的 形式写入数据
			try {
				StringBuilder sb = new StringBuilder();
				int k=0;
				for(int i=0;i<1000;i++){
					for(int j=0;j<5;j++){
						sb.append(numbers[i][j]);
					}
					sb.append("\r\n");
				}
				out.write(sb.toString().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		/*
		InputStream input;
		int[] numbers1 = new int[1000];
		int[][] numbers2 = new int[1000][5];
		try {
			input = new FileInputStream(file);
			FileReader fr = new FileReader(file);
			//File nextFile = new File("next.txt");
			//nextFile.createNewFile();
			//FileWriter out2 = new FileWriter(nextFile);
			char[] cbuf = new char[7];
			int hasread=0;
			int h=0;
			while((hasread = fr.read(cbuf))>0&&h<1000){
				System.out.print(new String(cbuf,0,hasread));
				//out2.write(cbuf,0,hasread);
				StringBuilder b = new StringBuilder();
				for(int i=0;i<5;i++){
					b.append(cbuf[i]);
				}	
				numbers1[h]=Integer.parseInt(b.toString());
				System.out.print("a["+h+"] :"+numbers1[h]);
				for(int j=0;j<5;j++){
					numbers2[h][j]=b.charAt(j)-48;
					System.out.print("bb["+h+"] ["+j+"]:"+numbers2[h][j]);
				}
				System.out.println();
				h++;
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		
		

	}
	
	
	/*
	public void FindNumber(int[]array){
		boolean find =false;
		int length =5;
		int count=5;
		for(int i=0;i<array.length;i++){
			if(array[i]==0)
				count--;
		}//先计算出array中有几个有效位
		if(count==5){
			
		}else if(count==4){
			
		}else if(count==3){
			
		}
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0;i<)
	}
	*/
}
