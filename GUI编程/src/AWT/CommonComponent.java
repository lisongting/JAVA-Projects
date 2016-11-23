package AWT;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.Box;

/**
 * ����awt��һЩ���õ����
 * 2016.7.29
 * @author LST
 *
 */
public class CommonComponent {
	Frame f= new Frame("���Գ�������Ĵ���");
	Button ok = new Button("OK");
	CheckboxGroup cbg = new CheckboxGroup();//һ��group��ֻ����һ��Checkbox��ѡ��
	Checkbox male = new Checkbox("��",cbg,true);
	Checkbox female = new Checkbox("Ů",cbg,false);
	//����һ�������ĸ�ѡ�򣬱���Ƿ��ѻ�
	Checkbox married = new Checkbox("�Ƿ��ѻ飿",false);
	Choice colorChooser = new Choice();//����ѡ���
	List colorList = new List(6,true);//�б�ѡ���
	TextArea ta = new TextArea(5,20);//����һ��5��20�еĶ����ı�
	TextField name = new TextField(50);//����һ��50�еĵ����ı���
	public void init(){
		colorChooser.add("��ɫ");
		colorChooser.add("��ɫ");
		colorChooser.add("��ɫ");
		colorList.add("��ɫ");
		colorList.add("��ɫ");
		colorList.add("��ɫ");
		colorList.add("��ɫ");
		
		//����һ��װ���ı���Ͱ�ť��panel
		Panel bottom = new Panel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom,BorderLayout.SOUTH);
		
		Panel checkPanel = new Panel();//����һ��װ������ѡ�������Checkbox ��panel
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		
		Box topLeft = Box.createVerticalBox();//����һ����ֱ���е�Box��ʢװ�����ı�����panel
		topLeft.add(ta);
		topLeft.add(checkPanel);
		
		Box top = Box.createHorizontalBox();//����һ��ˮƽ���е����box��ʢװtopLeft,colorList
		top.add(topLeft);
		top.add(colorList);
		f.add(top);
		f.pack();
		f.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new CommonComponent().init();
	}

}
