package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Util;

public class PrimeAnagram {
public static void main(String args[]) {
	
	int [][]array=new int[10][100];
	int[][]noarray=new int[10][100];
	int j=0;
	int anagram[]=new int[80];
	
	int row=0;
	int rangeNo=0;
	
	for(int i=0;i<10;i++)
	{
		rangeNo=rangeNo+100;
		array[row][0]=rangeNo;
		row++;
	}
	row=0;rangeNo=0;
	for(int i=0;i<10;i++)
	{
		rangeNo=rangeNo+100;
		noarray[row][0]=rangeNo;
		row++;
	}
	
	int range=100;
	 row=0;
	 int l=0;
	 for(int i=1;i<1000;i++){
		 if(Util.checkPrime(i)) {
	for(int k=i+1;k<1000;k++) {
		
		if(Util.checkPrime(k)) {
			if(Util.checkAnagram(i,k)) {
			anagram[l]=k;
			l++;
			 if(i<=range)
			{
				 //System.out.println(i);
				array[row][++j]=i;
			}
			else {
				j=1;
				range=range+100;
				row++;
				array[row][j++]=i;
			}
		}
	}
	 }
	 }
	 }
	 Util.sortInt(anagram);
	 Util.removeDuplicates(anagram,anagram.length);
	 j=0;row=0;
	range=100;
	for(int i=0;i<anagram.length;i++) {
		{
			

				
				 if(anagram[i]<=range)
					 
					{
						array[row][++j]=anagram[i];
					}
					else {
						j=1;
						range=range+100;
						row++;
						array[row][j++]=anagram[i];
					}
					}
				
			
		}
			
		
	
	


	for(int i=0;i<10;i++){

		for(int k=0;k<100;k++) {
			if(array[i][k]!=0)
				
			
			System.out.print(array[i][k]+" ");
			
		}
		System.out.println();
	}
	}




}




