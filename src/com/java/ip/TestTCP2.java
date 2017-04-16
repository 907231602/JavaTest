package com.java.ip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestTCP2 {
	
	@Test
	public void ClientTest(){
		Socket socket=null;
		OutputStream os=null;
		InputStream is=null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9191);
			os = socket.getOutputStream();
			os.write("我是客户端".getBytes());
			//shutdownOutput告诉服务端信息发送完毕
			socket.shutdownOutput();
			is = socket.getInputStream();
			byte[] b= new byte[20];
			int len;
			while((len=is.read(b))!=-1){
				String str=new String(b, 0, len);
			System.out.println(str);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(socket!=null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
		
		
	}
	
	@Test
	public void ServiceTest(){
		ServerSocket ss=null;
		Socket s=null;
		InputStream is=null;
		OutputStream os=null;
		try {
			ss = new ServerSocket(9191);
			s = ss.accept();
			is = s.getInputStream();
			byte[] b=new byte[20];
			int len;
			while((len=is.read(b))!=-1){
				String str=new String(b, 0, len);
				System.out.print(str);
			}
			
			os = s.getOutputStream();
			os.write("服务端已收到".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
						}
			
			if(s!=null){
				try {
					s.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ss!=null){
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		
	}
}
