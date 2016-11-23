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
 * 测试剪贴板的使用
 * 16.7.31
 * @author LST
 *
 */
public class SimpleClipboard {
	private Frame f = new Frame("测试剪贴板");
	//获取系统剪贴板
	private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	//如果创建本地剪贴板,则使用下面语句:Clipboard clipboard = new Clipboard("cb");cb是剪贴板对象的名称
	
	private TextArea jtaCopyTo = new TextArea(5,20);//用于复制文本的文本框
	private TextArea jtaPaste = new TextArea(5,20);//用于粘贴文本的文本框
	private Button btCopy = new Button("复制");
	private Button btPaste = new Button("粘贴");
	public void init(){
		Panel p = new Panel();
		p.add(btCopy);
		p.add(btPaste);
		
		//为复制和粘贴按钮添加响应
		btCopy.addActionListener(e->{
			StringSelection contents = new StringSelection(jtaCopyTo.getText());
			clipboard.setContents(contents, null);
		});
		btPaste.addActionListener(e->{
			if(clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
				//取出剪贴板中的StringFlavor 内容
				try {
					String content = (String)clipboard.getData(DataFlavor.stringFlavor);
					jtaPaste.append(content);//将复制的内容粘贴到jtaPaste文本框中去
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		Box box = new Box(BoxLayout.X_AXIS);//创建一个水平排列的容器
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
