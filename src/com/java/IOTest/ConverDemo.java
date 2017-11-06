package com.java.IOTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 转换流： 字节流转换成字节流
 * 1.输出流outputStreamWriter  编码  
 * 2.输入流InputStreamReader   解码
 * 
 * @author Administrator
 *
 */

public class ConverDemo {

	public static void main(String[] args) throws IOException {
		//指定解码字符集
		BufferedReader br=new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								new File("file"+File.separator+"fileOut.txt")), "GBK"));
		String line=null;
		while ((line=br.readLine())!=null) {
			System.out.println(line);
			
		}
		br.close();
	}
}
