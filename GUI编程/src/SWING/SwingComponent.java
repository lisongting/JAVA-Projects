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
 * 测试常用的swing插件的使用
 * 16.7.31
 * @author LST
 *
 */
public class SwingComponent {
	JFrame f = new JFrame("测试窗口");
	Icon okIcon = new ImageIcon("ico/ok.png");
	JButton ok = new JButton("确认",okIcon);
	JRadioButton male = new JRadioButton("男",true);//单选按钮
	JRadioButton female = new JRadioButton("女",false);//单选按钮
	ButtonGroup bg = new ButtonGroup();
	JCheckBox married = new JCheckBox("是否已婚?",false);
	String[] colors = new String[]{"红色","绿色","蓝色"};
	//定义一个下拉选择框
	JComboBox<String> colorChooser = new JComboBox<>(colors);
	//定义一个列表选择框
	JList<String> colorList = new JList<>(colors);
	JTextArea ta = new JTextArea(8,20);//定义一个8行20列的多行文本区
	JTextField name = new JTextField(40);//定义一个40列的单行文本区
	JMenuBar mb = new JMenuBar();//菜单条
	JMenu file = new JMenu("文件");
	JMenu edit = new JMenu("编辑");
	
	//创建"新建"菜单项,为之指定图标
	Icon newIcon = new ImageIcon("ico/new.png");
	JMenuItem newItem = new JMenuItem("新建",newIcon);
	
	//创建"保存"菜单项,并为之指定图标(两条语句创建菜单选项:创建图标对象和Item对象)
	Icon saveIcon = new ImageIcon("ico/save.png");
	JMenuItem saveItem = new JMenuItem("保存",saveIcon);
	
	Icon exitIcon = new ImageIcon("ico/exit.png");
	JMenuItem exitItem = new JMenuItem("退出",exitIcon);
	JCheckBoxMenuItem autoWrap = new JCheckBoxMenuItem("自动换行");
	//下面一条语句创建菜单选项:不创建图标实例
	JMenuItem copyItem = new JMenuItem("复制",new ImageIcon("ico/copy,png"));
	JMenuItem pasteItem = new JMenuItem("粘贴",new ImageIcon("ico/paste,png"));
	JMenu format = new JMenu("格式");
	JMenuItem commentItem = new JMenuItem("注释");
	JMenuItem cancelItem = new JMenuItem("取消注释");
	
	//定义一个右键菜单用于设置程序风格
	JPopupMenu pop = new JPopupMenu();
	ButtonGroup flavorGroup = new ButtonGroup();
	JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal风格",true);
	JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus风格",true);
	JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows风格",true);
	JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("Windows经典风格",true);
	JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif风格",true);
	
	/*----------用于执行界面初始化的init方法*/
	public void init(){
		JPanel bottom = new JPanel();
		bottom.add(name);//name是 TextField
		bottom.add(ok);
		f.add(bottom,BorderLayout.SOUTH);
		JPanel checkPanel = new JPanel();//创建一个装载了下拉选择框,三个JCheckBox的JPanel
		checkPanel.add(colorChooser);//colorChooser是comboBox
		bg.add(male);//bg是buttonGroup
		bg.add(female);//bg是buttonGroup
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		
		//创建了一个垂直排列的Box,盛装多行文本区域的Jpanel
		Box topLeft = Box.createVerticalBox();
		//使用JScrollPane作为普通组件的JViewPort
		JScrollPane taJsp = new JScrollPane(ta);
		topLeft.add(taJsp);
		topLeft.add(checkPanel);
		
		//创建了一个水平排列组件的box,盛装topLeft,colorList
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		//将top Box 容器添加到窗口的中间
		f.add(top);
		
		/*-----------下面开始组合菜单,并为菜单添加监听器*/
		//为newItem设置快捷键,设置快捷键时要使用大写字母
		newItem.setAccelerator(KeyStroke.getKeyStroke('N',InputEvent.CTRL_MASK));
		newItem.addActionListener(e->ta.append("用户单击了'新建'菜单"));
		//为file添加菜单项
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		edit.add(autoWrap);
		//添加菜单分割线,用addSeparator
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		//为comment组件添加提示信息
		commentItem.setToolTipText("将程序代码注释起来!");
		//为format添加菜单选项
		format.add(commentItem);
		format.add(cancelItem);
		//使用添加new JMenuIten("-")的方式不能添加菜单分隔符
		edit.add(new JMenuItem("-"));
		//将format菜单组合到edit菜单中,从而形成二级菜单
		edit.add(format);
		mb.add(file);
		mb.add(edit);
		//为f窗口设置菜单条
		f.setJMenuBar(mb);
		
		/*-----下面开始组合右键菜单,并安装右建菜单*/
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
		
		//为5个风格菜单添加菜单监听器
		ActionListener flavorListener=e->{
			try{
				switch(e.getActionCommand()){
				case "Metal风格":
					changeFlavor(1);
					break;
				case "Nimbus风格":
					changeFlavor(2);
					break;
				case "Windows风格":
					changeFlavor(3);
					break;
				case "Windows经典风格":
					changeFlavor(4);
					break;
				case "Motif风格":
					changeFlavor(5);
					break;
				}
				
			}
			catch (Exception ee){
				ee.printStackTrace();
			}
		};
		
		//为5个风格菜单项添加事件监听器
		metalItem.addActionListener(flavorListener);
		nimbusItem.addActionListener(flavorListener);
		windowsItem.addActionListener(flavorListener);
		classicItem.addActionListener(flavorListener);
		motifItem.addActionListener(flavorListener);
		
		//调用该放大即可设置右建菜单,无须使用事件机制
		ta.setComponentPopupMenu(pop);
		//设置关闭窗口时,退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
			
	}
	
	/*------定义一个方法,用于改变界面风格*/
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
		
		//更新f窗口内顶级容器以及内部所有组件的UI
		SwingUtilities.updateComponentTreeUI(f.getContentPane());
		
		//更新mb菜单条以及内部所有组件的UI
		SwingUtilities.updateComponentTreeUI(mb);
		
		//更新pop右建菜单以及内部所有组件的UI
		SwingUtilities.updateComponentTreeUI(pop);
	}
	
	public static void main(String[] args) {
		//设置Swing窗口使用java风格
		//JFrame.setDefaultLookAndFeelDecorated(true);//不好看
		new SwingComponent().init();
	}

}
