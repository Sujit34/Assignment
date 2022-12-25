package miu.edu.restbackendassignment.controller;

import miu.edu.restbackendassignment.dto.CourseDto;
import miu.edu.restbackendassignment.entity.Course;
import miu.edu.restbackendassignment.repository.CourseRepo;
import miu.edu.restbackendassignment.service.CourseService;
import miu.edu.restbackendassignment.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/courses")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public void save(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id,@RequestBody Course course){
        courseService.update(id,course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        courseService.delete(id);
    }
}
