package com.thread;

public class StringThreadTest {
	
	private final int THREAD_COUNT = 5;
	
	public void testStringThread(){
		String ip = "192.168.12.8";
		Thread[] threads = new Thread[THREAD_COUNT];
		for(int i = 0; i < threads.length;i++){
			threads[i] = new Thread(new StringThread(ip));
		}
		
		for(Thread thread:threads){
			thread.start();
		}
	}
	
	public static void main(String[] args){
		StringThreadTest test = new StringThreadTest();
		test.testStringThread();
	}
}
