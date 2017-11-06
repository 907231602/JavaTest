package com.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class c = Class.forName("java.lang.Integer");
		      //��ȡ���е�����?
			Field[] fs = c.getDeclaredFields();
	 
	               //����ɱ䳤���ַ����������洢����
			StringBuffer sb = new StringBuffer();
	        //ͨ��׷�ӵķ�������ÿ������ƴ�ӵ����ַ�����
			//����ߵ�public����
			sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() +"{\n");
	        //��ߵ�ÿһ������
			for(Field field:fs){
				sb.append("\t");//�ո�
				sb.append(Modifier.toString(field.getModifiers())+" ");//������Ե����η�������public��static�ȵ�
				sb.append(field.getType().getSimpleName() + " ");//���Ե����͵�����
				sb.append(field.getName()+";\n");//���Ե�����+�س�
			}
	
			sb.append("}");
	
			System.out.println(sb);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
