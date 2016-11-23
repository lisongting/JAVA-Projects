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
 * 测试用键盘事件来驱动swing组件,
 * 这种方法非常简洁,而无需为Swing组件绑定键盘监听器
 * 16.8.1
 * @author LST
 *
 */
public class BindKeyTest {

	JFrame jf = new JFrame("测试键盘绑定");
	JTextArea jta = new JTextArea(5,30);
	JButton jb = new JButton("发送");
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
		//添加事件监听器
		jb.addActionListener(sendMsg);
		
		//将CTRL+Enter键和"send"关联
		jtf.getInputMap().put(KeyStroke.getKeyStroke('\n',java.awt.event.InputEvent.CTRL_MASK),"send");
		
		//将send和sendMsg Action 关联
		jtf.getActionMap().put("send",sendMsg);//动作映射
		jf.pack();
		jf.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new BindKeyTest().init();
		
	}

}
