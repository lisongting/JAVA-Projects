package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

/**
 * ����GridLayout���ֹ�����
 * 2016.7.28
 * @author LST
 *
 */
public class GridLayoutTest {

	public static void main(String[] args) {
		Frame f = new Frame("������");
		Panel p1 = new Panel();
		p1.add(new TextField(30));
		f.add(p1,BorderLayout.NORTH);
		Panel p2 = new Panel();
		//����Panelʹ��GridLayout����
		p2.setLayout(new GridLayout(3,5,4,4));//GridLayout��4������Ϊ�������������������࣬������
		String[] name = {"0","1","2","3","4","5","6","7","8","9","+","-","x","/","."};
		for(String s:name){
			p2.add(new Button(s));
		}
		f.add(p2);
		f.pack();
		f.setVisible(true);
	}

}
