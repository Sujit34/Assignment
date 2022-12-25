package miu.edu.restbackendassignment.repository;

import miu.edu.restbackendassignment.dto.StudentDto;
import miu.edu.restbackendassignment.entity.Course;
import miu.edu.restbackendassignment.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    static List<Course> courses = new ArrayList<>();

    static{
        courses.add(new Course(1,"FPP","CS390"));
        courses.add(new Course(2,"MPP","CS400"));
        courses.add(new Course(3,"WAP","CS472"));
        courses.add(new Course(4,"WAA","CS545"));
    }

    public void save(Course course){
        courses.add(course);
    }
    public List<Course> getAll(){
        return courses;
    }
    public void update(int id, Course course){
        courses.set(id,course);
    }
    public void delete(int id){
        courses.stream().filter(x->x.getId()== id)
                .findFirst().get().setDeleted(true);
    }



}
