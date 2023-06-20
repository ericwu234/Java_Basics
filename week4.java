public class week4{
	public static void main(String[] args) {
        int a=0,b=0;
        int[] one=new int[11];
        int[] num=new int[11];
        int[] max=new int[11];
        int[] min=new int[11];
        int[] ave=new int[11];
        for(int i=0;i<100;i++)
        {
            if(i==0)
            {
                for(int j=0;j<11;j++)
                {
                    min[j]=10000;
                    max[j]=0;
                }
            }
            for(int j=0;j<10000;j++)
		    {
			    a=rolldice(a);
			    b=rolldice(b);
                decide(a,b,one);
            
            }
            for(int j=0;j<11;j++)
            {
                num[j]+=one[j];
                maxf(j,max,one);
                minf(j,min,one);
                one[j]=0;
            }
            
        }
        avef(num,ave);
        
		for(int i=0;i<11;i++)
		{
		System.out.println("("+(i+2)+")"+"average:"+ave[i]+"("+(ave[i]/100)+"%)"+" "+"Max:"+max[i]+"("+(max[i]/100)+"%)"+" "+"min:"+min[i]+"("+(min[i]/100)+"%)");
		}
	}
	static int rolldice(int d)
	{
		d=(int)(Math.random()*6+1);
		return d;
		
	}
	static void decide(int a,int b,int[] num)
	{
        for(int i=2;i<=12;i++)
        {
		if((a+b)==i)
		{
            num[i-2]+=1;
        }

        }
    }
    static void maxf(int j,int[] max,int[]num)
    {
        
            if(max[j]<num[j])
            {
                max[j]=num[j];
            
        }
    }
    static void minf(int j,int[] min,int[]num)
    {
        
        
        if(min[j]>num[j])
            {
                min[j]=num[j];
            
        }
    }
    static void avef(int[] num,int[] ave)
    {
        int sum=100;
        for(int i=0;i<11;i++)
        {
            ave[i]=num[i]/sum;
        }
    }
}