package com.java.DesignPatterns.Chain;

public class MyHandler extends AbstractHandler implements Handler {

	private String name;
	
	@Override
	public void operator() {
		// TODO Auto-generated method stub
		System.out.println("-->"+name);
		if(getHandler()!=null){  
            getHandler().operator();  
        }  
		
		
	}

	public MyHandler(String name) {
		this.name=name;
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
