package AWT;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
/**
 * ��ImageIO���Խ�ͼƬ��������
 * ����:����̨û�г����κ���ʾ,��֪����С���ͼƬ������������
 * @author LST
 *16.7.31
 */
public class ImageIOTest {
	private final int WIDTH = 400;
	private final int HEIGHT = 200;
	BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	public void zoom()throws Exception{
		Image srcImage = ImageIO.read(new File("E:/1.jpg"));//��ȡԭʼλͼ
		g.drawImage(srcImage,0,0,WIDTH,HEIGHT,null);//��λͼ��С����Ƶ������ļ���
		//��image��������������ļ���
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
