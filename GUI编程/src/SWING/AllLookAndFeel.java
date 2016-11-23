package SWING;

import javax.swing.UIManager;
/**
 * 查看当前系统可用的LookAndFeel
 * 16.7.31
 * @author LST
 *
 */
public class AllLookAndFeel {

	public static void main(String[] args) {
		System.out.println("当前系统所有可用的LAF");
		for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
			System.out.println(info.getName()+"------>"+info);
		}
	}

}
