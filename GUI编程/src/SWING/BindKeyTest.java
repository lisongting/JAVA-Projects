package SWING;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
/**
 * �����ü����¼�������swing���,
 * ���ַ����ǳ����,������ΪSwing����󶨼��̼�����
 * 16.8.1
 * @author LST
 *
 */
public class BindKeyTest {

	JFrame jf = new JFrame("���Լ��̰�");
	JTextArea jta = new JTextArea(5,30);
	JButton jb = new JButton("����");
	JTextField jtf  = new JTextField(15);
	
	public void init(){
		jf.add(jta);
		JPanel jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jf.add(jp,BorderLayout.SOUTH);
		
		Action sendMsg = new AbstractAction(){
			public void actionPerformed(ActionEvent e)
			{
				jta.append(jtf.getText()+"\n");
				jtf.setText("");
			}
		};
		//����¼�������
		jb.addActionListener(sendMsg);
		
		//��CTRL+Enter����"send"����
		jtf.getInputMap().put(KeyStroke.getKeyStroke('\n',java.awt.event.InputEvent.CTRL_MASK),"send");
		
		//��send��sendMsg Action ����
		jtf.getActionMap().put("send",sendMsg);//����ӳ��
		jf.pack();
		jf.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BindKeyTest().init();
		
	}

}
