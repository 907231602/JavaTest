package com.java.collectionDemo;

class Point<T1, T2>{
    T1 x;
    T2 y;
    public T1 getX() {
        return x;
    }
    public void setX(T1 x) {
        this.x = x;
    }
    public T2 getY() {
        return y;
    }
    public void setY(T2 y) {
        this.y = y;
    }
   
    // 定义泛型方法
    public <T1,T2>  void printPoint(T1 x, T2 y){
        T1 m = x;
        T2 n = y;
        System.out.println("This point is：" + m + ", " + n);
    }
    
    //T必须是Number类型及其子类，T 只接受 Number 及其子类，传入其他类型的数据会报错
    //如果是类，只能有一个；但是接口可以有多个，并以“&”分隔，例如 <T extends Interface1 & Interface2>。
    //<? super Number> 表示只能接受 Number 及其父类。
    public <T extends Number> T getMax(T array[]){
        T max = null;
        for(T element : array){
            max = element.doubleValue() > max.doubleValue() ? element : max;
        }
        return max;
    }
    
    public static void main(String[] args){
        // 实例化泛型类
        Point<Integer, Integer> p1 = new Point<Integer, Integer>();
        p1.setX(10);
        p1.setY(20);
        p1.printPoint(p1.getX(), p1.getY());
       
        Point<Double, String> p2 = new Point<Double, String>();
        p2.setX(25.4);
        p2.setY("东京180度");
        p2.printPoint(p2.getX(), p2.getY());
    }
}

