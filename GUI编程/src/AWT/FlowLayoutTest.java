package AWT;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * ����Flowout���ֹ�����
 * 2016.7.28
 * @author LST
 *
 */
public class FlowLayoutTest {

	public static void main(String[] args) {
		Frame f = new Frame("���Դ���");
		//����FlowLayout���ֹ�����������ʽΪ�������ң�ˮƽ���20����ֱ���5
		f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		for(int i=0;i<10;i++){
			f.add(new Button("��ť"));
			
		}
		f.pack();//�����ڴ�С����Ϊ��Ѵ�С�������Ͳ����ڿ�ƽ̨ʱ�ֶ����ô��ڴ�С
		f.setVisible(true);
	}

}
