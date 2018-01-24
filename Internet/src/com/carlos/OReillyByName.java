package com.carlos;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.junit.Test;

public class OReillyByName {

	
	public static void main(String[] args){
		try {
			InetAddress[] address =  InetAddress.getAllByName("www.baidu.com");
			for(InetAddress i: address){
				 System.out.println(i);
			}
		   
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public  void   test1(){
		try {
			InetAddress address =  InetAddress.getLocalHost();
		
				 System.out.println(address);
		   
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public  void   test2(){
		try {
			byte[]     address ={107,23,(byte)216,(byte)196};
			InetAddress lessWrong =  InetAddress.getByAddress(address);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
