package com.java.awt;

import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 记事本
 * @author Administrator
 *
 */
public class MenuBars {
	private Frame f;
	private Menu m,subm;
	private MenuBar mb;
	private MenuItem mi,submi,submi1,openFile,saveFile;
	private FileDialog openDialog,saveDialog;
	private TextArea ta;
	private File file;
	
	public MenuBars() {
		// TODO Auto-generated constructor stub
		f=new Frame("hello");
		m=new Menu("菜单");
		subm=new Menu("查看");
		mb=new MenuBar();
		mi=new MenuItem("退出");
		submi=new MenuItem("大图标");
		submi1=new MenuItem("小图标");
		openFile=new MenuItem("打开");
		saveFile=new MenuItem("保存");
		ta=new TextArea();
		
		subm.add(submi);
		subm.add(submi1);
	
		m.add(subm);
		m.add(openFile);
		m.add(saveFile);
		m.add(mi);
		
		mb.add(m);
		f.setMenuBar(mb);
		
		f.setBounds(100, 100, 600, 670);
		f.add(ta);
		openDialog =new FileDialog(f, "open file", FileDialog.LOAD);
		saveDialog =new FileDialog(f, "save file", FileDialog.SAVE);
		myeve();
		f.setVisible(true);
		
		
	}
	private void myeve(){
		openFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				openDialog.setVisible(true);
				String dir=openDialog.getDirectory();
				String fileName=openDialog.getFile();
			System.out.println("dir="+dir+" fileName="+fileName);
			if(dir==null || fileName==null){
				return;
			}
			ta.setText("");
			 file=new File(dir, fileName);
			try {
				BufferedReader bufr=new BufferedReader(new FileReader(file));
				String line=null;
				while((line=bufr.readLine())!=null){
					ta.append(line+"\r\n");
				}
				
			} catch (IOException e2) {
				// TODO: handle exception
				throw new RuntimeException("读取失败");
			}
			
			}
		});
		
		saveFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(file==null){
					saveDialog.setVisible(true);
				String dir=	saveDialog.getDirectory();
					String fileName=saveDialog.getFile();
					if(dir==null ||fileName ==null){
						return;
					}
					file=new File(dir, fileName);
				}
				try {
					BufferedWriter bufw=new BufferedWriter(new FileWriter(file));
					String text=ta.getText();
					bufw.write(text);
					bufw.flush();
					bufw.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		
		
		f.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) {
				 System.exit(0);
			 }
		});
		
		mi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new MenuBars();
	}
}
