package com.bridgelabz.Programs;

import com.bridgelabz.Utility.Util;

public class Prime2D {
	public static void main(String args[]) {
		int [][]array=new int[10][100];
		int j=0;
		
		int row=0;
		int rangeNo=0;
		
		for(int i=0;i<10;i++)
		{
			rangeNo=rangeNo+100;
			array[row][0]=rangeNo;
			row++;
		}
		int range=100;
		 row=0;
		for(int i=1;i<1000;i++) {
			
			if(Util.checkPrime(i)) {
				
				 if(i<=range)
				{
					array[row][j++]=i;
				}
				else {
					j=1;
					range=range+100;
					row++;
					array[row][j++]=i;
				}
			}
		}
		
		

		for(int i=0;i<10;i++){
	
			for(int k=0;k<100;k++) {
				System.out.print(array[i][k]+" ");
				
			}
			System.out.println();
		}
	}

}