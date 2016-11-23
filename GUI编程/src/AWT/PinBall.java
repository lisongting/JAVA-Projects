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
 * 一个简单的弹球游戏
 * 还未能完全理解这个程序
 * 16.7.30
 * @author LST
 *
 */
public class PinBall {
	private final int TABLE_WIDTH = 300;
	private final int TABLE_HEIGHT = 400;
	private final int RACKET_Y = 340;//球拍的垂直位置
	private final int RACKET_HEIGHT = 20;//球拍的高度
	private final int RACKET_WIDTH = 60;//球拍的宽度
	
	Random rand = new Random();
	private final int BALL_SIZE = 16;//小球的大小
	private int ySpeed = 10;//小球纵向的飞行速度
	private double xyRate= rand.nextDouble()-0.5;//返回一个-0.5到0.5的数,用来控制小球的飞行方向
	private int xSpeed =(int)(ySpeed*xyRate *2);//小球的横向运行速度
	private int ballx = rand.nextInt(200)+20;
	private int bally = rand.nextInt(10)+20;//小球的横坐标和纵坐标
	private int racketX = rand.nextInt(200);//球拍的水平位置
	
	private Frame f= new Frame("弹球游戏");
	private MyCanvas tableArea = new MyCanvas();
	private boolean isLose = false;//游戏结束的标志
	Timer timer;
	
	public void init(){
		tableArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));//设置桌面区域的最佳大小
		f.add(tableArea);
		//定义键盘监听器,使用匿名内部类
		KeyAdapter keyProcessor = new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode()==KeyEvent.VK_LEFT){
					if(racketX>0)
						racketX -=10;//向左移动10 个单位
				}
				if(ke.getKeyCode()==KeyEvent.VK_RIGHT){
					if(racketX<TABLE_WIDTH-RACKET_WIDTH)
						racketX +=10;//向右移动10 个单位
				}
			}
		};
		
		f.addKeyListener(keyProcessor);//为窗口和画布分别添加键盘监听器(为什么都要添加监听器?)
		tableArea.addKeyListener(keyProcessor);
		
		//定义每0.1秒执行一次监听器
		ActionListener taskPerformer = evt->{
			if(ballx<=0||ballx>=TABLE_WIDTH-BALL_SIZE){
				xSpeed = -xSpeed;//如果小球碰到左边框
			}
			//如果小球高度超出了球拍位置,且横向不在球拍范围之内,则游戏结束
			if(bally >= RACKET_Y-BALL_SIZE &&(ballx<racketX||ballx>racketX+RACKET_WIDTH)){
				timer.stop();
				isLose = true;
				tableArea.repaint();   
			}
			//如果小球位于球拍之内,且到达球拍位置,则小球反弹
			else if(bally<=0||(bally>=RACKET_Y-BALL_SIZE &&ballx>racketX&&ballx<=racketX+RACKET_WIDTH)){
				ySpeed = -ySpeed;
			}
			bally +=ySpeed;
			ballx +=xSpeed;//小球坐标增加
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
				g.drawString("游戏结束", 50, 200);
				
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
