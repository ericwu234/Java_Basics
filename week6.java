class rolldise
{
    public int[] sum=new int[11];
    
    public int roll()
    {
        int d;
        d=(int)(Math.random()*6+1);
		return d;
    }
    public void roll10000()
    {
        int a,b;
        for(int i=0;i<11;i++)
        {
            sum[i]=0;
        }
        for(int j=0;j<10000;j++)
        {
            a=roll();
            b=roll();
            for(int i=0;i<11;i++)
            {
                if(a+b==i+2)
                {
                    this.sum[i]+=1;
                }
            }
        }
    }
    public int getsum(int i)
    {
        return sum[i];
    }
}
class result
{
    public int[] sum=new int[11];
    public int[] ave=new int[11];
    public int[] min=new int[11];
    public int[] max=new int[11];
    public void cal(int[][] save)
    {
        for(int j=0;j<11;j++)
        {
            min[j]=10000;
            max[j]=0;
        }
        for(int j=0;j<11;j++)
        {
            for(int i=0;i<100;i++)
            {
                sum[j]=sum[j]+save[i][j];
                if(max[j]<save[i][j])
                {
                    max[j]=save[i][j];
                }
                if(min[j]>save[i][j])
                {
                    min[j]=save[i][j];
                }
            } 
        }  
        for(int i=0;i<11;i++)
        {
        ave[i]=sum[i]/100;
        }
    }
    public void printresult()
    {
        for(int i=0;i<11;i++)
		{
		System.out.println("("+(i+2)+")"+"average:"+ave[i]+"("+(ave[i]/100)+"%)"+" "+"Max:"+max[i]+"("+(max[i]/100)+"%)"+" "+"min:"+min[i]+"("+(min[i]/100)+"%)");
		}
    }
}
public class week6{
	public static void main(String[] args) {
        
        int[][] save=new int[100][11]; 
        for(int i=0;i<100;i++)
        {
            rolldise roll=new rolldise();
            for(int j=0;j<11;j++)
            {
                roll.roll10000();
                save[i][j]=roll.getsum(j);
            }
        }
        
            result end=new result();
            end.cal(save);
            end.printresult();
        /*for(int i=0;i<100;i++)
        {
            for(int j=0;j<11;j++)
            {
                System.out.print(save[i][j]+" ");
            }
            System.out.print("\n");
        }*/
    }
}