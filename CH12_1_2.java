class Person {
    private int id;
    private String name;
    private double height;

    public void setID(int id) {
        this.id = id;
    }

    public void setName(String n) {
        name = n;
    }

    public void setHeight(double h) {
        height = h;
    }

    public void personInfo() {
        System.out.println("�r�� : " + id);
        System.out.println("�m�W : " + name);
        System.out.println("���� : " + height);
    }
}

class Student extends Person {
    private int score;

    public Student(int id, String n, double h, int score) {
        setID(id);
        setName(n);
        setHeight(h);
        this.score = score;
    }

    public void studentInfo() {
        System.out.println("[ �ǥ͸�� ]=====");
        personInfo();
        System.out.println("���Z : " + score);
    }

}

public class CH12_1_2 {
    public static void main(String[] args) {
        Student joe = new Student(1234, "���|�w", 175.0, 85);
        Student jane = new Student(3456, "���p��", 150.0, 65);
        jane.setHeight(158.0);
        joe.studentInfo();
        jane.studentInfo();
    }
}