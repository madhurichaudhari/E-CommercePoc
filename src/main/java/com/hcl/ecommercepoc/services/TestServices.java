package com.hcl.ecommercepoc.services;


interface A{
	default void test() {
		System.out.println("Mad A");
	}
}

interface B{
	default void test() {
		System.out.println("Madh B");
	}
}

class TestServices implements A,B {
	
	public static void main(String args[]) {
		System.out.println("main");
		TestServices t=new TestServices();
		t.test();
		
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
	}

	
}