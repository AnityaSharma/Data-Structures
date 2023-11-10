package OOPS.FirstLec;

public class First_lec {
    public static void main(String[] args) {
        Student Anitya = new Student(101,"Anitya Sharma",75);
        Student Vedant = new Student(102,"Vedant Sharma",80);
//        Anitya.greeting();
        Student random = new Student();

        System.out.println(Vedant);
//        System.out.println(random.marks);
//        System.out.println(random.rollno);
    }

}
class Student{
    int rollno;
    String name;
    int marks;
    void greeting(){
        System.out.println("Hello ! My name is "+this.name);
    }
    Student(){
        this(0,"Default Name",0);
    }
    Student(int rn, String name, int marks){
        this.rollno = rn;
        this.name = name;
        this.marks = marks;
    }
    @Override
    public String toString() {
        System.out.println(this.name);
        System.out.println(this.marks);
        System.out.println(this.rollno);
        return "";
    }
}
