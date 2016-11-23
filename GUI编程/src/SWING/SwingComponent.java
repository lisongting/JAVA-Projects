package SWING;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 * ���Գ��õ�swing�����ʹ��
 * 16.7.31
 * @author LST
 *
 */
public class SwingComponent {
	JFrame f = new JFrame("���Դ���");
	Icon okIcon = new ImageIcon("ico/ok.png");
	JButton ok = new JButton("ȷ��",okIcon);
	JRadioButton male = new JRadioButton("��",true);//��ѡ��ť
	JRadioButton female = new JRadioButton("Ů",false);//��ѡ��ť
	ButtonGroup bg = new ButtonGroup();
	JCheckBox married = new JCheckBox("�Ƿ��ѻ�?",false);
	String[] colors = new String[]{"��ɫ","��ɫ","��ɫ"};
	//����һ������ѡ���
	JComboBox<String> colorChooser = new JComboBox<>(colors);
	//����һ���б�ѡ���
	JList<String> colorList = new JList<>(colors);
	JTextArea ta = new JTextArea(8,20);//����һ��8��20�еĶ����ı���
	JTextField name = new JTextField(40);//����һ��40�еĵ����ı���
	JMenuBar mb = new JMenuBar();//�˵���
	JMenu file = new JMenu("�ļ�");
	JMenu edit = new JMenu("�༭");
	
	//����"�½�"�˵���,Ϊָ֮��ͼ��
	Icon newIcon = new ImageIcon("ico/new.png");
	JMenuItem newItem = new JMenuItem("�½�",newIcon);
	
	//����"����"�˵���,��Ϊָ֮��ͼ��(������䴴���˵�ѡ��:����ͼ������Item����)
	Icon saveIcon = new ImageIcon("ico/save.png");
	JMenuItem saveItem = new JMenuItem("����",saveIcon);
	
	Icon exitIcon = new ImageIcon("ico/exit.png");
	JMenuItem exitItem = new JMenuItem("�˳�",exitIcon);
	JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("�Զ�����");
	//����һ����䴴���˵�ѡ��:������ͼ��ʵ��
	JMenuItem copyItem = new JMenuItem("����",new ImageIcon("ico/copy,png"));
	JMenuItem pasteItem = new JMenuItem("ճ��",new ImageIcon("ico/paste,png"));
	JMenu format = new JMenu("��ʽ");
	JMenuItem commentItem = new JMenuItem("ע��");
	JMenuItem cancelItem = new JMenuItem("ȡ��ע��");
	
	//����һ���Ҽ��˵��������ó�����
	JPopupMenu pop = new JPopupMenu();
	ButtonGroup flavorGroup = new ButtonGroup();
	JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal���",true);
	JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus���",true);
	JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows���",true);
	JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("Windows������",true);
	JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif���",true);
	
	/*----------����ִ�н����ʼ����init����*/
	public void init(){
		JPanel bottom = new JPanel();
		bottom.add(name);//name�� TextField
		bottom.add(ok);
		f.add(bottom,BorderLayout.SOUTH);
		JPanel checkPanel = new JPanel();//����һ��װ��������ѡ���,����JCheckBox��JPanel
		checkPanel.add(colorChooser);//colorChooser��comboBox
		bg.add(male);//bg��buttonGroup
		bg.add(female);//bg��buttonGroup
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		
		//������һ����ֱ���е�Box,ʢװ�����ı������Jpanel
		Box topLeft = Box.createVerticalBox();
		//ʹ��JScrollPane��Ϊ��ͨ�����JViewPort
		JScrollPane taJsp = new JScrollPane(ta);
		topLeft.add(taJsp);
		topLeft.add(checkPanel);
		
		//������һ��ˮƽ���������box,ʢװtopLeft,colorList
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		//��top Box ������ӵ����ڵ��м�
		f.add(top);
		
		/*-----------���濪ʼ��ϲ˵�,��Ϊ�˵���Ӽ�����*/
		//ΪnewItem���ÿ�ݼ�,���ÿ�ݼ�ʱҪʹ�ô�д��ĸ
		newItem.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		newItem.addActionListener(e->ta.append("�û�������'�½�'�˵�"));
		//Ϊfile��Ӳ˵���
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		edit.add(autoWrap);
		//��Ӳ˵��ָ���,��addSeparator
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		//Ϊcomment��������ʾ��Ϣ
		commentItem.setToolTipText("���������ע������!");
		//Ϊformat��Ӳ˵�ѡ��
		format.add(commentItem);
		format.add(cancelItem);
		//ʹ�����new JMenuIten("-")�ķ�ʽ������Ӳ˵��ָ���
		edit.add(new JMenuItem("-"));
		//��format�˵���ϵ�edit�˵���,�Ӷ��γɶ����˵�
		edit.add(format);
		mb.add(file);
		mb.add(edit);
		//Ϊf�������ò˵���
		f.setJMenuBar(mb);
		
		/*-----���濪ʼ����Ҽ��˵�,����װ�ҽ��˵�*/
		flavorGroup.add(metalItem);
		flavorGroup.add(nimbusItem);
		flavorGroup.add(windowsItem);
		flavorGroup.add(classicItem);
		flavorGroup.add(motifItem);
		pop.add(metalItem);
		pop.add(nimbusItem);
		pop.add(windowsItem);
		pop.add(classicItem);
		pop.add(motifItem);
		
		//Ϊ5�����˵���Ӳ˵�������
		ActionListener flavorListener=e->{
			try{
				switch(e.getActionCommand()){
				case "Metal���":
					changeFlavor(1);
					break;
				case "Nimbus���":
					changeFlavor(2);
					break;
				case "Windows���":
					changeFlavor(3);
					break;
				case "Windows������":
					changeFlavor(4);
					break;
				case "Motif���":
					changeFlavor(5);
					break;
				}
				
			}
			catch (Exception ee){
				ee.printStackTrace();
			}
		};
		
		//Ϊ5�����˵�������¼�������
		metalItem.addActionListener(flavorListener);
		nimbusItem.addActionListener(flavorListener);
		windowsItem.addActionListener(flavorListener);
		classicItem.addActionListener(flavorListener);
		motifItem.addActionListener(flavorListener);
		
		//���ø÷Ŵ󼴿������ҽ��˵�,����ʹ���¼�����
		ta.setComponentPopupMenu(pop);
		//���ùرմ���ʱ,�˳�����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
			
	}
	
	/*------����һ������,���ڸı������*/
	public void changeFlavor(int flavor)throws Exception{
		switch(flavor){
		case 1:
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			break;
		case 2:
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			break;
		case 3:
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			break;
		case 4:
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			break;
		case 5:
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			break;
		default:
			break;
		}
		
		//����f�����ڶ��������Լ��ڲ����������UI
		SwingUtilities.updateComponentTreeUI(f.getContentPane());
		
		//����mb�˵����Լ��ڲ����������UI
		SwingUtilities.updateComponentTreeUI(mb);
		
		//����pop�ҽ��˵��Լ��ڲ����������UI
		SwingUtilities.updateComponentTreeUI(pop);
	}
	
	public static void main(String[] args) {
		//����Swing����ʹ��java���
		//JFrame.setDefaultLookAndFeelDecorated(true);//���ÿ�
		new SwingComponent().init();
	}

}
