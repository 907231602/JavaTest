package com.java.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {
		public static void main(String[] args) {
			try {
				//InetAddress ia=InetAddress.getLocalHost();
				InetAddress ia=InetAddress.getByName("www.atguigu.com");
				System.out.println(ia);
				System.out.println(ia.getHostName());
				System.out.println(ia.getHostAddress());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
