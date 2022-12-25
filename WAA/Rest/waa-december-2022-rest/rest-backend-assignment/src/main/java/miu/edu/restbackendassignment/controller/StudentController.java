package miu.edu.restbackendassignment.controller;


import miu.edu.restbackendassignment.dto.CourseDto;
import miu.edu.restbackendassignment.dto.StudentDto;
import miu.edu.restbackendassignment.entity.Student;
import miu.edu.restbackendassignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void save(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping
    public List<Student> getAll(){
       return studentService.getAll();
    }

    @GetMapping("/{filterByMajor}")
    public List<StudentDto>getStudentsByMajor(@RequestParam String major){
        System.out.println("........................." + major);
        return studentService.getStudentsByMajor(major);
    }

    @GetMapping("/{id}/courses")
    public List<CourseDto>getCoursesByStudentId(@PathVariable int id){
        System.out.print(id);
        return studentService.getCoursesByStudentId(id);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id,@RequestBody Student student){
        studentService.update(id,student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);
    }

}
