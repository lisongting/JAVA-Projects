package AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;

/**
 * ����panel��ScrollPane
 * 2016.7.28
 * @author LST
 *
 */
public class PanelTest {

	public static void main(String[] args) {
		Frame f = new Frame("���Դ���");
		
//		Panel p = new Panel();
		//Panelʹ��FlowLayout���ֹ�����
//		p.add(new TextField(30));
//		p.add(new Button("������"));
//		//��panel������ӵ�Frame��
//		f.add(p);
//		f.setBounds(30, 30, 500, 300);
//		f.setVisible(true);
		
		
		//����һ��������������ָ�����Ǿ��й�����
		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		sp.add(new TextField(20));
		//��ΪScrollPaneʹ����BorderLayout���ֹ�����������ֻ��һ���������ʾ�˳�����TextField������
		sp.add(new Button("����"));//һ���޴�İ�ť�������²�
		f.add(sp);
		f.setBounds(30, 30, 500, 300);
		f.setVisible(true);
		
	}

}
