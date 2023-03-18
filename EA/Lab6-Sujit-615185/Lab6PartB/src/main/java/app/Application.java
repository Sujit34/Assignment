package app;

import domain.Course;
import domain.Department;
import domain.Grade;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.CourseRepository;
import repositories.DepartmentRepository;
import repositories.GradeRepository;
import repositories.StudentRepository;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain")
public class Application implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;
   @Autowired
    CourseRepository courseRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    GradeRepository gradeRepository;

    public static void main(String[] args) {  SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Course c1 = new Course("EA");
        Course c2 = new Course("WAA");
        Course c3 = new Course("SA");
        courseRepository.save(c1);
        courseRepository.save(c2);
        courseRepository.save(c3);

        Department d1 = new Department("CS");
        departmentRepository.save(d1);

        Student s1 = new Student(1L, "Mr. X");
        Student s2 = new Student(2L, "Mr. Y");
        Student s3 = new Student(3L, "Mr. Z");
        s1.setDepartment(d1);
        s2.setDepartment(d1);
        s3.setDepartment(d1);

        Grade g1 = new Grade("A", c1);
        gradeRepository.save(g1);
        s1.addGrade(g1);
        Grade g2 = new Grade("A-", c2);
        gradeRepository.save(g2);
        s1.addGrade(g2);
        Grade g3 = new Grade("A+", c1);
        gradeRepository.save(g3);
        s2.addGrade(g3);
        Grade g4 = new Grade("A", c3);
        gradeRepository.save(g4);
        s3.addGrade(g4);
        Grade g5 = new Grade("A+", c3);
        gradeRepository.save(g5);
        s3.addGrade(g5);

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);

        System.out.println("------ Find all students from a certain department  -------------------");
        List<Student> students1 = studentRepository.findStudentsFromDepartment("CS");
        students1.stream().forEach(c->System.out.println(c));

        System.out.println("------ Find all students who took a course with a certain name  -------------------");
        List<Student> students2 = studentRepository.findStudentsFromCertainCourse("EA");
        students2.stream().forEach(c->System.out.println(c));
    }


}
