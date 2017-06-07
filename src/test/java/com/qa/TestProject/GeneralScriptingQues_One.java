package com.qa.TestProject;


public class GeneralScriptingQues_One {

	static String s = "hope you are doing well";
	
	public static void main(String[] args) {
		reverseEverything(s);	
	}
	
	public static void reverseEverything(String s){
		
	     for(int i= s.length()-1;  i >= 0;  i--){
	         System.out.print(s.charAt(i));   	         
	     }
	 }
}
