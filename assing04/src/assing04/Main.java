package assing04;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	
	public static log[]buffer=new log[100000]; 
	
	
	
	
	public static int index=0;
	
	
	public static void main(String[] args) {
		String sorting="-t";
		
		Scanner sc = new Scanner(System.in);
	    while(true) {
	    	
	    	System.out.print("$");
	    	String s = sc.next();
	    	
	    	
			if(s.equals("read")) {
				String filename = sc.next();
				read(filename);
			}
			
			
			else if(s.equals("sort")) {
				sorting=sc.next();
				if(sorting.equals("-t")) 
					Arrays.sort(buffer,0,index-2,log.timeCompartor);
				else if(sorting.equals("-ip")) 
					Arrays.sort(buffer,0,index-2,log.ipCompartor);
				
			}
			
			
			else if(s.equals("print")) {
				if(sorting.equals("-t"))
				for(int i=0;i<index;i++) {
					System.out.println(buffer[i].Date);
					System.out.println("	IP:"+buffer[i].ip);
					System.out.println("	URL:"+buffer[i].URL);
					System.out.println("	Status:"+buffer[i].Status);
				}
				else
				{
					for(int i=0;i<index;i++) {
						System.out.println(buffer[i].ip);
						System.out.println("	Date:"+buffer[i].Date);
						System.out.println("	URL:"+buffer[i].URL);
						System.out.println("	Status:"+buffer[i].Status);
					}
				}
			}
			
			
			else if(s.equals("exit")) {
				return;
			}
	    }
		
		
		
	}
	
	
	
	
	
	public static void read(String f) {
		try {
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String data = ""; 
		
		while ((data = reader.readLine()) != null) { 
			
			int flag=0;
			String num="";
			String num2="";
			String num3="";
			String num4="";
			StringTokenizer str=new StringTokenizer(data,",");
			while(str.hasMoreTokens()) {
				if(flag==0) {
					num=str.nextToken();
					flag=1;
					
				}
				else if(flag==1) {
					num2=str.nextToken();
					num2=num2.substring(1, num2.length());
					
					flag=2;
				}
				else if(flag==2) {
					num3=str.nextToken();
					flag=3;
				}
				else {
					num4=str.nextToken();
					flag=0;
				}
			}
			buffer[index++]=new log(num,num2,num3,num4);
			
		}
		
		
		reader.close();
		
	}catch(FileNotFoundException e) {
		
	}catch(IOException e) {
		System.out.println(e);
	}
		
		
}
}
