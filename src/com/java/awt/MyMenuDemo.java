package com.java.awt;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyMenuDemo {
	private Frame f;
	private MenuBar mb;
	private Menu m,subMenu,con;
	private MenuItem closeItem,subItem;
	
	public MyMenuDemo() {
		init();
	}
	
	public void init(){
		f = new Frame("my window");
		f.setBounds(200,100,300,400);
		f.setLayout(new FlowLayout());
		
		mb=new MenuBar();
		
		m=new Menu("文件");
		con=new Menu("编辑");
		
		subMenu=new Menu("子菜单");
		subItem=new MenuItem("子条目");
		closeItem =new MenuItem("退出");
		
		subMenu.add(subItem);
		
		m.add(subMenu);
		m.add(closeItem);
		mb.add(m);
		mb.add(con);
		
		f.setMenuBar(mb);
		
		myEvent();
		f.setVisible(true);
	}
	
	private void myEvent(){
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new MyMenuDemo();
	}
}
