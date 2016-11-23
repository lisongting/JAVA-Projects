package AWT;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;

/**
 * 测试panel和ScrollPane
 * 2016.7.28
 * @author LST
 *
 */
public class PanelTest {

	public static void main(String[] args) {
		Frame f = new Frame("测试窗口");
		
//		Panel p = new Panel();
		//Panel使用FlowLayout布局管理器
//		p.add(new TextField(30));
//		p.add(new Button("点这里"));
//		//将panel容器添加到Frame中
//		f.add(p);
//		f.setBounds(30, 30, 500, 300);
//		f.setVisible(true);
		
		
		//创建一个滚动条容器，指定总是具有滚动条
		ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		sp.add(new TextField(20));
		//因为ScrollPane使用了BorderLayout布局管理器，所以只有一个组件被显示了出来，TextField不见了
		sp.add(new Button("点我"));//一个巨大的按钮，无力吐槽
		f.add(sp);
		f.setBounds(30, 30, 500, 300);
		f.setVisible(true);
		
	}

}
