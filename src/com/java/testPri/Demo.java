package com.java.testPri;

import java.util.Random;

public class Demo extends AB implements BC{
	/*static{
		System.out.println("je");
	}*/
	boolean hek;
	BC bc;
	
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		//super.finalize();
		System.out.println("astart");
	}
	
	int age;
 Demo(int age) {
		// TODO Auto-generated constructor stub
	 age=age;
	}


	public static void main(String[] args) {
		int c = 0;
        try
        {
        	System.currentTimeMillis();
        	System.out.println(System.currentTimeMillis());
        	
        	String s="abc";
        	String ss="abc";
        	String s3="abc"+"def";
        	String s4="abcdef";
        	String s5=ss+"def";
        	System.out.println(ss.hashCode());
        	String s2=new String("abc");
        	System.out.println(s==ss);//t
        	System.out.println(s3==s4);//t
        	System.out.println(s4==s5);//f
        	System.out.println(s4.equals(s5));//t
        	
        	System.out.println(System.currentTimeMillis());
        	
          /*  int a = 3;
            int b = 0;
String d="asdfghjkl";
System.out.println(d.substring(2, 5));*/
            // ������������쳣
           // c = a / b;
           // Throwable

            // ��ô�쳣֮��Ĵ��붼���ᱻִ��
            System.out.println("Hello World");
        }
        catch (ArithmeticException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //������û�з����쳣��finally���鶼�ᱻִ��
            System.out.println("Welcome");
        }

        System.out.println(c);
        // ��bΪ0ʱ�����쳣�����Ϊc�ĳ�ʼֵ0
		
		
		
		/////////////////////////////////////////////////////
		/*double i= Math.random()+15;
		System.out.println(i);*/
		//int a=975311;
		//System.out.printf("%d", a);
		/*int b=3;
		a=4;
		AB ab=null;
		
		
		Demo d=new Demo(a);
		new Demo(a);
		new Demo(a);
		new Demo(a);*/
		/*System.out.println(d.age);
		System.gc();*/
	//	System.exit(0);
		/*java.util.Random r=new Random();
		System.out.println( r.nextInt(100));*/
	}

	public boolean isHek() {
		return hek;
	}

	public void setHek(boolean hek) {
		this.hek = hek;
	}

}
