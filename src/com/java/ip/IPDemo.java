package com.java.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class IPDemo {
		public static void main(String[] args) {
			
			
			String  s1="a"+"b";
			   String  s2=new  String(s1);
			    if(s1==s2)
			       System.out.println("== is succeed");
			   if (s1.equals(s2))
			      System.out.println(".equals() is succeeded");

			   //System.out.println("s=" + s);

			/*try {
				//InetAddress ia=InetAddress.getLocalHost();
				InetAddress ia=InetAddress.getByName("www.atguigu.com");
				System.out.println(ia);
				System.out.println(ia.getHostName());
				System.out.println(ia.getHostAddress());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		}
}
