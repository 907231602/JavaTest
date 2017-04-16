package com.java.ip;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;
/**
 * TCP编程
 * @author Administrator
 *
 */
public class TestTCP1 {

	/**
	 * 客户端
	 */
	@Test
	public void client(){
		Socket socket=null;
		OutputStream ops=null;
		try {
			socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
			
			ops = socket.getOutputStream();
			
			ops.write("我是客户端".getBytes());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(ops!=null){
				try {
					
					ops.close();
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
	
	/**
	 * 服务端
	 */
	@Test
	public void ServiceTest(){
		ServerSocket ss=null;
		Socket s=null;
		InputStream is=null;
		try {
			ss = new ServerSocket(9090);
			s = ss.accept();
			 is= s.getInputStream();
			byte[] b=new byte[20];
			int len;
			if((len=is.read(b))!=-1){
				String str=new String(b, 0, len);
				System.out.print(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(is!=null){
				try {
					is.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			if(s!=null){
				try {
					s.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			if(ss!=null){
				try {
					ss.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		}
		
		
	}
	
	
}
