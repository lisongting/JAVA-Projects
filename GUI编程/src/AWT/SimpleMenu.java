package AWT;

import java.awt.CheckboxMenuItem;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * ����MenuBar,Menu,MenuItem,TextArea,CheckboxMenuItem��Щ����÷�
 * 16.7.30
 * ��������
 * @author LST
 *	�¼���GET:���ٵ�����Ŀ�ݼ�  ctrl+Shift+o
 */
public class SimpleMenu {
	private Frame f = new Frame("����"); 
	private MenuBar mb = new MenuBar();//�˵������˵�������
	private TextArea ta = new TextArea(10,40);
	Menu file = new Menu("�ļ�");
	Menu edit = new Menu("�༭");
	MenuItem newItem = new MenuItem("�½�");
	MenuItem saveItem = new MenuItem("����");
	MenuItem exitItem = new MenuItem("�˳�",new MenuShortcut(KeyEvent.VK_X));//����Menuexit�˵���,ָ����ݼ�Ϊctrl+X
	CheckboxMenuItem autowrap = new CheckboxMenuItem("�Զ�����");
	MenuItem copyItem = new MenuItem("����");
	MenuItem pasteItem = new MenuItem("ճ��");
	Menu format = new Menu("��ʽ");
	
	//��"��ʽ"ѡ��������µĹ���ѡ��"ע��",���ÿ�ݼ�Ϊctrl +Shift+/
	MenuItem commentItem = new MenuItem("ע��",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem cancelItem = new MenuItem("ȡ��ע��");
	public void init(){
		//��lambda���ʽ������ActionListener
		ActionListener menuListener = e->{
			String cmd = e.getActionCommand();//���getActionCommand ����ȡ�����ǵ����İ�ť������
			ta.append("����"+cmd+"�˵�"+"\n");
			if(cmd.equals("�˳�")){
				System.exit(0);
			}
		};
		
		commentItem.addActionListener(menuListener);//ΪItem����¼�������
		file.addActionListener(menuListener);//���������Ч,�ѵ�ֻ��MenuItem ��������¼���������?
		newItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		file.add(newItem);//Ϊ"�ļ�"�������Ŀ
		file.add(saveItem);//Ϊ"�ļ�"�������Ŀ
		file.add(exitItem);//Ϊ"�ļ�"�������Ŀ
		
		edit.add(autowrap);//Ϊ"�༭"�������Ŀ
		edit.addSeparator();//��Ӳ˵��ָ���
		edit.add(copyItem);
		edit.add(pasteItem);
		format.add(commentItem);//��"ע��"��ӵ�"��ʽ"��ȥ
		format.add(cancelItem); 
		edit.add(new MenuItem("**********"));//ʹ��****��Ϊ�˵��ָ���
		edit.add(format);//��"��ʽ"�ӵ�"�༭"��
		
		//��Menubar�˵����м���"�ļ�"��"�༭" ��Ŀ
		mb.add(file);
		mb.add(edit);
		f.setMenuBar(mb);//��frame������MenuBar
		
		//�������ڲ������ʽ�������ڵ��¼�������,�����رմ���
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		f.add(ta);
		f.pack();
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new SimpleMenu().init();
	}

}
