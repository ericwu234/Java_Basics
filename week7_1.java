class Card{
    private String name;
    private int age;
    private String email;
    private PhoneList phone;
    public Card(String n,int a,String e)
    {
        this.name=n;
        this.age=a;
        this.email=e;
    }
    public void printCard()
    {
        System.out.println("name:"+this.name+"\nage:"+this.age+"\nhomephone:"+this.phone.gethomephone()+"\nofficephone:"+this.phone.getofficephone()+"\ncellphone:"+this.phone.getcellphone()+"\nemail:"+this.email);
    }
    public void setPhoneList(PhoneList phonelist)
    {
        this.phone=phonelist;
    }
}
class PhoneList{
    private String homephone;
    private String officephone;
    private String cellphone;
    public PhoneList(String h,String o,String c)
    {
        this.homephone=h;
        this.officephone=o;
        this.cellphone=c;
    }
    public String gethomephone(){
        return this.homephone;
    }
    public String getofficephone(){
        return this.officephone;
    }
    public String getcellphone(){
        return this.cellphone;
    }
}
public class week7_1 {
    public static void main(String[] args){
        java.util.Scanner sc=new java.util.Scanner(System.in);
        String name,email,homephone,officephone,cellphone;
        int age;
        System.out.println("name:");
        name=sc.next();
        System.out.println("age:");
        age=sc.nextInt();
        System.out.println("email:");
        email=sc.next();
        System.out.println("homephone:");
        homephone=sc.next();
        System.out.println("officephone:");
        officephone=sc.next();
        System.out.println("cellphone:");
        cellphone=sc.next();
        System.out.println("=====================");
        Card first=new Card(name,age,email);
        PhoneList firstphone=new PhoneList(homephone,officephone,cellphone);
        first.setPhoneList(firstphone);
        first.printCard();
    }
}