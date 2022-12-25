package miu.edu.restbackendassignment.service;

import miu.edu.restbackendassignment.dto.CourseDto;
import miu.edu.restbackendassignment.entity.Course;

import java.util.List;

public interface CourseService {
    void save(Course course);
    List<Course> getAll();
    void update(int id,Course course);
    void delete(int id);
}
