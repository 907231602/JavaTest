package com.java.DesignPatterns.Decorator;

public class Decorator implements Sourceable{

	private Source source;
	
	public Decorator(Source source) {
		// TODO Auto-generated constructor stub
		this.source=source;
	}
	
	@Override
	public void menthd1() {
		// TODO Auto-generated method stub
		System.out.println("hello");
		source.menthd1();
		System.out.println("world");
		
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

}
