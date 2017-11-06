package com.java.IOTest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayDemo {
	
	/**
	 * 输入流 操作与文件输入流一致
	 * 读取字节数组
	 * @throws IOException
	 */
	public void ByteRead() throws IOException {
		String str="创建抽象文件名表示的文件";
		byte[] b=str.getBytes();
		InputStream br=new BufferedInputStream(new ByteArrayInputStream(b));
		
		while(br.read(b)!=-1) {
			
			System.out.println(new String(b, 0, b.length));
		}
		br.close();
		
	}
	public void ByteRead(byte[] src) throws IOException {
		//String str="创建抽象文件名表示的文件";
		//byte[] b=src.getBytes();
		InputStream br=new BufferedInputStream(new ByteArrayInputStream(src));
		
		while(br.read(src)!=-1) {
			
			System.out.println(new String(src, 0, src.length));
		}
		br.close();
		
	}
	
	/**
	 * 输出流 操作与文件输出流有些不同，有新增方法，不能使用多态
	 * @throws IOException
	 */
	public void ByteWrite() throws IOException {
		//目的地
		byte[] dest;
		//选择流  不同点
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		
		//操作写出
		String msg="创建抽象文件名表示的文件";
		byte[] info=msg.getBytes();
		bos.write(info, 0, info.length);
		//获取数据
		dest=bos.toByteArray();
		//释放数据
		bos.close();
		
	}
	public byte[] ByteWrites() throws IOException {
		//目的地
		byte[] dest;
		//选择流  不同点
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		//操作写出
		String msg="创建抽象文件名表示的文件";
		byte[] info=msg.getBytes();
		bos.write(info, 0, info.length);
		//获取数据
		dest=bos.toByteArray();
		//释放数据
		bos.close();
		return dest;
		
	}
	
	public static void main(String[] args) throws IOException {
		ByteArrayDemo bad=new ByteArrayDemo();
		bad.ByteRead();
		bad.ByteRead(bad.ByteWrites());
	}

}
