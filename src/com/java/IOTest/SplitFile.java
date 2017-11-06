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
	private String filePath;//文件的路径
	private int size;//块数
	private long length;//文件大小
	private String fileName;//文件名
	private long blockSize;//每块的大小
	
	private String destBlockPath;//分割后的存放目录
	private List<String> blockpath;//每块的名称
	
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
	
	//初始化操作 计算 块数、确定文件名
	public void init() {
		File src=null;
		//如果路径为空或者文件不存在，则直接返回
		if(null==filePath || !((src=new File(filePath)).exists())) {
			return;
		}
		if(src.isDirectory()) {
			return;
		}
		//文件名
		this.fileName=src.getName();
		//计算块数 实际大小 与每块大小
		this.length=src.length();
		//修正每块大小
		if(this.blockSize>length) {
			this.blockSize=length;
		}
		//确定块数
		size=(int)(Math.ceil(length*1.0/this.blockSize));
		initPathName();
	}
	
	private void initPathName() {
		for(int i=0;i<size;i++) {
			this.blockpath.add(destBlockPath+"/"+this.fileName+".part"+i);
		}
	
	}
	
	/**
	 * 文件的分割
	 * 1）第几块
	 *		1.起始位置
	 *		2.实际大小
	 * @param destPath 分割文件存放目录
	 */
	public void split() {
		//确定文件的路径
		//initPathName(destPath);
		
		
		long beginPos=0;
		long actualBlockSize=blockSize;
		//计算所有块的大小、位置、索引
		for(int i=0;i<size;i++) {
			if(i==size-1) {
				actualBlockSize=this.length-beginPos;
			}
			
			splitDetail(i, beginPos, actualBlockSize);
			beginPos+=actualBlockSize;
		}
	}
	
	/**
	 * 文件分割
	 * @param idex
	 * @param beginPos
	 * @param actualBlockSize
	 */
	private void splitDetail(int index,long beginPos,long actualBlockSize) {
		//创建源
		File src=new File(this.filePath);
		File dest=new File(this.blockpath.get(index));
		//选择流
		RandomAccessFile raf=null;
		BufferedOutputStream bos=null;
		try {
			 raf=new RandomAccessFile(src, "r");
			 bos=new  BufferedOutputStream(new FileOutputStream(dest));
			 
			 raf.seek(beginPos);
			 //缓冲区
			 byte[] flush=new byte[1024];
			 //接收长度
			 int len=0;
			 while(-1!=(len=raf.read(flush))) {
				 if(actualBlockSize-len>=0) {//查看是否足够
					 //写出
					 bos.write(flush, 0, len);
					 actualBlockSize-=len;
				 }else
				 {//写出最后一次的剩余量
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
	 * 文件的合并
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
				 //接收长度
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
	 * 文件的合并，通过SequenceInputStream，合并流
	 * @param destPath
	 */
	public void mergeFileBySequence(String destPath) {
		//创建源
		File dest=new File(destPath);
		//选择流
		BufferedOutputStream bos=null;//输出流
		SequenceInputStream sis=null;//输入流
		//创建容器
		Vector<InputStream> vi =new Vector<InputStream>();
		
		try {
			for(int i=0;i<this.blockpath.size();i++) {
				vi.add(new BufferedInputStream(new FileInputStream(new File(this.blockpath.get(i)))));
			}
			
			bos=new BufferedOutputStream(new FileOutputStream(dest,true));
				sis=new SequenceInputStream(vi.elements());
				
				 byte[] flush=new byte[1024];
				 //接收长度
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
