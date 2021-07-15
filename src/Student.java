
import static java.util.Objects.requireNonNull;

public class Student {

    public static final int WORKING_HOUR_START = 10;
    public static final int WORKING_HOUR_END = 18;

    private String name;
    private String surname;
    private Program trainingProgram;
    private String programStartDate;

    public Student(String name, String surname, Program trainingProgram, String startDate) {
        this.name = requireNonNull(name);
        this.surname = requireNonNull(surname);
        this.trainingProgram = requireNonNull(trainingProgram);
        this.programStartDate = requireNonNull(startDate);
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public static int getWorkingHoursPerDay() {
        return WORKING_HOUR_END - WORKING_HOUR_START;
    }

    public static String getWorkingHoursAsString() {
        return "from " + WORKING_HOUR_START + " to " + WORKING_HOUR_END;
    }

    public String getProgramStartDate() {
        return this.programStartDate;
    }

    public Program getTrainingProgram() {
        return this.trainingProgram;
    }

}
