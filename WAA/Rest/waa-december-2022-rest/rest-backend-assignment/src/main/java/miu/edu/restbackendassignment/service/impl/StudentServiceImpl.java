package miu.edu.restbackendassignment.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.restbackendassignment.dto.CourseDto;
import miu.edu.restbackendassignment.dto.StudentDto;
import miu.edu.restbackendassignment.entity.Course;
import miu.edu.restbackendassignment.entity.Student;
import miu.edu.restbackendassignment.repository.StudentRepo;
import miu.edu.restbackendassignment.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import miu.edu.restbackendassignment.dto.StudentDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentrepo;
    private final ModelMapper mapper;

    @Override
    public void save(Student student){
        studentrepo.save(student);
    }

    @Override
    public List<Student> getAll(){
        return studentrepo.getAll();
    }

    @Override
    public List<StudentDto> getStudentsByMajor(String major){
        return studentrepo.getStudentsByMajor(major).stream().map(x-> mapper.map(x,StudentDto.class)).toList();
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int id){
        return studentrepo.getCoursesByStudentId(id).stream().map(x-> mapper.map(x,CourseDto.class)).toList();
    }
    @Override
    public void update(int id, Student student){
        studentrepo.update(id,student);
    }
    @Override
    public void delete(int id){
        studentrepo.delete(id);
    }
}
