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
 * 测试拖放功能
 * 没完全理解这个程序
 * 16.7.31
 *   @author LST
 *
 */
public class DropTargetTest {
		final int DESKTOP_WIDTH = 480;
		final int DESKTOP_HEIGHT = 360;
		final int FRAME_DISTANCE = 30;
		JFrame jf = new JFrame("测试拖放目标---把图片拖入该窗口");
		//定义一个虚拟桌面
		private JDesktopPane desktop  = new JDesktopPane();
		private int nextFrameX;
		private int nextFrameY;//保存下一个内部窗口的坐标点
		//定义内部窗口的大小为虚拟窗口的一半大小
		private int width = DESKTOP_WIDTH/2;
		private int height = DESKTOP_HEIGHT/2;
			
		public void init(){
			desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH,DESKTOP_HEIGHT));
			//将当前窗口创建成拖放目标
			new DropTarget(jf,DnDConstants.ACTION_COPY,new ImageDropTargetListener());
			
			jf.add(desktop);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.pack();
			jf.setVisible(true);
		}
	class ImageDropTargetListener extends DropTargetAdapter{
		public void drop(DropTargetDropEvent e){
			//接受复制操作
			e.acceptDrop(DnDConstants.ACTION_COPY);
			//获取拖放内容
			Transferable transferable = e.getTransferable();
			DataFlavor[] flavors = transferable.getTransferDataFlavors();
			for(int i=0;i<flavors.length;i++){
				DataFlavor d = flavors[i];
				try{
					//如果拖放内容数据格式是文件列表
					if(d.equals(DataFlavor.javaFileListFlavor)){
						//去除拖放操作里的文件列表
						List fileList = (List)transferable.getTransferData(d);
						for(Object f :fileList){
							showImage((File)f,e);
						}
					}
				}
				catch (Exception ex){
					ex.printStackTrace();
				}
				//强制结束拖放操作,停止阻塞拖放目标
				e.dropComplete(true);
			}
		}
	}
	
	//显示每个文件的工具方法
	private void showImage(File f ,DropTargetDropEvent event)throws IOException
	{
		Image image = ImageIO.read(f);
		if(image ==null)
		{
			//强制拖放操作结束,停止阻塞拖放目标
			event.dropComplete(true);
			JOptionPane.showInternalMessageDialog(desktop, "系统不支持这种类型的文件");
			return ;//方法返回
		}
		ImageIcon icon = new ImageIcon(image);
		//创建内部窗口显示该图片
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
