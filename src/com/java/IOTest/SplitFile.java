package com.java.IOTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
	private String filePath;//�ļ���·��
	private int size;//����
	private long length;//�ļ���С
	private String fileName;//�ļ���
	private long blockSize;//ÿ��Ĵ�С
	
	private String destBlockPath;//�ָ��Ĵ��Ŀ¼
	private List<String> blockpath;//ÿ�������
	
	public SplitFile() {
		blockpath=new ArrayList<String>();
	}
	public SplitFile(String filePath,String destBlockPath) {
		this(filePath,1024,destBlockPath);
		
	}
	public SplitFile(String filePath,long blockSize,String destBlockPath) {
		this();
		this.filePath=filePath;
		this.blockSize=blockSize;
		this.destBlockPath=destBlockPath;
		init();
	}
	
	//��ʼ������ ���� ������ȷ���ļ���
	public void init() {
		File src=null;
		//���·��Ϊ�ջ����ļ������ڣ���ֱ�ӷ���
		if(null==filePath || !((src=new File(filePath)).exists())) {
			return;
		}
		if(src.isDirectory()) {
			return;
		}
		//�ļ���
		this.fileName=src.getName();
		//������� ʵ�ʴ�С ��ÿ���С
		this.length=src.length();
		//����ÿ���С
		if(this.blockSize>length) {
			this.blockSize=length;
		}
		//ȷ������
		size=(int)(Math.ceil(length*1.0/this.blockSize));
		initPathName();
	}
	
	private void initPathName() {
		for(int i=0;i<size;i++) {
			this.blockpath.add(destBlockPath+"/"+this.fileName+".part"+i);
		}
	
	}
	
	/**
	 * �ļ��ķָ�
	 * 1���ڼ���
	 *		1.��ʼλ��
	 *		2.ʵ�ʴ�С
	 * @param destPath �ָ��ļ����Ŀ¼
	 */
	public void split() {
		//ȷ���ļ���·��
		//initPathName(destPath);
		
		
		long beginPos=0;
		long actualBlockSize=blockSize;
		//�������п�Ĵ�С��λ�á�����
		for(int i=0;i<size;i++) {
			if(i==size-1) {
				actualBlockSize=this.length-beginPos;
			}
			
			splitDetail(i, beginPos, actualBlockSize);
			beginPos+=actualBlockSize;
		}
	}
	
	/**
	 * �ļ��ָ�
	 * @param idex
	 * @param beginPos
	 * @param actualBlockSize
	 */
	private void splitDetail(int index,long beginPos,long actualBlockSize) {
		//����Դ
		File src=new File(this.filePath);
		File dest=new File(this.blockpath.get(index));
		//ѡ����
		RandomAccessFile raf=null;
		BufferedOutputStream bos=null;
		try {
			 raf=new RandomAccessFile(src, "r");
			 bos=new  BufferedOutputStream(new FileOutputStream(dest));
			 
			 raf.seek(beginPos);
			 //������
			 byte[] flush=new byte[1024];
			 //���ճ���
			 int len=0;
			 while(-1!=(len=raf.read(flush))) {
				 if(actualBlockSize-len>=0) {//�鿴�Ƿ��㹻
					 //д��
					 bos.write(flush, 0, len);
					 actualBlockSize-=len;
				 }else
				 {//д�����һ�ε�ʣ����
					 bos.write(flush, 0, (int)actualBlockSize);
					 break;
				 }
				
			 }
			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(bos!=null)
					bos.close();
				if(raf!=null)
					raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * �ļ��ĺϲ�
	 * @param destPath
	 */
	public void mergeFile(String destPath) {
		File dest=new File(destPath);
		BufferedOutputStream bos=null;
		try {
			bos=new BufferedOutputStream(new FileOutputStream(dest,true));
			BufferedInputStream bis=null;
			for(int i=0;i<this.blockpath.size();i++) {
				bis=new BufferedInputStream(new FileInputStream(new File(this.blockpath.get(i))));
				
				 byte[] flush=new byte[1024];
				 //���ճ���
				 int len=0;
				 while(-1!=(len=bis.read(flush))) {
					 bos.write(flush, 0, len);
				 }
				 bos.flush();
				 bis.close();
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(bos!=null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * �ļ��ĺϲ���ͨ��SequenceInputStream���ϲ���
	 * @param destPath
	 */
	public void mergeFileBySequence(String destPath) {
		//����Դ
		File dest=new File(destPath);
		//ѡ����
		BufferedOutputStream bos=null;//�����
		SequenceInputStream sis=null;//������
		//��������
		Vector<InputStream> vi =new Vector<InputStream>();
		
		try {
			for(int i=0;i<this.blockpath.size();i++) {
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockpath.get(i)))));
			}
			
			bos=new BufferedOutputStream(new FileOutputStream(dest,true));
				sis=new SequenceInputStream(vi.elements());
				
				 byte[] flush=new byte[1024];
				 //���ճ���
				 int len=0;
				 while(-1!=(len=sis.read(flush))) {
					 bos.write(flush, 0, len);
				 }
				 bos.flush();
				 sis.close();
			}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(bos!=null)
					bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		SplitFile file=new SplitFile("file"+File.separator+"fileOut.txt",150,"file");
		//System.out.println(file.size); 
		//file.split();
		file.mergeFile("file/Split.txt");
	}
	
}
