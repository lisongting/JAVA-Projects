package AWT;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

/**
 * 测试Flowout布局管理器
 * 2016.7.28
 * @author LST
 *
 */
public class FlowLayoutTest {

	public static void main(String[] args) {
		Frame f = new Frame("测试窗口");
		//创建FlowLayout布局管理器，排序方式为从左向右，水平间距20，垂直间距5
		f.setLayout(new FlowLayout(FlowLayout.LEFT,20,5));
		for(int i=0;i<10;i++){
			f.add(new Button("按钮"));
			
		}
		f.pack();//将窗口大小设置为最佳大小，这样就不必在跨平台时手动设置窗口大小
		f.setVisible(true);
	}

}
