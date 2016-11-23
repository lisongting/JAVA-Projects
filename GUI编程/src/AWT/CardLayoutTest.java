package AWT;
/**
 * ����CardLayout����
 * 2016.7.29
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionListener;

public class CardLayoutTest {
	Frame f = new Frame("���Դ���");
	String[] names = {"��һ��","�ڶ���","������","������","������"};
	Panel pl = new Panel();
	public void init(){
		final CardLayout c = new CardLayout();
		pl.setLayout(c);
		for(String s:names){
			pl.add(s,new Button(s));
		}
		Panel p = new Panel();
		ActionListener listener = e->
		{
			switch(e.getActionCommand())
			{
			case"��һ��":
				c.previous(pl);
			break;
			case"��һ��":
				c.next(pl);
				break;
			case"��һ��":
				c.first(pl);
				break;
			case"���һ��":
				c.last(pl);
				break;
			case"������":
				c.show(pl,"������");
				break;
			}
		};//��lambda���ʽ����ActionListener
		//������ʾ��һ�ŵİ�ť
		Button previous = new Button("��һ��");
		previous.addActionListener(listener);
		Button next = new Button("��һ��");
		next.addActionListener(listener);
		Button first = new Button("��һ��");
		first.addActionListener(listener);
		Button last = new Button("���һ��");
		last.addActionListener(listener);
		Button third  = new Button("������");
		third.addActionListener(listener);
		p.add(previous);
		p.add(next);
		p.add(first);
		p.add(third);
		p.add(last);
		f.add(pl);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new CardLayoutTest().init();
	}

}
