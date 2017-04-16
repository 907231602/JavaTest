package com.java.proxy;

interface ClothFactory{
	void productCloth();
}

class NikeClothFactory implements ClothFactory{

	@Override
	public void productCloth() {
		// TODO Auto-generated method stub
		System.out.println("Nike����");
	}
}

class ProxyFactory implements ClothFactory{
	ClothFactory cf;
	public ProxyFactory(ClothFactory cf) {
		// TODO Auto-generated constructor stub
		this.cf=cf;
	}
	@Override
	public void productCloth() {
		// TODO Auto-generated method stub
		System.out.println("������ִ��");
		cf.productCloth();
	}
	
}

public class TestProxy {
	public static void main(String[] args) {
		NikeClothFactory nike=new NikeClothFactory();
		ProxyFactory proxy=new ProxyFactory(nike);
		proxy.productCloth();
	}
}
