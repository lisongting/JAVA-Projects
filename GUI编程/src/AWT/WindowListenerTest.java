package AWT;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * ���Ը������йصĺ���
 * 16.7.30
 * @author LST
 *
 */
public class WindowListenerTest {
	private Frame f= new Frame("����");
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
			ta.append("���ڱ����\n");
		}
  
		@Override
		public void windowClosed(WindowEvent arg0) {
			ta.append("���ڱ��رգ�\n");
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			ta.append("�û��رմ��ڣ�\n");
			System.exit(0);
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			ta.append("����ʧȥ���㣡\n");
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			ta.append("���ڱ��ָ���\n");
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			ta.append("���ڱ���С����\n");
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			ta.append("���ڳ��α��򿪣�\n");
		}
		
	}
	public static void main(String[] args) {
		new WindowListenerTest().init();
	}

}
