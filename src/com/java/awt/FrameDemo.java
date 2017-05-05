package com.java.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameDemo {
	private Frame f;
	private Button b;
	private TextField tf;
	public FrameDemo() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	private void  init(){
		f=new Frame("new Frame Demo");
		b=new Button("click me");
		tf=new TextField(10);
		f.setBounds(100,200, 200, 300);
		f.setLayout(new FlowLayout());
		f.add(tf);
		f.add(b);
		myevn();
		f.setVisible(true);
	}
	
	private void myevn(){
		f.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				System.out.println("窗口打开啦");
			}

		    /**
		     * Invoked when a window is in the process of being closed.
		     * The close operation can be overridden at this point.
		     */
		    public void windowClosing(WindowEvent e) {
		    	System.out.println("窗口关闭ing");
		    	System.exit(0);
		    }
		});
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				System.out.println("hello"+tf.getText());
			}
		});
		
		b.addKeyListener(new KeyAdapter() {
			 public void keyPressed(KeyEvent e) {
				 if(e.isControlDown() && e.getKeyCode()==65)
					 System.out.println("control+A");
				 else
				 System.out.println(e.getKeyCode()+"..."+e.getKeyChar());
			 }
		});
		
		
		tf.addKeyListener(new KeyAdapter() {
			  public void keyPressed(KeyEvent e) {
				  if(e.getKeyCode()>=KeyEvent.VK_0 && e.getKeyCode()<=KeyEvent.VK_9)
					  ;
				  else{
					  e.consume();
					  System.out.println(e.getKeyChar()+"不合法");
				  }
				    
			  }
		});
	}
	
	public static void main(String[] args) {
		FrameDemo fd=new FrameDemo();
	}
}
