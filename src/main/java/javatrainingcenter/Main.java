package javatrainingcenter;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParseException {
        Course java = new Course("Java", 16);
        Course jdbc = new Course("JDBC", 24);
        Course spring = new Course("Spring", 16);
        Course testDesign = new Course("Test Design", 10);
        Course pageObject = new Course("Page Object", 16);
        Course selenium = new Course("Selenium", 16);

        Program javaDeveloper = new Program("Java Developer", java, jdbc, spring);
        Program aqe = new Program("AQE", testDesign, pageObject, selenium);

        Student ivanov = new Student("Ivan", "Ivanov", javaDeveloper, "1 June 2020 - Monday");
        Student sidorov = new Student("Ivan", "Sidorov", aqe, "1 June 2020 - Monday");
        List<Student> students = Arrays.asList(ivanov, sidorov);

        if (args.length > 0 && !args[0].equals("0")) {
            StudentService.fullReport(students);
        } else {
            StudentService.shortReport(students);
        }
    }
}
