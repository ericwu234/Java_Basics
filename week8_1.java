class Person {
    private int id;
    private String name;
    private double height;

    /*public void setID(int id) {
        this.id = id;
    }

    public void setName(String n) {
        name = n;
    }

    public void setHeight(double h) {
        height = h;
    }*/
    public Person(int id,String name,double height)
    {
        this.id=id;
        this.name=name;
        this.height=height;
    }

    public void personInfo() {
        System.out.println("=[personal information]=====");
        System.out.println("id: " + id);
        System.out.println("name: " + name);
        System.out.println("height: " + height);
    }
}

class Student extends Person {
    private int score;

    public Student(int id, String n, double h, int score) {
        super(id,n,h);
        this.score = score;
    }

    public void personInfo() {
        super.personInfo();
        System.out.println("score: " +this. score);
    }

}
class Teacher extends Person{
    private int lesson_number;

    public Teacher(int id,String name,double height,int l_n){
        super(id,name,height);
        this.lesson_number=l_n;
    }
    public void personInfo(){
        super.personInfo();
        System.out.println("lesson number: " + this.lesson_number);
    }

}
class Salesperson extends Person{
    private int salary;
    public Salesperson(int id,String name,double height,int salary){
        super(id,name,height);
        this.salary=salary;
    }
    public void personInfo(){
        super.personInfo();
        System.out.println("salary: " +this.salary);
    }

}

public class week8_1 {
    public static void main(String[] args) {
        Student jack = new Student(1234, "jack", 175.0, 85);
        Teacher mark = new Teacher(3456, "mark", 150.0, 5);
        Salesperson leo=new Salesperson(4487, "leo",177, 30000) ;
        //mark.setHeight(158.0);
        jack.personInfo();
        mark.personInfo();
        leo.personInfo();

    }
}