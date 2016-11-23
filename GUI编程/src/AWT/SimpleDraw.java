package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
/**
 * 简单的绘图程序,测试Canvas类的使用
 * 16.7.30
 * @author LST
 *
 */
public class SimpleDraw {
	private final String Rect_Shape = "rect";
	private final String Oval_Shape = "oval";
	private Frame f= new Frame("简单绘图程序");
	private Button rect = new Button("绘制矩形");
	private Button oval = new Button("绘制圆形");
	private MyCanvas drawArea = new MyCanvas();
	private String shape = "";//用于保存需要绘制什么图形
	
	public void init(){
		Panel p = new Panel();
		rect.addActionListener(e->{
			shape = Rect_Shape;//设置shape变量为Rect_Shape
			drawArea.repaint();
		});
		oval.addActionListener(e->{
			shape = Oval_Shape;//设置shape变量为Oval_Shape
			drawArea.repaint();
		});
		p.add(rect);
		p.add(oval);
		drawArea.setPreferredSize(new Dimension(260,200));
		f.add(drawArea);
		f.add(p,BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
				
			}
		});
	}
	
	class MyCanvas extends Canvas{
		//重写Canvas的paint方法,实现重画
		public void paint(Graphics g){
			Random rand = new Random();
			if(shape.equals(Rect_Shape)){
				g.setColor(new Color(220,100,80));//设置画笔颜色
				g.drawRect(rand.nextInt(200),rand.nextInt(100),40,60);//随机的画一个矩形
			}
			if(shape.equals(Oval_Shape)){
				g.setColor(new Color(255,0,255));//设置画笔颜色
				g.fillOval(rand.nextInt(200),rand.nextInt(100),50,70);//随机的画一个实心圆形
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		new SimpleDraw().init();
	}

}
