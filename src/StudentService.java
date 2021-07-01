import java.time.DayOfWeek;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class StudentService {

    private static ZonedDateTime getFinishDateTime(Student student) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy - EEEE, H z", Locale.US);
        String startDate = student.programStartDate + ", " + Student.workingHourStart + " GMT";
        float programDuration = student.trainingProgram.getDurationInHours();
        ZonedDateTime finishDateTime = ZonedDateTime.parse(startDate, formatter);
        while (programDuration >= Student.getWorkingHoursPerDay()) {
            if (finishDateTime.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                finishDateTime = finishDateTime.plusDays(2);
            }
            finishDateTime = finishDateTime.plusDays(1);
            programDuration -= Student.getWorkingHoursPerDay();
        }
        finishDateTime = finishDateTime.plusHours((long) programDuration);
        return finishDateTime;

    }

    private static String checkProgramCompletion(Student student) {
        ZonedDateTime currentDate = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime finishDate = getFinishDateTime(student);
        if (currentDate.isBefore(finishDate)) {
            Duration diff = Duration.between(currentDate, finishDate);
            return String.format("Training is not finished. %d d %d hours are left until the end.%n",
                    (int) diff.toHours() / 24, (diff.toHours() % 24));
        } else {
            Duration diff = Duration.between(finishDate, currentDate);
            return  String.format("Training completed. %d d %d hours have passed since the end.%n",
                    (int) diff.toHours() / 24, (diff.toHours() % 24));

        }

    }

    public static void shortReport(List<Student> students) {
        for (Student student: students) {
            System.out.printf("%s (%s) - %s", student.getFullName(), student.trainingProgram.name,
                    checkProgramCompletion(student));
            System.out.println("---------------------------------------------------------");

        }

    }

    public static void fullReport(List<Student> students) {
        for (Student student: students) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy - EEEE, H z", Locale.US);
            System.out.println("Name: " + student.getFullName());
            System.out.println("Working time" + Student.getWorkingHours());
            System.out.println("Program: " + student.trainingProgram.name);
            System.out.println("Program duration:" + student.trainingProgram.getDurationInDaysAndHours(Student.getWorkingHoursPerDay()));
            System.out.println("Duration in hours: " + student.trainingProgram.getDurationInHours());
            System.out.println("Start date:" + student.getStartDate());
            System.out.println("Finish date: " + getFinishDateTime(student).format(formatter));
            System.out.println(checkProgramCompletion(student));
            System.out.println("---------------------------------------------------------");

        }
    }

}
