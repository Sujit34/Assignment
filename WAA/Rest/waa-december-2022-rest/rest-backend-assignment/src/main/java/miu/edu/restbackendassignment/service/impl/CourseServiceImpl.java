package miu.edu.restbackendassignment.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.restbackendassignment.dto.CourseDto;
import miu.edu.restbackendassignment.dto.StudentDto;
import miu.edu.restbackendassignment.entity.Course;
import miu.edu.restbackendassignment.repository.CourseRepo;
import miu.edu.restbackendassignment.service.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final ModelMapper mapper;
    @Override
    public void save(Course course){
        courseRepo.save(course);
    }
    @Override
    public List<Course> getAll(){
        return courseRepo.getAll();
    }
    @Override
    public void update(int id, Course course){
        courseRepo.update(id,course);
    }
    @Override
    public void delete(int id){
        courseRepo.delete(id);
    }
}
