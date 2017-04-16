package com.java.DesignPatterns.Adapter;

public class WrapperTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Sourceable souce1=new SourceSub1();
			Sourceable source2=new SourceSub2();
			
			souce1.method1();
			souce1.method2();
			
			source2.method1();
			source2.method2(); 
	}

}
