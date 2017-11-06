package com.java.IOTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileCharIOTest {

	/**
	 * ��ȡ�ļ�����,����ʹ�ö�̬��ʹ��BufferedReader
	 * @param fileName
	 */
	public void readerFiles(String fileName) {
		File file =new File(fileName);
		BufferedReader r=null;
		try {
			r=new BufferedReader(new FileReader(file)) ;
			char[] cbuf=new char[1024];
			int len=0;
			String line=null;
			/*while((len=r.read(cbuf))!=-1) {
				System.out.println(String.valueOf(cbuf, 0, len));
			}*/
			while((line=r.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(r!=null)
				r.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	/**
	 * ׷��д�ļ�����
	 * @param filePath
	 */
	public void writerFiles(String filePath) {
		File file=new File(filePath);
		Writer w=null;
		try {
			w=new FileWriter(file,true);
			
			String content="���������ļ�����ʾ���ļ��������·�������ڣ����ܴ���";
			w.append("\n\r");
			w.write(content);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(w!=null)
				w.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileCharIOTest fc=new FileCharIOTest();
		fc.readerFiles("file"+File.separator+"fileOut.txt");
		
		fc.writerFiles("file"+File.separator+"fileOut.txt");

	}

}

