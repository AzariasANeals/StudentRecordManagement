
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StudentRecordManagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentRecordManagerTest
{
    StudentRecordManager manager;

    /**
     * Default constructor for test class StudentRecordManagerTest
     */
    public StudentRecordManagerTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        Student student1 = new Student(15, "Mark", 2.9);
        Student student2 = new Student(3, "Stephanie", 3.7);
        Student student3 = new Student(7, "Daniel", 4.0);
        Student student4 = new Student(10, "Beth", 3.1);
        Student student5 = new Student(4, "John", 3.5);
        Student student6 = new Student(7, "Jose", 3.9);
        manager = new StudentRecordManager();
        manager.insertStudent(student1);
        manager.insertStudent(student2);
        manager.insertStudent(student3);
        manager.insertStudent(student4);
        manager.insertStudent(student5);
        manager.insertStudent(student6);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    // 3 normal test cases
    @Test
    public void testInsertStudentRecord(){
        Student expected = new Student(20, "Kim", 1.5);
        manager.insertStudent(expected);
        Student actual = manager.retrieveStudentRecord(20);
        assertEquals(expected.getName(), actual.getName());
    }

    @Test
    public void testUpdateStudentRecord(){
        String expected = "Franco";
        int updateRecordID = 7;
        Student actual = manager.retrieveStudentRecord(updateRecordID);
        assertNotEquals(expected, actual.getName(), "Before Update");

        Student tester = new Student(updateRecordID, expected, 3.5);
        manager.updateStudent(tester);
        actual = manager.retrieveStudentRecord(updateRecordID);
        assertEquals(expected, actual.getName(), "After Update");
    }

    @Test
    public void testRemoveStudentRecord(){
        Student expected = null;
        int removeRecordID = 3;
        Student transferred = new Student(removeRecordID, "Stephanie", 3.7);
        manager.removeStudent(transferred);
        Student actual = manager.retrieveStudentRecord(removeRecordID);
        assertEquals(expected, actual);
    }

    // 3 edge test cases
    @Test
    public void testInsertDuplicateStudentRecord(){
        // Student student5 = new Student(4, "John", 3.5);
        int newID = 4;
        String newStudent = "Eric";
        double newGPA = 3.5;
        
        Student tester = new Student(newID, newStudent, newGPA);
        String expected = "John";
        manager.insertStudent(tester);
        String actual = manager.retrieveStudentRecord(newID).getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateInsertDuplicateStudentRecord(){
        // Student student5 = new Student(4, "John", 3.5);
        int newID = 4;
        String newStudent = "Eric";
        double newGPA = 3.5;
        
        Student tester = new Student(newID, newStudent, newGPA);
        String expected = "Eric";
        manager.updateInsertStudent(tester);
        String actual = manager.retrieveStudentRecord(newID).getName();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNullInsert(){
        int expected = manager.getNumberOfRecords();
        Student notPresent = null;
        manager.insertStudent(notPresent);
        int actual = manager.getNumberOfRecords();
        assertEquals(expected, actual);
    }
}
