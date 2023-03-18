package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select distinct s from Student s join fetch s.grades g join fetch s.department where s.department.name = :department")
    List<Student> findStudentsFromDepartment(@Param("department") String department);

    @Query("select distinct s from Student s join fetch s.grades g join fetch s.department where g.course.name = :course")
    List<Student> findStudentsFromCertainCourse(@Param("course") String course);
}
