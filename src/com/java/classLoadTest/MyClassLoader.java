package com.java.classLoadTest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{
	 /* 
     * 覆盖了父类的findClass，实现自定义的classloader
     */
    @Override
    public Class<?> findClass(String name) {
        byte[] bt = loadClassData(name);
        return defineClass(name, bt, 0, bt.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(
                className.replace(".", "/") + ".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        int len = 0;
        try {
            while ((len = is.read()) != -1) {
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteSt.toByteArray();
    }
    
    /**
	 * 父类classloader
	 * @throws Exception
	 */
	private static void test2() throws Exception{
	    MyClassLoader loader = new MyClassLoader();
	    Class<?> c = loader.loadClass("com.java.classLoadTest.HighRichHandsome");
	    System.out.println("Loaded by :" + c.getClassLoader());

	    Person p = (Person) c.newInstance();
	    p.say();

	    HighRichHandsome man = (HighRichHandsome) c.newInstance();
	    man.say();    
	}
}
