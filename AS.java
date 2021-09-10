/*
	Anurag Sort
	
	Unsorted : 15 6 13 22 3 52 2
	
	For ASC Order
	find max=52
	looping 
		find min=2
		store min in res[]
		store the max+1 at min val index
		
		0 => ASC
		1 => DESC
*/

import java.util.Scanner;
import java.util.Arrays;
class AS
{	
	static AS obj=new AS();
	
	int indexOfMinVal(int a[],int len)
	{
		int idx=0;
		int min=a[0];
		for(int i=0;i<len;i++)
		{
			if(min>a[i])
			{
				min=a[i];
				idx=i;
			}
		}
		return idx;
	}
	
	int indexOfMaxVal(int a[],int len)
	{
		int idx=0;
		int max=a[0];
		for(int i=0;i<len;i++)
		{
			if(max<a[i])
			{
				max=a[i];
				idx=i;
			}
		}
		return idx;
	}
	
	int[] anuragSortASC(int a[],int len)
	{
		int res[]=new int[len];
		int index_max=obj.indexOfMaxVal(a,len);
		int max_val=a[index_max]+1;
		for(int i=0;i<len;i++)
		{
			int index_min=obj.indexOfMinVal(a,len);
			int min=a[index_min];
			res[i]=min;
			a[index_min]=max_val;
		}
		return res;
	}
	int[] anuragSortDESC(int a[],int len)
	{
		int res[]=new int[len];
		int index_min=obj.indexOfMinVal(a,len);
		int min_val=a[index_min]-1;
		for(int i=0;i<len;i++)
		{
			int index_max=obj.indexOfMaxVal(a,len);
			int max=a[index_max];
			res[i]=max;
			a[index_max]=min_val;
		}
		return res;
	}
	
	int[] anuragSort(int a[],int choice)
	{  
		int len=a.length;
	
		switch(choice)
		{
			case 0 : return obj.anuragSortASC(a,len);
			
			case 1 : return obj.anuragSortDESC(a,len);
		}
		return null;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the number of elements in array");
		int len=sc.nextInt();
		
		int unsorted_array[]=new int[len];
		System.out.println("Enter elements of the array");
		for(int i=0;i<len;i++)
		{
			unsorted_array[i]=sc.nextInt();
		}
		
		int unsorted_array_clone[]=unsorted_array.clone();
		
		int choice=-1;
		// Looping till valid input is entered
		while(true)
		{
			System.out.println("Enter the Choice");
			System.out.println("0 for Ascending , 1 for Descending");
			choice=sc.nextInt();
			if(!(choice==0 || choice==1))
			{
				System.out.println("Invalid input , Enter either 0 or 1");	
				continue;
			}
			else
			{
				break;
			}
		}	
		
		if(choice==0)
		{
			// Sorting in ASC Order
			int asc_sorted_array[]=obj.anuragSort(unsorted_array,0);
			System.out.println(Arrays.toString(asc_sorted_array));
		}
		else if(choice==1)
		{
			// Sorting in DESC Order
			int desc_sorted_array[]=obj.anuragSort(unsorted_array_clone,1);
			System.out.println(Arrays.toString(desc_sorted_array));
		}
	}
}
