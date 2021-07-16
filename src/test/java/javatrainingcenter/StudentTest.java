package javatrainingcenter;

import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testGetFullName() {
        Program javaDeveloper = new Program("Java Developer");
        Student student = new Student("Test1", "Test2", javaDeveloper, "15 july 2021 - Monday");
        assertEquals("Test1 Test2", student.getFullName());
    }

    @Test(expected = NullPointerException.class)
    public void trainingProgramCantBeNull() {
        Student student = new Student("Test1", "Test2", null, "15 july 2021 - Monday");
    }

}