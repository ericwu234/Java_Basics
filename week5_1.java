public class week5_1{
	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		int[] arr=new int[5];
		for(int i=0;i<5;i++)
		{
			arr[i]=sc.nextInt();
			if(arr[i]>1000)
			{
				System.out.println("over");
				i=i-1;
			}
		}
		int max,min;
		max=arrayMax(arr);
		min=arrayMin(arr);
    	System.out.print("max="+max+" min="+min);
	}
	static int arrayMax(int[] arr)
	{
		int max=0;
		for(int i=0;i<5;i++)
		{
			if(max<arr[i])
			{
				max=arr[i];	
			}
		}
		return max;
	}
	static int arrayMin(int[] arr)
	{
		int min=1000;
		for(int i=0;i<5;i++)
		{
			if(min>arr[i])
			{
				min=arr[i];
			}
		}
		return min;
	}
}