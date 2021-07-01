public class Student {

    public static int workingHourStart = 10;
    public static int workingHourEnd = 18;

    String name;
    String surname;
    Program trainingProgram;
    String programStartDate;

    public Student(String name, String surname, Program trainingProgram, String startDate){
        this.name = name;
        this.surname = surname;
        this.trainingProgram = trainingProgram;
        this.programStartDate = startDate;
    }

    public String getFullName(){
        return name + " " + surname;
    }

    public static int getWorkingHoursPerDay(){
        return workingHourEnd - workingHourStart;
    }

    public static String getWorkingHours(){
        return "from " + workingHourStart + " to " + workingHourEnd;
    }

    public String getStartDate(){
        return this.programStartDate;
    }

}
