package javatrainingcenter;

import static java.util.Objects.requireNonNull;

public class Course {
    private final String name;
    private final float duration;

    public Course(String name, float duration){
        this.name = requireNonNull(name);
        this.duration = duration;
    }

    public float getDuration(){
        return this.duration;
    }
}
