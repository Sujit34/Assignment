package miu.edu.restbackendassignment.service;

import miu.edu.restbackendassignment.dto.CourseDto;
import miu.edu.restbackendassignment.dto.StudentDto;
import miu.edu.restbackendassignment.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student> getAll();
    List<StudentDto> getStudentsByMajor(String major);
    List<CourseDto> getCoursesByStudentId(int id);
    void update(int id, Student student);
    void delete(int id);
}
