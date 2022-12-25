package miu.edu.restbackendassignment.repository;


import miu.edu.restbackendassignment.entity.Course;
import miu.edu.restbackendassignment.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    static List<Course> courses=  new ArrayList<>();
    static{
        courses.add(new Course(1,"FPP","CS390"));
        courses.add(new Course(2,"MPP","CS400"));
        courses.add(new Course(3,"WAP","CS472"));
        courses.add(new Course(4,"WAA","CS545"));
    }

    static List<Student> students  = new ArrayList<>();
    static{
        students.add(new Student(1,"Sujit","Chanda","sujit.chanda@miu.edu","WAA",courses));
        students.add(new Student(2,"Kumar","Chanda","kumar.chanda@miu.edu","EA",courses));
    }

    public void save(Student student){
        students.add(student);
    }

    public List<Student> getAll(){
        return students;
    }

    public List<Student> getStudentsByMajor(String major){
        return  students.stream().filter(x->x.getMajor().equals(major)).toList();
    }

    public List<Course> getCoursesByStudentId(int id){
        return  students.stream().filter(x->x.getId() == id).findAny().get().getCoursesTaken();

    }

    public void update(int id, Student student){
        students.set(id,student);
    }
    public void delete(int id){
        students.stream().filter(x -> x.getId() == id)
                .findFirst().get().setDeleted(true);
    }


}
