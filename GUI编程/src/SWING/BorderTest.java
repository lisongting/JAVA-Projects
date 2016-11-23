package SWING;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
/**
 * ���Ա߿�Border��ʹ��
 * 16.8.1
 * @author LST
 *
 */
public class BorderTest {
	private JFrame jf = new JFrame();
	
	public JPanel getPanelWithBorder(Border b,String BorderName){
		JPanel p = new JPanel();
		p.add(new JLabel(BorderName));
		p.setBorder(b);//Ϊjpanel���ñ߿�
		return p;
	}
	
	public void init(){
		jf.setLayout(new GridLayout(2,4));
		//ʹ�þ�̬��������BevelBorder
		Border bb = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.RED,Color.GREEN,Color.BLUE,Color.GRAY);
		jf.add(getPanelWithBorder(bb,"BevelBorder"));
		
		//ʹ�þ�̬������������LineBorder
		Border lb = BorderFactory.createLineBorder(Color.ORANGE,10);
		jf.add(getPanelWithBorder(lb,"LineBorder"));
		
		//ʹ�þ�̬������������EmptyBorder,EmptyBorder�������������
		Border eb = BorderFactory.createEmptyBorder(20,5,10,30);
		jf.add(getPanelWithBorder(eb,"EmptyBorder"));//��frame�����Border
		
		//ʹ�þ�̬������������EtchedBorder
		Border etb = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.RED,Color.GREEN);
		jf.add(getPanelWithBorder(etb,"EtchedBorder"));
		
		//ֱ�Ӵ���TitleBorder ,TitleBorder����Ϊԭ�߿����ӱ���
		TitledBorder tb = new TitledBorder(lb,"���Ա���",TitledBorder.LEFT,TitledBorder.BOTTOM,new Font("StSong",Font.BOLD,18),Color.BLUE);
		jf.add(getPanelWithBorder(tb,"TitledBorder"));
		
		//ֱ�Ӵ���MatteBorder,MatteBorder��EmptyBorder������
		//������ָ�������������ɫ�򱳾�,�˴�ָ��ɫ
		MatteBorder mb = BorderFactory.createMatteBorder(20, 5, 10, 30, Color.GREEN);
		jf.add(getPanelWithBorder(mb,"MatteBorder"));
		
		//ֱ�Ӵ���CompoundBorder ,CompoundBorder�������߿���ϳ�һ���±߿�
		CompoundBorder cb = new CompoundBorder(new LineBorder(Color.RED,8),tb);
		jf.add(getPanelWithBorder(cb,"CompoundBorder"));
		jf.pack();
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderTest().init();
	}

}
