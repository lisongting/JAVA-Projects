package SWING;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
/**
 * ����JTabbedPane��ʹ��
 * 16.8.4
 * @author LST
 *
 */
public class JTabbedPaneTest {
	JFrame jf = new JFrame("����Tab����");
	//����һ��Tabҳ��ı�ǩ��������,���û��в��ֲ��Ե�JTabbedPane		
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.WRAP_TAB_LAYOUT);
	ImageIcon icon = new ImageIcon("ico/close.gif");
	String[] layouts = {"���в���","����������"};
	String[] position = {"���","����","�ұ�","�ײ�"};
	Map<String,String> books = new LinkedHashMap<>(); 
	
	
	public void init(){
			books.put("���java����", "java.png");
			books.put("������javaEE��ҵӦ��", "ee.png");
			books.put("���ajax����", "ajax.png");
			books.put("���׿����", "android.png");
			books.put("����javaEE��ҵӦ��ʵս", "classic.png");
			String tip ="�ɿ�������ķ�����Ƭ"; 
			//��JTabbedPane �����5����ǩҳ,ָ���˱���,ͼ�����ʾ
			//���ñ�ǩ�����Ϊnull
			for(String bookName:books.keySet()){
				tabbedPane.addTab(bookName, icon, null, tip);
			}
			jf.add(tabbedPane);
			
			//ΪJTabbedPane ����¼�������
			tabbedPane.addChangeListener(e->{
				//�����ѡ��������Ȼ�ǿ�
				if(tabbedPane.getSelectedComponent()==null){
					//��ȡ��ѡ��ǩҳ
					int n = tabbedPane.getSelectedIndex();
					//Ϊָ����ǩҳ��������
					loadTab(n);
				}
			});
					
			//ϵͳĬ��ѡ���һҳ,���ص�һҳ������
			loadTab(0);
			tabbedPane.setPreferredSize(new Dimension(500,300));
			//��ӿ��Ʊ�ǩ����,��ǩλ�õĵ�ѡ��ť
			JPanel buttonPanel = new JPanel();
			ChangeAction action = new ChangeAction();
			buttonPanel.add(new ButtonPanel(action,"ѡ���ǩ���ֲ���",layouts));
			buttonPanel.add(new ButtonPanel(action,"ѡ���ǩλ��",position));
			jf.add(buttonPanel,BorderLayout.SOUTH);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.pack();
			jf.setVisible(true);
	}
	
	//Ϊָ����ǩҳ��������
	private void loadTab(int n){
		String title = tabbedPane.getTitleAt(n);
		//���ݱ�ǩҳ�ı����ȡ��Ӧ��ͼ�����
		ImageIcon bookImage = new ImageIcon("ico/"+books.get(title));
		tabbedPane.setComponentAt(n, new JLabel(bookImage));
		//�ı��ǩҳ��ͼ��
		tabbedPane.setIconAt(n, new ImageIcon("ico/open.gif"));
	}
	
	//����ı��ǩ���ֲ���,����λ�õļ�����
	class ChangeAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JRadioButton source = (JRadioButton)e.getSource();
			String Selection = source.getActionCommand();
			
			//���ñ�ǩҳ�ı��Ⲽ�ֲ���
			if(Selection.equals(layouts[0])){
				tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			}
			else if(Selection.equals(layouts[1])){
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			}
			//���ñ�ǩҳ�ı������λ��
			else if(Selection.equals(position[0])){
				tabbedPane.setTabPlacement(JTabbedPane.LEFT);
			}
			else if(Selection.equals(position[1])){
				tabbedPane.setTabPlacement(JTabbedPane.TOP);
			}
			else if(Selection.equals(position[2])){
				tabbedPane.setTabPlacement(JTabbedPane.RIGHT);
			}
			else if(Selection.equals(position[3])){
				tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
			}
		}
	}
	
	//����һ��JPanel����չ��,����Ķ����������������е�JRadioButton
	class ButtonPanel extends JPanel{
		private ButtonGroup group;
		public ButtonPanel(JTabbedPaneTest.ChangeAction action,String title,String[] labels){
			setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),title));
			setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
			group = new ButtonGroup();
			for(int i =0;labels!=null&&i<labels.length;i++){
				JRadioButton b = new JRadioButton(labels[i]);
				b.setActionCommand(labels[i]);
				add(b);
				b.addActionListener(action);
				group.add(b);
				b.setSelected(i==0);
			}
		}
	}
	public static void main(String[] args) {
			new JTabbedPaneTest().init();
	}

}
