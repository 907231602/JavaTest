package com.java.awt;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class MyWindowDemo {
	private Frame f;
	private Button but;
	private TextField tf;
	private TextArea ta;
	
	private Dialog d;
	private Label lab;
	private Button okBut;
	
	public MyWindowDemo() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init(){
		f = new Frame("my window");
		f.setBounds(200,100,300,400);
		f.setLayout(new FlowLayout());
		
		tf=new TextField(30);
		
		but = new Button("跳转");
		
		ta =new TextArea(10,30);
		
		d=new Dialog(f, "提示信息",true);
		d.setBounds(200,150, 200, 150);
		d.setLayout(new FlowLayout());
		lab=new Label();
		okBut=new Button("确定");
		
		d.add(lab);
		d.add(okBut);
		
		f.add(tf);
		f.add(but);
		f.add(ta);
		
		myEvent();
		f.setVisible(true);
		
	}
	
	private void myEvent(){
		
		okBut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				d.setVisible(false);
			}
		});
		
		d.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				d.setVisible(false);
			}
		});
		
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*String texts=tf.getText();
				System.out.println(texts);*/
				String dirPath=tf.getText();
				
				File dir=new File(dirPath);
				if(dir.exists() && dir.isDirectory()){
					ta.setText("");
					String[] names=dir.list();
					for(String name:names){
						ta.append(name+"\r\n");
					}
				}else{
					String info="目录"+dirPath+"错误";
					lab.setText(info);
					d.setVisible(true);
				}
				
				tf.setText("");
				
			}
		});
		
		f.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public static void main(String[] args) {
	       new	MyWindowDemo();
	}
}
