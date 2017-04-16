package com.java.reflect;

public class Person {
		public String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
			
		public void show(){
			System.out.println("����һ���й���");
		}
		
		public  void display(String nation){
			System.out.println("�ҵĹ�����"+nation);
		}

		
		public Person() {
			super();
		}
		
		public Person(String name) {
			super();
			this.name = name;
		}

		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		
		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}

		
}
