package com.java.IOTest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 按指定位置获取文件字节
 * RandomAccessFile 此类的实例支持对随机访问文件的读取和写入。
 * @author Administrator
 *
 */
public class RandomAccessDemo {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("file"+File.separator+"fileOut.txt"), "r");
		raf.seek(10);
		
		byte[] b=new byte[1024];
		int len=0;
		while((len=raf.read(b))!=-1) {
			System.out.println(new String(b,0,len));
		}
		
		raf.close();
	}
}
