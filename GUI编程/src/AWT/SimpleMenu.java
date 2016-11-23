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
 * 测试MenuBar,Menu,MenuItem,TextArea,CheckboxMenuItem这些类的用法
 * 16.7.30
 * 存在疑问
 * @author LST
 *	新技能GET:快速导入包的快捷键  ctrl+Shift+o
 */
public class SimpleMenu {
	private Frame f = new Frame("测试"); 
	private MenuBar mb = new MenuBar();//菜单条：菜单的容器
	private TextArea ta = new TextArea(10,40);
	Menu file = new Menu("文件");
	Menu edit = new Menu("编辑");
	MenuItem newItem = new MenuItem("新建");
	MenuItem saveItem = new MenuItem("保存");
	MenuItem exitItem = new MenuItem("退出",new MenuShortcut(KeyEvent.VK_X));//创建Menuexit菜单项,指定快捷键为ctrl+X
	CheckboxMenuItem autowrap = new CheckboxMenuItem("自动换行");
	MenuItem copyItem = new MenuItem("复制");
	MenuItem pasteItem = new MenuItem("粘贴");
	Menu format = new Menu("格式");
	
	//在"格式"选项中添加新的功能选项"注释",设置快捷键为ctrl +Shift+/
	MenuItem commentItem = new MenuItem("注释",new MenuShortcut(KeyEvent.VK_SLASH,true));
	MenuItem cancelItem = new MenuItem("取消注释");
	public void init(){
		//用lambda表达式创建的ActionListener
		ActionListener menuListener = e->{
			String cmd = e.getActionCommand();//这个getActionCommand 方法取到的是单击的按钮的名字
			ta.append("单击"+cmd+"菜单"+"\n");
			if(cmd.equals("退出")){
				System.exit(0);
			}
		};
		
		commentItem.addActionListener(menuListener);//为Item添加事件监听器
		file.addActionListener(menuListener);//这条语句无效,难道只有MenuItem 可以添加事件监听器吗?
		newItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		file.add(newItem);//为"文件"添加子条目
		file.add(saveItem);//为"文件"添加子条目
		file.add(exitItem);//为"文件"添加子条目
		
		edit.add(autowrap);//为"编辑"添加子条目
		edit.addSeparator();//添加菜单分割线
		edit.add(copyItem);
		edit.add(pasteItem);
		format.add(commentItem);//把"注释"添加到"格式"中去
		format.add(cancelItem); 
		edit.add(new MenuItem("**********"));//使用****作为菜单分割线
		edit.add(format);//把"格式"加到"编辑"中
		
		//往Menubar菜单条中加入"文件"和"编辑" 条目
		mb.add(file);
		mb.add(edit);
		f.setMenuBar(mb);//在frame中设置MenuBar
		
		//以匿名内部类的形式创建窗口的事件监听器,用来关闭窗口
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
