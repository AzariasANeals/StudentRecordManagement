import java.util.TreeMap;
import java.util.Map;
/**
 * This is the StudentRecordManager class. It will use a TreeMap
 * to store the student records. The key will be the student ID.
 * 
 * You can insert students, update students, remove students, and display student records.
 * 
 * You are also able to display and filter student records by GPA.
 */
public class StudentRecordManager
{
    TreeMap<Integer, Student> studentRecords;

    public StudentRecordManager(){
        studentRecords = new TreeMap<Integer, Student>();

    }

    public void insertStudent(Student student){
        if(student == null){
            return;
        }
        // Prevents duplicate studentIDs
        if(studentRecords.containsKey(student.getStudentID())){
            return;
        }

        studentRecords.put(student.getStudentID(), student);
    }

    public void updateStudent(Student student){
        if(student == null){
            return;
        }
        // first removes student, then inserts a new student in its place
        if(studentRecords.containsKey(student.getStudentID())){
            removeStudent(student);
            insertStudent(student);
        }
    }

    public void removeStudent(Student student){
        if(student == null){
            return;
        }
        if(studentRecords.containsKey(student.getStudentID())){
            studentRecords.remove(student.getStudentID());
        }
    }

    public void updateInsertStudent(Student student){
        if(student == null){
            return;
        }
        // if the record doesn't exist, it will create it, if it does it will replace it
        if(studentRecords.containsKey(student.getStudentID())){
            updateStudent(student);
        }
        else{
            insertStudent(student);
        }
    }

    public void displayStudentRecords(){
        for(Map.Entry<Integer, Student> entry : studentRecords.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("");
    }

    // Here we are using the entrySet to pull back a Map and then filtering on
    // the filter (in this case gpa) that we pass in. So it will only return students
    // with gpa's greater than the value we pass in.
    public void displayStudentRecords(double gpaFilter){
        for(Map.Entry<Integer, Student> entry : studentRecords.entrySet()){
            if(entry.getValue().getGPA() > gpaFilter){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        System.out.println("");
    }

    public Student retrieveStudentRecord(int studentID){
        return studentRecords.get(studentID);
    }

    public int getNumberOfRecords(){
        return studentRecords.size();
    }

    public String toString(){
        String buffer = "";
        for(Map.Entry<Integer, Student> entry : studentRecords.entrySet()){
            buffer += (entry.getKey() + ": " + entry.getValue()) + "\n";
        }
        buffer += "\n";
        return buffer;
    }
}
