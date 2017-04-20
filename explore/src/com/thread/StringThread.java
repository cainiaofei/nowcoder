package com.thread;

public class StringThread implements Runnable{
	
	private String ip;
	private static final String LOCK_PREFIX = "XXX---";
	
	public StringThread(String ip){
		this.ip = ip;
	}
	
	@Override
	public void run() {
		String lock = buildLock();
		synchronized(lock){
			System.out.println(Thread.currentThread().getName()+"start to run...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"end...");
		}
	}
	

	private String buildLock() {
		StringBuilder sb = new StringBuilder();
		sb.append(LOCK_PREFIX);
		sb.append(ip);
		System.out.println("----build lock----");
		return sb.toString().intern();
	}
}
