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
 * �򵥵Ļ�ͼ����,����Canvas���ʹ��
 * 16.7.30
 * @author LST
 *
 */
public class SimpleDraw {
	private final String Rect_Shape = "rect";
	private final String Oval_Shape = "oval";
	private Frame f= new Frame("�򵥻�ͼ����");
	private Button rect = new Button("���ƾ���");
	private Button oval = new Button("����Բ��");
	private MyCanvas drawArea = new MyCanvas();
	private String shape = "";//���ڱ�����Ҫ����ʲôͼ��
	
	public void init(){
		Panel p = new Panel();
		rect.addActionListener(e->{
			shape = Rect_Shape;//����shape����ΪRect_Shape
			drawArea.repaint();
		});
		oval.addActionListener(e->{
			shape = Oval_Shape;//����shape����ΪOval_Shape
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
		//��дCanvas��paint����,ʵ���ػ�
		public void paint(Graphics g){
			Random rand = new Random();
			if(shape.equals(Rect_Shape)){
				g.setColor(new Color(220,100,80));//���û�����ɫ
				g.drawRect(rand.nextInt(200),rand.nextInt(100),40,60);//����Ļ�һ������
			}
			if(shape.equals(Oval_Shape)){
				g.setColor(new Color(255,0,255));//���û�����ɫ
				g.fillOval(rand.nextInt(200),rand.nextInt(100),50,70);//����Ļ�һ��ʵ��Բ��
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		new SimpleDraw().init();
	}

}
