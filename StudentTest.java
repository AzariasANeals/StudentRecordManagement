
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
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
    public void testGetName(){
        String expected = "Bob";
        Student tester = new Student(15, "Bob", 3.5);
        String actual = tester.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetID(){
        int expected = 15;
        Student tester = new Student(15, "Bob", 3.5);
        int actual = tester.getStudentID();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetGPA(){
        double expected = 3.5;
        Student tester = new Student(15, "Bob", 3.5);
        double actual = tester.getGPA();
        assertEquals(expected, actual);
    }
    
    // 3 edge test cases
    @Test
    public void testNullName(){
        String expected = null;
        Student tester = new Student(15, null , 3.5);
        String actual = tester.getName();
        assertEquals(expected, actual);        
    }
    
    @Test
    public void testNegativeGPA(){
        double expected = 0.0;
        Student tester = new Student(15, "Bob", -1.0);
        double actual = tester.getGPA();
        assertEquals(expected, actual);
    }
    
    @Test
    public void testNegativeStudentID(){
        int expected = 1;
        Student tester = new Student(-1, "Bob", 3.5);
        int actual = tester.getStudentID();
        assertEquals(expected, actual);
    }
}
