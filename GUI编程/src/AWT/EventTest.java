package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 测试awt事件响应机制
 * 16.7.30
 * @author LST
 *
 */
public class EventTest {
	private Frame f = new Frame("测试");
	private Button ok = new Button("确定");
	private TextField tf = new TextField(30);
	public void init(){
		ok.addActionListener(new OKListener());
		f.add(tf);
		f.add(ok,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		
	}
	class OKListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("用户单击了ok按钮");
			tf.setText("Hello World");
		}

	}
	public static void main(String[] args) {
		new EventTest().init();
	}
	
}
