package org.cuelebre.Assignment;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	
	public static HashMap<Character, Character> hashMapCreation()
	{
	    
	     HashMap<Character, Character> hash_map = new HashMap<Character, Character>(); 

	     hash_map.put('{', '}'); 
	     hash_map.put('}', '{'); 
	     hash_map.put('[', ']'); 
	     hash_map.put(']', '['); 
	     hash_map.put('(', ')'); 
	     hash_map.put(')', '('); 
	     
	     return hash_map;
	}
	
	
	
	
	public static boolean checkInputCharacter(String input)
	{
		
		char inputChar[]=input.toCharArray();
		 for (char temp : inputChar) 
		 {
		        if (!(temp == '{' || temp == '[' || temp == '(' || temp == '}' || temp == ']' || temp == ')')) {
		            return false;
		        }
		       
		        	
		 }
		 
		 return true;
	}
	
	
	
	public static boolean checkParanthesisBalance(String fetch_input,HashMap<Character, Character> fetch_hashMap)
	{

		char arrayParanthesis[] = fetch_input.toCharArray();
		int length = arrayParanthesis.length;
		int flag=0;
		
		if (length % 2 == 0)// even count
		{

			
			if ((arrayParanthesis[0] == '}') || (arrayParanthesis[0] == ')') || (arrayParanthesis[0] == ']') || (arrayParanthesis[length - 1] == '{') || (arrayParanthesis[length - 1] == '(')	|| (arrayParanthesis[length - 1] == '[')) //check for first and last character
			{
				return false;
			}
			
			if(length==2)
			{
				
				if(arrayParanthesis[0]==fetch_hashMap.get(arrayParanthesis[1]))
				{
					return true;
				}
				
				else
				{
					return false;
				}
			}
			
			boolean fetch_recursiveFlag=RecurviseCheck(arrayParanthesis,0,length-1,fetch_hashMap);//charArray,recursiveStart,recursiveEnd
			
			return fetch_recursiveFlag;


		}
		
		else //odd count
		{
			return false;

		}
	}
	
	
	

	private static boolean RecurviseCheck(char[] arrayParanthesis, int recursiveStart, int recursiveEnd, HashMap<Character, Character> fetch_hashMap) 
	{

		int leftStart=0,leftEnd=0,leftFlag=0,rightStart=0,rightEnd=0,rightFlag=0,completeStart=0,completeEnd=0,completeFlag=0;
		leftStart=recursiveStart;
		leftEnd=recursiveEnd/2;
		leftFlag=leftCheck(arrayParanthesis,leftStart,leftEnd,fetch_hashMap);
		
	
		if(leftFlag==0)//true
		{
			rightStart=(recursiveEnd/2)+1;
			rightEnd=recursiveEnd;
			rightFlag=rightCheck(arrayParanthesis,rightStart,rightEnd,fetch_hashMap);
			if(rightFlag==0)
			return true;
			
		}
		
		
		else // ((leftFlag==1 && rightFlag==0) || (leftFlag==0 && rightFlag==1) || (leftFlag==1 && rightFlag==1))
		{
			
		    completeStart=recursiveStart;
			completeEnd=recursiveEnd;
			completeFlag=completeCheck(arrayParanthesis,completeStart,completeEnd,fetch_hashMap);
			if(completeFlag==0)
				return true;
			else if(completeFlag==1) 
			{
				int recursiveMid=(recursiveStart+recursiveEnd)/2;
				recursiveStart=recursiveStart+1;
				recursiveEnd=recursiveEnd-1;
				
				if(recursiveEnd>recursiveStart)
				{
					boolean recursiveFlag=RecurviseCheck(arrayParanthesis, recursiveStart, recursiveEnd, fetch_hashMap);
					if(recursiveFlag==true)
					return recursiveFlag;
				}
			}
			else if(completeFlag==10)
			{
				return false;
			}
		}
		return false;
	
		
	}




	private static int completeCheck(char[] arrayParanthesis,int completeStart, int completeEnd, HashMap<Character, Character> fetch_hashMap)
	{
		int flag=0;
		int Mid=(completeStart+completeEnd)/2;

		if(arrayParanthesis[completeStart]== fetch_hashMap.get(arrayParanthesis[completeEnd]))    //check if first and last character same
		{
			for(int i=completeStart+1;i<=Mid;i++) 
			{
				if(arrayParanthesis[i]!=fetch_hashMap.get(arrayParanthesis[completeEnd-i]))
				{
					flag=1;
					break;
					
				}
			}
		
		}
		else
		{
			flag=10;
			return flag;
		}
		
		
		
		return flag;
		
	}

	private static int rightCheck(char[] arrayParanthesis, int start,int end , HashMap<Character, Character> fetch_hashMap)
	{
		int flag=0;
		int Mid=(start+end)/2;
		int length=(end-start)+1;
		if(length%2==0)
		{
			for(int i=start,j=end;i<=Mid && j>=Mid;i++,j--)
			{
				
					if(arrayParanthesis[i]!=fetch_hashMap.get(arrayParanthesis[j]))
					{
						flag=1;
						break;
					}
				
	
			}
		}
		else
		{
			flag=1;
		}
		
		return flag;
	}

	private static int leftCheck(char[] arrayParanthesis, int start ,int end, HashMap<Character, Character> fetch_hashMap)
	{
		int flag=0;
		int Mid=(start+end)/2;
		int length=start+end+1;
		if(length%2==0)
		{
			for(int i=start,j=end;i<=Mid && j>=Mid ;i++,j--)
			{
				
					if(arrayParanthesis[i]!=fetch_hashMap.get(arrayParanthesis[j]))
					{
						flag=1;
						break;
					}

			}
		}
		else
		{
			flag=1;
		}
		
		return flag;
	}


	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input string:");
		HashMap<Character, Character> fetch_hashMap=hashMapCreation();
		
			while (sc.hasNext()) 
			{
				String input = sc.next();
				boolean charCheck=checkInputCharacter(input);
				
				if(charCheck==true)
					{
						boolean result = checkParanthesisBalance(input,fetch_hashMap);
						System.out.println("result:"+result);
					}
				else
					{
						System.out.println("Enter valid input");
						System.exit(0);
					}
				
			}

	}
}
