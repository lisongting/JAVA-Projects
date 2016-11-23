package AWT;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

/**
 * 借助BufferedImage实现缓冲技术:一个手绘程序
 * 16.7.31
 * 未能完全理解这个程序
 * @author LST
 *
 */
public class HandDraw {
	private final int AREA_WIDTH = 500;
	private final int AREA_HEIGHT = 400;
	private int prex = -1;
	private int prey = -1;//prex和prey保存上一次鼠标拖动事件的鼠标坐标
	
	PopupMenu pop = new PopupMenu();//定义一个右键菜单用来设置画笔颜色
	MenuItem redItem = new MenuItem("红色");
	MenuItem greenItem = new MenuItem("绿色");
	MenuItem blueItem = new MenuItem("蓝色");
	
	//定义一个BufferedImage对象
	BufferedImage image = new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();//获取image对象的graphics
	private Frame f = new Frame("简单手绘程序");
	private DrawCanvas drawArea = new DrawCanvas();
	private Color foreColor = new Color(255,0,0);//用于保存画笔颜色
	public void init(){
		ActionListener menuListener = e->{
			if(e.getActionCommand().equals("绿色"))
				foreColor = new Color(0,255,0);
			if(e.getActionCommand().equals("红色"))
				foreColor = new Color(255,0,0);
			if(e.getActionCommand().equals("蓝色"))
				foreColor = new Color(0,0,255);
		};
		redItem.addActionListener(menuListener);
		blueItem.addActionListener(menuListener);
		greenItem.addActionListener(menuListener);//为这三个选项都加入监听器
		pop.add(redItem);
		pop.add(blueItem);
		pop.add(greenItem);
		drawArea.add(pop);
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);//把g的背景色填充成白色
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));
		
		//监听鼠标事件
		drawArea.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				if(prex>0&&prey>0){
					g.setColor(foreColor);//设置当前颜色
					g.drawLine(prex, prey, e.getX(), e.getY());//从上一次的位置到当前位置用线连接起来
				}
				prex = e.getX();
				prey = e.getY();
				drawArea.repaint();
			}
		});
		
		//鼠标松开的事件处理器
		drawArea.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(e.isPopupTrigger()){
					pop.show(drawArea, e.getX(), e.getY());
				}
				prex = -1;
				prey = -1;//松开鼠标键时,把上一次鼠标拖动事件的x,y坐标设为-1
			}
		});
		
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		f.add(drawArea);
		f.pack();
		f.setVisible(true);
	}
	class DrawCanvas extends Canvas{
		public void paint(Graphics g){
			g.drawImage(image, 0, 0, null);
		}
	}
	public static void main(String[] args) {
		new HandDraw().init();
	}

}
