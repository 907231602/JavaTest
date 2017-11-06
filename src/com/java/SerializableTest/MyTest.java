package com.java.SerializableTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
/**
 * ���л��������л�
 * @author Administrator
 *
 */
public class MyTest implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String name="SheepMu";
    private int age=24;
    
    public static void main(String[] args)
    {//���´���ʵ�����л�
        try
        {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("my.out"));//�����������ļ���Ϊ my.out ��ObjectOutputStream�ܰ�Object�����Byte��
            MyTest myTest=new MyTest();
            oos.writeObject(myTest); 
            oos.flush();  //������ 
            oos.close(); //�ر���
        } catch (FileNotFoundException e) 
        {        
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        } 
        fan();//���������  �����л�  ����
    }
    public static void fan()//�����еĹ���
    {    
         ObjectInputStream oin = null;//�ֲ���������Ҫ��ʼ��
        try
        {
            oin = new ObjectInputStream(new FileInputStream("my.out"));
        } catch (FileNotFoundException e1)
        {        
            e1.printStackTrace();
        } catch (IOException e1)
        {
            e1.printStackTrace();
        }      
        MyTest mts = null;
        try {
            mts = (MyTest ) oin.readObject();//��Object��������ת��ΪMyTest����
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }     
         System.out.println("name="+mts.name);    
         System.out.println("age="+mts.age);    
    }
}
