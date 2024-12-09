
/**
 My Main Class. This is where we will run all of our programs.
 
 This is my StudentRecordManagement program. This program will manage student records. 
Each record will contain a student's ID, name and GPA. The student ID will serve as the 
unique key. The application allows adding new student records, deleting records,
updating records, and displaying all records sorted by student ID.

In order to run it, first go to the main class and add your students, this is done by
creating a new Student and giving it them an ID, Name, and GPA.

You will then create a new StudentRecordManagement() and insert the students into it.

Once this is done, you can manually set a students gpa, remove a student, update a student id,
etc. 
 */
public class Main
{
    public static void main(String[] args){
        Student student1 = new Student(15, "Mark", 2.9);
        Student student2 = new Student(3, "Stephanie", 3.7);
        Student student3 = new Student(7, "Daniel", 4.0);
        Student student4 = new Student(10, "Beth", 3.1);
        Student student5 = new Student(4, "John", 3.5);
        Student student6 = new Student(7, "Jose", 3.9);

        StudentRecordManager manager = new StudentRecordManager();
        System.out.println("All Students in StudentRecordManager");
        manager.insertStudent(student1);
        manager.insertStudent(student2);
        manager.insertStudent(student3);
        manager.insertStudent(student4);
        manager.insertStudent(student5);
        manager.insertStudent(student6);
        manager.displayStudentRecords();

        System.out.println("Updating student2's gpa to 3.2");
        student2.setGPA(3.2);
        manager.updateStudent(student2);
        manager.displayStudentRecords();

        System.out.println("Removing student4 from the StudentRecordManager");
        manager.removeStudent(student4);
        manager.displayStudentRecords();

        System.out.println("Updating student6 id value");
        student6 = new Student(17, "Jose", 3.9);
        manager.updateInsertStudent(student6);
        manager.displayStudentRecords();

        System.out.println("Updating student5 GPA value");
        student5.setGPA(2.5);
        manager.updateInsertStudent(student5);
        manager.displayStudentRecords();

        System.out.println("Displaying all student's with a GPA higher than 3.0");
        System.out.println(manager);
        manager.displayStudentRecords(3.0);

        Student mark = manager.retrieveStudentRecord(15);
        System.out.println(mark);
        System.out.println("\n");

        Student bobby = manager.retrieveStudentRecord(18);
        System.out.println(bobby);
        System.out.println("\n");
    }
}
