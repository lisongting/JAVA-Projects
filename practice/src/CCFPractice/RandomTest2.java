package CCFPractice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**�������ļ�txtת��Ϊstring�Ķ�ά����洢����,������һ������,����sql���
 * {��׿����app}
 *  fe_Ada_��������ֵ�������_11541
	fe_Adela_�������������� ���ŵ�_63762
	fe_Adelaide_�������¡����߹�� �߹�׼���_55668
	fe_Afra_��ܽ����������_16422
	fe_Agatha_����ɯ�������������õ�_64187
	fe_Agnes_������˿�������� ���� ���_72788
	fe_Alberta_�������������߹��Ժյ�_77368
	���»�����Ϊ�ָ���
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
