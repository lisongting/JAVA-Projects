package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
/**
 * ���Լ������ʹ��
 * 16.7.31
 * @author LST
 *
 */
public class SimpleClipboard {
	private Frame f = new Frame("���Լ�����");
	//��ȡϵͳ������
	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	//����������ؼ�����,��ʹ���������:Clipboard clipboard = new Clipboard("cb");cb�Ǽ�������������
	
	private TextArea jtaCopyTo = new TextArea(5,20);//���ڸ����ı����ı���
	private TextArea jtaPaste = new TextArea(5,20);//����ճ���ı����ı���
	private Button btCopy = new Button("����");
	private Button btPaste = new Button("ճ��");
	public void init(){
		Panel p = new Panel();
		p.add(btCopy);
		p.add(btPaste);
		
		//Ϊ���ƺ�ճ����ť�����Ӧ
		btCopy.addActionListener(e->{
			StringSelection contents = new StringSelection(jtaCopyTo.getText());
			clipboard.setContents(contents, null);
		});
		btPaste.addActionListener(e->{
			if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
				//ȡ���������е�StringFlavor ����
				try {
					String content = (String)clipboard.getData(DataFlavor.stringFlavor);
					jtaPaste.append(content);//�����Ƶ�����ճ����jtaPaste�ı�����ȥ
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		Box box = new Box(BoxLayout.X_AXIS);//����һ��ˮƽ���е�����
		box.add(jtaCopyTo);
		box.add(jtaPaste);
		f.add(p,BorderLayout.SOUTH);
		f.add(box);
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new SimpleClipboard().init();
	}

}
