package com.java.DesignPatterns.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ԭ��ģʽ
 * @author Administrator
 *
 */
public class Prototype implements Cloneable ,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String string;
	private SerializableObject object;

	/**
	 * ǳ����
	 */
	public Object clone() throws CloneNotSupportedException{
		Prototype proto=(Prototype) super.clone();
		return proto;
	}
	
	/**
	 * ���
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object deepClone() throws IOException, ClassNotFoundException{
		//д�뵱ǰ����Ķ�������
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(this);
		//�����������������Ķ���
		ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		return  ois.readObject();
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public SerializableObject getObject() {
		return object;
	}

	public void setObject(SerializableObject object) {
		this.object = object;
	}
}



class SerializableObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
