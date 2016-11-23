package AWT;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
/**
 * 用ImageIO测试将图片进行缩放
 * 疑问:控制台没有出现任何显示,不知道缩小后的图片被放在了哪里
 * @author LST
 *16.7.31
 */
public class ImageIOTest {
	private final int WIDTH = 400;
	private final int HEIGHT = 200;
	BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	public void zoom()throws Exception{
		Image srcImage = ImageIO.read(new File("E:/1.jpg"));//读取原始位图
		g.drawImage(srcImage,0,0,WIDTH,HEIGHT,null);//将位图缩小后绘制到磁盘文件中
		//将image对象输出到磁盘文件中
		ImageIO.write(image, "pngggg", new File(System.currentTimeMillis()+".jpg"));
		
	}
	public static void main(String[] args) {
		try {
			new ImageIOTest().zoom();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
