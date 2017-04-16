package com.java.DesignPatterns.Builder;

import java.util.List;

/**
 * 建造者模式
 * 建造者模式是将各种产品集中起来进行管理，用来创建复合对象，复合对象指某个类具有不同属性
 * @author Administrator
 *
 */
public class BuilderTest {
	public static void main(String[] ad) {
		// TODO Auto-generated method stub
			Builder builder=new Builder();
			List<Sender> listSender=builder.produceMailSender(2);
			System.out.println(listSender);
			/*for(List<Sender>  k:listSender){
				System.out.println(k);
			}*/
	}
}
