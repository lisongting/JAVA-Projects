package cn.ssdut.practice;

import java.io.IOException;

/**
 * 测试Runtime类
 * 2016.7.24
 * @author LST
 *
 */
public class RuntimeTest {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println("处理器数量："+rt.availableProcessors());
		System.out.println("空闲内存数："+rt.freeMemory());
		System.out.println("总内存数："+rt.totalMemory());
		System.out.println("最大内存数："+rt.maxMemory());
		//System.out.println(Math.random());
		
	}

}
