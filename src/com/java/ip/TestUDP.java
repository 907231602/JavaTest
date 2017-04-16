package com.java.ip;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Test;

public class TestUDP {
	
	@Test
	public void send(){
		//数据报套接字
		DatagramSocket ds=null;
		try {
			ds = new DatagramSocket();
			byte[] b ="我是数据".getBytes();
			//创建数据报
			DatagramPacket dp=new DatagramPacket(b, 0, b.length, InetAddress.getByName("127.0.0.1"), 9292);
			
			ds.send(dp);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ds!=null){
				ds.close();
				
			}
		}
		
	}
	
	@Test
	public void receives(){
		DatagramSocket ds=null;
		try {
			ds = new DatagramSocket(9292);
			byte[] b=new byte[64];
			DatagramPacket dp = new DatagramPacket(b, 0, b.length);
			ds.receive(dp);
			String str=new String(dp.getData(), 0, dp.getLength());
			
			System.out.println(str);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(ds!=null){
				ds.close();
			}
		}
		
		
	}
}
