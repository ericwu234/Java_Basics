import java.util.ArrayList;
class Student{
    private String stdno;
    private String name;
    private int pos=0;
    private ArrayList<Phone> itsPhone = new ArrayList<Phone>();
    //private Phone[] itsPhone=new Phone[3];
    public Student(String no,String name){
        stdno=no;
        this.name=name;
    }
    public void addPhone(Phone item){
        itsPhone.add(item);
        itsPhone.get(pos).stu=this;
        //itsPhone[pos]=item;
        //itsPhone[pos].stu=this;
        pos++;
    }
    public String getName(){
        return name;
    }
    public String getNo(){
        return stdno;
    }
    public void studentInfo(){
        System.out.println("Student_no:"+stdno);
        System.out.println("name:"+name);
        for(int i=0;i<pos;i++)
        {
            System.out.println(itsPhone.get(i).getPhone());
            //System.out.println(itsPhone[i].getPhone());
        }
    }
}
class Phone{
    private String type;
    private String number;
    public Student stu;
    public Phone(String type,String number){
        this.type=type;
        this.number=number;
    }
    public String getPhone(){
        return stu.getName()+":"+type+":"+number;
    }
}

public class week10_1 {
    public static void main(String[] args){
        Student joe=new Student("s001","cheng");
        Phone phone1=new Phone("house:","02-22222222");
        Phone phone2=new Phone("phone","0999-4567-199");
        joe.addPhone(phone1);
        joe.addPhone(phone2);
        joe.studentInfo(); 
    }
}