package random;

import java.util.Random;

public class FourRandomNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		int[] ar;
		ar = new int[5];

		int random = 1;
		int [] result_arr=new int[5];
		boolean flag=false;

		for(int i=0;i<5;i++)
		{  
		    ar[i]=0;

		    do{
		        random =rand.nextInt(5);
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
		
		for(int i=0;i<5;i++)
		{ 
			System.out.println(ar[i]);
		}
		
		

	}

}
