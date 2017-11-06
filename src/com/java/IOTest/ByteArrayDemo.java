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
	 * ������ �������ļ�������һ��
	 * ��ȡ�ֽ�����
	 * @throws IOException
	 */
	public void ByteRead() throws IOException {
		String str="���������ļ�����ʾ���ļ�";
		byte[] b=str.getBytes();
		InputStream br=new BufferedInputStream(new ByteArrayInputStream(b));
		
		while(br.read(b)!=-1) {
			
			System.out.println(new String(b, 0, b.length));
		}
		br.close();
		
	}
	public void ByteRead(byte[] src) throws IOException {
		//String str="���������ļ�����ʾ���ļ�";
		//byte[] b=src.getBytes();
		InputStream br=new BufferedInputStream(new ByteArrayInputStream(src));
		
		while(br.read(src)!=-1) {
			
			System.out.println(new String(src, 0, src.length));
		}
		br.close();
		
	}
	
	/**
	 * ����� �������ļ��������Щ��ͬ������������������ʹ�ö�̬
	 * @throws IOException
	 */
	public void ByteWrite() throws IOException {
		//Ŀ�ĵ�
		byte[] dest;
		//ѡ����  ��ͬ��
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		
		//����д��
		String msg="���������ļ�����ʾ���ļ�";
		byte[] info=msg.getBytes();
		bos.write(info, 0, info.length);
		//��ȡ����
		dest=bos.toByteArray();
		//�ͷ�����
		bos.close();
		
	}
	public byte[] ByteWrites() throws IOException {
		//Ŀ�ĵ�
		byte[] dest;
		//ѡ����  ��ͬ��
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		//����д��
		String msg="���������ļ�����ʾ���ļ�";
		byte[] info=msg.getBytes();
		bos.write(info, 0, info.length);
		//��ȡ����
		dest=bos.toByteArray();
		//�ͷ�����
		bos.close();
		return dest;
		
	}
	
	public static void main(String[] args) throws IOException {
		ByteArrayDemo bad=new ByteArrayDemo();
		bad.ByteRead();
		bad.ByteRead(bad.ByteWrites());
	}

}
