package AWT;
/**
 * 测试GridBagLayout
 * 2016.7.28
 */
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutTest {

	private Frame f = new Frame("测试窗口");
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private Button[] bs = new Button[10];
	public void init(){
		f.setLayout(gb);
		for(int i=0;i<bs.length;i++){
			bs[i] = new Button("按钮"+i);
		}
		
		gbc.fill = GridBagConstraints.BOTH;//所有组件都可以横向，纵向扩大
		gbc.weightx = 1;//设置组件的增加比例为1
		addButton(bs[0]);
		addButton(bs[1]);
		addButton(bs[2]);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;//该gbc控制的组件将成为横向最后一个组件
		addButton(bs[3]);
		
		gbc.weightx = 0;//该组件在横向上不会扩大
		addButton(bs[4]);
		
		gbc.gridwidth = 2;//该组件将会横跨两个网格
		addButton(bs[5]);
		
		gbc.gridwidth = 1;//横向跨1个网格
		gbc.gridheight = 2;//纵向跨2个网格
		gbc.gridwidth = GridBagConstraints.REMAINDER;//该gbc控制的组件将成为横向最后一个组件
		addButton(bs[6]);//可是6并没有纵向跨2个网格啊？难道是因为格子满了？
		
		gbc.gridwidth = 1;
		gbc.gridheight = 2;//纵跨2个网格
		gbc.weighty = 1;
		addButton(bs[7]);
		
		gbc.weighty = 0;//纵向不会扩大
		gbc.gridwidth = GridBagConstraints.REMAINDER;//该gbc控制的组件将成为横向最后一个组件
		gbc.gridheight=1;
		addButton(bs[8]);
		addButton(bs[9]);
		f.pack();
		f.setVisible(true);
		
	}
	public void addButton(Button b){
		gb.setConstraints(b, gbc);
		f.add(b);
	}
	public static void main(String[] args) {
		new GridBagLayoutTest().init();
	}
	/**有些按钮虽然设置了横向或纵向不会扩大，由于受到邻居按钮的影响，
	 * 所以才会扩大
	 * 疑问：gbc设置了属性后，在调用一次后就会失效吗？
	 */
	 
}
