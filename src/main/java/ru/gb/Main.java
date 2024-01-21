package ru.gb;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        iRepository<Course> repository = new CoursesRepository();
        System.out.println("Insertion...");
        repository.insertData(Course.create(), Course.create(), Course.create());
        List<Course> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(Course.create());
        }
        repository.insertData(list);
        System.out.println("Insertion is done!");
        System.out.println("Reading...");
        System.out.println("\n\tWith id 1: " + repository.readData(1, Course.class).get() + "\n");
        repository.readAllData(Course.class).get().forEach(System.out::println);
        System.out.println("Read!");
        System.out.println("Updating...");
        Course course = repository.readData(2, Course.class).get();
        course.setTitle("Exploring");
        repository.updateData(course);
        System.out.println("Updated!");
        System.out.println("Dropping...");
        Course courseForDropping = repository.readData(1, Course.class).get();
        repository.dropData(courseForDropping);
        System.out.println("Dropped!");
    }
}