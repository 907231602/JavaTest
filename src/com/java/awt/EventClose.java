package com.java.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventClose {
	public static void main(String[] args) {
		System.out.println("kkk");
		Frame f=new Frame("my window Event");
		
		Button b=new Button("click me");
		f.setBounds(200, 100, 100, 200);
		f.setLayout(new FlowLayout());
		f.add(b);
		f.addWindowListener(new Myevent());
		f.setVisible(true);
	}
}

class Myevent extends WindowAdapter{
	   public void windowClosing(WindowEvent e) {
		   System.out.println("exit");
	   }

}
