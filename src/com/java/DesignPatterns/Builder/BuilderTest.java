package com.java.DesignPatterns.Builder;

import java.util.List;

/**
 * ������ģʽ
 * ������ģʽ�ǽ����ֲ�Ʒ�����������й��������������϶��󣬸��϶���ָĳ������в�ͬ����
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
