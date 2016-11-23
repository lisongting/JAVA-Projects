package CCFPractice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**将数据文件txt转换为string的二维数组存储起来,方便下一步处理,构建sql语句
 * {安卓开发app}
 *  fe_Ada_艾达……快乐的美丽的_11541
	fe_Adela_爱得拉……尊贵的 优雅的_63762
	fe_Adelaide_爱得莱德……高贵的 高贵阶级的_55668
	fe_Afra_阿芙拉……尘土_16422
	fe_Agatha_爱盖莎……善良而美好的_64187
	fe_Agnes_爱葛妮丝……纯洁 高雅 贞节_72788
	fe_Alberta_爱尔柏塔……高贵显赫的_77368
	以下划线作为分隔符
 * @author Administrator
 *
 */
public class RandomTest2 {

	public static void main(String[] args) {
		String [][] s = new String[7][4];
		try {
			FileReader freader = new FileReader("data.txt");
			BufferedReader bufferedReader = new BufferedReader(freader);
			String tmp = null;
			try {
				int h=0;
				while((tmp=bufferedReader.readLine())!=null){
					System.out.println(tmp);
					s[h]=tmp.split("_");
					h++;
				}
				System.out.println();
				for(int i=0;i<7;i++){
					for(int j=0;j<4;j++){
						System.out.print(s[i][j]+"  ");
					}
					System.out.println();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
