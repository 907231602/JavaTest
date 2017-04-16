package com.java.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtDemo {
	private Frame f;
	private Button but;
	
	public AwtDemo() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init(){
		f=new Frame("my frame");
		
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		but =new Button("my button");
		
		f.add(but);
		
		myEvent();
		
		f.setVisible(true);
	}
	
	public void myEvent(){
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("按钮关闭的");
				System.exit(0);
			}
		} );
	}
	
	public static void main(String[] args) {
		new AwtDemo();
	}
	
/*	public static void main(String[] args) {
		Frame f=new Frame("my awt");
		
		f.setSize(500, 400);
		f.setLocation(300, 200);
		f.setLayout(new FlowLayout());
		
		Button b=new Button("按钮");
		
		f.add(b);
		f.setVisible(true);
		System.out.println("hello awt");
	}*/
}
