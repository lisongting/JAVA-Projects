package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * ����awt�¼���Ӧ����
 * 16.7.30
 * @author LST
 *
 */
public class EventTest {
	private Frame f = new Frame("����");
	private Button ok = new Button("ȷ��");
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
			System.out.println("�û�������ok��ť");
			tf.setText("Hello World");
		}

	}
	public static void main(String[] args) {
		new EventTest().init();
	}
	
}
