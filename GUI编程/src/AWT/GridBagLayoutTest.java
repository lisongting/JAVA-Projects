package AWT;
/**
 * ����GridBagLayout
 * 2016.7.28
 */
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutTest {

	private Frame f = new Frame("���Դ���");
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private Button[] bs = new Button[10];
	public void init(){
		f.setLayout(gb);
		for(int i=0;i<bs.length;i++){
			bs[i] = new Button("��ť"+i);
		}
		
		gbc.fill = GridBagConstraints.BOTH;//������������Ժ�����������
		gbc.weightx = 1;//������������ӱ���Ϊ1
		addButton(bs[0]);
		addButton(bs[1]);
		addButton(bs[2]);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;//��gbc���Ƶ��������Ϊ�������һ�����
		addButton(bs[3]);
		
		gbc.weightx = 0;//������ں����ϲ�������
		addButton(bs[4]);
		
		gbc.gridwidth = 2;//�������������������
		addButton(bs[5]);
		
		gbc.gridwidth = 1;//�����1������
		gbc.gridheight = 2;//�����2������
		gbc.gridwidth = GridBagConstraints.REMAINDER;//��gbc���Ƶ��������Ϊ�������һ�����
		addButton(bs[6]);//����6��û�������2�����񰡣��ѵ�����Ϊ�������ˣ�
		
		gbc.gridwidth = 1;
		gbc.gridheight = 2;//�ݿ�2������
		gbc.weighty = 1;
		addButton(bs[7]);
		
		gbc.weighty = 0;//���򲻻�����
		gbc.gridwidth = GridBagConstraints.REMAINDER;//��gbc���Ƶ��������Ϊ�������һ�����
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
	/**��Щ��ť��Ȼ�����˺�������򲻻����������ܵ��ھӰ�ť��Ӱ�죬
	 * ���ԲŻ�����
	 * ���ʣ�gbc���������Ժ��ڵ���һ�κ�ͻ�ʧЧ��
	 */
	 
}
