package AWT;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * 测试跟窗口有关的函数
 * 16.7.30
 * @author LST
 *
 */
public class WindowListenerTest {
	private Frame f= new Frame("测试");
	private TextArea ta = new TextArea(6,40);
	public void init(){
		f.addWindowListener(new MyListener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	class MyListener implements WindowListener{

		@Override
		public void windowActivated(WindowEvent arg0) {
			ta.append("窗口被激活！\n");
		}
  
		@Override
		public void windowClosed(WindowEvent arg0) {
			ta.append("窗口被关闭！\n");
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			ta.append("用户关闭窗口！\n");
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			ta.append("窗口失去焦点！\n");
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			ta.append("窗口被恢复！\n");
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			ta.append("窗口被最小化！\n");
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			ta.append("窗口初次被打开！\n");
		}
		
	}
	public static void main(String[] args) {
		new WindowListenerTest().init();
	}

}
