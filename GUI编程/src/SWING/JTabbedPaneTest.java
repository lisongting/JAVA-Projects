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
 * 测试JTabbedPane的使用
 * 16.8.4
 * @author LST
 *
 */
public class JTabbedPaneTest {
	JFrame jf = new JFrame("测试Tab界面");
	//创建一个Tab页面的标签放在坐边,采用换行布局策略的JTabbedPane		
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.WRAP_TAB_LAYOUT);
	ImageIcon icon = new ImageIcon("ico/close.gif");
	String[] layouts = {"换行布局","滚动条布局"};
	String[] position = {"左边","顶部","右边","底部"};
	Map<String,String> books = new LinkedHashMap<>(); 
	
	
	public void init(){
			books.put("疯狂java讲义", "java.png");
			books.put("轻量级javaEE企业应用", "ee.png");
			books.put("疯狂ajax讲义", "ajax.png");
			books.put("疯狂安卓讲义", "android.png");
			books.put("经典javaEE企业应用实战", "classic.png");
			String tip ="可看到本书的封面照片"; 
			//向JTabbedPane 中添加5个标签页,指定了标题,图标和提示
			//但该标签的组件为null
			for(String bookName:books.keySet()){
				tabbedPane.addTab(bookName, icon, null, tip);
			}
			jf.add(tabbedPane);
			
			//为JTabbedPane 添加事件监听器
			tabbedPane.addChangeListener(e->{
				//如果被选择的组件依然是空
				if(tabbedPane.getSelectedComponent()==null){
					//获取所选标签页
					int n = tabbedPane.getSelectedIndex();
					//为指定标签页加载内容
					loadTab(n);
				}
			});
					
			//系统默认选择第一页,加载第一页的内容
			loadTab(0);
			tabbedPane.setPreferredSize(new Dimension(500,300));
			//添加控制标签布局,标签位置的单选按钮
			JPanel buttonPanel = new JPanel();
			ChangeAction action = new ChangeAction();
			buttonPanel.add(new ButtonPanel(action,"选择标签布局策略",layouts));
			buttonPanel.add(new ButtonPanel(action,"选择标签位置",position));
			jf.add(buttonPanel,BorderLayout.SOUTH);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.pack();
			jf.setVisible(true);
	}
	
	//为指定标签页加载内容
	private void loadTab(int n){
		String title = tabbedPane.getTitleAt(n);
		//根据标签页的标题获取对应的图书封面
		ImageIcon bookImage = new ImageIcon("ico/"+books.get(title));
		tabbedPane.setComponentAt(n, new JLabel(bookImage));
		//改变标签页的图标
		tabbedPane.setIconAt(n, new ImageIcon("ico/open.gif"));
	}
	
	//定义改变标签布局策略,放置位置的监听器
	class ChangeAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JRadioButton source = (JRadioButton)e.getSource();
			String Selection = source.getActionCommand();
			
			//设置标签页的标题布局策略
			if(Selection.equals(layouts[0])){
				tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			}
			else if(Selection.equals(layouts[1])){
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			}
			//设置标签页的标题放置位置
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
	
	//定义一个JPanel的扩展类,该类的对象包含多个纵向排列的JRadioButton
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
