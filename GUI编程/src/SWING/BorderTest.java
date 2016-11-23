package SWING;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
/**
 * 测试边框Border的使用
 * 16.8.1
 * @author LST
 *
 */
public class BorderTest {
	private JFrame jf = new JFrame();
	
	public JPanel getPanelWithBorder(Border b,String BorderName){
		JPanel p = new JPanel();
		p.add(new JLabel(BorderName));
		p.setBorder(b);//为jpanel设置边框
		return p;
	}
	
	public void init(){
		jf.setLayout(new GridLayout(2,4));
		//使用静态方法创建BevelBorder
		Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY);
		jf.add(getPanelWithBorder(bb,"BevelBorder"));
		
		//使用静态工厂方法创建LineBorder
		Border lb = BorderFactory.createLineBorder(Color.ORANGE,10);
		jf.add(getPanelWithBorder(lb,"LineBorder"));
		
		//使用静态工厂方法创建EmptyBorder,EmptyBorder在组件四周留空
		Border eb = BorderFactory.createEmptyBorder(20,5,10,30);
		jf.add(getPanelWithBorder(eb,"EmptyBorder"));//往frame中添加Border
		
		//使用静态工厂方法创建EtchedBorder
		Border etb = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED,Color.GREEN);
		jf.add(getPanelWithBorder(etb,"EtchedBorder"));
		
		//直接创建TitleBorder ,TitleBorder就是为原边框增加标题
		TitledBorder tb = new TitledBorder(lb,"测试标题",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong",Font.BOLD,18),Color.BLUE);
		jf.add(getPanelWithBorder(tb,"TitledBorder"));
		
		//直接创建MatteBorder,MatteBorder是EmptyBorder的子类
		//它可以指定留空区域的颜色或背景,此处指颜色
		MatteBorder mb = BorderFactory.createMatteBorder(20, 5, 10, 30, Color.GREEN);
		jf.add(getPanelWithBorder(mb,"MatteBorder"));
		
		//直接创建CompoundBorder ,CompoundBorder将两个边框组合成一个新边框
		CompoundBorder cb = new CompoundBorder(new LineBorder(Color.RED,8),tb);
		jf.add(getPanelWithBorder(cb,"CompoundBorder"));
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderTest().init();
	}

}
