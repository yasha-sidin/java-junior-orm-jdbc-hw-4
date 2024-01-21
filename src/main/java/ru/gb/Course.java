package ru.gb;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", length = 45)
    private String title;
    @Column(name = "duration")
    private Timestamp duration;
    private static final List<String> titles = List.of("Running", "Programming", "Reading", "Singing", "Canoeing", "Walking", "Math", "Boxing", "Fighting", "Shooting");
    private static final Random random = new Random();

    public Course(String title, Timestamp duration) {
        this.title = title;
        this.duration = duration;
    }

    public static Course create() {
        return new Course(titles.get(random.nextInt(titles.size())), new Timestamp(0, 0, 0, random.nextInt(0, 3), random.nextInt(45, 60), 0, 0));
    }

    @Override
    public String toString() {
        return "Course(" +
                "id => " + id +
                ", title => '" + title + '\'' +
                ", duration => " + duration.getHours() + ":" + duration.getMinutes() +
                ')';
    }
}
