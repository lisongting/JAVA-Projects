package AWT;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.Timer;

/**
 * һ���򵥵ĵ�����Ϸ
 * ��δ����ȫ����������
 * 16.7.30
 * @author LST
 *
 */
public class PinBall {
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	private final int RACKET_Y = 340;//���ĵĴ�ֱλ��
	private final int RACKET_HEIGHT = 20;//���ĵĸ߶�
	private final int RACKET_WIDTH = 60;//���ĵĿ��
	
	Random rand = new Random();
	private final int BALL_SIZE = 16;//С��Ĵ�С
	private int ySpeed = 10;//С������ķ����ٶ�
	private double xyRate= rand.nextDouble()-0.5;//����һ��-0.5��0.5����,��������С��ķ��з���
	private int xSpeed =(int)(ySpeed*xyRate *2);//С��ĺ��������ٶ�
	private int ballx = rand.nextInt(200)+20;
	private int bally = rand.nextInt(10)+20;//С��ĺ������������
	private int racketX = rand.nextInt(200);//���ĵ�ˮƽλ��
	
	private Frame f= new Frame("������Ϸ");
	private MyCanvas tableArea = new MyCanvas();
	private boolean isLose = false;//��Ϸ�����ı�־
	Timer timer;
	
	public void init(){
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));//���������������Ѵ�С
		f.add(tableArea);
		//������̼�����,ʹ�������ڲ���
		KeyAdapter keyProcessor = new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode()==KeyEvent.VK_LEFT){
					if(racketX>0)
						racketX -=10;//�����ƶ�10 ����λ
				}
				if(ke.getKeyCode()==KeyEvent.VK_RIGHT){
					if(racketX<TABLE_WIDTH-RACKET_WIDTH)
						racketX +=10;//�����ƶ�10 ����λ
				}
			}
		};
		
		f.addKeyListener(keyProcessor);//Ϊ���ںͻ����ֱ���Ӽ��̼�����(Ϊʲô��Ҫ��Ӽ�����?)
		tableArea.addKeyListener(keyProcessor);
		
		//����ÿ0.1��ִ��һ�μ�����
		ActionListener taskPerformer = evt->{
			if(ballx<=0||ballx>=TABLE_WIDTH-BALL_SIZE){
				xSpeed = -xSpeed;//���С��������߿�
			}
			//���С��߶ȳ���������λ��,�Һ��������ķ�Χ֮��,����Ϸ����
			if(bally >= RACKET_Y-BALL_SIZE &&(ballx<racketX||ballx>racketX+RACKET_WIDTH)){
				timer.stop();
				isLose = true;
				tableArea.repaint();   
			}
			//���С��λ������֮��,�ҵ�������λ��,��С�򷴵�
			else if(bally<=0||(bally>=RACKET_Y-BALL_SIZE &&ballx>racketX&&ballx<=racketX+RACKET_WIDTH)){
				ySpeed = -ySpeed;
			}
			bally +=ySpeed;
			ballx +=xSpeed;//С����������
			tableArea.repaint();
		};
		timer = new Timer(100,taskPerformer);
		timer.start();
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	
	}
	
	class MyCanvas extends Canvas{
		public void paint(Graphics g){
			if(isLose){
				g.setColor(new Color(255,0,0));
				g.setFont(new Font("Times",Font.BOLD,30));
				g.drawString("��Ϸ����", 50, 200);
				
			}
			else{
				g.setColor(new Color(240,240,80));
				g.fillOval(ballx, bally, BALL_SIZE, BALL_SIZE);
				g.setColor(new Color(80,80,200));
				g.fillRect(racketX, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		new PinBall().init();
	}

}
