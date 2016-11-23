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
 * ����BufferedImageʵ�ֻ��弼��:һ���ֻ����
 * 16.7.31
 * δ����ȫ����������
 * @author LST
 *
 */
public class HandDraw {
	private final int AREA_WIDTH = 500;
	private final int AREA_HEIGHT = 400;
	private int prex = -1;
	private int prey = -1;//prex��prey������һ������϶��¼����������
	
	PopupMenu pop = new PopupMenu();//����һ���Ҽ��˵��������û�����ɫ
	MenuItem redItem = new MenuItem("��ɫ");
	MenuItem greenItem = new MenuItem("��ɫ");
	MenuItem blueItem = new MenuItem("��ɫ");
	
	//����һ��BufferedImage����
	BufferedImage image = new BufferedImage(AREA_WIDTH,AREA_HEIGHT,BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();//��ȡimage�����graphics
	private Frame f = new Frame("���ֻ����");
	private DrawCanvas drawArea = new DrawCanvas();
	private Color foreColor = new Color(255,0,0);//���ڱ��滭����ɫ
	public void init(){
		ActionListener menuListener = e->{
			if(e.getActionCommand().equals("��ɫ"))
				foreColor = new Color(0,255,0);
			if(e.getActionCommand().equals("��ɫ"))
				foreColor = new Color(255,0,0);
			if(e.getActionCommand().equals("��ɫ"))
				foreColor = new Color(0,0,255);
		};
		redItem.addActionListener(menuListener);
		blueItem.addActionListener(menuListener);
		greenItem.addActionListener(menuListener);//Ϊ������ѡ����������
		pop.add(redItem);
		pop.add(blueItem);
		pop.add(greenItem);
		drawArea.add(pop);
		g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);//��g�ı���ɫ���ɰ�ɫ
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));
		
		//��������¼�
		drawArea.addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				if(prex>0&&prey>0){
					g.setColor(foreColor);//���õ�ǰ��ɫ
					g.drawLine(prex, prey, e.getX(), e.getY());//����һ�ε�λ�õ���ǰλ��������������
				}
				prex = e.getX();
				prey = e.getY();
				drawArea.repaint();
			}
		});
		
		//����ɿ����¼�������
		drawArea.addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				if(e.isPopupTrigger()){
					pop.show(drawArea, e.getX(), e.getY());
				}
				prex = -1;
				prey = -1;//�ɿ�����ʱ,����һ������϶��¼���x,y������Ϊ-1
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
