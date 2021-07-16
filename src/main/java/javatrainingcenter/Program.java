package javatrainingcenter;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Objects.requireNonNull;

public class Program {

    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Program(String name, Course ... courses){
        this.name = requireNonNull(name);
        if (courses.length > 0){
            Collections.addAll(this.courses, courses);
        }
    }

    public float getDurationInHours(){
        float programDuration = 0;
        for (Course course: courses){
            programDuration += course.getDuration();
        }
        return programDuration;
    }

    public float getDurationInDaysAndHours(float workingHoursPerDay){
        float dur = this.getDurationInHours();
        return dur/workingHoursPerDay;
    }

    public String getName() {
        return this.name;
    }
}
