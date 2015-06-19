package com.ftfl.mindgame.util;

import java.util.Random;

public class LevelControl {
	
	public static Integer[] START_NUMBERS ;
	public static Integer[] INPUT_NUMBERS;
	
	static boolean check = true;
	
	public static void  setValue(int eArg)
	{

		START_NUMBERS = new Integer[eArg];
		Random rand = new Random();
		int[] ar = new int[eArg];
		

		int random = 0;
		//int [] result_arr=new int[5];
		boolean flag=false;

		for(int i=0;i<eArg;i++)
		{  
		    ar[i]=0;

		    do{
		        random =rand.nextInt(eArg);
		        flag=false;
		        for(int j=0;j<i;j++)
		        {
		            if(ar[j]==random)
		            flag=true;
		        }
		        if(!flag)
		        {
		            ar[i]=random;
		            break;
		        }
		     }
		     while(true) ;
		}
		
		if(eArg!=10)
		{
			for(int i=0;i<eArg;i++)
			{ 
				START_NUMBERS[i] = ar[i]+1;
			}
		}
		else{
			for(int i=0;i<eArg;i++)
			{ 
				START_NUMBERS[i] = ar[i];
			}
		}
		
		
	}
	
	public static void resetInput(int eArg)
	{
		INPUT_NUMBERS = new Integer[eArg];
		check = true;
	}
	
	public static boolean findResult(int eArg)
	{
		for (int i=0; i<eArg; i++)
		{
			if(START_NUMBERS[i]!=INPUT_NUMBERS[i])
				check = false;
		}
		return check;
	}
}
