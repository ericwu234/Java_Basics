public class week6_1{
	public static void main(String[] args) {
        java.util.Scanner sc=new java.util.Scanner(System.in);
        Time first=new Time();
        int hour,minute,second;
        while(true){
        hour=sc.nextInt();
        minute=sc.nextInt();
        second=sc.nextInt();
        first.setHour(hour);
        first.setMinute(minute);
        first.setSecond(second);
        if(first.validateTime())
        {
            break;
        }
        System.out.println("false");
    }
        
        first.printTime();
    }
}
class Time{
    private int hour;
    private int minute;
    private int second;
    public void setHour(int h){
        this.hour=h;
    }
    public void setMinute(int m){
        this.minute=m;
    }
    public void setSecond(int s){
            this.second=s;
    }
    public int getHour(){
        return this.hour;
    }
    public int getMinute(){
        return this.minute;
    }
    public int getSecond(){
        return this.second;
    }
    public void printTime(){
        System.out.println("hour:"+this.hour);
        System.out.println("minute:"+this.minute);
        System.out.println("second:"+this.second);
    }
    public boolean validateTime(){
        int h=getHour();
        int m=getMinute();
        int s=getSecond();
        if(h<24 && m<60 && s<60 && h>=0 && m>=0 && s>=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
