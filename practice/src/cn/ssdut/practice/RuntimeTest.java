package cn.ssdut.practice;

import java.io.IOException;

/**
 * ����Runtime��
 * 2016.7.24
 * @author LST
 *
 */
public class RuntimeTest {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println("������������"+rt.availableProcessors());
		System.out.println("�����ڴ�����"+rt.freeMemory());
		System.out.println("���ڴ�����"+rt.totalMemory());
		System.out.println("����ڴ�����"+rt.maxMemory());
		//System.out.println(Math.random());
		
	}

}
