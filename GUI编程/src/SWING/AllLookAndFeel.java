package SWING;

import javax.swing.UIManager;
/**
 * �鿴��ǰϵͳ���õ�LookAndFeel
 * 16.7.31
 * @author LST
 *
 */
public class AllLookAndFeel {

	public static void main(String[] args) {
		System.out.println("��ǰϵͳ���п��õ�LAF");
		for(UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()){
			System.out.println(info.getName()+"------>"+info);
		}
	}

}
