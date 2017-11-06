package com.java.IOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 基本数据类型+String处理流
 * 
 * @author Administrator 
 * 输入流：DataInputStream
 * 
 * 输出流：DataOutputStream
 *
 *EOFException 没有读取到相应的内容
 */
public class DataDemo {

	// 输出 数据+类型到文件中
	public void writeData() throws FileNotFoundException {
		double point = 2.5;
		int num = 10;
		String str = "数据类型读取";
		File file = new File("file" + File.separator + "DataType.txt");
		DataOutputStream dos = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(file)));
		try {
			dos.writeDouble(point);
			dos.writeInt(num);
			dos.writeUTF(str);
			dos.flush();
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 读取文件数据
	public void readData() throws FileNotFoundException {
		File file = new File("file" + File.separator + "DataType.txt");

		DataInputStream dis = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(file)));
		
		try {
			
		double num1=	dis.readDouble();
		int num2=dis.readInt();
		String str=dis.readUTF();
		System.out.println(String.format("num1=%f num2=%d str=%s", num1,num2,str));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		DataDemo dd = new DataDemo();
		dd.writeData();
		dd.readData();

	}

}
