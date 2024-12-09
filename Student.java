
/**
 * This is my Student class. Here you can set a students ID, name and gpa. We
 * also have getter functions for retrieving the students ID, name, or gpa.
 */
public class Student
{
    private int studentID;
    private String name;
    private double gpa;

    public Student(int studentID, String name, double gpa){
        if(studentID < 1){
            this.studentID = 1;
        }
        else{
            this.studentID = studentID;
        }
        this.name = name;

        if(gpa < 0.0){
            this.gpa = 0.0;
        }
        else{
            this.gpa = gpa;    
        }

    }

    public int getStudentID(){
        return studentID;
    }

    public String getName(){
        return name;
    }

    public double getGPA(){
        return gpa;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGPA(double gpa){
        this.gpa = gpa;
    }

    public String toString(){
        return("Name: " + name + " ID: " + studentID + " GPA: " + gpa);
    }
}
