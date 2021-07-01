import java.util.ArrayList;
import java.util.Collections;

public class Program {

    String name;
    ArrayList<Course> courses = new ArrayList<>();

    public Program(String name, Course ... courses){
        this.name = name;
        if (courses.length > 0){
            Collections.addAll(this.courses, courses);
        }
    }

    public float getDurationInHours(){
        float programDuration = 0;
        for (Course course: courses){
            programDuration += course.duration;
        }
        return programDuration;
    }

    public float getDurationInDaysAndHours(float workingHoursPerDay){
        float dur = this.getDurationInHours();
        return dur/workingHoursPerDay;
    }
}
