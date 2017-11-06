package com.java.IOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FileLIst {
	
	/**
	 * �ļ���ȡ
	 * @param filePath
	 */
	public void FileReadMethod(String filePath) {
		File file =new File(filePath);
		InputStream fis=null;
		if(file.isFile()) {
			 try {
				fis=new FileInputStream(file);
				byte[] b=new byte[1024];
				 while(fis.read(b)!=-1)
				 {
					 System.out.println(String.format("--->�ַ�����ʽ��%d %s", 2,"rrr"));
					String s=new String(b, 0, b.length);
					System.out.println(s);
				 }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(fis!=null)
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
		}
	}
	
	/**
	 * ����ļ�����
	 * @param path
	 */
	public void FileWriteMethod(String path) {
		File file=new File(path);
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(file,true);
			byte[] b="hello".getBytes();
			fos.write(b);
			
			fos.flush();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(fos!=null)
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * �����ļ�
	 * @param inputPath
	 * @param outPutPath
	 */
	public void  fileCopy(String inputPath,String outPutPath) {
		
			File inPath=new File(inputPath);
			File outPath=new File(outPutPath);
			FileInputStream fis=null;
			FileOutputStream fos=null;
			try {
				fis=new FileInputStream(inPath);
				fos=new FileOutputStream(outPath);
				
				byte[] b=new byte[1024];
				
				int len=0;
				while((len=fis.read(b))!=-1) {
					fos.write(b, 0, len);
				}
				fos.flush();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(fos!=null)
						fos.close();
					if(fis!=null)
						fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			
	}
	
	/**
	 * �ж��ļ��Ƿ���ڣ����ھ�ɾ���������ھʹ���
	 * @param fileName
	 */
	public void checkFileIsExist(FileLIst FL ,String fileName) {
		File file=new File("jack.txt");
		System.out.println(String.format("�ļ�����·����%s", file.getAbsolutePath())	);
		System.out.println(file.getParent());
		
		if(file.exists()) {
			file.delete();
		}else {
			try {
				file.createNewFile();
				FL.FileWriteMethod("jack.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("�ļ�������");
		}
	}
	
	/**
	 * �����ļ�Ŀ¼
	 * @param src
	 * @param dest
	 */
	public void copyFileDirectory(File src,File dest) {
		if(src.isDirectory()) {
			dest.mkdirs();
			System.out.println(Arrays.asList(src.list()));
			/*for (File DirName : src.listFiles()) {
				copyFileDirectory(DirName,new File(dest,DirName.getName()));
			}*/
			/*for(String name:src.list()) {
				System.out.println(new File(name).getAbsolutePath());
				System.out.println("-->"+new File(dest,name).getAbsolutePath()); 
				copyFileDirectory(new File(name), new File(dest,name));
			}*/
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File[] roots=File.listRoots();
		System.out.println(Arrays.asList(roots));
		System.out.println(File.separator);
		
		FileLIst FL=new FileLIst();
		String path="E:"+File.separator+"test\\JavaTest\\src\\com\\java\\IOTest";
		//����ļ��Ƿ����
		//FL.checkFileIsExist(FL, "jack.txt");
		
		File file=new File(path);
		if(file.isDirectory()) {
			for (String files : file.list()) {
				System.out.println(files);
			} 
		}
		
		File copyFile=new File("F:\\Android-movies");
		File dest=new File("F:\\copy",copyFile.getName());
		//FL.copyFileDirectory(copyFile, dest);
		
		//��ȡ�ļ�
		//FL.FileReadMethod(path);
		//д�ļ�
		//FL.FileWriteMethod("file\\fileOut.txt");
		//�����ļ�
		//FL.fileCopy("file\\list.png", "file\\list2.png");
			
			

	}

}
