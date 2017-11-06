package com.java.IOTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * ת������ �ֽ���ת�����ֽ���
 * 1.�����outputStreamWriter  ����  
 * 2.������InputStreamReader   ����
 * 
 * @author Administrator
 *
 */

public class ConverDemo {

	public static void main(String[] args) throws IOException {
		//ָ�������ַ���
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
