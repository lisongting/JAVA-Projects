package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;

/**
 * 测试GridLayout布局管理器
 * 2016.7.28
 * @author LST
 *
 */
public class GridLayoutTest {

	public static void main(String[] args) {
		Frame f = new Frame("计算器");
		Panel p1 = new Panel();
		p1.add(new TextField(30));
		f.add(p1,BorderLayout.NORTH);
		Panel p2 = new Panel();
		//设置Panel使用GridLayout布局
		p2.setLayout(new GridLayout(3,5,4,4));//GridLayout的4个参数为：行数，列数，横向间距，纵向间距
		String[] name = {"0","1","2","3","4","5","6","7","8","9","+","-","x","/","."};
		for(String s:name){
			p2.add(new Button(s));
		}
		f.add(p2);
		f.pack();
		f.setVisible(true);
	}

}
