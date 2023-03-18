package customers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {
    Student findByName(String name);
    Student findByPhone(String phone);

    @Query("{'address.city' : :#{#aCity}}")
    List<Student> findStudentFromCertainCity(@Param("aCity") String aCity);

    @Query("{'grade.courseName' : :#{#aCourseName}}")
    List<Student> findStudentFromCertainCourse(@Param("aCourseName") String aCourseName);

    @Query("{'grade.courseName' : :#{#aCourseName}, 'grade.grade' : :#{#aGrade}}")
    List<Student> findStudentFromCertainCourseWithACertainGrade(@Param("aCourseName") String aCourseName,@Param("aGrade") String aGrade);
}
