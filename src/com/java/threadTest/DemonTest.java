package com.java.threadTest;

//�ػ��߳�
/**
 * �ػ��̵߳�Ψһ���þ���Ϊ�����߳��ṩ���񡣼�ʱ�߳̾���һ�����͵����ӣ�����ʱ�ط��͡���ʱ���δ��źŸ��������߳�ȥִ��ĳ������
 * ��ֻʣ���ػ��߳�ʱ����������˳��ˣ���Ϊ���ֻʣ���ػ��̣߳������û�б�Ҫִ���ˡ�����JVM���������ա��ڴ������̶߳����ػ��̡߳�
 * ���о����������ݿ�Ӧ��ʱ��ʹ�õ����ݿ����ӳأ����ӳر���Ҳ�����źܶ��̨�̣߳�������Ӹ�������ʱʱ�䡢״̬�ȵȡ�
 * �����һ����Ҫ�ر�ע�������java������˳�ʱDaemon�߳��е�finally����鲢��һ����ִ��Ŷ��
 * @author Administrator
 *
 */
public class DemonTest {
	public static void main(String[] args) {  
        Thread deamon = new Thread(new DaemonRunner(),"DaemonRunner");  
      
        Thread demo=new Thread(new Demo(), "demo");
        demo.start();
        
        //����Ϊ�ػ��߳�  
        deamon.setDaemon(true);  
        deamon.start();//�����߳�  
        
     
    }  
      
      
    static class DaemonRunner implements Runnable{  
        @Override  
        public void run() {  
            try {  
            	System.out.println("I'm daem");
                Thread.sleep(500);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }finally{  
                System.out.println("����Ĵ�����java������˳�ʱ����һ����ִ��Ŷ��");  
            }  
        }  
    }  
    
   
}

class Demo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("I'm not deam");
	}
	
}
