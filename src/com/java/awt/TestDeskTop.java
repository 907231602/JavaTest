package com.java.awt;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
/**
 * Javaʵ����QQ���������ֲ�����
 * @author Wayss
 *
 */
public class TestDeskTop {
    static Desktop deskapp = Desktop.getDesktop();

    public static void main(String [] args) throws AWTException{
        inputQQ();
    }

    public static void openQQ(){
        //�жϵ�ǰϵͳ�ͷ�֧��Desktop�ṩ�Ľӿ�
        if(Desktop.isDesktopSupported()){
            try {
                deskapp.open(new File("C:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQScLauncher.exe"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void inputQQ() throws AWTException{
        Robot robot = new Robot();
        //3�ȴ�3���ʼִ��������Զ������¼�
        robot.delay(3000);
        //���������(Ŀ�����ù��ŵ�QQ��)
        TestInput.mouseLeftHit(robot);

        for(int i = 0 ; i < 10; i++){
            //����Ц��
            TestInput.keyPressString(robot, "C:\\Users\\Administrator\\Desktop\\file\\logo\\file.png");
            
            //���»س�
            TestInput.keyPress(robot, KeyEvent.VK_ENTER);
        }
    }
}
