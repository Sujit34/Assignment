package miu.edu.restbackendassignment.dto;

import lombok.Getter;
import lombok.Setter;
import miu.edu.restbackendassignment.entity.Course;

import java.util.List;

@Getter
@Setter
public class StudentDto {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String major;
    private List<Course> coursesTaken;
}
