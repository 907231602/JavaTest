package com.java.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * �����̼����¼�
 * @author Administrator
 *
 */
public class MouseAndKeyEvent {
	private Frame f;
	private Button but;
	private TextField tf;
	
	public MouseAndKeyEvent() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init(){
		f=new Frame("my frame");
		
		f.setBounds(300, 100, 600, 500);
		f.setLayout(new FlowLayout());
		
		tf=new TextField(20);
		but =new Button("my button");
		
		f.add(tf);
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
		
		tf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				int code=e.getKeyCode();
				if(!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9)){
					System.out.println(code+"...��������");
					e.consume();
				}
				
			}
		});
		
		/*but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("action ok");
			}
		});*/
		/**
		 * ��but���һ�����̼���
		 */
		but.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e){
					System.out.println(e.getKeyChar()+"...."+e.getKeyCode());
				}
		});
		/**
		 * ��but���һ��������
		 */
		but.addMouseListener(new MouseAdapter() {
				private int count=0;
				public void mouseEntered(MouseEvent e){
					System.out.println("�����뵽�����"+count++);
					
				}
				
				public void mouseClicked(MouseEvent e){
					if(e.getClickCount()==2){
						System.out.println("˫��");
					}
				}
		});
	}
	
	public static void main(String[] args) {
		new MouseAndKeyEvent();
	}
	
}
