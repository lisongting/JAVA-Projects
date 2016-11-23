package AWT;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
/**
 * �����ϷŹ���
 * û��ȫ����������
 * 16.7.31
 *   @author LST
 *
 */
public class DropTargetTest {
		final int DESKTOP_WIDTH = 480;
		final int DESKTOP_HEIGHT = 360;
		final int FRAME_DISTANCE = 30;
		JFrame jf = new JFrame("�����Ϸ�Ŀ��---��ͼƬ����ô���");
		//����һ����������
		private JDesktopPane desktop  = new JDesktopPane();
		private int nextFrameX;
		private int nextFrameY;//������һ���ڲ����ڵ������
		//�����ڲ����ڵĴ�СΪ���ⴰ�ڵ�һ���С
		private int width = DESKTOP_WIDTH/2;
		private int height = DESKTOP_HEIGHT/2;
			
		public void init(){
			desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH,DESKTOP_HEIGHT));
			//����ǰ���ڴ������Ϸ�Ŀ��
			new DropTarget(jf,DnDConstants.ACTION_COPY,new ImageDropTargetListener());
			
			jf.add(desktop);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.pack();
			jf.setVisible(true);
		}
	class ImageDropTargetListener extends DropTargetAdapter{
		public void drop(DropTargetDropEvent e){
			//���ܸ��Ʋ���
			e.acceptDrop(DnDConstants.ACTION_COPY);
			//��ȡ�Ϸ�����
			Transferable transferable = e.getTransferable();
			DataFlavor[] flavors = transferable.getTransferDataFlavors();
			for(int i=0;i<flavors.length;i++){
				DataFlavor d = flavors[i];
				try{
					//����Ϸ��������ݸ�ʽ���ļ��б�
					if(d.equals(DataFlavor.javaFileListFlavor)){
						//ȥ���ϷŲ�������ļ��б�
						List fileList = (List)transferable.getTransferData(d);
						for(Object f :fileList){
							showImage((File)f,e);
						}
					}
				}
				catch (Exception ex){
					ex.printStackTrace();
				}
				//ǿ�ƽ����ϷŲ���,ֹͣ�����Ϸ�Ŀ��
				e.dropComplete(true);
			}
		}
	}
	
	//��ʾÿ���ļ��Ĺ��߷���
	private void showImage(File f ,DropTargetDropEvent event)throws IOException
	{
		Image image = ImageIO.read(f);
		if(image ==null)
		{
			//ǿ���ϷŲ�������,ֹͣ�����Ϸ�Ŀ��
			event.dropComplete(true);
			JOptionPane.showInternalMessageDialog(desktop, "ϵͳ��֧���������͵��ļ�");
			return ;//��������
		}
		ImageIcon icon = new ImageIcon(image);
		//�����ڲ�������ʾ��ͼƬ
		JInternalFrame iframe = new JInternalFrame(f.getName(),true,true,true,true);
		JLabel imageLabel = new JLabel(icon);
		iframe.add(new JScrollPane(imageLabel));
		desktop.add(iframe);
		iframe.reshape(nextFrameX, nextFrameY, width,height);
		iframe.show();
		nextFrameX +=FRAME_DISTANCE;
		nextFrameY +=FRAME_DISTANCE;
		if(nextFrameX+width>desktop.getWidth())
			nextFrameX=0;
		if(nextFrameY+height>=desktop.getHeight())
			nextFrameY=0;
	}
	public static void main(String[] args) {
		new DropTargetTest().init();
	}

}
