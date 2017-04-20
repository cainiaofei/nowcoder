package com.demo;

public class Debug {
	public String test(){
		StringBuilder sb = new StringBuilder();
		sb.append("debug");
		return sb.toString();
	}
	
	public static void main(String[] args){
		Debug debug = new Debug();
		debug.test();
	}
}
