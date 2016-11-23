package AWT;
/**
 * 测试CardLayout布局
 * 2016.7.29
 */
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionListener;

public class CardLayoutTest {
	Frame f = new Frame("测试窗口");
	String[] names = {"第一张","第二张","第三张","第四张","第五张"};
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
			case"上一张":
				c.previous(pl);
			break;
			case"下一张":
				c.next(pl);
				break;
			case"第一张":
				c.first(pl);
				break;
			case"最后一张":
				c.last(pl);
				break;
			case"第三张":
				c.show(pl,"第三张");
				break;
			}
		};//用lambda表达式创建ActionListener
		//控制显示上一张的按钮
		Button previous = new Button("上一张");
		previous.addActionListener(listener);
		Button next = new Button("下一张");
		next.addActionListener(listener);
		Button first = new Button("第一张");
		first.addActionListener(listener);
		Button last = new Button("最后一张");
		last.addActionListener(listener);
		Button third  = new Button("第三张");
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
