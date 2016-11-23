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
 * 测试awt中一些常用的组件
 * 2016.7.29
 * @author LST
 *
 */
public class CommonComponent {
	Frame f= new Frame("测试常用组件的窗口");
	Button ok = new Button("OK");
	CheckboxGroup cbg = new CheckboxGroup();//一个group中只能有一个Checkbox被选中
	Checkbox male = new Checkbox("男",cbg,true);
	Checkbox female = new Checkbox("女",cbg,false);
	//定义一个单独的复选框，标记是否已婚
	Checkbox married = new Checkbox("是否已婚？",false);
	Choice colorChooser = new Choice();//下拉选择框
	List colorList = new List(6,true);//列表选择框
	TextArea ta = new TextArea(5,20);//定义一个5行20列的多行文本
	TextField name = new TextField(50);//定义一个50列的单行文本域
	public void init(){
		colorChooser.add("红色");
		colorChooser.add("绿色");
		colorChooser.add("蓝色");
		colorList.add("红色");
		colorList.add("绿色");
		colorList.add("蓝色");
		colorList.add("黄色");
		
		//创建一个装了文本框和按钮的panel
		Panel bottom = new Panel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom,BorderLayout.SOUTH);
		
		Panel checkPanel = new Panel();//创建一个装了下拉选择框，三个Checkbox 的panel
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		
		Box topLeft = Box.createVerticalBox();//创建一个垂直排列的Box，盛装多行文本区和panel
		topLeft.add(ta);
		topLeft.add(checkPanel);
		
		Box top = Box.createHorizontalBox();//创建一个水平排列的组件box，盛装topLeft,colorList
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
